package Funções;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarCadastros {
    private BDConnect bdConnect;
    private JTable pessoasCadastradas;

    public ListarCadastros(BDConnect bdConnect, JTable pessoasCadastradas) {
        this.bdConnect = bdConnect;
        this.pessoasCadastradas = pessoasCadastradas;
    }

    public void listarCadastros() {
        DefaultTableModel model = (DefaultTableModel) pessoasCadastradas.getModel();
        model.setRowCount(0);

        try {
            bdConnect.conectarBancoDados();

            String sql = "SELECT * FROM pessoas";
            java.sql.Statement statement = bdConnect.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            DateFormat dateFormatInput = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormatOutput = new SimpleDateFormat("dd/MM/yyyy");

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String dataNascimento = resultSet.getString("data_nascimento");

                // Formatar a data de nascimento
                if (dataNascimento != null) {
                    java.util.Date date = dateFormatInput.parse(dataNascimento);
                    dataNascimento = dateFormatOutput.format(date);
                }

                String tipo = resultSet.getString("tipo");
                String peso = resultSet.getString("peso");
                String altura = resultSet.getString("altura");
                String idade = resultSet.getString("idade");

                // Adicionar o registro à tabela
                model.addRow(new Object[]{nome, cpf, dataNascimento, tipo, peso, altura, idade});
            }

            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ListarCadastros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            // Tratar exceção de análise da data
            Logger.getLogger(ListarCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
