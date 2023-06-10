package Funções;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlterarCadastro {
    private BDConnect bdConnect;
    private JTable pessoasCadastradas;

    public AlterarCadastro(BDConnect bdConnect, JTable pessoasCadastradas) {
        this.bdConnect = bdConnect;
        this.pessoasCadastradas = pessoasCadastradas;
    }

    public void alterarCadastro() {
        int selectedRow = pessoasCadastradas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cadastro para alterar!");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) pessoasCadastradas.getModel();
        String cpf = (String) model.getValueAt(selectedRow, 1);

        String novoNome = JOptionPane.showInputDialog(null, "Digite o novo nome:", model.getValueAt(selectedRow, 0));
        String novaDataNascimento = JOptionPane.showInputDialog(null, "Digite a nova data de nascimento (dd/MM/yyyy):", model.getValueAt(selectedRow, 2));
        DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormatInput.parse(novaDataNascimento);

            // Verifica se a nova data de nascimento resulta em uma idade superior a 120 anos
            boolean idadeValida = ValidadorIdade.validarIdade(date.getDay(), date.getMonth() + 1, date.getYear() + 1900);
            if (!idadeValida) {
                // Volta para a tela de alteração de data de nascimento
                alterarCadastro();
                return;
            }

            String novoTipo = (String) JOptionPane.showInputDialog(null, "Selecione o novo tipo:", "Tipo", JOptionPane.PLAIN_MESSAGE, null, new String[]{"Aluno", "Personal"}, model.getValueAt(selectedRow, 3));
            String novoPeso = null;
            String novaAltura = null;
            if (novoTipo.equals("Aluno")) {
                novoPeso = JOptionPane.showInputDialog(null, "Digite o novo peso:", model.getValueAt(selectedRow, 4));
                novaAltura = JOptionPane.showInputDialog(null, "Digite a nova altura:", model.getValueAt(selectedRow, 5));
            }

            if (bdConnect.conectarBancoDados()) {
                DateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");
                String novaDataFormatada = dateFormatOutput.format(date);
                
                // Recalcula a idade com base na nova data de nascimento
                int idade = calcularIdade(date);
                
                String sql = "UPDATE pessoas SET nome = ?, data_nascimento = ?, tipo = ?, peso = ?, altura = ?, idade = ? WHERE cpf = ?";
                PreparedStatement stmt = bdConnect.getConnection().prepareStatement(sql);
                stmt.setString(1, novoNome);
                stmt.setString(2, novaDataFormatada);
                stmt.setString(3, novoTipo);
                stmt.setString(4, novoPeso);
                stmt.setString(5, novaAltura);
                stmt.setInt(6, idade);
                stmt.setString(7, cpf);
                stmt.executeUpdate();

                // Atualiza os valores na tabela
                model.setValueAt(novoNome, selectedRow, 0);
                model.setValueAt(novaDataNascimento, selectedRow, 2);
                model.setValueAt(novoTipo, selectedRow, 3);
                model.setValueAt(novoPeso, selectedRow, 4);
                model.setValueAt(novaAltura, selectedRow, 5);
                model.setValueAt(idade, selectedRow, 6);

                stmt.close();
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int calcularIdade(Date dataNascimento) {
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);
        
        int idade = dataAtual.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        
        if (dataAtual.get(Calendar.MONTH) < dataNasc.get(Calendar.MONTH)
                || (dataAtual.get(Calendar.MONTH) == dataNasc.get(Calendar.MONTH)
                && dataAtual.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH))) {
            idade--;
        }
        
        return idade;
    }
}
