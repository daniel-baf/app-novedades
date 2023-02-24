package Model.DB.DAO.Inventario;

import Model.DB.DAO.SQL.SQL_SELECT;
import Model.DB.DAO.Sucursal.SucursalDAO;
import Model.DB.DBConnection;
import Model.DB.Domain.Inventario.InventarioSucursal;
import Model.DB.Domain.Sucursal.Sucursal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InventarioSucursalDAO {

    /**
     * Este metodo busca en la base de datos toda la informacion relacionada a un producto
     * Este metodo puede buscar en todas las tiendas, o en una tienda en especifico
     *
     * @param salesDepartment   nulo si se quiere buscar en todas las tiendas, o la tienda si se desea buscar
     *                          una en especifico
     * @param bySalesDepartment true si se desea buscar la existencia de una tienda
     * @return el listado de productos disponibles
     */
    public ArrayList<InventarioSucursal> select(Sucursal salesDepartment, Boolean bySalesDepartment) {
        ArrayList<InventarioSucursal> invAvailability = new ArrayList<>();
        // modifica el SQL para elegir entre todas las sucursales o una en especifico
        String SQL_TMP = SQL_SELECT.INVENTARIO_SUCURSAL.getSentence();
        SQL_TMP += bySalesDepartment ? SQL_SELECT.INVENTARIO_SUUCRSAL_ADD_ID.getSentence() : "";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(SQL_TMP)) {
            if(bySalesDepartment) ps.setInt(1, salesDepartment.getId()); // configura la sucursal que se desea buscar
            // ejecuta sentencia SQL y obtiene los datos
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                getInventarioSucursalFromRS(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return invAvailability;
    }

    private InventarioSucursal getInventarioSucursalFromRS(ResultSet rs) {
        // creamos los objetos pertinentes con los datos obtenidos
        try {
            InventarioSucursal tmpInventorySuc = new InventarioSucursal(rs.getInt("stock")); // basic inventory sucursal
            // obtenemos la sucursal y el inventario de cada elemento
            tmpInventorySuc.setSucursal(new SucursalDAO().select(rs.getInt("Sucursal_id")));
            tmpInventorySuc.setInventory(new InventarioDAO().select(rs.getInt("Inventario_id")));
            System.out.println(tmpInventorySuc.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
