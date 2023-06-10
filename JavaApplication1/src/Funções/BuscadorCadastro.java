package Funções;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class BuscadorCadastro {
    public static void buscarCadastro(BDConnect bdConnect, JTable pessoasCadastradas) {
        String busca = JOptionPane.showInputDialog(null, "Digite o CPF do cadastro:");

        // Verificar se o CPF existe no banco de dados
        boolean encontrou = bdConnect.verificarCPFExistente(busca);

        if (encontrou) {
            JOptionPane.showMessageDialog(null, "Cadastro encontrado!");

            ListarCadastros listarCadastros = new ListarCadastros(bdConnect, pessoasCadastradas);
            listarCadastros.listarCadastros();

            // Selecionar o cadastro correspondente ao CPF fornecido
            int rowCount = pessoasCadastradas.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String cpf = (String) pessoasCadastradas.getValueAt(i, 1);
                if (busca.equals(cpf)) {
                    pessoasCadastradas.setRowSelectionInterval(i, i);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não encontrado!");
        }
    }
}
