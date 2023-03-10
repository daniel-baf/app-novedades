package Utils;

import View.ErrorConsoleJDialog;

import javax.swing.*;

/**
 * Esta clase sirve para lanzar errores personalizados y que todos tengan un mismo formato para ser atrapados
 *
 * @author jefe_mayoneso
 */
public class CustomException extends Exception {

    public static ErrorConsoleJDialog GUI = new ErrorConsoleJDialog(null, false); // lo hacemos veradedor para que bloquee el acceso a otras ventanas hasta ser cerrada la ventan

    public CustomException() {
    }

    /**
     * Crea un mensaje estandarizado para que todos manejemos el mismo
     * mensaje al imprimir errores
     *
     * @param message el error del mensaje
     * @param aClass  la clase donde ocurre el error
     * @return el mensaje con formato estandar
     */
    public static String formatError(String message, Class aClass) {
        // muestra el error en GUI
        // TODO esto es temporal
        String data = String.format("%1$s\n\t%2$s", message, aClass.getName().toUpperCase());
        GUI.addError(aClass.getName(), data);
        return data;
    }
}
