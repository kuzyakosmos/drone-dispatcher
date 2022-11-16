--todo init database
DROP TABLE IF EXISTS dronedispatcher.drones;
CREATE TABLE dronedispatcher.drones (
  serial_number VARCHAR(100) NOT NULL,
   model VARCHAR(13) NULL,
   weight_limit SMALLINT(3) NOT NULL,
   battery_capacity TINYINT(2) NOT NULL,
   state VARCHAR(10) NULL,
   CONSTRAINT pk_drones PRIMARY KEY (serial_number)
);

DROP TABLE IF EXISTS dronedispatcher.medications;
CREATE TABLE dronedispatcher.medications (
  code VARCHAR(255) NOT NULL,
   name VARCHAR(255) NULL,
   weight SMALLINT(3) NOT NULL,
   image VARCHAR(255) NULL,
   drone VARCHAR(255) NULL,
   CONSTRAINT pk_medications PRIMARY KEY (code)
);

ALTER TABLE dronedispatcher.medications ADD CONSTRAINT FK_MEDICATIONS_ON_DRONE FOREIGN KEY (drone) REFERENCES drones (serial_number);