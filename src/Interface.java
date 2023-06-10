import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author enzor
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Entrar = new javax.swing.JButton();
        User_info = new javax.swing.JFormattedTextField();
        User_pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CadastrarLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("USUÁRIO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 65, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("SENHA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 145, -1, -1));

        Entrar.setText("ENTRAR");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });
        getContentPane().add(Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 225, 220, 50));

        User_info.setMinimumSize(new java.awt.Dimension(10, 16));
        User_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_infoActionPerformed(evt);
            }
        });
        getContentPane().add(User_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 87, 220, 40));
        getContentPane().add(User_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 167, 220, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("ÁREA DE LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 28, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1D6FAEFC-BB4A-4430-B41F-1FB8FBFE96D7-removebg-preview__1_-removebg-preview (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -80, 420, 450));

        CadastrarLogin.setText("Cadastrar");
        CadastrarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarLoginActionPerformed(evt);
            }
        });
        getContentPane().add(CadastrarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 280, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
        String username = User_info.getText();
        String password = User_pass.getText();
        
        if (ValidarCredenciais(username, password)) {
            Interface.this.setVisible(false);
            CadastrodePessoas cadastroPessoas = new CadastrodePessoas();
            cadastroPessoas.setVisible(true);
        }
        else {
        // Credenciais inválidas
        // Exiba uma mensagem de erro ou tome outras ações apropriadas
        JOptionPane.showMessageDialog(this, "Credenciais inválidas. Tente novamente.", "Erro de login", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_EntrarActionPerformed

    private void User_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_User_infoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_User_infoActionPerformed

    private void CadastrarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarLoginActionPerformed
    String login = User_info.getText();
    String senha = new String(User_pass.getPassword());

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/pessoascadastradas", "root", "Mochye@Nonprofile");
        String query = "INSERT INTO tabela_login (Login, Senha) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        stmt.close();
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar pessoa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_CadastrarLoginActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarLogin;
    private javax.swing.JButton Entrar;
    private javax.swing.JFormattedTextField User_info;
    private javax.swing.JPasswordField User_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    private boolean ValidarCredenciais(String username, String password) {
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/pessoascadastradas", "root", "Mochye@Nonprofile");
        String query = "SELECT * FROM tabela_login WHERE Login = ? AND Senha = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        
        boolean credenciaisValidas = rs.next();
        
        rs.close();
        stmt.close();
        conn.close();
        
        return credenciaisValidas;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
    }
}
