/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.view.customer;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pleystation.model.CustomerModel;
import pleystation.model.controller.CustomerController;

/**
 *
 * @author Aksal
 */
public class CustomerFrame extends javax.swing.JFrame {
    
    private final DefaultTableModel tableModel;
    private final CustomerController controller;
    private List<CustomerModel> customerData = null;
    
    private int currentPage = 1;

    /**
     * Creates new form CustomerFrame
     */
    public CustomerFrame() {
        initComponents();
        setLocationRelativeTo(null);
        
        tableModel = (DefaultTableModel) tblData.getModel();
        controller = new CustomerController();
        
        customerData = controller.getAllData(currentPage);
        customerData.forEach((customerModel) -> {
            tableModel.addRow(customerModel.toObjects());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnNewData = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        pnlTableData = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnPreviousPage = new javax.swing.JButton();
        tblData = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        btnNextPage = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlHeader.setBackground(java.awt.SystemColor.controlHighlight);

        lblTitle.setFont(new java.awt.Font("Segoe UI Semilight", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Data Penyewa");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnNewData.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnNewData.setText("Tambah Data");
        btnNewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDataActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSearch.setText("Cari data penyewa...");
        txtSearch.setMargin(new java.awt.Insets(2, 5, 2, 5));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblData.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Penyewa", "Nama Lengkap", "No. Telepon", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblData.setToolTipText("Klik dua kali untuk mengubah atau menghapus data");
        tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        pnlTableData.setViewportView(tblData);

        btnPreviousPage.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        btnPreviousPage.setText("⯇");

        btnNextPage.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        btnNextPage.setText("⯈");

        lblPage.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPage.setText("Halaman 1/1");
        btnPreviousPage.setVisible(false);
        lblPage.setVisible(false);
        btnNextPage.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPreviousPage)
                        .addGap(111, 111, 111)
                        .addComponent(btnNextPage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlTableData)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewData, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewData)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTableData, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnNextPage)
                        .addComponent(btnPreviousPage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPage)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Cari data penyewa...")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equals("")) {
            txtSearch.setText("Cari data penyewa...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        new CustomerDetailsDialog(this, 
                controller, 
                customerData.get(tblData.getSelectedRow()).getCustomerId()
        ).setVisible(true);
        repopulateTable();
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnNewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDataActionPerformed
        new CustomerDetailsDialog(this, controller).setVisible(true);
        repopulateTable();
    }//GEN-LAST:event_btnNewDataActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().equals("") || txtSearch.getText().equals("Cari data penyewa...")) {
            repopulateTable();
            return;
        }
        
        for (int remaining = tableModel.getRowCount(); remaining > 0;) {
            tableModel.removeRow(--remaining);
        }
        
        customerData = controller.searchData(txtSearch.getText(), 1);
        customerData.forEach((userModel) -> {
            tableModel.addRow(userModel.toObjects());
        });
    }//GEN-LAST:event_txtSearchKeyReleased

    private void repopulateTable() {
        for (int remaining = tableModel.getRowCount(); remaining > 0;) {
            tableModel.removeRow(--remaining);
        }
        
        customerData = controller.getAllData(currentPage);
        customerData.forEach((customerModel) -> {
            tableModel.addRow(customerModel.toObjects());
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewData;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPreviousPage;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane pnlTableData;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}