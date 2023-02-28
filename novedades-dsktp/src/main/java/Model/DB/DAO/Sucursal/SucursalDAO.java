package Model.DB.DAO.Sucursal;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DBConnection;
import Model.DB.Domain.Sucursal.Sucursal;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase para hacer consultas a la BD respecto a la entidad Sucursal
 *
 * @author colaborativo
 */
public class SucursalDAO {

    public ArrayList<Sucursal> select() throws Exception {
        ArrayList<Sucursal> salesDepartments = new ArrayList<>();
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.SUCURSAL_ALL.getSentence())) {
            // como no hay ? en el SQL, ejecutamos ResulSet, de lo contrario deberiamos usar ps.Set...
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                salesDepartments.add(getSalesDepFromRS(rs));
            }
            salesDepartments.removeAll(Collections.singleton(null)); // remove possible nulls
            return salesDepartments;
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
    }

    public Sucursal select(int id) throws Exception {
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SELECT.SUCURSAL_ALL.getSentence() + SQL_SELECT.SUCURSAL_ADD_ID.getSentence())) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return getSalesDepFromRS(rs);
        } catch (Exception e) {
            throw new Exception(CustomException.formatError(e.getMessage(), this.getClass()));
        }
        return null;
    }


    private Sucursal getSalesDepFromRS(ResultSet rs) {
        try {
            return new Sucursal(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"));
        } catch (Exception e) {
            return null;
        }
    }

}
