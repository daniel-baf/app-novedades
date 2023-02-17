package Backend.DB.DAO;

public enum SQL_SENTENCES {
    // Area
    INSERT_AREA("INSERT INTO `novedades`.`Area` (`area`) VALUES (?);"),
    SELECT_AREA_ALL("SELECT * FROM novedades.Area;"),
    DELETE_AREA("DELETE FROM `novedades`.`Area` WHERE `area` = ?;"),
    // Usuario
    INSERT_USER("INSERT INTO `novedades`.`Usuario` (`usuario`, `nombre`, `password`, `area`) VALUES (?, ?, ?, ?);"),
    SELECT_USER("SELECT * FROM `novedades`.`Usuario` WHERE `usuario` = ?;"),
    UPDATE_USER("UPDATE `novedades`.`Usuario` SET `nombre` = ?, `password` = ?, `area` = ? WHERE (`usuario` = ?);"),
    DELETE_USER("DELETE FROM `novedades`.`Usuario` WHERE (`usuario` = ?);");

    // data
    private String sentence;

    private SQL_SENTENCES(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
