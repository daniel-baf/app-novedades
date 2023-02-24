package Utils;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Esta clase sirve para hacer casteos entre ciertos tipos de datos de SQL a JAVA
 *
 * @author jefe_mayoneso
 */
public class Parser {

    public Parser() {
    }

    /**
     * Castea de tipo de dato LOCALDATE a SQL DATE
     *
     * @param date la fecha en formato LOCALDATE
     * @return la fecha en formato SQL DATE
     */
    public Date toDate(LocalDate date) {
        try {
            return Date.valueOf(date);
        } catch (Exception e) {
            return null;
        }
    }

    public Date toDate(String date) {
        try {
            return Date.valueOf(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Castea de un tipo de dato SQL DATE a LOCALDATE
     *
     * @param date la fecha en formato SQL DATE
     * @return la fecha en formato LOCALDATE
     */
    public LocalDate toLocalDate(Date date) {
        return date.toLocalDate();
    }

    public LocalDate toLocalDate(String dateString) {
        return LocalDate.parse(dateString);
    }

}
