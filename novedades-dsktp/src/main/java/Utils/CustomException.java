package Utils;

/**
 * Esta clase sirve para lanzar errores personalizados y que todos tengan un mismo formato para ser atrapados
 *
 * @author jefe_mayoneso
 */
public class CustomException extends Exception {

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
        return String.format("Ha ocurrido un error ejecutando un proceso.\nProceso: %1$s\nEn: %2$s", message, aClass.getName());
    }
}
