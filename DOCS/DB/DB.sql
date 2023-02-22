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
-- Table `Area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Area` (
  `id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Categoria_Gasto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Categoria_Gasto` (
  `gasto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`gasto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Cliente_Especial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cliente_Especial` (
  `id` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Color` (
  `color` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`color`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `compuesto` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Talla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Talla` (
  `talla` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`talla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Prod_Talla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Prod_Talla` (
  `Producto_id` INT NOT NULL,
  `talla` VARCHAR(4) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `precio_especial` DOUBLE NOT NULL,
  PRIMARY KEY (`Producto_id`, `talla`),
  INDEX `fk_Producto_has_Talla_Talla1_idx` (`talla` ASC) VISIBLE,
  INDEX `fk_Producto_has_Talla_Producto1_idx` (`Producto_id` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Talla_Producto1`
    FOREIGN KEY (`Producto_id`)
    REFERENCES `Producto` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Producto_has_Talla_Talla1`
    FOREIGN KEY (`talla`)
    REFERENCES `Talla` (`talla`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Inventario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(20) NOT NULL,
  `Prod_Talla_Producto_id` INT NOT NULL,
  `Prod_Talla_talla` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Color_has_Prod_Talla_Prod_Talla1_idx` (`Prod_Talla_Producto_id` ASC, `Prod_Talla_talla` ASC) VISIBLE,
  INDEX `fk_Color_has_Prod_Talla_Color1_idx` (`color` ASC) VISIBLE,
  CONSTRAINT `fk_Color_has_Prod_Talla_Color1`
    FOREIGN KEY (`color`)
    REFERENCES `Color` (`color`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Color_has_Prod_Talla_Prod_Talla1`
    FOREIGN KEY (`Prod_Talla_Producto_id` , `Prod_Talla_talla`)
    REFERENCES `Prod_Talla` (`Producto_id` , `talla`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Conjunto` (
  `inventario_id_conjunto` INT NOT NULL,
  `Inventario_id_pieza` INT NOT NULL,
  PRIMARY KEY (`inventario_id_conjunto`, `Inventario_id_pieza`),
  INDEX `fk_Inventario_has_Inventario_Inventario2_idx` (`Inventario_id_pieza` ASC) VISIBLE,
  INDEX `fk_Inventario_has_Inventario_Inventario1_idx` (`inventario_id_conjunto` ASC) VISIBLE,
  CONSTRAINT `fk_Inventario_has_Inventario_Inventario1`
    FOREIGN KEY (`inventario_id_conjunto`)
    REFERENCES `Inventario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventario_has_Inventario_Inventario2`
    FOREIGN KEY (`Inventario_id_pieza`)
    REFERENCES `Inventario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Sucursal`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `novedades`.`Sucursal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(9) NULL DEFAULT NULL,
  `direccion` VARCHAR(55) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `direccion_UNIQUE` (`direccion` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Inventario_Sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Inventario_Sucursal` (
  `Inventario_id` INT NOT NULL,
  `Sucursal_id` INT NOT NULL,
  `stock` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`Inventario_id`, `Sucursal_id`),
  INDEX `fk_Inventario_has_Sucursal_Sucursal1_idx` (`Sucursal_id` ASC) VISIBLE,
  INDEX `fk_Inventario_has_Sucursal_Inventario1_idx` (`Inventario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Inventario_has_Sucursal_Inventario1`
    FOREIGN KEY (`Inventario_id`)
    REFERENCES `Inventario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inventario_has_Sucursal_Sucursal1`
    FOREIGN KEY (`Sucursal_id`)
    REFERENCES `Sucursal` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Usuario` (
  `id` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `Area_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Area1_idx` (`Area_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Area1`
    FOREIGN KEY (`Area_id`)
    REFERENCES `Area` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Envio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Envio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `Usuario_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Envio_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Envio_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `Usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Detalle_Envio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Detalle_Envio` (
  `Inventario_Sucursal_Inventario_id` INT NOT NULL,
  `Inventario_Sucursal_Sucursal_id` INT NOT NULL,
  `Envio_id` INT NOT NULL,
  `cantidad` INT NOT NULL DEFAULT '1',
  `Sucursal_id` INT NOT NULL,
  PRIMARY KEY (`Inventario_Sucursal_Inventario_id`, `Inventario_Sucursal_Sucursal_id`, `Envio_id`),
  INDEX `fk_Disponibilidad_has_Envio_Envio1_idx` (`Envio_id` ASC) VISIBLE,
  INDEX `fk_Disponibilidad_has_Envio_Disponibilidad1_idx` (`Inventario_Sucursal_Inventario_id` ASC, `Inventario_Sucursal_Sucursal_id` ASC) VISIBLE,
  INDEX `fk_Paquete_Sucursal1_idx` (`Sucursal_id` ASC) VISIBLE,
  CONSTRAINT `fk_Disponibilidad_has_Envio_Disponibilidad1`
    FOREIGN KEY (`Inventario_Sucursal_Inventario_id` , `Inventario_Sucursal_Sucursal_id`)
    REFERENCES `Inventario_Sucursal` (`Inventario_id` , `Sucursal_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Disponibilidad_has_Envio_Envio1`
    FOREIGN KEY (`Envio_id`)
    REFERENCES `Envio` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Paquete_Sucursal1`
    FOREIGN KEY (`Sucursal_id`)
    REFERENCES `Sucursal` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `nit` VARCHAR(10) NULL DEFAULT 'CF',
  `nombre` VARCHAR(45) NOT NULL,
  `total` DECIMAL(10,0) NOT NULL,
  `Usuario_id` VARCHAR(20) NOT NULL,
  `Cliente_Especial_id` VARCHAR(10) NULL DEFAULT NULL,
  `no_listada` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_Venta_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  INDEX `fk_Venta_Cliente_Especial1_idx` (`Cliente_Especial_id` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Cliente_Especial1`
    FOREIGN KEY (`Cliente_Especial_id`)
    REFERENCES `Cliente_Especial` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Venta_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `Usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Detalle_Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Detalle_Venta` (
  `Inventario_Sucursal_Inventario_id` INT NOT NULL,
  `Inventario_Sucursal_Sucursal_id` INT NOT NULL,
  `Venta_id` INT NOT NULL,
  `cantidad` TINYINT NOT NULL,
  `precio_unitario` DECIMAL(10,0) NOT NULL,
  `subtotal` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`Inventario_Sucursal_Inventario_id`, `Inventario_Sucursal_Sucursal_id`, `Venta_id`),
  INDEX `fk_Disponibilidad_has_Venta_Venta1_idx` (`Venta_id` ASC) VISIBLE,
  INDEX `fk_Disponibilidad_has_Venta_Disponibilidad1_idx` (`Inventario_Sucursal_Inventario_id` ASC, `Inventario_Sucursal_Sucursal_id` ASC) VISIBLE,
  CONSTRAINT `fk_Disponibilidad_has_Venta_Disponibilidad1`
    FOREIGN KEY (`Inventario_Sucursal_Inventario_id` , `Inventario_Sucursal_Sucursal_id`)
    REFERENCES `Inventario_Sucursal` (`Inventario_id` , `Sucursal_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Disponibilidad_has_Venta_Venta1`
    FOREIGN KEY (`Venta_id`)
    REFERENCES `Venta` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Gasto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gasto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `total` DOUBLE NOT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  `categoria_gasto` VARCHAR(45) NOT NULL,
  `Usuario_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Gasto_Categoria_Gasto_idx` (`categoria_gasto` ASC) VISIBLE,
  INDEX `fk_Gasto_Usuario1_idx` (`Usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_Gasto_Categoria_Gasto`
    FOREIGN KEY (`categoria_gasto`)
    REFERENCES `Categoria_Gasto` (`gasto`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Gasto_Usuario1`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `Usuario` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Intercambio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intercambio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `Inventario_Sucursal_Inventario_id_cambio` INT NOT NULL,
  `Inventario_Sucursal_Sucursal_id_cambio` INT NOT NULL,
  `Inventario_Sucursal_Inventario_id_viejo` INT NOT NULL,
  `Inventario_Sucursal_Sucursal_id_viejo` INT NOT NULL,
  `Venta_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Intercambio_Disponibilidad1_idx` (`Inventario_Sucursal_Inventario_id_cambio` ASC, `Inventario_Sucursal_Sucursal_id_cambio` ASC) VISIBLE,
  INDEX `fk_Intercambio_Disponibilidad2_idx` (`Inventario_Sucursal_Inventario_id_viejo` ASC, `Inventario_Sucursal_Sucursal_id_viejo` ASC) VISIBLE,
  INDEX `fk_Intercambio_Venta1_idx` (`Venta_id` ASC) VISIBLE,
  CONSTRAINT `fk_Intercambio_Disponibilidad1`
    FOREIGN KEY (`Inventario_Sucursal_Inventario_id_cambio` , `Inventario_Sucursal_Sucursal_id_cambio`)
    REFERENCES `Inventario_Sucursal` (`Inventario_id` , `Sucursal_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Intercambio_Disponibilidad2`
    FOREIGN KEY (`Inventario_Sucursal_Inventario_id_viejo` , `Inventario_Sucursal_Sucursal_id_viejo`)
    REFERENCES `Inventario_Sucursal` (`Inventario_id` , `Sucursal_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Intercambio_Venta1`
    FOREIGN KEY (`Venta_id`)
    REFERENCES `Venta` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `novedades`;

DELIMITER $$
USE `novedades`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `novedades`.`Inventario_BEFORE_INSERT`
BEFORE INSERT ON `novedades`.`Inventario`
FOR EACH ROW
BEGIN
	IF EXISTS 
		(SELECT * FROM `Inventario` 
			WHERE color=new.color 
            AND Prod_Talla_Producto_id = new.Prod_Talla_Producto_id
            AND Prod_Talla_talla = new.Prod_Talla_talla) THEN
				SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Ya existe un elemento con estos atributos";
	END IF;
END$$

USE `novedades`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `novedades`.`Conjunto_BEFORE_INSERT`
BEFORE INSERT ON `novedades`.`Conjunto`
FOR EACH ROW
BEGIN
    -- bundle color and size
	DECLARE piece_color VARCHAR(20);
    DECLARE conj_color VARCHAR(20);
    DECLARE piece_size VARCHAR(4);
    DECLARE conj_size VARCHAR(4);
    DECLARE is_conj TINYINT;

    -- get the bundle data and piece data

	SELECT `compuesto` INTO is_conj FROM `novedades`.`Producto` WHERE 
		`id`= (SELECT `Prod_Talla_Producto_id` FROM `novedades`.`Inventario` WHERE `id` = new.inventario_id_conjunto);

    SELECT `Prod_Talla_talla`, `color` INTO piece_size, piece_color FROM `novedades`.`Inventario` WHERE `id`=new.inventario_id_pieza;
    SELECT `Prod_Talla_talla`, `color` INTO conj_size, conj_color FROM `novedades`.`Inventario` WHERE `id`=new.inventario_id_conjunto;

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