package Controller;

import Model.CurrentUser;
import Model.DB.Domain.Usuario.Usuario;
import Model.Login.LoginModel;
import View.Login.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador para el login
 *
 * @author jefe_mayoneso
 */
public class LoginController implements ActionListener {

    private final LoginView view;
    private final LoginModel model;

    public LoginController(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
        this.view.loginJButton.addActionListener(this);
        // set values for select
        configList();
    }

    /**
     * Init view
     */
    public void start() {
        this.view.setTitle("Ventana de logueo");
        this.view.setLocationRelativeTo(null);
        this.view.setResizable(false);
        this.view.setVisible(true);
    }


    /**
     * Config the values for combobox on view
     */
    private void configList() {
        try {
            this.model.getSalesDepratments().forEach(department -> this.view.salesDepJComboBox.addItem(department.getName()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void clearData() {
        this.view.loginMessageJLabel.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // clear data
        clearData();
        this.model.setUser(new Usuario(this.view.userJTextField.getText(), String.valueOf(this.view.passwordJPasswordField.getPassword()), true));
        if (!this.model.login()) {
            this.view.loginMessageJLabel.setText("Revisa tus credenciales");
        } else {
            CurrentUser.setUSER(this.model.getCurrentUser()); // configure global data for future SQL queries
            CurrentUser.setSalesDepartment(this.model.getSalesDepratments().get(this.view.salesDepJComboBox.getSelectedIndex()));
            // TODO redirect
            this.view.loginMessageJLabel.setText("Bienvenido...");
        }
    }
}
