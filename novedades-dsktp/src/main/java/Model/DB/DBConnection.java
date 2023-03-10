package Model.DB;

import Utils.CustomException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Genera una conexión con la base de datos
 *
 * @author jefe_mayoneso
 */
public class DBConnection {

    private static Connection connection = null;
    // constantes
    private final String SCHEMA = "novedades";
    private final String IP = "localhost:3306";
    private final String MYSQl_URL = String.format("jdbc:mysql://%1$s/%2$s?autoReconnect=true&characterEncoding=UTF-8", IP, SCHEMA);
    private final String MYSQL_USER = "app-usr";
    private final String MYSQL_PASSWORD = "Carro_252525";


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

    /**
     * Activa o desactiva el rollback
     *
     * @param status true si se quiere activar el auto commit
     */
    public static void setAutoCommit(boolean status) {
        try {
            DBConnection.getConnection().setAutoCommit(status);
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), DBConnection.class));
        }
    }

    /**
     * Hace rollback en la base de datos
     */
    public static void rollback() {
        try {
            DBConnection.getConnection().rollback();
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), DBConnection.class));
        }
    }

    public static void commit() {
        try {
            DBConnection.getConnection().commit();
        } catch (SQLException e) {
            System.out.println(CustomException.formatError(e.getMessage(), DBConnection.class));
        }
    }
}
