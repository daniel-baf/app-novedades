/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Ventas;

/**
 *
 * @author jefe_mayoneso
 */
public class VentaJDialog extends javax.swing.JFrame {

    /**
     * Creates new form VentaJDialog
     */
    public VentaJDialog() {
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

        containerJPanel = new javax.swing.JPanel();
        inventorySectionJPanel = new javax.swing.JPanel();
        inventorySearchJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchJTextField = new javax.swing.JTextField();
        searchTypeJButton = new javax.swing.JComboBox<>();
        searchJButton = new javax.swing.JButton();
        inventoryListSectionJPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsResultJTable = new javax.swing.JTable();
        inventoryAddSectionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        addToCartJButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        setupSpecialClientJButton = new javax.swing.JButton();
        loadMoreJButton = new javax.swing.JButton();
        sellsSectionJPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartlistJTable = new javax.swing.JTable();
        totalJLabel = new javax.swing.JLabel();
        specialClientJLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        checkoutJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        containerJPanel.setLayout(new javax.swing.BoxLayout(containerJPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Busqueda");
        inventorySearchJPanel.add(jLabel2);

        searchJTextField.setPreferredSize(new java.awt.Dimension(100, 25));
        inventorySearchJPanel.add(searchJTextField);

        searchTypeJButton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id prenda", "Color", "Nombre prenda", "Talla" }));
        inventorySearchJPanel.add(searchTypeJButton);

        searchJButton.setText("Buscar");
        inventorySearchJPanel.add(searchJButton);

        productsResultJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pieza", "Color", "Producto", "Talla", "Precio", "Precio 2", "Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsResultJTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        inventoryAddSectionPanel.setLayout(new javax.swing.BoxLayout(inventoryAddSectionPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Cantidad");
        jPanel3.add(jLabel1);
        jPanel3.add(jTextField1);

        addToCartJButton.setText("AGREGAR");
        jPanel3.add(addToCartJButton);

        inventoryAddSectionPanel.add(jPanel3);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        setupSpecialClientJButton.setText("Cliente E");
        jPanel4.add(setupSpecialClientJButton);

        loadMoreJButton.setText("CARGAR MAS");
        jPanel4.add(loadMoreJButton);

        inventoryAddSectionPanel.add(jPanel4);

        javax.swing.GroupLayout inventoryListSectionJPanelLayout = new javax.swing.GroupLayout(inventoryListSectionJPanel);
        inventoryListSectionJPanel.setLayout(inventoryListSectionJPanelLayout);
        inventoryListSectionJPanelLayout.setHorizontalGroup(
            inventoryListSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventoryAddSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inventoryListSectionJPanelLayout.setVerticalGroup(
            inventoryListSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryListSectionJPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryAddSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout inventorySectionJPanelLayout = new javax.swing.GroupLayout(inventorySectionJPanel);
        inventorySectionJPanel.setLayout(inventorySectionJPanelLayout);
        inventorySectionJPanelLayout.setHorizontalGroup(
            inventorySectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventorySectionJPanelLayout.createSequentialGroup()
                .addGroup(inventorySectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventorySectionJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inventorySearchJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(inventoryListSectionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        inventorySectionJPanelLayout.setVerticalGroup(
            inventorySectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventorySectionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventorySearchJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryListSectionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        containerJPanel.add(inventorySectionJPanel);

        cartlistJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID prenda", "Nombre", "Precio", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cartlistJTable);

        totalJLabel.setText("Total: ");

        specialClientJLabel.setText("Cliene especial: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalJLabel)
                    .addComponent(specialClientJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialClientJLabel)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        checkoutJButton.setText("PROCEDER VENTA");
        jPanel5.add(checkoutJButton);

        javax.swing.GroupLayout sellsSectionJPanelLayout = new javax.swing.GroupLayout(sellsSectionJPanel);
        sellsSectionJPanel.setLayout(sellsSectionJPanelLayout);
        sellsSectionJPanelLayout.setHorizontalGroup(
            sellsSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellsSectionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sellsSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sellsSectionJPanelLayout.setVerticalGroup(
            sellsSectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellsSectionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        containerJPanel.add(sellsSectionJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addToCartJButton;
    public javax.swing.JTable cartlistJTable;
    public javax.swing.JButton checkoutJButton;
    private javax.swing.JPanel containerJPanel;
    private javax.swing.JPanel inventoryAddSectionPanel;
    private javax.swing.JPanel inventoryListSectionJPanel;
    private javax.swing.JPanel inventorySearchJPanel;
    private javax.swing.JPanel inventorySectionJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JButton loadMoreJButton;
    public javax.swing.JTable productsResultJTable;
    public javax.swing.JButton searchJButton;
    public javax.swing.JTextField searchJTextField;
    public javax.swing.JComboBox<String> searchTypeJButton;
    private javax.swing.JPanel sellsSectionJPanel;
    public javax.swing.JButton setupSpecialClientJButton;
    public javax.swing.JLabel specialClientJLabel;
    public javax.swing.JLabel totalJLabel;
    // End of variables declaration//GEN-END:variables
}
