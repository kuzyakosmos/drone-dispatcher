DROP TABLE IF EXISTS dronedispatcher.drones;
CREATE TABLE dronedispatcher.drones (
  id BIGINT AUTO_INCREMENT NOT NULL,
   serial_number VARCHAR(255) NOT NULL,
   model VARCHAR(255) NULL,
   weight_limit SMALLINT NOT NULL,
   battery_capacity TINYINT NOT NULL,
   state VARCHAR(255) NULL,
   CONSTRAINT pk_drones PRIMARY KEY (id)
);

DROP TABLE IF EXISTS dronedispatcher.medications;
CREATE TABLE dronedispatcher.medications (
  id BIGINT AUTO_INCREMENT NOT NULL,
   code VARCHAR(255) NULL,
   name VARCHAR(255) NULL,
   weight SMALLINT NOT NULL,
   image VARCHAR(255) NULL,
   drone BIGINT NULL,
   CONSTRAINT pk_medications PRIMARY KEY (id)
);

ALTER TABLE dronedispatcher.medications ADD CONSTRAINT FK_MEDICATIONS_ON_DRONE FOREIGN KEY (drone) REFERENCES dronedispatcher.drones (id);