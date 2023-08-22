package biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Livro {
    private String titulo, autor, editora, quantidade, id;
    private final Connection con;

    public Livro(String titulo, String autor, String editora, String quantidade) {
       this.titulo = titulo;
       this.autor = autor;
       this.editora = editora;
       this.quantidade = quantidade;
       this.con = new Conexao().getConnection();
    }

    public Livro() {
        this.con = new Conexao().getConnection();
    }

    public Livro(String id, String titulo, String autor, String editora, String quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.quantidade = quantidade;
        this.con = new Conexao().getConnection();
    }
    
    //registra dados de Livro
    public boolean persistir() throws SQLException {
        String sql = "INSERT INTO tbl_livros (titulo, autor, editora, quantidade)"
                    + " VALUES ('" + titulo + "', '" + autor + "', '" + editora + "', '" + quantidade + "')"; 
            
            PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
            banco.execute(sql); // cria o vetor
        return true;
    }

    //Gera lista de livros
    public ArrayList<String> listarLivros() {
        String sql = "SELECT tbl_livros.id, tbl_livros.titulo, tbl_livros.quantidade "
                + " FROM tbl_livros ORDER BY tbl_livros.titulo";

        ArrayList<String> lista = new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();

            ResultSet resultado = banco.executeQuery(sql);

            while (resultado.next()) {

                lista.add(resultado.getString("id"));
                lista.add(resultado.getString("titulo"));
                lista.add(resultado.getString("quantidade"));
            }
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return lista;
    }

    //Recupera dados de um livro
    public ArrayList<String> recuperarDados(String id) {
        String sql="SELECT * FROM tbl_livros WHERE tbl_livros.id='"+id+"'";
        ArrayList<String> dados= new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            ResultSet resultado = banco.executeQuery(sql);

 
            while(resultado.next()){
                this.id= id;
                this.titulo= resultado.getString("titulo");
                this.autor= resultado.getString("autor");
                this.editora= resultado.getString("editora");
                this.quantidade= resultado.getString("quantidade");

                }
            
            dados.add(id);
            dados.add(titulo);
            dados.add(autor);
            dados.add(editora);
            dados.add(quantidade);
            
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return dados;
    }
    
    //Atualiza dados de um livro
    public boolean update() {
        try {
            String sql = "UPDATE tbl_livros SET titulo='" + titulo + "', autor = '" + autor
            + "', editora ='" + editora + "', quantidade = '" + quantidade + "'"
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

    //exclui um livro
    public boolean deletar(String id) {
        String sql = "DELETE FROM tbl_livros WHERE id = '" + id + "'";
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(sql);
            return true;
        } 
        catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
            return false;
        }
    }

    //Busca por id, título ou autor de um livro
    public ArrayList<String> buscarLivro(String texto) {
    
        ArrayList<String> resultados = new ArrayList<>();

        String sql = "SELECT tbl_livros.id, tbl_livros.titulo, tbl_livros.autor, "
                + "tbl_livros.editora, (tbl_livros.quantidade - "
                + "coalesce((SELECT COUNT(*) AS 'livrosEmprestados' "
                + "FROM tbl_emprestimos WHERE status='emprestado' AND "
                + "tbl_emprestimos.idLivro = tbl_livros.id GROUP BY idLivro), 0)) "
                + "as livrosDisponiveis from tbl_livros WHERE (tbl_livros.quantidade"
                + " - coalesce((SELECT COUNT(*) AS 'livrosEmprestados' "
                + "FROM tbl_emprestimos WHERE status='emprestado' AND "
                + "tbl_emprestimos.idLivro = tbl_livros.id GROUP BY idLivro), 0)) > 0 "
                + "AND (id like '%" + texto + "%' OR titulo like '%" + texto + "%'"
                + " OR autor like '%" + texto + "%')";       

        System.out.println(sql);
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor
            ResultSet resultadoPesquisa = banco.executeQuery(sql);

            if (!resultadoPesquisa.isBeforeFirst()) {
                resultados.add("Nenhum usuário encontrado");
            } else {
                while (resultadoPesquisa.next()) {
                    resultados.add(resultadoPesquisa.getString("id"));
                    resultados.add(resultadoPesquisa.getString("titulo"));
                    resultados.add(resultadoPesquisa.getString("livrosDisponiveis"));
                }

            }

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        
        return resultados;
    
    }
}
