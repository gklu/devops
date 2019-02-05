#!/usr/bin/python
# -*- coding: utf-8 -*-
#
# (c) 2015, Jefferson Girão <jefferson@girao.net>
# (c) 2015, René Moser <mail@renemoser.net>
#
# This file is part of Ansible
#
# Ansible is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Ansible is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with Ansible. If not, see <http://www.gnu.org/licenses/>.

ANSIBLE_METADATA = {'metadata_version': '1.1',
                    'status': ['stableinterface'],
                    'supported_by': 'community'}


DOCUMENTATION = '''
---
module: cs_volume
short_description: Manages volumes on Apache CloudStack based clouds.
description:
    - Create, destroy, attach, detach volumes.
version_added: "2.1"
author:
    - "Jefferson Girão (@jeffersongirao)"
    - "René Moser (@resmo)"
options:
  name:
    description:
      - Name of the volume.
      - C(name) can only contain ASCII letters.
    required: true
  account:
    description:
      - Account the volume is related to.
  custom_id:
    description:
      - Custom id to the resource.
      - Allowed to Root Admins only.
  disk_offering:
    description:
      - Name of the disk offering to be used.
      - Required one of C(disk_offering), C(snapshot) if volume is not already C(state=present).
  display_volume:
    description:
      - Whether to display the volume to the end user or not.
      - Allowed to Root Admins only.
    default: true
  domain:
    description:
      - Name of the domain the volume to be deployed in.
  max_iops:
    description:
      - Max iops
  min_iops:
    description:
      - Min iops
  project:
    description:
      - Name of the project the volume to be deployed in.
  size:
    description:
      - Size of disk in GB
  snapshot:
    description:
      - The snapshot name for the disk volume.
      - Required one of C(disk_offering), C(snapshot) if volume is not already C(state=present).
  force:
    description:
      - Force removal of volume even it is attached to a VM.
      - Considered on C(state=absnet) only.
    default: false
  shrink_ok:
    description:
      - Whether to allow to shrink the volume.
    default: false
  vm:
    description:
      - Name of the virtual machine to attach the volume to.
  zone:
    description:
      - Name of the zone in which the volume should be deployed.
      - If not set, default zone is used.
  state:
    description:
      - State of the volume.
    default: present
    choices: [ present, absent, attached, detached ]
  poll_async:
    description:
      - Poll async jobs until job has finished.
    default: true
  tags:
    description:
      - List of tags. Tags are a list of dictionaries having keys C(key) and C(value).
      - "To delete all tags, set a empty list e.g. C(tags: [])."
    aliases: [ 'tag' ]
    version_added: "2.4"
extends_documentation_fragment: cloudstack
'''

EXAMPLES = '''
- name: create volume within project and zone with specified storage options
  local_action:
    module: cs_volume
    name: web-vm-1-volume
    project: Integration
    zone: ch-zrh-ix-01
    disk_offering: PerfPlus Storage
    size: 20

- name: create/attach volume to instance
  local_action:
    module: cs_volume
    name: web-vm-1-volume
    disk_offering: PerfPlus Storage
    size: 20
    vm: web-vm-1
    state: attached

- name: detach volume
  local_action:
    module: cs_volume
    name: web-vm-1-volume
    state: detached

- name: remove volume
  local_action:
    module: cs_volume
    name: web-vm-1-volume
    state: absent
'''

RETURN = '''
id:
  description: ID of the volume.
  returned: success
  type: string
  sample:
name:
  description: Name of the volume.
  returned: success
  type: string
  sample: web-volume-01
display_name:
  description: Display name of the volume.
  returned: success
  type: string
  sample: web-volume-01
group:
  description: Group the volume belongs to
  returned: success
  type: string
  sample: web
domain:
  description: Domain the volume belongs to
  returned: success
  type: string
  sample: example domain
project:
  description: Project the volume belongs to
  returned: success
  type: string
  sample: Production
zone:
  description: Name of zone the volume is in.
  returned: success
  type: string
  sample: ch-gva-2
created:
  description: Date of the volume was created.
  returned: success
  type: string
  sample: 2014-12-01T14:57:57+0100
attached:
  description: Date of the volume was attached.
  returned: success
  type: string
  sample: 2014-12-01T14:57:57+0100
type:
  description: Disk volume type.
  returned: success
  type: string
  sample: DATADISK
size:
  description: Size of disk volume.
  returned: success
  type: string
  sample: 20
vm:
  description: Name of the vm the volume is attached to (not returned when detached)
  returned: success
  type: string
  sample: web-01
state:
  description: State of the volume
  returned: success
  type: string
  sample: Attached
device_id:
  description: Id of the device on user vm the volume is attached to (not returned when detached)
  returned: success
  type: string
  sample: 1
'''

from ansible.module_utils.basic import AnsibleModule
from ansible.module_utils.cloudstack import (
    AnsibleCloudStack,
    cs_required_together,
    cs_argument_spec
)


class UploadVolume(AnsibleCloudStack):

    def __init__(self, module):
        super(UploadVolume, self).__init__(module)
        self.returns = {
            'size': 'size',
            'status': 'status',
            'type': 'type',
        }
        # self.upload_volume = None
    def get_args(self):
        args = {
            'name': self.module.params.get('name'),
            'format': self.module.params.get('format'),
            'url': self.module.params.get('url'),
            'zoneid': self.get_zone(key='id'),
        }
        required_params = [
            'format',
            'url',
            'name',
        ]
        self.module.fail_on_missing_params(required_params=required_params)
        return  args

    def upload_volume(self):

        self.result['changed'] = True

        args = self.get_args()

        if not self.module.check_mode:
            res = self.query_api('uploadVolume', **args)
            if 'errortext' in res:
                self.module.fail_json(msg="Failed: '%s'" % res['errortext'])

            poll_async = self.module.params.get('poll_async')
            if poll_async:
                upload = self.poll_job(res, 'upload')
                return upload

    # def get_result(self, upload):
    #     super(UploadVolume, self).get_result(upload)
    #     if upload:
    #         self.result['name'] =  ""
    #         self.result['status'] = ""
    #         self.result['size'] = ""
    #     return self.result


def main():
    argument_spec = cs_argument_spec()
    argument_spec.update(dict(
        format=dict(type='str', required=True),
        name=dict(type='str', required=True),
        url=dict(type='str', required=True),
        state=dict(choices=['upload', 'attached', 'list'], default='upload'),
        zone=dict(),
        domain=dict(),
        account=dict(),
        project=dict(),
        poll_async=dict(type='bool', default=True),
    ))

    module = AnsibleModule(
        argument_spec=argument_spec,
        required_together=cs_required_together(),
        supports_check_mode=True
    )

    my_upload = UploadVolume(module)

    state = module.params.get('state')

    if state == 'upload':
        upload = my_upload.upload_volume()
    else:
        pass

    result = my_upload.get_result(upload)

    module.exit_json(**result)

if __name__ == '__main__':
    main()
