package Model.DB.DAO;

public enum SQL_SENTENCES {
    // Area
    INSERT_AREA("INSERT INTO `novedades`.`Area` (`id`) VALUES (?);"),
    SELECT_AREA_ALL("SELECT * FROM novedades.Area;"),
    DELETE_AREA("DELETE FROM `novedades`.`Area` WHERE `id` = ?;"),
    // Usuario
    INSERT_USER("INSERT INTO `novedades`.`Usuario` (`id`, `nombre`, `password`, `Area_id`) VALUES (?, ?, ?, ?);"),
    SELECT_USER("SELECT * FROM novedades.Usuario WHERE id=?;"),
    UPDATE_USER("UPDATE `novedades`.`Usuario` SET `nombre` = ?, `password` = ?, `Area_id` = ? WHERE (`id` = ?);"),
    DELETE_USER("DELETE FROM `novedades`.`Usuario` WHERE (`id` = ?);"),
    // Sucursal
    SELECT_SUCURAL_ALL("SELECT * FROM novedades.Sucursal;");

    // data
    private String sentence;

    private SQL_SENTENCES(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
