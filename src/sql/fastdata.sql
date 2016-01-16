USE `paqueteria`;

/* Empleados */
insert into `empleados` values (1, '11', 'aa');
insert into `empleados` values (2, '22', 'bb');
insert into `empleados` values (3, '33', 'cc');

/* Clintes */
insert into `clientes` values (1, '11', 'aa', '11', 'aa', '11', 'aa', '11');
insert into `clientes` values (2, '22', 'bb', '22', 'bb', '22', 'bb', '22');
insert into `clientes` values (3, '33', 'cc', '33', 'cc', '33', 'cc', '33');

/* Rutas */
insert into `rutas` values (1, '11.5', 'a-a', true);
insert into `rutas` values (2, '22.5', 'b-b', true);
insert into `rutas` values (3, '33.5', 'c-c', true);

/* Paquetes */
insert into `paquetes` values (1, '11.5', 'sobre', true);
insert into `paquetes` values (2, '22.5', 'mediano', true);
insert into `paquetes` values (3, '33.5', 'grande', true);


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


CREATE OR REPLACE USER 'usuario'@'localhost' identified by '1234';
grant all privileges on paqueteria.* to 'usuario'@'localhost';
