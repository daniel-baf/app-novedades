package Backend.DB.DAO;

public enum SQL_SENTENCES {
    // Area
    INSERT_AREA("INSERT INTO `novedades`.`Area` (`area`) VALUES (?);"),
    SELECT_AREA_ALL("SELECT * FROM novedades.Area;"),
    DELETE_AREA("DELETE FROM `novedades`.`Area` WHERE (`area` = ?);");

    // data
    private String sentence;

    private SQL_SENTENCES(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
