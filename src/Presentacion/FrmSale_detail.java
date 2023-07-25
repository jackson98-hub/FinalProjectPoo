/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import BussinesObject.Sale_detail;
import TransferObject.Sale_detailDTO;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose.abad
 */
public class FrmSale_detail extends javax.swing.JFrame {
    DefaultTableModel modelo;
    Sale_detailDTO sale_detailDTO;
    Sale_detail sale_detail;
    int idSaleDetail;
    Exportar obj;

    public FrmSale_detail() {
        modelo = new DefaultTableModel();
        sale_detailDTO = new Sale_detailDTO();
        sale_detail = new Sale_detail();
        
        initComponents();
        listar();
        limpiarTexto();
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tSale_detail.getModel();
        modelo.getDataVector().removeAllElements();
        tSale_detail.removeAll();
    }
    
    private void limpiarTexto() {
        txtSearch.setText("");
        txtIdSale.setText("");
        txtIddetail.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        txtIdprodcut.setText("");
        txtQuantity.setText("");
        txtIddetail.requestFocus();
    }
    
    private void listar() {
        try {
            modelo = (DefaultTableModel) tSale_detail.getModel();
            Object[] ob = new Object[6];
            for (Sale_detailDTO p : sale_detail.listar()) {
                ob[0] = p.getIdDetail();
                ob[1] = p.getIdSale();
                ob[2] = p.getIdProduct();
                ob[3] = p.getQuantity();
                ob[4] = p.getPrice();
                ob[5] = p.getDiscount();
                modelo.addRow(ob);
            }
            tSale_detail.setModel(modelo);
        } catch (Exception e) {
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tSale_detail = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtIddetail = new javax.swing.JTextField();
        txtIdSale = new javax.swing.JTextField();
        txtIdprodcut = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtClose = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DETALLE VENTA");
        setLocation(new java.awt.Point(310, 150));

        tSale_detail.setBackground(new java.awt.Color(204, 255, 255));
        tSale_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CODIGO VENTA", "CODIGO PRODUCTO", "CANTIDAD", "PRECIO", "DESCUENTO"
            }
        ));
        tSale_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSale_detailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tSale_detail);

        jLabel1.setText("BUSCAR:");

        jLabel2.setText("CODIGO:");

        jLabel3.setText("CODIGO VENTA");

        jLabel4.setText("CODIGO PRODUCTO");

        jLabel5.setText("CANTIDAD");

        jLabel6.setText("PRECIO");

        jLabel7.setText("DESCUENTO");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(51, 51, 255));
        btnNuevo.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 51, 255));
        btnAdd.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("AGREGAR");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 51, 255));
        btnUpdate.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("MODIFICAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 51, 255));
        btnDelete.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("ELIMINAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtClose.setBackground(new java.awt.Color(51, 51, 255));
        txtClose.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        txtClose.setForeground(new java.awt.Color(255, 255, 255));
        txtClose.setText("CERRAR");
        txtClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCloseActionPerformed(evt);
            }
        });

        btnReporte.setBackground(new java.awt.Color(51, 51, 255));
        btnReporte.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("REPORTE");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIddetail, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtIdSale)
                                    .addComponent(txtIdprodcut))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(txtPrice)
                                    .addComponent(txtDiscount)))
                            .addComponent(txtSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnNuevo)
                        .addGap(46, 46, 46)
                        .addComponent(btnAdd)
                        .addGap(38, 38, 38)
                        .addComponent(btnUpdate)
                        .addGap(58, 58, 58)
                        .addComponent(btnDelete)
                        .addGap(52, 52, 52)
                        .addComponent(btnReporte)
                        .addGap(50, 50, 50)
                        .addComponent(txtClose)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtIddetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtIdSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(txtIdprodcut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(txtClose)
                    .addComponent(btnReporte))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarTexto();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String mensaje = sale_detail.agregar(
                Integer.parseInt(txtIddetail.getText()), 
                Integer.parseInt(txtIdSale.getText()),
                Integer.parseInt(txtIdprodcut.getText()),
                Integer.parseInt(txtQuantity.getText()),
                Byte.parseByte(txtPrice.getText()),
                Byte.parseByte(txtDiscount.getText()) 
                
        );
        limpiarTabla();
        listar();
        limpiarTexto();
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String mensaje = "";
        int fila = tSale_detail.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una Fila");
        } else {
                mensaje = sale_detail.actualizar(
                Integer.parseInt(txtIddetail.getText()), 
                Integer.parseInt(txtIdSale.getText()),
                Integer.parseInt(txtIdprodcut.getText()),
                Integer.parseInt(txtQuantity.getText()),
                Byte.parseByte(txtPrice.getText()),
                Byte.parseByte(txtDiscount.getText())
            );
        }
        limpiarTabla();
        listar();
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String mensaje = "";
        int fila = tSale_detail.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila");
        } else {
            mensaje = sale_detail.eliminar(idSaleDetail);
        }
        limpiarTabla();
        listar();
        limpiarTexto();
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tSale_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSale_detailMouseClicked
        int fila = tSale_detail.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar una Fila");
        } else {
            idSaleDetail = Integer.parseInt(tSale_detail.getValueAt(fila, 0).toString());
            txtIddetail.setText(tSale_detail.getValueAt(fila, 0).toString());
            txtIdSale.setText(tSale_detail.getValueAt(fila, 1).toString());
            txtIdprodcut.setText(tSale_detail.getValueAt(fila, 2).toString());
            txtQuantity.setText(tSale_detail.getValueAt(fila, 3).toString());
            txtPrice.setText(tSale_detail.getValueAt(fila, 4).toString());
            txtDiscount.setText(tSale_detail.getValueAt(fila, 5).toString());

        }
    }//GEN-LAST:event_tSale_detailMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (!txtSearch.getText().isEmpty()) {
            idSaleDetail = Integer.parseInt(txtSearch.getText());
            sale_detailDTO = sale_detail.buscar(idSaleDetail);
            if (sale_detailDTO != null) {
                limpiarTabla();
                modelo = (DefaultTableModel) tSale_detail.getModel();
                Object[] ob = new Object[6];
                ob[0] = sale_detailDTO.getIdDetail();
                ob[1] = sale_detailDTO.getIdSale();
                ob[2] = sale_detailDTO.getIdProduct();
                ob[3] = sale_detailDTO.getQuantity();
                ob[4] = sale_detailDTO.getPrice();
                ob[5] = sale_detailDTO.getDiscount();
                modelo.addRow(ob);
                tSale_detail.setModel(modelo);
                JOptionPane.showMessageDialog(this, "Producto Encontrado");
            } else {
                JOptionPane.showMessageDialog(this, "Producto No encontrado");
                limpiarTabla();
            }
        } else {
            limpiarTabla();
            listar();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_txtCloseActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        try{
            obj = new Exportar();
            obj.exportarExcel(tSale_detail);
        }catch(IOException ex){
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSale_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSale_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSale_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSale_detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSale_detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tSale_detail;
    private javax.swing.JButton txtClose;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtIdSale;
    private javax.swing.JTextField txtIddetail;
    private javax.swing.JTextField txtIdprodcut;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
