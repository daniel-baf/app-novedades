package Model.DB.Domain.Venta;

/**
 * Esta clase representa el detalle de una venta en la base de datos
 *
 * @author jefe_mayoneso
 */
public class DetalleVenta {
    private int ISinventarioId; // Inventario_Sucursal_INventario_id
    private int ISsucursalId; // Inventario_Sucursal_Sucursal_id
    private int Venta_id;
    private int cantidad;
    private double unitPrice;
    private double subtotal;

    public DetalleVenta(int ISinventarioId, int ISsucursalId, int venta_id, int cantidad, double unitPrice, double subtotal) {
        this.ISinventarioId = ISinventarioId;
        this.ISsucursalId = ISsucursalId;
        Venta_id = venta_id;
        this.cantidad = cantidad;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public int getISinventarioId() {
        return ISinventarioId;
    }

    public void setISinventarioId(int ISinventarioId) {
        this.ISinventarioId = ISinventarioId;
    }

    public int getISsucursalId() {
        return ISsucursalId;
    }

    public void setISsucursalId(int ISsucursalId) {
        this.ISsucursalId = ISsucursalId;
    }

    public int getVenta_id() {
        return Venta_id;
    }

    public void setVenta_id(int venta_id) {
        Venta_id = venta_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
