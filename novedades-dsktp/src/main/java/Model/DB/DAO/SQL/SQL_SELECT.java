package Model.DB.DAO.SQL;

/**
 * Coleccion de sentencias SQL para seleccionar en la base de datos
 *
 * @author colaborativo
 */
public enum SQL_SELECT implements SQL_SENTENCE {
    // USUSARIOS
    USER("SELECT * FROM novedades.Usuario WHERE id=? "),
    // SUCURSAL
    SUCURSAL_ALL("SELECT * FROM novedades.Sucursal "),
    SUCURSAL_ADD_ID(" WHERE `id` = ? "),
    // INVENTARIO SUCURSAL
    INVENTARIO_SUCURSAL("SELECT * FROM `novedades`.`Inventario_Sucursal` AS `is` "),
    INVENTARIO_SUCURSAL_ADD_SUC_ID(" `is`.`Sucursal_id` = ? "),
    INVENTARIO_SUCURSAL_BY_ID("SELECT * FROM `novedades`.`Inventario_Sucursal` WHERE `Inventario_Id`"),
    // INVENTARIO
    INVENTARIO("SELECT * FROM novedades.Inventario "),
    INVENTARIO_ADD_ID(" `id` = ? "),
    // PRODUCTO TALLA
    PRODUCTO_TALLA("SELECT * FROM novedades.Prod_Talla "),
    PRODUCTO_TALLA_ADD_ID(" WHERE `Producto_id` = ? AND talla = ? "),
    // PRODUCTO
    PRODUCTO("SELECT * FROM novedades.Producto "),
    // CONJUNTOS
    CONJUNTO("SELECT * FROM novedades.Conjunto "),
    CONJUNTO_ADD_ID(" WHERE `inventario_id_conjunto` = ? "),
    PRODUCTO_ADD_ID(" WHERE `id` = ? "),
    // AREA
    AREA_ALL("SELECT * FROM novedades.Area ");


    private final String sentence;

    SQL_SELECT(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public String getSentence() {
        return this.sentence;
    }
}
