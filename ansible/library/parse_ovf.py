#!/usr/bin/python

from ansible.module_utils.basic import *
from ansible.module_utils.ovfclass import OVFData


def run_module():
	# define available arguments/parameters
	module_args = dict(
		path=dict(type='str',required=True)
	)

	# we primarily care about changed and state
	# change is if this module effectively modified the target
	# state will include any data that you want your module to pass back
	# for consumption
	result = dict(
		changed=False,
		vm_name=None,
		os_type=None,
		cpu_count=None,
		memory_size=None,
		disks=[],
		net_interface=[],
		networks=dict(),
		root_volume=None
	)
	# the AnsibleModule object will be our abstraction working with Ansible
	# this includes instantiation, a couple of common attr would be the
	# args/params passed to the execution, as well as if the module
	# supports check mode
	module = AnsibleModule(
		argument_spec=module_args,
		supports_check_mode=True
	)
	# if the user is working with this module in only check mode we do not
    # want to make any changes to the environment, just return the current
    # state with no modifications
	if module.check_mode:
		return result


	# manipulate or modify the state as needed (this is going to be the
	# part where your module will do what it needs to do)
	file = module.params['path']
	my_ovf = OVFData(file)
	my_ovf.parse()
	result['vm_name'] = my_ovf.name
	result['os_type'] = my_ovf.osname
	result['cpu_count'] = my_ovf.cpus
	result['memory_size'] = my_ovf.ram
	result['disks'] = my_ovf.disks
	result['net_interface'] = my_ovf.nics
	result['lans'] = my_ovf.lans
	result['root_volume'] = my_ovf.disks[0]
	result['volumes'] = my_ovf.disks[1:]


	# use whatever logic you need to determine whether or not this module
	# made any modifications to your target
	# if module.params['new']:
	# 	result['changed'] = True


	# during the execution of the module, if there is an exception or a
	# conditional state that effectively causes a failure, run
	# AnsibleModule.fail_json() to pass in the message and the result

	if module.params['path'] == '':
		module.fail_json(msg='You need to specify file', **result)

	# in the event of a successful module execution, you will want to
	# simple AnsibleModule.exit_json(), passing the key/value results
	module.exit_json(**result)

def main():
	run_module()

if __name__ == '__main__':
    main()
