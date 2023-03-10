package Model.DB.DAO.SQL;

/**
 * Coleccion de sentencias SQL para insertar en la base de datos
 *
 * @author colaborativo
 */
public enum SQL_INSERT implements SQL_SENTENCE{
    SELL("INSERT INTO `novedades`.`Venta` (`fecha`, `nit`, `nombre`, `total`, `Usuario_id`, `Cliente_Especial_id`, `no_listada`) VALUES (?, ?, ?, ?, ?, ?, ?) "),
    SELL_DETAIL("INSERT INTO `novedades`.`Detalle_Venta` (`Inventario_Sucursal_Inventario_id`, `Inventario_Sucursal_Sucursal_id`, `Venta_id`, `cantidad`, `precio_unitario`, `subtotal`) VALUES (?, ?, ?, ?, ?, ?) "),
    USER("INSERT INTO `novedades`.`Usuario` (`id`, `nombre`, `password`, `Area_id`) VALUES (?, ?, ?, ?) "),
    AREA("INSERT INTO `novedades`.`Area` (`id`) VALUES (?) ");

    private final String sentence;
    SQL_INSERT(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public String getSentence() {
        return this.sentence;
    }
}
