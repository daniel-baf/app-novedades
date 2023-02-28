package Model.DB.DAO.SQL;

/**
 * Coleccion de sentencias SQL para borrar en la base de datos
 *
 * @author colaborativo
 */
public enum SQL_DELETE implements SQL_SENTENCE {
    AREA("DELETE FROM `novedades`.`Area` WHERE `id` = ? "),
    USER("DELETE FROM `novedades`.`Usuario` WHERE (`id` = ?) ");

    private final String sentence;

    SQL_DELETE(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getSentence() {
        return this.sentence;
    }
}
