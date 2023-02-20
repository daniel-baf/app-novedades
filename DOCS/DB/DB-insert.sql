USE `novedades`;

-- CATEGORIA GASTOS

INSERT INTO `novedades`.`Categoria_Gasto` (`gasto`) VALUES 
	('sueldos'), ('remodelaciones'), ('mercancia'), ('mobiliario y equipo');

-- AREAS

INSERT INTO `novedades`.`Area` (`id`) VALUES 
	('administrativo'), ('operativo'), ('ventas');

-- USUARIOS ESPECIALES

INSERT INTO `novedades`.`Cliente_Especial` (`id`, `nombre`) VALUES 
	('esp1', 'Juanita Perez'), ('esp2', 'Pepe Juarez');

-- COLOR

INSERT INTO `novedades`.`Color` (`color`) VALUES
	('rojo'), ('amarillo'), ('gris'),
    ('negro'), ('verde'), ('verde lima');

-- TALLAS

INSERT INTO `novedades`.`Talla` (`talla`) VALUES
	('xs'), ('s'), ('m'), ('l'), ('xl'), 
    ('8'), ('10'), ('12'), ('14'), ('16'); 

-- SUCURSAL

INSERT INTO `novedades`.`Sucursal` (`direccion`, `nombre`, `telefono`) VALUES
	('5 calle 10-64', 'Local 1 Centro Comercial', '77601234'), 
	('12 av 10-56', 'Central', '77604321');

-- GASTOS

INSERT INTO `novedades`.`Gasto` (`fecha`, `total`, `descripcion`, `categoria_gasto`) VALUES 
	('2019-10-02', 560, 'pago a empleados', 'sueldos'),
	('2019-11-05', 678, 'nuevos productos de prueba', 'mercancia'),
    ('2020-03-12', 123, 'empleados', 'sueldos'),
    ('2020-07-28', 442, 'pago a Ana', 'sueldos'),
    ('2022-09-01', 1201, 'Nuevas luces para la oficina', 'remodelaciones'),
	('2022-10-11', 980, 'Vitrinas nuevas', 'mobiliario y equipo'),
	('2023-01-19', 59, 'gorras', 'mercancia');

-- USUARIOS

INSERT INTO `novedades`.`Usuario` (`id`, `nombre`, `password`, `Area_id`) VALUES
	('vnt1', 'Pepe Aguilar', 'nyAxukqFV5aEea67GUHbwg==', 'ventas'), -- pass: ventas123
	('adm1', 'Andrea Barilla', '9RP8WZOSpXTZRksFnnjWvA==', 'administrativo'), -- pass: admin123,
    ('opr1', 'Jose Rodriguez', 'kHd/LorCm4ubE50LPiNrkQ==', 'operativo'); -- pass: ope123

-- PRODUCTOS

INSERT INTO `novedades`.`Producto` (`nombre`, `compuesto`) VALUES
	('sueter tipo 1', 0),
    ('sueter tipo 2', 0),
    ('falda tipo 1', 0),
    ('pantalon tipo 1', 0),
    ('blusa tipo 1', 0),
    ('chumpa tipo 1', 0),
    ('conjunto tipo 1', 1); -- formado por sueter tipo 1 y chumpa tipo 1

-- PRODUCTO POR TALLAS

INSERT INTO `novedades`.`Prod_Talla` (`Producto_id`, `talla`, `precio`, `precio_especial`) VALUES 
	(1, 'xs', 75, 72),
    (1, 'm', 80, 75),
    (2, 'l', 70, 60),
    (2, 's', 60, 56),
    (3, 'xl', 95, 91),
    (4, 'm', 60, 55),
    (4, 's', 55, 50),
    (5, 'm', 80, 75),
    (5, 's', 70, 65),
	(6, 'xs', 100, 92),
	(6, 'l', 105, 95),
    (7, 'xs', 160, 150); -- sutert tipo 1 xs y cumpa tipo 1 xs (mismo color)

-- PRODUCTO POR TALLAS Y COLOR

INSERT INTO `novedades`.`Inventario` (`color`, `Prod_Talla_Producto_id`, `Prod_Talla_talla`) VALUES 
	('amarillo', 1, 'xs'),
   	('rojo', 1, 'xs'),
    ('rojo', 1, 'm'),
    ('verde', 2, 'l'),
    ('gris', 2, 's'),
    ('verde lima', 3, 'xl'),
    ('negro', 4, 'm'),
	('verde', 4, 'm'),
    ('gris', 4, 's'),
    ('amarillo', 5, 'm'),
    ('negro', 5, 'm'),
    ('negro', 5, 's'),
	('amarillo', 6, 'xs'),
	('verde', 6, 'l'),
    ('amarillo', 7, 'xs'); -- sutert tipo 1 xs y cumpa tipo 1 xs (mismo color)

-- FORMACION DE LOS CONJUNTOS

INSERT INTO `novedades`.`Conjunto` (`inventario_id_conjunto`, `Inventario_id_pieza`) VALUES 
	(15, 13), -- amarillo xs con amarillo xs -> OK
	(15, 1); -- amarillo xs con amarillo xs -> OK

-- STOCK POR TIENDAS

 INSERT INTO `novedades`.`Disponibilidad` (`Inventario_id`, `Sucursal_id`, `stock`) VALUES 
 	(1, 1, 10), (2, 1, 13), (3, 2, 6), (4, 1, 8), (5, 1, 9), 
    (6, 1, 20), (7, 1, 42), (8, 1, 23), (9, 1, 9), (10, 1, 1), 
    (11, 1, 23), (12, 1, 5), (13, 1, 8), (14, 1, 0), (15, 1, 7), 
    (1, 2, 67), (2, 2, 10), (4, 2, 11), (5, 2, 5), (6, 2, 8), 
    (7, 2, 7), (9, 2, 9), (10, 2, 7), (11, 2, 12), (12, 2, 7),
	(14, 2, 9), (15, 2, 8);

-- ENVIOS

INSERT INTO `novedades`.`Envio` (`feha`, `Sucursal_id_destino`, `Usuario_id`) VALUES 
	('2020-12-10', 1, 'vnt1'),
    ('2023-01-09', 2, 'vnt1');

-- CONTENIDO DE LOS ENVIOS

INSERT INTO `novedades`.`Paquete` (`Disponibilidad_Inventario_id`, `Disponibilidad_Sucursal_id`, `Envio_id`, `cantidad`) VALUES 
	(12, 1, 2, 2),
    (15, 1, 2, 1),
    (10, 2, 1, 1);
