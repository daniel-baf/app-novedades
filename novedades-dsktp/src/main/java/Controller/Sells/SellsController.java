package Controller.Sells;

import Model.DB.DAO.Inventario.SearchFilters;
import Model.Sells.SellsModel;
import View.Ventas.VentaJDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase es el controlador para la seccion de las ventas
 *
 * @author jefe_mayoneso
 */
public class SellsController implements ActionListener {

    // variables
    private final VentaJDialog view;
    private final SellsTableDisplayer sellsTableDisplayerController;
    private final SellsSearchController searchButtonController;
    private final ShoppingCartController cartController;

    /**
     * Controlador accionador de las ventas, genera los actions listeners y configura los valores en multiples sub controladores
     *
     * @param view  la vista donde desplegar los elementos
     * @param model el modelo que contiene todos los elementos para manipular la visat
     */
    public SellsController(VentaJDialog view, SellsModel model) {
        this.view = view;
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
        this.view.specialClientJMenuButton.addActionListener(this);
    }

    /**
     * Metodo por defecto para los eventos que sse realicen al hacer click en un elemento accionable
     *
     * @param ae elemento de origen del evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // generamos un tipo de instruccion por cada elemento
        Map<Object, Runnable> actions = new HashMap<>();
        actions.put(this.view.loadMoreJButton, () -> this.sellsTableDisplayerController.loadRowsOffsetToProductTable(this.searchButtonController));
        actions.put(this.view.searchJButton, () -> this.searchButtonController.search(this.sellsTableDisplayerController, true));
        actions.put(this.view.addToCartJButton, () -> this.cartController.add(this.sellsTableDisplayerController));
        actions.put(this.view.specialClientJMenuButton, () -> this.cartController.setupSpecialClient(this.sellsTableDisplayerController));
        // ejecutamos la accion
        Runnable action = actions.getOrDefault(ae.getSource(), () -> {
        });
        action.run();
    }

    /**
     * Configuramos todos los elementos que nos interese en la vista
     */
    private void config() {
        Arrays.stream(SearchFilters.values()).forEach(item -> {
            if (item != SearchFilters.NONE) this.view.searchTypeJComboBox.addItem(item.getValue());
        });
        this.view.searchTypeJComboBox.setSelectedIndex(0);
    }

}
