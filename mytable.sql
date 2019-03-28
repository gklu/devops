CREATE TABLE billing(
   id INT AUTO_INCREMENT PRIMARY KEY,
   vm_name VARCHAR(50),
   vm_id VARCHAR(100),
   date_created VARCHAR(50),
   os VARCHAR(50),
   iaas VARCHAR(50),
   disk_size INT,
   disk1 VARCHAR(50),
   disk2 VARCHAR(50),
   service_offering VARCHAR(50),
   iaas_rate FlOAT(6),
   archive_storage_rate FlOAT(6),
   std_storage_rate FlOAT(6),
   iops_5k_rate FlOAT(6),
   iops_10k_rate FlOAT(6),
   uptime INT,
   captured_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);