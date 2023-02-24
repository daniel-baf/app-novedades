package Model.DB.DAO.Usuario;

import Model.DB.DAO.SQL.SQL_DELETE;
import Model.DB.DAO.SQL.SQL_INSERT;
import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AreaDAO {

    /**
     * Inserta en la BD un campo de Area
     *
     * @param area el area
     * @return el resultado, 1 si hubo exito
     * @throws Exception en caso no se complete la operación
     */
    public int insert(String area) throws Exception {
        // Intenta actualizar la BD, si hay error, devuelve una excepcon
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_INSERT.USER.getSentence())) {
            ps.setString(1, area);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Selecciona todos los elementos de la tabla
     *
     * @return listado de todas las areas
     */
    public ArrayList<String> select() throws Exception {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.AREA_ALL.getSentence())) {
            ArrayList<String> data = new ArrayList<>();
            // como no hay ? en el SQL, ejecutamos ResulSet, de lo contrario deberiamos usar ps.Set...
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(getAreaFromRs(rs));
            }
            return data;
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Borra un Area de la base de datos
     *
     * @param area el area a borrar
     * @return el numero de filas afectadas
     * @throws Exception el error, en caso ocurra un error
     */
    public int delete(String area) throws Exception {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_DELETE.AREA.getSentence())) {
            ps.setString(1, area);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    /**
     * Convierte los datos del ResultSet en un String, pero podria editarse para
     * convertirlo a un objeto de tipo <T> o <C>
     *
     * @param rs ResultSet
     * @return el dato obtenido de la BD
     * @throws SQLException el error en SQL que se pueda generar
     */
    private String getAreaFromRs(ResultSet rs) throws SQLException {
        return rs.getString("area");
    }
}
