package Backend.Utils;

import Backend.DB.DAO.Usuario.AreaDAO;

public class CustomException extends Exception {

    public CustomException(String message, Class aClass) {
        this(String.format("Ha ocurrido un error ejecutando un proceso.\nProceso: %1$s\nEn: %2$s", message, aClass.getName()));
    }

    public CustomException(String message) {
        super(message);
    }
}
