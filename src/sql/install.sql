CREATE USER `final`;

CREATE OR REPLACE DATABASE `final`;
USE `final`;

CREATE OR REPLACE TABLE `empleados`
(
    `id_empleado`  integer,
    `cedula`       varchar(10) NOT NULL,
    `nombre`      varchar(50) NOT NULL
) ENGINE = InnoDB;
