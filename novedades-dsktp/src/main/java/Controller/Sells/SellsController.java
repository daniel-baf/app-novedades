package Controller.Sells;

import Model.DB.DAO.Inventario.SearchFilters;
import Model.Sells.SellsModel;
import View.Ventas.VentaJDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Esta clase es el controlador para la seccion de las ventas
 *
 * @author jefe_mayoneso
 */
public class SellsController implements ActionListener {

    private final VentaJDialog view;
    private final SellsModel model;
    private final SellsTable sellsTableController;
    private final SellsSearchController searchButtonController;

    public SellsController(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
        this.sellsTableController = new SellsTable();
        this.searchButtonController = new SellsSearchController();
        // configuramos los action listeners
        setupActionListeners();
    }

    public void start() {
        // configura la vista
        this.view.setLocationRelativeTo(null); // centra la ventana
        this.view.setTitle("Zona de ventas");
        this.view.setVisible(true);
        this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // mostramos el listado de productos generado por el modelo
        this.searchButtonController.search(view, model, this.sellsTableController, true);
        config();
    }

    private void setupActionListeners() {
        this.view.loadMoreJButton.addActionListener(this);
        this.view.addToCartJButton.addActionListener(this);
        this.view.searchJButton.addActionListener(this);
    }

    // default method
    @Override
    public void actionPerformed(ActionEvent ae) {
        // revisamos que boton ha generado el evento
        if (ae.getSource() == this.view.loadMoreJButton) {
            this.sellsTableController.loadRowsOffsetToTable(view, model, this.searchButtonController);
        } else if (ae.getSource() == this.view.searchJButton) {
            this.searchButtonController.search(view, model, this.sellsTableController, true);
        }
    }

    private void config() {
        // agregar elementos a select
        for (SearchFilters item : SearchFilters.values()) {
            if (item != SearchFilters.NONE) {
                this.view.searchTypeJComboBox.addItem(item.getValue());
            }
        }
    }

}
