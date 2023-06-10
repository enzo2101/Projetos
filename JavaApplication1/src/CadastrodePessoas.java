import Funções.ValidadorIdade;
import Funções.BuscadorCadastro;
import Funções.LimitadorCPF;
import Funções.AlterarCadastro;
import Funções.BDConnect;
import Funções.Campo_data;
import Funções.RemoverCadastro;
import Funções.ListarCadastros;
import Funções.ValidaCPF;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.lang.*;



public class CadastrodePessoas extends javax.swing.JFrame {
        
    private BDConnect bdConnect;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JTextField diaTextField;
    private javax.swing.JTextField mesTextField;
    private javax.swing.JTextField anoTextField;
    private JComboBox<String> tipoComboBox;
    private JTable pessoasCadastradas;
    
public CadastrodePessoas() {
    initComponents();
    this.setLocationRelativeTo(null);
    tipoComboBox = new JComboBox<String>();
        // Criar instância de CamposDataListener e passar as referências dos campos
        Campo_data camposDataListener  = new Campo_data(Dia, Mes, Ano);

        LimitadorCPF.limitarTamanhoCPF(CPF);
        
        bdConnect = new BDConnect();
        bdConnect.conectarBancoDados();
        
        nomeTextField = new javax.swing.JTextField();
        cpfTextField = new javax.swing.JTextField();
        diaTextField = new javax.swing.JTextField();
        mesTextField = new javax.swing.JTextField();
        anoTextField = new javax.swing.JTextField();       

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CPF = new javax.swing.JTextField();
        Nome = new javax.swing.JTextField();
        Dia = new javax.swing.JTextField();
        Ano = new javax.swing.JTextField();
        Mes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        PessoasCadastradas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Tipo = new javax.swing.JComboBox<>();
        Inserir1 = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        Alterar = new javax.swing.JButton();
        Listar_Cadastros1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 560));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 64, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("CPF");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 67, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Data Nascimento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFActionPerformed(evt);
            }
        });
        getContentPane().add(CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 64, 211, -1));

        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });
        getContentPane().add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 61, 211, -1));

        Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiaActionPerformed(evt);
            }
        });
        getContentPane().add(Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 104, 40, -1));
        getContentPane().add(Ano, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 104, 40, -1));

        Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesActionPerformed(evt);
            }
        });
        getContentPane().add(Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 104, 40, -1));

        PessoasCadastradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Data Nascimento", "Tipo", "Peso", "Altura", "Idade"
            }
        ));
        jScrollPane1.setViewportView(PessoasCadastradas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 159, 684, 297));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("CADASTRO DE PESSOAS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 13, -1, -1));

        Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personal", "Aluno" }));
        Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoActionPerformed(evt);
            }
        });
        getContentPane().add(Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 90, -1));

        Inserir1.setText("Inserir");
        Inserir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Inserir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inserir1ActionPerformed(evt);
            }
        });
        getContentPane().add(Inserir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        Remover.setText("Remover");
        Remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });
        getContentPane().add(Remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, -1, -1));

        Buscar.setText("Buscar");
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, -1, -1));

        jLabel6.setText("/");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 107, -1, -1));

        jLabel7.setText("/");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 107, -1, -1));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 700, 320));

        Alterar.setText("Alterar");
        Alterar.setToolTipText("");
        Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, -1, -1));

        Listar_Cadastros1.setText("Listar Cadastros");
        Listar_Cadastros1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Listar_Cadastros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Listar_Cadastros1ActionPerformed(evt);
            }
        });
        getContentPane().add(Listar_Cadastros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiaActionPerformed

    }//GEN-LAST:event_DiaActionPerformed

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed

    private void CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFActionPerformed
        
    }//GEN-LAST:event_CPFActionPerformed

    private void MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MesActionPerformed

    private void TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoActionPerformed
    
    }//GEN-LAST:event_TipoActionPerformed

    private void Inserir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inserir1ActionPerformed
    String tipo = (String) Tipo.getSelectedItem();
    String nome = Nome.getText();
    String cpf = CPF.getText();
    String dia = Dia.getText();
    String mes = Mes.getText();
    String ano = Ano.getText();
    String data_nascimento = dia + "/" + mes + "/" + ano;

    // Verifica se o CPF é válido
    ValidaCPF validaCPF = new ValidaCPF();
    boolean cpfValido = validaCPF.isCPFValido(cpf);


    if (!cpfValido) {
        JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DefaultTableModel pessoasCadastradas = (DefaultTableModel) PessoasCadastradas.getModel();
    int rowCount = pessoasCadastradas.getRowCount();

    // Verificar se o CPF já existe
    for (int i = 0; i < rowCount; i++) {
        String cpfExistente = (String) pessoasCadastradas.getValueAt(i, 1);

        if (cpfExistente.equals(cpf)) {
            JOptionPane.showMessageDialog(this, "O CPF já está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Obtém a data atual
    Calendar dataAtual = Calendar.getInstance();
    int anoAtual = dataAtual.get(Calendar.YEAR);
    int mesAtual = dataAtual.get(Calendar.MONTH) + 1; // O mês é baseado em zero, então adicionamos 1
    int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);

    int idade = anoAtual - Integer.parseInt(ano);

    // Verifica se o mês atual é menor que o mês de aniversário ou se o mês é igual, mas o dia atual é menor
    if (mesAtual < Integer.parseInt(mes) || (mesAtual == Integer.parseInt(mes) && diaAtual < Integer.parseInt(dia))) {
        idade--; // Ainda não fez aniversário, então subtrai 1 da idade
    }

    // Formata a data no formato correto: yyyy-MM-dd
    String dataFormatada = String.format("%04d-%02d-%02d", Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));

    // Verifica se a idade é maior que 120
    if (!ValidadorIdade.validarIdade(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(ano))) {
        return;
    }

    Vector<String> pessoa = new Vector<String>();

    pessoa.add(nome);
    pessoa.add(cpf);
    pessoa.add(dia + "/" + mes + "/" + ano);
    pessoa.add(tipo);

    if (tipo.equals("Aluno")) {
        String peso = JOptionPane.showInputDialog(null, "Digite o peso do aluno:");
        String altura = JOptionPane.showInputDialog(null, "Digite a altura do aluno:");
        pessoa.add(peso);
        pessoa.add(altura);
    } else {
        pessoa.add(""); // Deixe em branco para a coluna do peso
        pessoa.add(""); // Deixe em branco para a coluna da altura
    }

    pessoa.add(Integer.toString(idade)); // Adicione a idade na coluna correspondente

    pessoasCadastradas.insertRow(0, pessoa); // Insere a pessoa na primeira linha da tabela

    BDConnect bdConnect = new BDConnect(); // Instância a classe BDConnect
    if (bdConnect.conectarBancoDados()) {
        bdConnect.inserirPessoaNoBancoDeDados(tipo, nome, cpf, dataFormatada, pessoa.get(4), pessoa.get(5), Integer.toString(idade));
        JOptionPane.showMessageDialog(this, "Pessoa inserida com sucesso!");
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    Nome.setText("");
    CPF.setText("");
    Dia.setText("");
    Mes.setText("");
    Ano.setText("");
    }//GEN-LAST:event_Inserir1ActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        RemoverCadastro removerCadastro = new RemoverCadastro(bdConnect, PessoasCadastradas);
        removerCadastro.removerCadastroSelecionado();
    }//GEN-LAST:event_RemoverActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
    BDConnect bdConnect = new BDConnect();
    JTable pessoasCadastradas = PessoasCadastradas;
    
    BuscadorCadastro buscadorCadastro = new BuscadorCadastro();
    buscadorCadastro.buscarCadastro(bdConnect, pessoasCadastradas);
    }//GEN-LAST:event_BuscarActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
    AlterarCadastro alterarCadastro = new AlterarCadastro(bdConnect, PessoasCadastradas);
    alterarCadastro.alterarCadastro();
    }//GEN-LAST:event_AlterarActionPerformed

    private void Listar_Cadastros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Listar_Cadastros1ActionPerformed
    ListarCadastros listarCadastros = new ListarCadastros(bdConnect, PessoasCadastradas);
    listarCadastros.listarCadastros();
    }//GEN-LAST:event_Listar_Cadastros1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrodePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrodePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrodePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrodePessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrodePessoas cadastro = new CadastrodePessoas();
                cadastro.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JTextField Ano;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField CPF;
    private javax.swing.JTextField Dia;
    private javax.swing.JButton Inserir1;
    private javax.swing.JButton Listar_Cadastros1;
    private javax.swing.JTextField Mes;
    private javax.swing.JTextField Nome;
    private javax.swing.JTable PessoasCadastradas;
    private javax.swing.JButton Remover;
    private javax.swing.JComboBox<String> Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}