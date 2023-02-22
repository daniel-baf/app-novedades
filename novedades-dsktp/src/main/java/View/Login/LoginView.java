/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Login;

import Model.DB.Domain.Sucursal.Sucursal;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author jefe_mayoneso
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginJFrame
     */
    public LoginView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        containerJPanel = new javax.swing.JPanel();
        headerJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginSectionJPanel = new javax.swing.JPanel();
        loginSectionTopJPanel = new javax.swing.JPanel();
        loginSectionLeftJPanel = new javax.swing.JPanel();
        userTextLoginJPanel = new javax.swing.JPanel();
        loginJLabel = new javax.swing.JLabel();
        userJTextField = new javax.swing.JTextField();
        passwordTextLoginJPanel = new javax.swing.JPanel();
        passwordJLabel = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        loginSectionRightJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        salesDepJComboBox = new javax.swing.JComboBox<>();
        loginSectionLowJPanel = new javax.swing.JPanel();
        loginMessageJLabel = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerJPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Login Novedades");
        headerJPanel.add(jLabel1, "card2");

        loginSectionTopJPanel.setMinimumSize(new java.awt.Dimension(500, 120));
        loginSectionTopJPanel.setLayout(new java.awt.GridBagLayout());

        loginSectionLeftJPanel.setLayout(new javax.swing.BoxLayout(loginSectionLeftJPanel, javax.swing.BoxLayout.Y_AXIS));

        userTextLoginJPanel.setMinimumSize(new java.awt.Dimension(100, 40));
        userTextLoginJPanel.setPreferredSize(new java.awt.Dimension(60, 40));
        userTextLoginJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        loginJLabel.setText("Usuario");
        userTextLoginJPanel.add(loginJLabel);

        userJTextField.setPreferredSize(new java.awt.Dimension(100, 24));
        userTextLoginJPanel.add(userJTextField);
        userJTextField.getAccessibleContext().setAccessibleName("userInput");

        loginSectionLeftJPanel.add(userTextLoginJPanel);

        passwordTextLoginJPanel.setMinimumSize(new java.awt.Dimension(100, 40));
        passwordTextLoginJPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        passwordJLabel.setText("Contraseña");
        passwordTextLoginJPanel.add(passwordJLabel);

        passwordJPasswordField.setPreferredSize(new java.awt.Dimension(100, 24));
        passwordTextLoginJPanel.add(passwordJPasswordField);

        loginSectionLeftJPanel.add(passwordTextLoginJPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        loginSectionTopJPanel.add(loginSectionLeftJPanel, gridBagConstraints);

        loginSectionRightJPanel.setMinimumSize(new java.awt.Dimension(239, 50));
        loginSectionRightJPanel.setPreferredSize(new java.awt.Dimension(40, 50));
        loginSectionRightJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Sucursal");
        loginSectionRightJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        salesDepJComboBox.setMaximumSize(new java.awt.Dimension(140, 32767));
        loginSectionRightJPanel.add(salesDepJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 40));
        salesDepJComboBox.getAccessibleContext().setAccessibleName("salesDepInput");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 155;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 6);
        loginSectionTopJPanel.add(loginSectionRightJPanel, gridBagConstraints);

        loginSectionLowJPanel.setLayout(new javax.swing.BoxLayout(loginSectionLowJPanel, javax.swing.BoxLayout.X_AXIS));

        loginJButton.setText("Iniciar Sesión");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginSectionJPanelLayout = new javax.swing.GroupLayout(loginSectionJPanel);
        loginSectionJPanel.setLayout(loginSectionJPanelLayout);
        loginSectionJPanelLayout.setHorizontalGroup(
            loginSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginSectionJPanelLayout.createSequentialGroup()
                .addGroup(loginSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginSectionJPanelLayout.createSequentialGroup()
                        .addGroup(loginSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginSectionLowJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(loginSectionJPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(loginMessageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginJButton))
                    .addGroup(loginSectionJPanelLayout.createSequentialGroup()
                        .addComponent(loginSectionTopJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginSectionJPanelLayout.setVerticalGroup(
            loginSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginSectionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginSectionTopJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginSectionLowJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginJButton)
                    .addComponent(loginMessageJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout containerJPanelLayout = new javax.swing.GroupLayout(containerJPanel);
        containerJPanel.setLayout(containerJPanelLayout);
        containerJPanelLayout.setHorizontalGroup(
            containerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginSectionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(containerJPanelLayout.createSequentialGroup()
                        .addComponent(headerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        containerJPanelLayout.setVerticalGroup(
            containerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginSectionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed

    }//GEN-LAST:event_loginJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerJPanel;
    private javax.swing.JPanel headerJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    public javax.swing.JLabel loginMessageJLabel;
    private javax.swing.JPanel loginSectionJPanel;
    private javax.swing.JPanel loginSectionLeftJPanel;
    private javax.swing.JPanel loginSectionLowJPanel;
    private javax.swing.JPanel loginSectionRightJPanel;
    private javax.swing.JPanel loginSectionTopJPanel;
    private javax.swing.JLabel passwordJLabel;
    public javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JPanel passwordTextLoginJPanel;
    public javax.swing.JComboBox<String> salesDepJComboBox;
    public javax.swing.JTextField userJTextField;
    private javax.swing.JPanel userTextLoginJPanel;
    // End of variables declaration//GEN-END:variables

}
