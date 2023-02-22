package Model.DB.DAO.Sucursal;

import Model.DB.DAO.SQL_SENTENCES;
import Model.DB.DBConnection;
import Model.DB.Domain.Sucursal.Sucursal;
import Utils.CustomException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class SucursalDAO {

    public ArrayList<Sucursal> selectAll() throws Exception {
        ArrayList<Sucursal> salesDepartments = new ArrayList<>();
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_SENTENCES.SELECT_SUCURAL_ALL.getSentence())) {
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

    private Sucursal getSalesDepFromRS(ResultSet rs) {
        try {
            return new Sucursal(rs.getInt("id"),rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"));
        } catch (Exception e) {
            return  null;
        }
    }

}
