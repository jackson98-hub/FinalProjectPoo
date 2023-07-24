/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import BussinesObject.Users;
import TransferObject.UsersDTO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose.abad
 */
public class FrmLogin extends javax.swing.JFrame {
    DefaultTableModel modelo;
    UsersDTO usersDTO;
    Users users;

    public FrmLogin() { 
        modelo = new DefaultTableModel();
        usersDTO = new UsersDTO();
        users = new Users();
        initComponents();
        
        rsscalelabel.RSScaleLabel.setScaleLabel(lblFondo, "src\\Presentacion\\assets\\img\\images.jpg");
        txtUser.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setLocation(new java.awt.Point(500, 100));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(125, 179, 196));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLogin.setBackground(new java.awt.Color(23, 74, 104));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Ingresar");
        btnLogin.setEnabled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setFocusAccelerator('1');
        txtUser.setFocusCycleRoot(true);
        txtUser.setMargin(new java.awt.Insets(6, 6, 2, 6));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });

        txtPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPass.setAlignmentX(4.0F);
        txtPass.setAlignmentY(4.0F);
        txtPass.setMargin(new java.awt.Insets(6, 6, 2, 6));
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(txtUser)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 300, 270));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 420, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUser.getText();
        String pss = txtPass.getText();
        
        Boolean result = users.login(user, pss);
        
        if(result) {
            FrmMenu abrir= new FrmMenu();
            abrir.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña ivalidos");
            txtUser.setText("");
            txtPass.setText("");
            txtUser.requestFocus();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        setEbaledValue();
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
        setEbaledValue();
    }//GEN-LAST:event_txtPassKeyReleased

    private void setEbaledValue(){
        int user = txtUser.getText().length();
        int pss = txtPass.getText().length();
        if(user >= 3 && pss >= 3){
            btnLogin.setEnabled(true);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
