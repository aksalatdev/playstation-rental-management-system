/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.view.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pleystation.model.CustomerModel;
import pleystation.model.ProductModel;
import pleystation.model.TransactionDetailModel;
import pleystation.model.TransactionModel;
import pleystation.model.controller.ProductController;
import pleystation.model.controller.TransactionController;

/**
 *
 * @author Aksal
 */
public class TransactionReturnFrame extends javax.swing.JFrame {
    String username;
    List<CustomerModel> customerData;
    List<ProductModel> productData;
    List<TransactionDetailModel> onCart;
    DefaultTableModel tableModel;
    TransactionController controller;
    TransactionModel transactionModel;
        
        ProductController product = new ProductController();

    /**
     * Creates new form TransactionFrame
     * @param username
     */
    public TransactionReturnFrame(String username) {
        initComponents();
        this.username = username;
        
        controller = new TransactionController();
        
        customerData = controller.getTenants();
        customerData.forEach((customerModel) -> {
            cbCustomer.addItem(customerModel.getName());
        });
        
        onCart = new ArrayList<>();
        tableModel = (DefaultTableModel) tblCart.getModel();
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
        lblTenant = new javax.swing.JLabel();
        lblRentDate = new javax.swing.JLabel();
        cbCustomer = new javax.swing.JComboBox<>();
        txtRentDate = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        lblDuration = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        lblLateDuration = new javax.swing.JLabel();
        txtLateDuration = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlHeader.setBackground(java.awt.SystemColor.controlHighlight);

        lblTitle.setFont(new java.awt.Font("Segoe UI Semilight", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Pengembalian Playstation");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lblTenant.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTenant.setText("Penyewa");

        lblRentDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblRentDate.setText("Tanggal Pinjam");

        cbCustomer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbCustomer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbCustomerPropertyChange(evt);
            }
        });

        txtRentDate.setEditable(false);
        txtRentDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSave.setText("Cek sudah kembali dan simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnReset.setText("Transaksi Baru");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblCart.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCart);

        lblDuration.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDuration.setText("Lama Pinjam");

        txtDuration.setEditable(false);
        txtDuration.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        lblLateDuration.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLateDuration.setText("Lama Keterlambatan");

        txtLateDuration.setEditable(false);
        txtLateDuration.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenant)
                    .addComponent(lblRentDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCustomer, 0, 201, Short.MAX_VALUE)
                            .addComponent(txtRentDate))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDuration)
                            .addComponent(lblLateDuration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLateDuration)
                            .addComponent(txtDuration))))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenant)
                            .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDuration)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRentDate)
                    .addComponent(txtRentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLateDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLateDuration)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        controller.returnRent(transactionModel);
        JOptionPane.showMessageDialog(this, "Berhasil disimpan!",
                "Informasi", JOptionPane.INFORMATION_MESSAGE);
        new TransactionReturnFrame(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        new TransactionReturnFrame(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnResetActionPerformed

    private void cbCustomerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCustomerPropertyChange
        if (customerData == null)
            return;
        
        if (customerData.get(cbCustomer.getSelectedIndex()) == null)
            return;
        
        for (int remaining = tableModel.getRowCount(); remaining > 0;) {
            tableModel.removeRow(--remaining);
        }
        
        transactionModel = controller.getRentDetail(customerData.get(cbCustomer.getSelectedIndex()));
        transactionModel.getDetails().forEach((detail) -> {
            tableModel.addRow(new Object[] {
                product.getData(detail.getProductId()).getName(), detail.getQuantity()
            });
        });
        long lateDuration = (new Date().getTime()
                - (transactionModel.getRentDate().getTime() 
                + (transactionModel.getDuration() * (24 * 60 * 60 * 1000)))
                )  / (24 * 60 * 60 * 1000);
        txtRentDate.setText(transactionModel.getRentDate().toString());
        txtDuration.setText(String.valueOf(transactionModel.getDuration()) + " hari");
        txtLateDuration.setText(Math.abs(lateDuration) + " hari");
    }//GEN-LAST:event_cbCustomerPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblLateDuration;
    private javax.swing.JLabel lblRentDate;
    private javax.swing.JLabel lblTenant;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTable tblCart;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtLateDuration;
    private javax.swing.JTextField txtRentDate;
    // End of variables declaration//GEN-END:variables
}