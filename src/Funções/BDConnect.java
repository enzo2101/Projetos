package Funções;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Types;


public class BDConnect {
    Connection connection;

    public BDConnect() {
        conectarBancoDados();
    }

    public boolean conectarBancoDados() {
        String url = "jdbc:mysql://none/none"; //URL do banco de dados
        String username = "none"; //usuário do banco de dados
        String password = "none"; //senha do banco de dados

        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão com o banco de dados
            connection = DriverManager.getConnection(url, username, password);

            return true;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return false;
    }
    
    public Connection getConnection() {
        return connection;
    }


public void inserirPessoaNoBancoDeDados(String tipo, String nome, String cpf, String data_nascimento, String peso, String altura, String idade) {
    String sql = "INSERT INTO pessoas (tipo, nome, cpf, data_nascimento, peso, altura, idade) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tipo);
        statement.setString(2, nome);
        statement.setString(3, cpf);
        statement.setString(4, data_nascimento);

        if (tipo.equals("Aluno")) {
            statement.setString(5, peso);
            statement.setString(6, altura);
        } else {
            statement.setNull(5, Types.INTEGER); // Define o valor do peso como nulo
            statement.setNull(6, Types.INTEGER); // Define o valor da altura como nulo
        }

        statement.setString(7, idade);

        statement.executeUpdate();
        System.out.println("Pessoa inserida no banco de dados com sucesso.");
    } catch (SQLException e) {
        System.out.println("Erro ao inserir pessoa no banco de dados: " + e.getMessage());
    }
}



    public void alterarPessoaNoBancoDeDados(String cpf, String novoNome, String novaDataNascimento, String novoTipo, String novoPeso, String novaAltura) {
        String sql = "UPDATE pessoas SET nome = ?, data_nascimento = ?, tipo = ?, peso = ?, altura = ? WHERE cpf = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, novoNome);
            statement.setString(2, novaDataNascimento);
            statement.setString(3, novoTipo);
            statement.setString(4, novoPeso);
            statement.setString(5, novaAltura);
            statement.setString(6, cpf);

            statement.executeUpdate();
            System.out.println("Cadastro alterado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar cadastro: " + e.getMessage());
        }
    }
    
        public void excluirPessoaDoBancoDeDados(String cpf) {
        String sql = "DELETE FROM pessoas WHERE cpf = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.executeUpdate();
            System.out.println("Cadastro excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cadastro: " + e.getMessage());
        }
    }
        
        public boolean verificarCPFExistente(String cpf) {
        String sql = "SELECT * FROM pessoas WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar CPF no banco de dados: " + e.getMessage());
        }

    return false;
    }
}
