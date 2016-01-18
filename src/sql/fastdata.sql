USE `paqueteria`;

/* Empleados */
insert into `empleados` values (1, '11', 'aa', '11');
insert into `empleados` values (2, '22', 'bb', '22');
insert into `empleados` values (3, '33', 'cc', '33');

/* Clintes */
insert into `clientes` values (1, '11', 'aa', '11', 'aa', '11', 'aa', '11');
insert into `clientes` values (2, '22', 'bb', '22', 'bb', '22', 'bb', '22');
insert into `clientes` values (3, '33', 'cc', '33', 'cc', '33', 'cc', '33');

/* Rutas */
insert into `rutas` values (1, '11.5', 'a-a', true);
insert into `rutas` values (2, '22.5', 'b-b', true);
insert into `rutas` values (3, '33.5', 'c-c', true);

/* Paquetes */
insert into `paquetes` values (1, '11.5', 'sobre', '0.0', '0.7', true);
insert into `paquetes` values (2, '22.5', 'mediano', '0.7', '2.0', true);
insert into `paquetes` values (3, '33.5', 'grande', '2.0', '5.5', true);

/* Admin password */
insert into `admin` values (1, '12345');
