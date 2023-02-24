package Model.DB.DAO.SQL;

public enum SQL_INSERT implements SQL_SENTENCE{
    USER("INSERT INTO `novedades`.`Usuario` (`id`, `nombre`, `password`, `Area_id`) VALUES (?, ?, ?, ?);"),
    AREA("INSERT INTO `novedades`.`Area` (`id`) VALUES (?);");

    private String sentence;
    SQL_INSERT(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public String getSentence() {
        return this.sentence;
    }
}
