package Utils;

public class CustomException extends Exception {

    public CustomException() {
    }

    public static String formatError(String message, Class aClass) {
        return String.format("Ha ocurrido un error ejecutando un proceso.\nProceso: %1$s\nEn: %2$s", message, aClass.getName());
    }
}
