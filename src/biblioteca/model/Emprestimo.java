package biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Emprestimo {
    
    String idLivro, idUsuario, dataEmprestimo, dataDevolucao, id;
    private final Connection con;

    public Emprestimo(String idLivro, String idUsuario, String dataEmprestimo, String dataDevolucao) {
       this.idLivro = idLivro;
       this.idUsuario = idUsuario;
       this.dataEmprestimo = dataEmprestimo.substring(6,10) + "-" + dataEmprestimo.substring(3,5) + "-" + dataEmprestimo.substring(0,2);
       this.dataDevolucao = dataDevolucao.substring(6,10) + "-" + dataDevolucao.substring(3,5) + "-" + dataDevolucao.substring(0,2);
       this.con = new Conexao().getConnection();
    }

    public Emprestimo() {
        this.con = new Conexao().getConnection();
    }

    public Emprestimo(String id) {
       this.con = new Conexao().getConnection();
       this.id = id;
    }
    
    //grava dados de empréstimo no banco de dados
    public boolean persistir() {
       try {
            String sql = "INSERT INTO tbl_emprestimos (idLivro, idUsuario, dataEmprestimo, dataDevolucao, status)"
                    + " VALUES ('" + idLivro + "', '" + idUsuario + "', '" + dataEmprestimo + "', '" + dataDevolucao + "', '" 
                    + "emprestado')";

           PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
           banco.execute(sql); // cria o vetor
           return true;
        }
        catch (SQLException ex)  {
                    System.out.println("o erro foi " +ex);
                    return false;
        }
    }

    //Gera lista de empréstimos
    public ArrayList<String> listarEmprestimos() {
        String sql = "SELECT tbl_emprestimos.id, tbl_usuarios.nome, tbl_livros.titulo, "
                + "tbl_emprestimos.status FROM tbl_emprestimos INNER JOIN tbl_usuarios "
                + "INNER JOIN tbl_livros ON tbl_emprestimos.idLivro = tbl_livros.id AND "
                + "tbl_emprestimos.idUsuario = tbl_usuarios.id WHERE tbl_emprestimos.status = "
                + "'emprestado' ORDER BY tbl_usuarios.nome";

        ArrayList<String> lista = new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();

            ResultSet resultado = banco.executeQuery(sql);

            while (resultado.next()) {

                lista.add(resultado.getString("id"));
                lista.add(resultado.getString("nome"));
                lista.add(resultado.getString("titulo"));
                lista.add(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return lista;
    }
    
    //recupera dados de um empréstimo
    public ArrayList<String> recuperarDados() {
        String sql = "SELECT tbl_emprestimos.id, tbl_emprestimos.idUsuario, tbl_usuarios.nome, tbl_livros.titulo, "
                + "tbl_emprestimos.dataDevolucao FROM tbl_emprestimos INNER JOIN tbl_usuarios "
                + "INNER JOIN tbl_livros ON tbl_emprestimos.idLivro = tbl_livros.id AND "
                + "tbl_emprestimos.idUsuario = tbl_usuarios.id WHERE tbl_emprestimos.id = "
                + "'" + id +"'";
        ArrayList<String> dados= new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            ResultSet resultado = banco.executeQuery(sql);
            String nomeResultado ="", tituloResultado = "", dataDevolucao = "", idUsuario = "";
             while(resultado.next()){
                this.id= id;
                idUsuario = resultado.getString("idUsuario");
                nomeResultado = resultado.getString("nome");
                tituloResultado = resultado.getString("titulo");
                dataDevolucao = resultado.getString("dataDevolucao");
                }
                dados.add(id);
                dados.add(idUsuario);
                dados.add(nomeResultado);
                dados.add(tituloResultado);
                dados.add(dataDevolucao);

            
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return dados;
    }

    //Registra devolução de empréstimo
    public boolean registrarDevolucao() {
        try {
            String sql = "UPDATE tbl_emprestimos SET status='devolvido'"
            + " WHERE id = '" + id + "'";
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            banco.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
            return false;
        }
    }

    //Registra bloqueio de usuário
    public boolean bloquearUsuario(String idUsuario, String totalMulta, String descricaoMulta) {
        try {
            String sql = "INSERT INTO tbl_bloqueio (idUsuario, valorDevido, descricao, status)"
                    + " VALUES ('" + idUsuario + "', '" + totalMulta + "', '" + descricaoMulta + "', 'bloqueado')";
           PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
           banco.execute(sql); // cria o vetor
           
           sql = "UPDATE tbl_usuarios SET status='bloqueado'"
                + " WHERE id = '" + idUsuario + "'";

           banco = (PreparedStatement)con.prepareStatement(sql);
           banco.execute(sql); // cria o vetor
           
           return true;
        }
        catch (SQLException ex)  {
                    System.out.println("o erro foi " +ex);
                    return false;
        }
    }

    //Gera dados para renovação
    public ArrayList<String> dadosRenovar() {
       String sql = "SELECT tbl_emprestimos.id, tbl_livros.titulo, tbl_emprestimos.renovacao, "
                + "tbl_emprestimos.dataDevolucao FROM tbl_emprestimos "
                + "INNER JOIN tbl_livros ON tbl_emprestimos.idLivro = tbl_livros.id "
                + "WHERE tbl_emprestimos.id = "
                + "'" + id +"'";
        ArrayList<String> dados= new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            ResultSet resultado = banco.executeQuery(sql);
            String tituloLivro ="", renovacao = "", dataDevolucaoSt = "";
            while(resultado.next()){
                this.id = id;
                tituloLivro = resultado.getString("titulo");
                renovacao = resultado.getString("renovacao");
                dataDevolucaoSt = resultado.getString("dataDevolucao");
                }
                dados.add(id);
                dados.add(tituloLivro);
                dados.add(renovacao);
                dados.add(dataDevolucaoSt);
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return dados;
    }

    //Registra renovação de empréstimo
    public boolean renovacao(String renovacaoNumero, String novaDataDevolucao) {
        try {
            novaDataDevolucao = novaDataDevolucao.substring(6,10) + "-" + novaDataDevolucao.substring(3,5) + "-" + novaDataDevolucao.substring(0,2);
            int renovacao = Integer.parseInt(renovacaoNumero) + 1;
            String sql = "UPDATE tbl_emprestimos SET dataDevolucao='"+novaDataDevolucao+"',"
            + " renovacao = "+renovacao+" WHERE id = '" + id + "'";
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            banco.executeUpdate(sql);
            return true;
    } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
            return false;
    }
    }
    
}
