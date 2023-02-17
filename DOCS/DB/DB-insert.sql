
-- CATEGORIA GASTOS
USE `novedades`;

INSERT INTO `novedades`.`Categoria_Gasto` (`nombre`) VALUES 
	('sueldos'), ('remodelaciones'), ('mercancia'), ('mobiliario y equipo');

-- GASTOS

INSERT INTO `novedades`.`Gasto` (`fecha`, `total`, `descripcion`, `categoria`) VALUES 
	('2019-10-02', 560, 'pago a empleados', 'sueldos'),
	('2019-11-05', 678, 'nuevos productos de prueba', 'mercancia'),
    ('2020-03-12', 123, 'empleados', 'sueldos'),
    ('2020-07-28', 442, 'pago a Ana', 'sueldos'),
    ('2022-09-01', 1201, 'Nuevas luces para la oficina', 'remodelaciones'),
	('2022-10-11', 980, 'Vitrinas nuevas', 'mobiliario y equipo'),
	('2023-01-19', 59, 'gorras', 'mercancia');

-- AREAS
INSERT INTO `novedades`.`Area` (`area`) VALUES 
	('administrativo'), ('operativo'), ('ventas');

-- USUARIOS

INSERT INTO `novedades`.`Usuario` (`usuario`, `nombre`, `password`, `area`) VALUES
	('slr1', 'Pepe Aguilar', 'nyAxukqFV5aEea67GUHbwg==', 'ventas'), -- pass: ventas123
	('adm1', 'Andrea Barilla', '9RP8WZOSpXTZRksFnnjWvA==', 'administrativo'), -- pass: admin123,
    ('vnt1', 'Jose Rodriguez', 'kHd/LorCm4ubE50LPiNrkQ==', 'operativo'); -- pass: ope123

-- USUARIOS ESPECIALES

INSERT INTO `novedades`.`Cliente_Especial` (`codigo`) VALUES 
	('esp1'), ('esp2');

-- TODO crear tarjetas de regalo, debemos editar para saber de dónde se generó la venta...

-- SUCURSAL

INSERT INTO `novedades`.`Sucursal` (`direccion`, `nombre`, `telefono`) VALUES
	('5 calle 10-64', 'Local 1 Centro Comercial', '77601234'), 
	('12 av 10-56', 'Central', '77604321');

-- TALLAS

INSERT INTO `novedades`.`Talla` (`talla`) VALUES
	('XS'), ('S'), ('M'), ('L'), ('XL'), ('8'),
    ('10'), ('12'), ('14'), ('16'); 

-- COLOR

INSERT INTO `novedades`.`Color` (`color`) VALUES
	('rojo'), ('amarillo'), ('gris'),
    ('negro'), ('verde'), ('verde lima');
    
-- PRODUCTOS

INSERT INTO `novedades`.`Producto` (`nombre`, `es_compuesto`, `esta_descontinuada`, `precio`, `precio_especial`, `talla`, `color`) VALUES 
	('sueter 1', 0, 0, 70, 65, 'm', 'rojo'), -- venta
    ('sueter 1', 0, 0, 70, 65, 'l', 'amarillo'), -- venta
	('sueter 1', 0, 0, 70, 65, 's', 'gris'),
    ('sueter 2', 0, 0, 50, 45, '16', 'negro'), -- venta cliente especial 2 items
    ('falda 1', 0, 0, 55, 50, 'l', 'verde'),
    ('falda 1', 0, 0, 55, 50, 'm', 'rojo'),
    ('pantalon 1', 0, 0, 75, 65, 'xs', 'verde lima'),
    ('conjunto 1', 1, 0, 120, 108, 'm', 'rojo'); -- conjunto 1: suter 1, falda 1 && venta

INSERT INTO `novedades`.`Producto_Producto` (`producto_codigo`, `producto_codigo_item`) VALUES 
	('8', '1'), ('8', '6');

INSERT INTO `novedades`.`Producto_Sucursal` (`sucursal_direccion`, `producto_codigo`, `stock`) VALUES
	('12 av 10-56', 1, 21), ('12 av 10-56', 2, 12), ('12 av 10-56', 3, 5), ('12 av 10-56', 4, 2),
    ('12 av 10-56', 5, 100), ('5 calle 10-64', 6, 34), ('5 calle 10-64', 7, 1), ('5 calle 10-64', 8, 9),
    ('5 calle 10-64', 1, 7), ('5 calle 10-64', 3, 0);

-- ENVIOS

INSERT INTO `novedades`.`Envio` (`fecha`, `sucursal_direccion_destino`) VALUES 
	('2023-01-12', '12 av 10-56'), ('2021-12-12', '12 av 10-56'), ('2019-05-01', '5 calle 10-64');

INSERT INTO `novedades`.`Producto_Envio` (`envio_id`, `producto_sucursal_codigo`, `producto_sucursal_sucursal`, `cantidad`) VALUES
	('1', 1, '5 calle 10-64', 2), -- se enviaron 2, hay 27 en 12 av y 7 en 5 av (o sea que habian 9) 
    ('2', 3, '5 calle 10-64', 1), ('2', 1, '5 calle 10-64', 4),
    ('3', 1, '12 av 10-56', 3);

-- VENTA

INSERT INTO `novedades`.`Venta` (`fecha`, `nombre`, `NIT`, `total`) VALUES
	('2020-10-09', 'El pepe', 'CF', 70), 
    ('2021-08-08', 'Juan', '12345678', 70),
    ('2022-09-23', 'Marta R. Kath', '12451231', 90), -- venta de 2 items a 45 c/u
    ('2023-02-18', 'Homero Simpson', 'CF', 120);

INSERT INTO `novedades`.`Venta_Prod_Sucursal` (`venta_id`, `producto_sucursal_direccion`, `producto_sucursal_prod_codigo`, `cantidad`) VALUES
	(1, '12 av 10-56', 1, 1), 
    (2, '12 av 10-56', 2, 1), 
    (3, '12 av 10-56', 4, 2),
    (4, '5 calle 10-64', 8, 1);

-- INTERCAMBIO

INSERT INTO `novedades`.`Intercambio` (`venta_id`, `prod_codigo_original`, `prod_codigo_cambio`, `prod_sucursal_original`, `prod_sucursal_cambio`) VALUES 
	(2, 4, 2, '12 av 10-56', '12 av 10-56');


