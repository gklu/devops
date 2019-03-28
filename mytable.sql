CREATE TABLE billing(
   id INT AUTO_INCREMENT PRIMARY KEY,
   vm_name VARCHAR(30),
   vm_id VARCHAR(30),
   date_created VARCHAR(30),
   os VARCHAR(30),
   iaas VARCHAR(30),
   disk_size INT,
   disk1 VARCHAR(30),
   disk2 VARCHAR(30),
   service_offering VARCHAR(30),
   iaas_rate FlOAT(6),
   archive_storage_rate FlOAT(6),
   std_storage_rate FlOAT(6),
   iops_5k_rate FlOAT(6),
   iops_10k_rate FlOAT(6),
   uptime INT,
   captured_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);