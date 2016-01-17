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
    `ruc_empresa`          varchar(50) NOT NULL,
    `nombre_empresa`       varchar(50) NOT NULL,
    `cedula_representante` varchar(50) NOT NULL,
    `nombre_representante` varchar(50) NOT NULL,
    `telefono`             varchar(50) NOT NULL,
    `direccion`            varchar(50) NOT NULL,
    `password`             varchar(50) NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `rutas`
(
    `id_ruta`     integer,
    `tarifa`      float NOT NULL,
    `descripcion` varchar(50) NOT NULL,
    `habilitado`  boolean NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `paquetes`
(
    `id_paquete`  integer,
    `tarifa`      float NOT NULL,
    `descripcion` varchar(50) NOT NULL,
    `habilitado`  boolean NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `facturas`
(
    `id_factura` integer,
    `fecha`      date NOT NULL,
    `valor`      float NOT NULL,
    `pagado`     boolean NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `facturas_clientes`
(
    `id_cliente` integer,
    `id_factura` integer NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `eventos`
(
    `id_evento`   integer,
    `fecha`       date NOT NULL,
    `descripcion` varchar(50) NOT NULL
) ENGINE = InnoDB;

CREATE OR REPLACE TABLE `guias`
(
    `id_guia`        integer,
    `fecha_creacion` date NOT NULL,
    `fecha_salida`   date NOT NULL,
    `fecha_llegada`  date NOT NULL
) ENGINE = InnoDB;


CREATE OR REPLACE USER 'usuario'@'localhost' identified by '1234';
grant all privileges on paqueteria.* to 'usuario'@'localhost';
