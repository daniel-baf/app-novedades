package Controller.Sells;

import Model.CurrentUser;
import Model.DB.DAO.Venta.VentaDAO;
import Model.DB.Domain.Venta.DetalleVenta;
import Model.DB.Domain.Venta.Venta;
import Model.Sells.SellsModel;
import View.Ventas.VentaJDialog;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase es la que se encargara de generar
 *
 * @author jefe_mayoneso
 */
public class BillController {

    private final SellsModel model;
    private final VentaJDialog view;

    public BillController(SellsModel model, VentaJDialog view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Genera una venta en base a los datos que se encuentran en la aplicacion
     * Para realizar esto, deshabilitara el autocommit y generara  un commit
     * nuevo si la operacion es exitosa, de lo contrario, hara un rollback
     */
    public void create() {
        // revisamos que el nombre ingresado no sea null
        ArrayList<DetalleVenta> sellDetail = new ArrayList<>();
        // creamos el objeto venta que servira para el SQL
        Venta sell = new Venta(
                LocalDate.now(),
                this.model.getNIT(),
                this.model.getBillName(),
                this.model.getCart().getTotal(),
                CurrentUser.getUSER(),
                this.model.getSpecialClient() != null ? this.model.getSpecialClient() : null,
                false
        );
        // creamos el detalle de la venta
        // este Detalle VEnta depende de la venta, asi que de momento no sabemsos su ID, le pondremos -1 al id de venta
        this.model.getCart().getList().forEach(_item -> {
            // generamos un nuevo elemento y lo agregamos al array
            sellDetail.add(new DetalleVenta(
                    _item.getProduct().getInventory().getId(),
                    _item.getProduct().getSucursal().getId(),
                    -1,
                    _item.getCuantity(),
                    _item.getProduct().getInventory().getProductoTalla().getPrice(),
                    _item.getProduct().getInventory().getProductoTalla().getPrice() * _item.getCuantity()
            ));
        });
        // insertamos la venta y mostramos un mensaje de exito si se realiza
        if (new VentaDAO().insert(sell, sellDetail) == 1) {
            this.view.showPopUp("Venta realizada con exito", "VENTA", JOptionPane.INFORMATION_MESSAGE);
        }
        // no mostramos un mensaje de error porque CustomError arroja una ventana emergente
    }
}
