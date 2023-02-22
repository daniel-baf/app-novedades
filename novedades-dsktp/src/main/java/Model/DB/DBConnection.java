package Model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Genera una conexión con la base de datos
 *
 * @author jefe_mayoneso
 */
public class DBConnection {

    // constantes
    private final String MYSQl_URL = "jdbc:mysql://localhost:3306/novedades?autoReconnect=true&characterEncoding=UTF-8";
    private final String MYSQL_USER = "app-usr";
    private final String MYSQL_PASSWORD = "Carro_252525";
    private static Connection connection = null;


    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(MYSQl_URL, MYSQL_USER, MYSQL_PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido generar la conexión a la base de datos en la clase " + this.getClass().getName() + " error" + ex.getMessage());
        }
    }

    /**
     * Genera una conexión a base de datos que siempre estará abierta, para evitar estár generando conexiones en cada
     * momento
     *
     * @return la conexión a la base de datos
     */
    public static Connection getConnection() {
        if (connection == null) new DBConnection();
        return connection;
    }
}
