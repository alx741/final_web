CREATE OR REPLACE DATABASE `paqueteria`;
USE `paqueteria`;

CREATE OR REPLACE TABLE `empleados`
(
    `id_empleado` integer,
    `cedula`      varchar(10) NOT NULL,
    `nombre`      varchar(50) NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `clientes`
(
    `id_cliente`           integer,
    `nombre_empresa`       varchar(10) NOT NULL,
    `cedula_representante` varchar(50) NOT NULL,
    `nombre_representante` varchar(50) NOT NULL,
    `telefono`             varchar(50) NOT NULL,
    `direccion`            varchar(50) NOT NULL,
    `password`             varchar(50) NOT NULL
) ENGINE = InnoDB;


CREATE OR REPLACE USER 'usuario'@'localhost' identified by '1234';
grant all privileges on paqueteria.* to 'usuario'@'localhost';
