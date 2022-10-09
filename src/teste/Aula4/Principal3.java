package teste.Aula4;

import java.sql.*;

public class Principal3 {

    // Variável principal da conexão MySQL. É a classe que representa a conexão com
    // o bando de dados
    private static Connection connection;

    public static void main(String[] args) {
        // o try/catch serve para tratamento de exceções, tratamento de códigos que
        // podem não ser totalmente atendidos e gerarem alguma exceção/erro.
        // try consegue recuperar erros que possam ocorrer no código fornecido em seu
        // bloco.
        // catch por sua vez faz o tratamento dos erros que aconteceram
        try {
            // Conecta com o banco de dados
            // DriverManager - gerencia o driver e cria uma conexão com o banco
            // Dentro do getConnection é especificado o driver JDBC específico, neste caso
            // utilizaremos o mysql
            // depois especificamos o local que está o banco de dados e o nome do banco
            // (localhost:3306/test), os outros dois parametros são o usuario (root) e senha
            // (neste caso esta vazia)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            // O PreparedStatement controla e executa uma instrução SQL preparada
            // No exemplo a seguir o SQL verifica se a tabela veiculos nao existe
            // se não existir, ele cria a tabela com os atributos: codigo, modelo e cor.
            PreparedStatement stm = connection.prepareStatement(
                    "create table if not exists veiculos(codigo INT, modelo TEXT, cor TEXT)");
            // Executa o SQL no banco de dados;
            stm.executeUpdate();
            // catch = se o que o try tentou não der certo, ele executa oque está dentro do
            // catch.
        } catch (SQLException exception) { // SQLException = exceção SQL
            exception.printStackTrace(); // Printa o erro;
        }
        inserirVeiculo(1, "Jeep", "Azul");
        inserirVeiculo(2, "Corsa", "Branco");
        inserirVeiculo(3, "Cruze", "Verde");
        inserirVeiculo(4, "Palio", "Cinza");
        inserirVeiculo(5, "Onix", "Prata");

        mostrarVeiculos();

        atualizarVeiculo(5, "Fusca", "Azul");

        excluirVeiculo(5);
    }

    private static void inserirVeiculo(int codigo, String modelo, String cor) {
        // Se tiver um veículo com o código X
        if (temVeiculo(codigo)) {
            System.out.println("Já tem um veículo registrado no MySQL.");
        } else {
            try {
                // No exemplo a seguir o SQL verifica insere uma instância na tabela veiculos
                PreparedStatement stm = connection.prepareStatement(
                        "insert into veiculos(codigo, modelo, cor) values(?,?,?)");
                // os numeros são definidos de acordo com a ordem dos atributos no comando SQL.
                stm.setInt(1, codigo);
                stm.setString(2, modelo);
                stm.setString(3, cor);

                // Executa o SQL no banco de dados;
                stm.executeUpdate();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    private static void atualizarVeiculo(int codigo, String modelo, String cor) {
        try {
            // No exemplo a seguir o SQL atualiza uma instancia da tabela veiculos
            // se o codigo for igual a 3 ele vai alterar o modelo e a cor passado no
            // parâmetro
            PreparedStatement stm = connection.prepareStatement(
                    "update veiculos set modelo = ?, cor = ? where codigo = ?");
            stm.setString(1, modelo);
            stm.setString(2, cor);
            stm.setInt(3, codigo);

            stm.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void mostrarVeiculos() {
        try {
            // No exemplo a seguir o SQL recupera todos os registros da tabela veiculos
            PreparedStatement stm = connection.prepareStatement(
                    "select * from veiculos");
            // ResultSet - contém o conjunto de dados retornado por uma consulta SQL.
            // O stm executará o SQL no banco e guardará o resultado no ResultSet
            ResultSet resultSet = stm.executeQuery();

            // enquanto o resultado(resultset) tiver algum dado, ou tiver um próximo dado,
            // as linhas dentro do laço while serão executadas.
            while (resultSet.next()) {
                // recupera o valor do atributo "codigo" e atribui na variavel "codigo"
                int codigo = resultSet.getInt("codigo");

                // recupera o valor do atributo "modelo" e atribui na variavel "modelo"
                String modelo = resultSet.getString("modelo");

                // recupera o valor do atributo "cor" e atribui na variavel "cor"
                String cor = resultSet.getString("cor");

                // Mostra no console as informações recuperadas
                System.out.println("Código: " + codigo);
                System.out.println("Modelo: " + modelo);
                System.out.println("Cor: " + cor);
                System.out.println(" ");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void excluirVeiculo(int codigo) {
        try {
            // No exemplo a seguir o SQL exclui um registro da tabela veiculos
            PreparedStatement stm = connection.prepareStatement(
                    "delete from veiculos where codigo = ?");
            stm.setInt(1, codigo);

            // Executa o SQL no banco de dados
            stm.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static boolean temVeiculo(int codigo) {
        try {
            // pega todos os registros da tabela veiculos, que o código seja igual ao do
            // parâmetro.
            PreparedStatement stm = connection.prepareStatement(
                    "select * from veiculos where codigo = ?");
            stm.setInt(1, codigo);
            ResultSet resultSet = stm.executeQuery();

            // next() = boolean.
            // Se tiver algum dado ou um próximo dado = true;
            // Caso contrário = false;
            return resultSet.next();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}