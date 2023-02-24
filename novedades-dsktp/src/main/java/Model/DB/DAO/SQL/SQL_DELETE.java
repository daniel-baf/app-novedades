package Model.DB.DAO.SQL;

public enum SQL_DELETE implements SQL_SENTENCE {
    AREA("DELETE FROM `novedades`.`Area` WHERE `id` = ?;"),
    USER("DELETE FROM `novedades`.`Usuario` WHERE (`id` = ?);");

    private String sentence;

    SQL_DELETE(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return this.sentence;
    }
}
