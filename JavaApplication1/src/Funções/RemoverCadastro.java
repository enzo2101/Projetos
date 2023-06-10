package Funções;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoverCadastro {
    private BDConnect bdConnect;
    private JTable pessoasCadastradas;

    public RemoverCadastro(BDConnect bdConnect, JTable pessoasCadastradas) {
        this.bdConnect = bdConnect;
        this.pessoasCadastradas = pessoasCadastradas;
    }

    public void removerCadastroSelecionado() {
        int selectedRow = pessoasCadastradas.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) pessoasCadastradas.getModel();
            String cpf = (String) model.getValueAt(selectedRow, 1); // Assume que a coluna do CPF é a coluna 1

            // Remover a linha selecionada da tabela
            model.removeRow(selectedRow);

            if (bdConnect.conectarBancoDados()) {
                bdConnect.excluirPessoaDoBancoDeDados(cpf); // Chama o método para excluir o registro no banco de dados
                JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cadastro para excluir!");
        }
    }
}
