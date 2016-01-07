CREATE OR REPLACE DATABASE `paqueteria`;
USE `paqueteria`;

CREATE OR REPLACE TABLE `empleados`
(
    `id_empleado`  integer,
    `cedula`       varchar(10) NOT NULL,
    `nombre`      varchar(50) NOT NULL
) ENGINE = InnoDB;


CREATE OR REPLACE USER 'usuario'@'localhost' identified by '1234';
grant all privileges on paqueteria.* to 'usuario'@'localhost';
