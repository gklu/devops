
import xml.etree.ElementTree as ET

# base_path = os.path.dirname(os.path.realpath(__file__))
# xml_file = os.path.join(base_path,"data/gitlab.xml")

# -- OVF parsing --

class OVFData():
    '''OFV meta data - the data is only available after calling OFVData.parse'''
    def __init__(self, file=None):
        '''OVF meta data initializer'''
        # namespaces, dflt is default namespace xmlns, others are xmlns:<ns>
        # @TODO: read these from <Envelope> because version may change
        #        e.g. OVF 2.0 exists: xmlns:ovf="http://schemas.dmtf.org/ovf/envelope/2"
        self._ns = {
            # 'dflt': "http://schemas.dmtf.org/ovf/envelope/1", # same as ovf!?!
            'cim': "http://schemas.dmtf.org/wbem/wscim/1/common",
            'ovf': "http://schemas.dmtf.org/ovf/envelope/1",
            'rasd': "http://schemas.dmtf.org/wbem/wscim/1/cim-schema/2/"
                    "CIM_ResourceAllocationSettingData",
            'vmw': "http://www.vmware.com/schema/ovf",
            'vssd': "http://schemas.dmtf.org/wbem/wscim/1/cim-schema/2/"
                    "CIM_VirtualSystemSettingData"
        }
        self.file = file
        self.root = None
        self.name = None
        self.osid = None
        self.licenseType = "OTHER"
        self.cpus = None
        self.ram = None
        self.disks = []
        self.lans = dict()
        self.nics = []
        self.osname = None
        self.resourceTypes = {
            '1': 'Other',
            '2': 'Computer System',
            '3': 'Processor',
            '4': 'Memory',
            '5': 'IDE Controller',
            '6': 'Parallel SCSI HBA',
            '7': 'FC HBA',
            '8': 'iSCSI HBA',
            '9': 'IB HCA',
            '10': 'Ethernet Adapter',
            '11': 'Other Network Adapter',
            '12': 'I/O Slot',
            '13': 'I/O Device',
            '14': 'Floppy Drive',
            '15': 'CD Drive',
            '16': 'DVD drive',
            '17': 'Disk Drive',
            '18': 'Tape Drive',
            '19': 'Storage Extent',
            '20': 'Other storage device',
            '21': 'Serial port',
            '22': 'Parallel port',
            '23': 'USB Controller',
            '24': 'Graphics controller',
            '25': 'IEEE 1394 Controller',
            '26': 'Partitionable Unit',
            '27': 'Base Partitionable Unit',
            '28': 'Power',
            '29': 'Cooling Capacity',
            '30': 'Ethernet Switch Port',
            '31': 'Logical Disk',
            '32': 'Storage Volume',
            '33': 'Ethernet Connection',
            '..': 'DMTF reserved',
            '0x8000..0xFFFF': 'Vendor Reserved'
        }   # end resourceType
        self.osTypeOther = {
            '0': 'Unknown',
            '1': 'Other',
            '2': 'MACOS',
            '3': 'ATTUNIX',
            '4': 'DGUX',
            '5': 'DECNT',
            '6': 'Tru64 UNIX',
            '7': 'OpenVMS',
            '8': 'HPUX',
            '9': 'AIX',
            '10': 'MVS',
            '11': 'OS400',
            '12': 'OS/2',
            '13': 'JavaVM',
            '14': 'MSDOS',
            '15': 'WIN3x',
            '16': 'WIN95',
            '17': 'WIN98',
            '18': 'WINNT',
            '19': 'WINCE',
            '20': 'NCR3000',
            '21': 'NetWare',
            '22': 'OSF',
            '23': 'DC/OS',
            '24': 'Reliant UNIX',
            '25': 'SCO UnixWare',
            '26': 'SCO OpenServer',
            '27': 'Sequent',
            '28': 'IRIX',
            '29': 'Solaris',
            '30': 'SunOS',
            '31': 'U6000',
            '32': 'ASERIES',
            '33': 'HP NonStop OS',
            '34': 'HP NonStop OSS',
            '35': 'BS2000',
            '37': 'Lynx',
            '38': 'XENIX',
            '39': 'VM',
            '40': 'Interactive UNIX',
            '41': 'BSDUNIX',
            '42': 'FreeBSD',
            '43': 'NetBSD',
            '44': 'GNU Hurd',
            '45': 'OS9',
            '46': 'MACH Kernel',
            '47': 'Inferno',
            '48': 'QNX',
            '49': 'EPOC',
            '50': 'IxWorks',
            '51': 'VxWorks',
            '52': 'MiNT',
            '53': 'BeOS',
            '54': 'HP MPE',
            '55': 'NextStep',
            '56': 'PalmPilot',
            '57': 'Rhapsody',
            '59': 'Dedicated',
            '60': 'OS/390',
            '61': 'VSE',
            '62': 'TPF',
            '64': 'Caldera Open UNIX',
            '65': 'OpenBSD',
            '66': 'Not Applicable',
            '68': 'z/OS',
            '78': 'FreeBSD 64-Bit',
            '81': 'Solaris 64-Bit',
            '86': 'Novell OES',
            '87': 'Novell Linux Desktop',
            '88': 'Sun Java Desktop System',
            '102': 'Other 64-Bit',
            '104': 'VMware ESXi',
            '110': 'eComStation 32-bitx',
        }   # end osTypeOther
        self.osTypeLinux = {
            '36': 'LINUX',
            '79': 'RedHat Enterprise Linux',
            '80': 'RedHat Enterprise Linux 64-Bit',
            '82': 'SUSE',
            '83': 'SUSE 64-Bit',
            '84': 'SLES',
            '85': 'SLES 64-Bit',
            '89': 'Mandriva',
            '90': 'Mandriva 64-Bit',
            '91': 'TurboLinux',
            '92': 'TurboLinux 64-Bit',
            '93': 'Ubuntu',
            '94': 'Ubuntu 64-Bit',
            '95': 'Debian',
            '96': 'Debian 64-Bit',
            '97': 'Linux 2.4.x',
            '98': 'Linux 2.4.x 64-Bit',
            '99': 'Linux 2.6.x',
            '100': 'Linux 2.6.x 64-Bit',
            '101': 'Linux 64-Bit',
            '106': 'CentOS 32-bit',
            '107': 'CentOS 64-bit',
            '108': 'Oracle Linux 32-bit',
            '109': 'Oracle Linux 64-bit',
        }   # end osTypeLinux
        self.osTypeWindows = {
            '58': 'Windows 2000',
            '63': 'Windows (R) Me',
            '67': 'Windows XP',
            '69': 'Microsoft Windows Server 2003',
            '70': 'Microsoft Windows Server 2003 64-Bit',
            '71': 'Windows XP 64-Bit',
            '72': 'Windows XP Embedded',
            '73': 'Windows Vista',
            '74': 'Windows Vista 64-Bit',
            '75': 'Windows Embedded for Point of Service',
            '76': 'Microsoft Windows Server 2008',
            '77': 'Microsoft Windows Server 2008 64-Bit',
            '103': 'Microsoft Windows Server 2008 R2',
            '105': 'Microsoft Windows 7',
            '111': 'Microsoft Windows Server 2011',
            '113': 'Microsoft Windows Server 2012',
            '114': 'Microsoft Windows 8',
            '115': 'Microsoft Windows 8 64-bit',
            '116': 'Microsoft Windows Server 2012 R2'
        }   # end osTypeWindows
    # end __init__()

    def parse(self):
        tree = ET.parse(self.file)
        self.root = tree.getroot()
        # print("parsed file, root element is '{} w/ attributes {}"
        #       .format(self.root.tag, self.root.attrib))
        self._collect_system_data()
        self._collect_disk_data()
        self._collect_nic_data()
    # end parse()

    def _nsattr(self, attr, ns=None):
        ''' returns an attribute name w/ namespace prefix'''
        if ns is None:
            return attr
        return '{' + self._ns[ns] + '}' + attr
    # end _nsattr()

    def _collect_system_data(self):
        virtsys = self.root.find('ovf:VirtualSystem', self._ns)
        self.name = virtsys.find('ovf:Name', self._ns).text
        virtos = virtsys.find('ovf:OperatingSystemSection', self._ns)
        self.osid = virtos.get(self._nsattr('id', 'ovf'))
        if self.osid in self.osTypeLinux:
            self.licenseType = "LINUX"
            self.osname = self.osTypeLinux[self.osid]
        else:
            if self.osid in self.osTypeWindows:
                self.licenseType = "WINDOWS"
                self.osname = self.osTypeWindows[self.osid]
            else:
                self.osname = self.osTypeOther[self.osid]
        print("VM '{}' has {}-type OS '{}'(id:{})"
              .format(self.name, self.licenseType, self.osname, self.osid))
        virtcpu = virtsys.find('./ovf:VirtualHardwareSection/ovf:Item/[rasd:ResourceType="3"]',
                               self._ns)
        self.cpus = virtcpu.find('rasd:VirtualQuantity', self._ns).text
        # !!! VMware also as vmw:CoresPerSocket !!!
        # we currently exclude this, so there may be cores missing in VM!
        virtmem = virtsys.find('./ovf:VirtualHardwareSection/ovf:Item/[rasd:ResourceType="4"]',
                               self._ns)
        # we assume that RAM is specified in MB (or 'byte * 2^20')
        self.ram = virtmem.find('rasd:VirtualQuantity', self._ns).text
        print("VM '{}' has {} CPUs and {} MB RAM"
              .format(self.name, self.cpus, self.ram))
    # end _collect_system_data()

    # get the disks
    def _collect_disk_data(self):
        filerefs = self.root.findall('./ovf:References/ovf:File', self._ns)
        files = dict()
        for ref in filerefs:
            name = ref.get(self._nsattr('href', 'ovf'))
            fileid = ref.get(self._nsattr('id', 'ovf'))
            files[fileid] = name
        print("found filerefs {}".format(files))
        diskrefs = self.root.findall('./ovf:DiskSection/ovf:Disk', self._ns)
        disks = dict()
        for ref in diskrefs:
            # Note: we assume ovf:capacityAllocationUnits="byte * 2^30" == GiB
            capacity = ref.get(self._nsattr('capacity', 'ovf'))
            # reference to file references above
            fref = ref.get(self._nsattr('fileRef', 'ovf'))
            # the virt. HW section refers to '/disk/vmdisk1' not 'vmdisk1'
            diskid = 'ovf:/disk/'+ref.get(self._nsattr('diskId', 'ovf'))
            # we resolve fref here, we only need the name from now on
            disks[diskid] = {'capacity': capacity, 'file': files[fref]}
        print("found disks {}".format(disks))
        virtsys = self.root.find('ovf:VirtualSystem', self._ns)
        virthds = virtsys.findall('./ovf:VirtualHardwareSection/ovf:Item/[rasd:ResourceType="17"]',
                                  self._ns)
        devices = dict()
        for hdd in virthds:
            # print("hdd is {}".format(hdd))
            diskref = hdd.find('rasd:HostResource', self._ns).text
            address = hdd.find('rasd:AddressOnParent', self._ns)
            if address is None:
                print("no address for sorting found for {}, use InstanceId"
                      .format(diskref))
                devNr = hdd.find('rasd:InstanceId', self._ns).text
                print("disk {} has InstanceId {}".format(diskref, devNr))
            else:
                devNr = address.text
                print("disk {} has address {}".format(diskref, devNr))
            devices[devNr] = disks[diskref]
        print("devices : {}".format(devices))
        self.disks = [devices[dev_no] for dev_no in sorted(devices)]
        print("disks : {}".format(self.disks))
    # end _collect_disk_data()

    # get the nics
    def _collect_nic_data(self):
        # the NetworkSection contains only name and description
        # maybe that helps for better LAN assignment one day
        vnets = self.root.findall('./ovf:NetworkSection/ovf:Network', self._ns)
        lanid = 1
        for net in vnets:
            self.lans[net.get(self._nsattr('name', 'ovf'))] = lanid
            lanid += 1
        print("LANs found: {}".format(self.lans))
        virtsys = self.root.find('ovf:VirtualSystem', self._ns)
        virtnics = virtsys.findall(
            './ovf:VirtualHardwareSection/ovf:Item/[rasd:ResourceType="10"]', self._ns)
        devices = dict()
        for nic in virtnics:
            # print("nic is {}".format(nic))
            nicname = nic.find('rasd:ElementName', self._ns).text
            connection = nic.find('rasd:Connection', self._ns).text
            address = nic.find('rasd:AddressOnParent', self._ns)
            if address is None:
                print("no address for sorting found for {}, use InstanceId"
                      .format(nicname))
                devNr = nic.find('rasd:InstanceId', self._ns).text
                print("nic '{}' has InstanceId {}".format(nicname, devNr))
            else:
                devNr = address.text
                print("nic '{}' has address {}".format(nicname, devNr))
            devices[devNr] = {'nic': nicname, 'lan': connection,
                              'lanid': self.lans[connection]}
        print("devices : {}".format(devices))
        self.nics = [devices[dev_no] for dev_no in sorted(devices)]
        print("nics : {}".format(self.nics))


    # end _collect_nic_data()

# end class OVFData

