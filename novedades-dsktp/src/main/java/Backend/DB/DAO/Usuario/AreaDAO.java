package Backend.DB.DAO.Usuario;

import Backend.DB.DBConnection;
import Backend.DB.DAO.SQL_SENTENCES;
import Backend.Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AreaDAO {

    /**
     * Inserta en la BD un campo de Area
     * @param area el area
     * @return el resultado, 1 si hubo exito
     * @throws Exception en caso no se complete la operación
     */
    public int insert(String area) throws Exception {
        // Intenta actualizar la BD, si hay error, devuelve una excepcon
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SENTENCES.INSERT_AREA.getSentence())) {
            ps.setString(1, area);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), this.getClass());
        }
    }

    /**
     * Selecciona todos los elementos de la tabla
     * @return listado de todas las areas
     */
    public ArrayList<String> select() throws CustomException {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SENTENCES.SELECT_AREA_ALL.getSentence())) {
            ArrayList<String> data = new ArrayList<>();
            // como no hay ? en el SQL, ejecutamos ResulSet, de lo contrario deberiamos usar ps.Set...
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(getAreaFromRs(rs));
            }
            return data;
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), this.getClass());
        }
    }

    public int delete(String area) throws CustomException {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SENTENCES.DELETE_AREA.getSentence())){
            ps.setString(1, area);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), this.getClass());
        }
    }

    // obtenemos los datos de la base de datos y lo convertimos en objeto
    private String getAreaFromRs(ResultSet rs) throws SQLException {
        return rs.getString("area");
    }
}
