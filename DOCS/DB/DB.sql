-- APP DB

DROP SCHEMA IF EXISTS `novedades`;
CREATE SCHEMA `novedades`;
USE `novedades`;

-- GASTOS

CREATE TABLE `novedades`.`Categoria_Gasto` (
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nombre`));

CREATE TABLE `novedades`.`Gasto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `total` DECIMAL(7,2) NOT NULL COMMENT 'Venta maxima de 99,999.99',
  `descripcion` VARCHAR(70) NULL COMMENT 'Si se desea tener una descripción detallada del gasto',
  `categoria` VARCHAR(45) NOT NULL COMMENT 'Categoria del tipo de gasto, ej: Pagos, remodelaciones...',
  PRIMARY KEY (`id`),
  INDEX `fk_gasto_categoria_idx` (`categoria` ASC) VISIBLE,
  CONSTRAINT `fk_gasto_categoria`
    FOREIGN KEY (`categoria`)
    REFERENCES `novedades`.`Categoria_Gasto` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- USUARIOS

CREATE TABLE `novedades`.`Area` (
  `area` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`area`));

CREATE TABLE `novedades`.`Usuario` (
  `usuario` VARCHAR(45) NOT NULL COMMENT 'Debe medir maximo 20 caracteres, para que encriptada ocupe 45 caracteres',
  `nombre` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL COMMENT 'Debe medir maximo 20 caracteres, para que encriptada ocupe 45 caracteres',
  `area` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`usuario`),
  INDEX `fk_usuario_area_idx` (`area` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_area`
    FOREIGN KEY (`area`)
    REFERENCES `novedades`.`Area` (`area`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- CLIENTE ESPECIAL

CREATE TABLE `novedades`.`Cliente_Especial` (
  `codigo` VARCHAR(45) NOT NULL COMMENT 'Debe medir maximo 20 caracteres, para que encriptada ocupe 45 caracteres',
  PRIMARY KEY (`codigo`));

-- TARJETA DE REGALO
-- TODO, preguntar si se debe encriptar este dato

CREATE TABLE `novedades`.`Tarjeta_Regalo` (
  `codigo` VARCHAR(25) NOT NULL,
  `valor` TINYINT NOT NULL,
  PRIMARY KEY (`codigo`));

-- SUCURSAL

CREATE TABLE `novedades`.`Sucursal` (
  `direccion` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(10) NULL,
  PRIMARY KEY (`direccion`));

-- PRODUCTO

CREATE TABLE `novedades`.`Talla` (
  `talla` VARCHAR(3) NOT NULL COMMENT 'MV: XXL',
  PRIMARY KEY (`talla`));

CREATE TABLE `novedades`.`Color` (
  `color` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`color`));

CREATE TABLE `novedades`.`Producto` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(35) NOT NULL,
  `es_compuesto` TINYINT NOT NULL DEFAULT 0,
  `esta_descontinuada` TINYINT NOT NULL,
  `precio` DOUBLE NOT NULL DEFAULT 0,
  `precio_especial` DOUBLE NOT NULL,
  `talla` VARCHAR(3) NOT NULL,
  `color` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_producto_talla_idx` (`talla` ASC) VISIBLE,
  INDEX `fk_producto_color_idx` (`color` ASC) VISIBLE,
  CONSTRAINT `fk_producto_talla`
    FOREIGN KEY (`talla`)
    REFERENCES `novedades`.`Talla` (`talla`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_color`
    FOREIGN KEY (`color`)
    REFERENCES `novedades`.`Color` (`color`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

CREATE TABLE `novedades`.`Producto_Producto` (
  `producto_codigo` INT NOT NULL COMMENT 'El conjunto / prenda compuesta',
  `producto_codigo_item` INT NOT NULL COMMENT 'Lo que forma el conjunto /  prenda compuesta',
  PRIMARY KEY (`producto_codigo`, `producto_codigo_item`),
  INDEX `fk_producto_item_idx` (`producto_codigo_item` ASC) VISIBLE,
  CONSTRAINT `fk_producto_conjunto`
    FOREIGN KEY (`producto_codigo`)
    REFERENCES `novedades`.`Producto` (`codigo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_item`
    FOREIGN KEY (`producto_codigo_item`)
    REFERENCES `novedades`.`Producto` (`codigo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

-- PRODUCTO Y SUCURSAL

CREATE TABLE `novedades`.`Producto_Sucursal` (
  `sucursal_direccion` VARCHAR(50) NOT NULL,
  `producto_codigo` INT NOT NULL,
  `stock` INT NOT NULL,
  PRIMARY KEY (`sucursal_direccion`, `producto_codigo`),
  INDEX `fk_producto_sucursal_Producto_idx` (`producto_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_producto_sucursal_Sucursal`
    FOREIGN KEY (`sucursal_direccion`)
    REFERENCES `novedades`.`Sucursal` (`direccion`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_sucursal_Producto`
    FOREIGN KEY (`producto_codigo`)
    REFERENCES `novedades`.`Producto` (`codigo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

-- ENVIOS

CREATE TABLE `novedades`.`Envio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL DEFAULT (CURRENT_DATE),
  `sucursal_direccion_destino` VARCHAR(50) NOT NULL, -- no contiene origen porque se obtiene del contenido de Produto_Envio
  PRIMARY KEY (`id`),
  INDEX `fk_envio_sucursal_destino_idx` (`sucursal_direccion_destino` ASC) VISIBLE,
  CONSTRAINT `fk_envio_sucursal_destino`
    FOREIGN KEY (`sucursal_direccion_destino`)
    REFERENCES `novedades`.`Sucursal` (`direccion`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

CREATE TABLE `novedades`.`Producto_Envio` (
  `envio_id` INT NOT NULL,
  `producto_sucursal_codigo` INT NOT NULL,
  `producto_sucursal_sucursal` VARCHAR(50) NULL,
  `cantidad` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`envio_id`, `producto_sucursal_codigo`),
  INDEX `fk_Producto_envio_Producto_sucursal_idx` (`producto_sucursal_codigo` ASC, `producto_sucursal_sucursal` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_envio_Producto_sucursal`
    FOREIGN KEY (`producto_sucursal_codigo` , `producto_sucursal_sucursal`)
    REFERENCES `novedades`.`Producto_Sucursal` (`producto_codigo` , `sucursal_direccion`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

-- VENTA

CREATE TABLE `novedades`.`Venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL DEFAULT (CURRENT_DATE),
  `nombre` VARCHAR(45) NULL,
  `NIT` VARCHAR(9) NULL,
  `total` DECIMAL NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `novedades`.`Venta_Prod_Sucursal` (
  `venta_id` INT NOT NULL,
  `producto_sucursal_direccion` VARCHAR(50) NOT NULL,
  `producto_sucursal_prod_codigo` INT NOT NULL,
  `cantidad` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`venta_id`, `producto_sucursal_direccion`, `producto_sucursal_prod_codigo`),
  INDEX `fk_venta_producto_sucursal_idx` (`producto_sucursal_direccion` ASC, `producto_sucursal_prod_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_venta_prod_sucursal_producto_sucursal`
    FOREIGN KEY (`producto_sucursal_direccion` , `producto_sucursal_prod_codigo`)
    REFERENCES `novedades`.`Producto_Sucursal` (`sucursal_direccion` , `producto_codigo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_prod_sucursal_venta`
	FOREIGN KEY (`venta_id`)
    REFERENCES `novedades`.`Venta` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

-- INTERCAMBIO

CREATE TABLE `novedades`.`Intercambio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venta_id` INT NOT NULL,
  `prod_codigo_original` INT NOT NULL,
  `prod_codigo_cambio` INT NOT NULL,
  `prod_sucursal_original` VARCHAR(50) NOT NULL,
  `prod_sucursal_cambio` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_intercambio_prod_sucursal_idx` (`prod_codigo_original` ASC, `prod_sucursal_original` ASC) VISIBLE,
  INDEX `fk_intercambio_prod_sucursal_cambio_idx` (`prod_codigo_cambio` ASC, `prod_sucursal_cambio` ASC) VISIBLE,
  CONSTRAINT `fk_intercambio_venta`
    FOREIGN KEY (`venta_id`)
    REFERENCES `novedades`.`Venta` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_intercambio_prod_sucursal_original`
    FOREIGN KEY (`prod_codigo_original` , `prod_sucursal_original`)
    REFERENCES `novedades`.`Producto_Sucursal` (`producto_codigo` , `sucursal_direccion`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_intercambio_prod_sucursal_cambio`
    FOREIGN KEY (`prod_codigo_cambio` , `prod_sucursal_cambio`)
    REFERENCES `novedades`.`Producto_Sucursal` (`producto_codigo` , `sucursal_direccion`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);

-- CREACION DE USUARIO PARA APPLICACION

USE mysql; -- cambio de BD para crear usuario

-- configuración de usuario que solo tendrá acceso a la BD que se creará

DROP USER IF EXISTS 'app-usr'@'localhost';
CREATE USER 'app-usr'@'localhost' IDENTIFIED BY 'Carro_252525';
GRANT ALL PRIVILEGES ON `novedades`.* TO 'app-usr'@'localhost';
FLUSH PRIVILEGES;

