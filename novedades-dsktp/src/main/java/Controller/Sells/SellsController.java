package Controller.Sells;

import Model.DB.DAO.Inventario.SearchFilters;
import Model.Sells.SellsModel;
import View.Ventas.VentaJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador para la seccion de las ventas
 *
 * @author jefe_mayoneso
 */
public class SellsController implements ActionListener {

    // variables
    private final VentaJDialog view;
    private final SellsModel model;
    private final SellsTableDisplayer sellsTableDisplayerController;
    private final SellsSearchController searchButtonController;
    private final ShoppingCartController cartController;

    /**
     * Controlador accionador de las ventas, genera los actions listeners y configura los valores en multiples sub controladores
     *
     * @param view la vista donde desplegar los elementos
     * @param model el modelo que contiene todos los elementos para manipular la visat
     */
    public SellsController(VentaJDialog view, SellsModel model) {
        this.view = view;
        this.model = model;
        this.sellsTableDisplayerController = new SellsTableDisplayer(view, model);
        this.searchButtonController = new SellsSearchController(view, model);
        this.cartController = new ShoppingCartController(view, model);
        // configuramos los action listeners
        setupActionListeners();
    }

    /**
     * Inicia todos los componentes y genera la busqueda principal de los productos disponibles para la venta
     */
    public void start() {
        // configura la vista
        this.view.setLocationRelativeTo(null); // centra la ventana
        this.view.setTitle("Zona de ventas");
        this.view.setVisible(true);
        this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // configuramos los valores
        config();
        // mostramos el listado de productos generado por el modelo
        this.searchButtonController.search(this.sellsTableDisplayerController, true);
    }

    /**
     * Configura los action listeners en distintos controladores
     */
    private void setupActionListeners() {
        this.view.loadMoreJButton.addActionListener(this);
        this.view.addToCartJButton.addActionListener(this);
        this.view.searchJButton.addActionListener(this);
    }

    /**
     * Metodo por defecto para los eventos que sse realicen al hacer click en un elemento accionable
     *
     * @param ae elemento de origen del evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // revisamos que boton ha generado el evento
        if (ae.getSource() == this.view.loadMoreJButton) {
            this.sellsTableDisplayerController.loadRowsOffsetToProductTable(this.searchButtonController);
        } else if (ae.getSource() == this.view.searchJButton) {
            this.searchButtonController.search(this.sellsTableDisplayerController, true);
        } else if (ae.getSource() == this.view.addToCartJButton) {
            this.cartController.add();
        }
    }

    /**
     * Configura los elementos del JComboBox para que los datos para filtrar sean obtenidos a partir de un ENUM
     */
    private void config() {
        // agregar elementos a select
        for (SearchFilters item : SearchFilters.values()) {
            if (item != SearchFilters.NONE) {
                this.view.searchTypeJComboBox.addItem(item.getValue());
            }
        }
        this.view.searchTypeJComboBox.setSelectedIndex(0);
    }

}
