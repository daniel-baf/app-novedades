-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema novedades
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `novedades` ;

-- -----------------------------------------------------
-- Schema novedades
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `novedades` ;
USE `novedades` ;

-- -----------------------------------------------------
-- Table `novedades`.`Categoria_Gasto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Categoria_Gasto` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Categoria_Gasto` (
  `gasto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`gasto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Gasto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Gasto` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Gasto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `total` DOUBLE NOT NULL,
  `descripcion` VARCHAR(100) NULL,
  `categoria_gasto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Gasto_Categoria_Gasto_idx` (`categoria_gasto` ASC) VISIBLE,
  CONSTRAINT `fk_Gasto_Categoria_Gasto`
    FOREIGN KEY (`categoria_gasto`)
    REFERENCES `novedades`.`Categoria_Gasto` (`gasto`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Area` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Area` (
  `id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Usuario` (
  `id` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `Area_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Area1_idx` (`Area_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Area1`
    FOREIGN KEY (`Area_id`)
    REFERENCES `novedades`.`Area` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Cliente_Especial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Cliente_Especial` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Cliente_Especial` (
  `id` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Sucursal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Sucursal` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Sucursal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(9) NULL,
  `direccion` VARCHAR(55) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `direccion_UNIQUE` (`direccion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Talla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Talla` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Talla` (
  `talla` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`talla`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Color` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Color` (
  `color` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`color`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Producto` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL UNIQUE,
  `compuesto` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `novedades`.`Prod_Talla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Prod_Talla` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Prod_Talla` (
  `Producto_id` INT NOT NULL,
  `talla` VARCHAR(4) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `precio_especial` DOUBLE NOT NULL,
  PRIMARY KEY (`Producto_id`, `talla`),
  INDEX `fk_Producto_has_Talla_Talla1_idx` (`talla` ASC) VISIBLE,
  INDEX `fk_Producto_has_Talla_Producto1_idx` (`Producto_id` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Talla_Producto1`
    FOREIGN KEY (`Producto_id`)
    REFERENCES `novedades`.`Producto` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Producto_has_Talla_Talla1`
    FOREIGN KEY (`talla`)
    REFERENCES `novedades`.`Talla` (`talla`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Inventario` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Inventario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(20) NOT NULL,
  `Prod_Talla_Producto_id` INT NOT NULL,
  `Prod_Talla_talla` VARCHAR(4) NOT NULL,
  INDEX `fk_Color_has_Prod_Talla_Prod_Talla1_idx` (`Prod_Talla_Producto_id` ASC, `Prod_Talla_talla` ASC) VISIBLE,
  INDEX `fk_Color_has_Prod_Talla_Color1_idx` (`color` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Color_has_Prod_Talla_Color1`
    FOREIGN KEY (`color`)
    REFERENCES `novedades`.`Color` (`color`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Color_has_Prod_Talla_Prod_Talla1`
    FOREIGN KEY (`Prod_Talla_Producto_id` , `Prod_Talla_talla`)
    REFERENCES `novedades`.`Prod_Talla` (`Producto_id` , `talla`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Conjunto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Conjunto` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Conjunto` (
  `inventario_id_conjunto` INT NOT NULL,
  `inventario_id_pieza` INT NOT NULL,
  PRIMARY KEY (`inventario_id_conjunto`, `inventario_id_pieza`),
  INDEX `fk_Inventario_has_Inventario_Inventario2_idx` (`inventario_id_pieza` ASC) VISIBLE,
  INDEX `fk_Inventario_has_Inventario_Inventario1_idx` (`inventario_id_conjunto` ASC) VISIBLE,
  CONSTRAINT `fk_Inventario_has_Inventario_Inventario1`
    FOREIGN KEY (`inventario_id_conjunto`)
    REFERENCES `novedades`.`Inventario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventario_has_Inventario_Inventario2`
    FOREIGN KEY (`inventario_id_pieza`)
    REFERENCES `novedades`.`Inventario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `novedades`.`Disponibilidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Disponibilidad` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Disponibilidad` (
  `Inventario_id` INT NOT NULL,
  `Sucursal_id` INT NOT NULL,
  `stock` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`Inventario_id`, `Sucursal_id`),
  INDEX `fk_Inventario_has_Sucursal_Sucursal1_idx` (`Sucursal_id` ASC) VISIBLE,
  INDEX `fk_Inventario_has_Sucursal_Inventario1_idx` (`Inventario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Inventario_has_Sucursal_Inventario1`
    FOREIGN KEY (`Inventario_id`)
    REFERENCES `novedades`.`Inventario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventario_has_Sucursal_Sucursal1`
    FOREIGN KEY (`Sucursal_id`)
    REFERENCES `novedades`.`Sucursal` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Envio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Envio` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Envio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `feha` DATE NOT NULL,
  `Sucursal_id_destino` INT NOT NULL,
  `Usuario_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Envio_Sucursal1_idx` (`Sucursal_id_destino` ASC) VISIBLE,
  INDEX `fk_Envio_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Envio_Sucursal1`
    FOREIGN KEY (`Sucursal_id_destino`)
    REFERENCES `novedades`.`Sucursal` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Envio_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `novedades`.`Usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Paquete`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Paquete` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Paquete` (
  `Disponibilidad_Inventario_id` INT NOT NULL,
  `Disponibilidad_Sucursal_id` INT NOT NULL,
  `Envio_id` INT NOT NULL,
  `cantidad` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`Disponibilidad_Inventario_id`, `Disponibilidad_Sucursal_id`, `Envio_id`),
  INDEX `fk_Disponibilidad_has_Envio_Envio1_idx` (`Envio_id` ASC) VISIBLE,
  INDEX `fk_Disponibilidad_has_Envio_Disponibilidad1_idx` (`Disponibilidad_Inventario_id` ASC, `Disponibilidad_Sucursal_id` ASC) VISIBLE,
  CONSTRAINT `fk_Disponibilidad_has_Envio_Disponibilidad1`
    FOREIGN KEY (`Disponibilidad_Inventario_id` , `Disponibilidad_Sucursal_id`)
    REFERENCES `novedades`.`Disponibilidad` (`Inventario_id` , `Sucursal_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Disponibilidad_has_Envio_Envio1`
    FOREIGN KEY (`Envio_id`)
    REFERENCES `novedades`.`Envio` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Venta` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `nit` VARCHAR(10) NULL DEFAULT 'CF',
  `nombre` VARCHAR(45) NOT NULL,
  `total` DECIMAL NOT NULL,
  `Usuario_id` VARCHAR(20) NOT NULL,
  `Cliente_Especial_id` VARCHAR(10) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Venta_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  INDEX `fk_Venta_Cliente_Especial1_idx` (`Cliente_Especial_id` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `novedades`.`Usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Venta_Cliente_Especial1`
    FOREIGN KEY (`Cliente_Especial_id`)
    REFERENCES `novedades`.`Cliente_Especial` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Listado_Venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Listado_Venta` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Listado_Venta` (
  `Disponibilidad_Inventario_id` INT NOT NULL,
  `Disponibilidad_Sucursal_id` INT NOT NULL,
  `Venta_id` INT NOT NULL,
  `cantidad` TINYINT NOT NULL,
  PRIMARY KEY (`Disponibilidad_Inventario_id`, `Disponibilidad_Sucursal_id`, `Venta_id`),
  INDEX `fk_Disponibilidad_has_Venta_Venta1_idx` (`Venta_id` ASC) VISIBLE,
  INDEX `fk_Disponibilidad_has_Venta_Disponibilidad1_idx` (`Disponibilidad_Inventario_id` ASC, `Disponibilidad_Sucursal_id` ASC) VISIBLE,
  CONSTRAINT `fk_Disponibilidad_has_Venta_Disponibilidad1`
    FOREIGN KEY (`Disponibilidad_Inventario_id` , `Disponibilidad_Sucursal_id`)
    REFERENCES `novedades`.`Disponibilidad` (`Inventario_id` , `Sucursal_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Disponibilidad_has_Venta_Venta1`
    FOREIGN KEY (`Venta_id`)
    REFERENCES `novedades`.`Venta` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `novedades`.`Intercambio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `novedades`.`Intercambio` ;

CREATE TABLE IF NOT EXISTS `novedades`.`Intercambio` (
  `id` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `Disponibilidad_Inventario_id` INT NOT NULL,
  `Disponibilidad_Sucursal_id` INT NOT NULL,
  `Disponibilidad_Inventario_id1` INT NOT NULL,
  `Disponibilidad_Sucursal_id1` INT NOT NULL,
  `Venta_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Intercambio_Disponibilidad1_idx` (`Disponibilidad_Inventario_id` ASC, `Disponibilidad_Sucursal_id` ASC) VISIBLE,
  INDEX `fk_Intercambio_Disponibilidad2_idx` (`Disponibilidad_Inventario_id1` ASC, `Disponibilidad_Sucursal_id1` ASC) VISIBLE,
  INDEX `fk_Intercambio_Venta1_idx` (`Venta_id` ASC) VISIBLE,
  CONSTRAINT `fk_Intercambio_Disponibilidad1`
    FOREIGN KEY (`Disponibilidad_Inventario_id` , `Disponibilidad_Sucursal_id`)
    REFERENCES `novedades`.`Disponibilidad` (`Inventario_id` , `Sucursal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Intercambio_Disponibilidad2`
    FOREIGN KEY (`Disponibilidad_Inventario_id1` , `Disponibilidad_Sucursal_id1`)
    REFERENCES `novedades`.`Disponibilidad` (`Inventario_id` , `Sucursal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Intercambio_Venta1`
    FOREIGN KEY (`Venta_id`)
    REFERENCES `novedades`.`Venta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- //////////////////////////////////////////////////////////////
-- ///////////////            TRIGGERS            ///////////////
-- //////////////////////////////////////////////////////////////


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `novedades`;

DELIMITER $$

USE `novedades`$$
DROP TRIGGER IF EXISTS `novedades`.`Inventario_BEFORE_INSERT` $$
USE `novedades`$$
CREATE DEFINER = CURRENT_USER TRIGGER `novedades`.`Inventario_BEFORE_INSERT` BEFORE INSERT ON `Inventario` FOR EACH ROW
BEGIN
	IF EXISTS 
		(SELECT * FROM `Inventario` 
			WHERE color=new.color 
            AND Prod_Talla_Producto_id = new.Prod_Talla_Producto_id
            AND Prod_Talla_talla = new.Prod_Talla_talla) THEN
				SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Ya existe un elemento con estos atributos";
	END IF;
END$$


DELIMITER ;

DROP TRIGGER IF EXISTS `novedades`.`Conjunto_BEFORE_INSERT`;

DELIMITER $$
USE `novedades`$$
CREATE DEFINER = CURRENT_USER TRIGGER `novedades`.`Conjunto_BEFORE_INSERT` BEFORE INSERT ON `Conjunto` FOR EACH ROW
BEGIN
    -- bundle color and size
	DECLARE piece_color VARCHAR(20);
    DECLARE conj_color VARCHAR(20);
    DECLARE piece_size VARCHAR(4);
    DECLARE conj_size VARCHAR(4);
    DECLARE is_conj TINYINT;

    -- get the bundle data and piece data
    SELECT `compuesto` INTO is_conj FROM `novedades`.`Producto` WHERE `id`=new.inventario_id_conjunto;

    SELECT `Prod_Talla_talla` INTO conj_size FROM `novedades`.`Inventario` WHERE `id`=new.inventario_id_pieza;
    SELECT `Prod_Talla_talla` INTO conj_size FROM `novedades`.`Inventario` WHERE `id`=new.inventario_id_conjunto;

    SELECT `color` INTO piece_color FROM `novedades`.`Inventario` WHERE `id`=new.inventario_id_pieza;
    SELECT `color` INTO conj_color FROM `novedades`.`Inventario` WHERE `id`=new.inventario_id_conjunto;

    -- compare
    IF(is_conj = 0) THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "La pieza madre no es un conjunto";
    ELSE
      IF (piece_color != conj_color OR piece_size != conj_size) THEN
          -- error
          SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "El conjunto y la pieza no coinciden en talla o color";
      END IF;
    END IF;
END$$
DELIMITER ;

-- configuración de usuario que solo tendrá acceso a la BD que se creará

USE `mysql`;

DROP USER IF EXISTS 'app-usr'@'localhost';
CREATE USER 'app-usr'@'localhost' IDENTIFIED BY 'Carro_252525';
GRANT ALL PRIVILEGES ON `novedades`.* TO 'app-usr'@'localhost';
FLUSH PRIVILEGES;