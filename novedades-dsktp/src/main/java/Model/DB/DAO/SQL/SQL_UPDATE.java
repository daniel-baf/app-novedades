package Model.DB.DAO.SQL;

public enum SQL_UPDATE implements SQL_SENTENCE {

    USER("UPDATE `novedades`.`Usuario` SET `nombre` = ?, `password` = ?, `Area_id` = ? WHERE (`id` = ?);");
    private String sentence;

    SQL_UPDATE(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public String getSentence() {
        return this.sentence;
    }
}
