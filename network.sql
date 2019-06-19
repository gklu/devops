CREATE TABLE okc_outside(
   id INT AUTO_INCREMENT NOT NULL  PRIMARY KEY,
   speed INT,
   captured_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE okc_inside(
   id INT AUTO_INCREMENT NOT NULL  PRIMARY KEY,
   speed INT,
   captured_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE mgm_outside(
   id INT AUTO_INCREMENT NOT NULL  PRIMARY KEY,
   speed INT,
   captured_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE mgm_inside(
   id INT AUTO_INCREMENT NOT NULL  PRIMARY KEY,
   speed INT,
   captured_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE USER 'grafanaReader' IDENTIFIED BY 'password';
GRANT SELECT ON network.* TO 'grafanaReader';