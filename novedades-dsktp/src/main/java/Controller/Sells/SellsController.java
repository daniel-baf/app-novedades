package Controller.Sells;

import Controller.Sells.SellsTable;
import Model.Sells.SellsModel;
import View.Ventas.VentaJDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador para la seccion de las ventas
 *
 * @author jefe_mayoneso
 */
public class SellsController implements ActionListener {

    private final VentaJDialog view;
    private final SellsModel model;
    private final SellsTable sellsTableController;

    public SellsController(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
        this.sellsTableController = new SellsTable();
        // configuramos los action listeners
        setupActionListeners();
    }

    public void start() {
        // configura la vista
        this.view.setLocationRelativeTo(null); // centra la ventana
        this.view.setTitle("Zona de ventas");
        this.view.setVisible(true);
        // mostramos el listado de productos generado por el modelo
        this.sellsTableController.addRowsToTable(this.view, this.model);
    }

    private void setupActionListeners() {
        this.view.loadMoreJButton.addActionListener(this);
        this.view.addToCartJButton.addActionListener(this);
    }

    // default method
    @Override
    public void actionPerformed(ActionEvent ae) {
        // revisamos que boton ha generado el evento
        if (ae.getSource() == this.view.loadMoreJButton) this.sellsTableController.loadMoreIntoTable(this.view, this.model);
//        else if (ae.getSource() == this.view.searchJButton )
    }

}
