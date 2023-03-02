package Model.Sells;

import Model.DB.Domain.Inventario.InventarioSucursal;

import java.util.ArrayList;

/**
 * Modelo para MVC de la seccion de ventas (Generacion de facturas)
 *
 * @author jefe_mayoneso
 */
public class SellsModel {

    ArrayList<InventarioSucursal> availableProductos;

    private int offset; // sirve para saber la posicion actual de la consulta SQL
    private int limit;

    public SellsModel() {
        this.offset = 0; // iniciamos las consultas SQL en 0 para ir incrementando, asi no tendremos consultar largas suponiendo existan miles de productos
        this.limit = 50;
//        updateList(CurrentUser.getSalesDepartment(), true, true, true);
    }


    /**
     * Configura e inicializa el modelo
     * @return 
     */
//    public void updateList(Sucursal department, Boolean bySalesDepartment, Boolean useLimit, Boolean useOffset) {
//            this.availableProductos = this.invSucDAO.select(department, bySalesDepartment, useLimit, useOffset, this.offset, this.limit); // TODO esta linea puede cambiar si la consulta tarda mucho
//            this.offset = this.offset + this.limit;
//    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Obtiene los productos disponibles al iniciar la applicacion, usa limites y offset para no argar la RAM
     * en caso existan demasiados productos
     *
     * @return el listado de productos
     */
    public ArrayList<InventarioSucursal> getAvailableProductos() {
        return this.availableProductos;
    }

    public void setAvailableProductos(ArrayList<InventarioSucursal> availableProductos) {
        this.availableProductos = availableProductos;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
