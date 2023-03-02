package Model.DB.DAO.SQL;

/**
 * Interfaz generica para la implementacion de ENUMS para las sentencias SQL de las clases DAO
 *
 * @author jefe_mayoneso
 */
public interface SQL_SENTENCE {

        // GENERAL
   String  WHERE = " WHERE ";
   String AND = " AND ";
    String LIMIT = " LIMIT ? ";
    String OFFSET = " OFFSET ? ";

    String getSentence();
}
