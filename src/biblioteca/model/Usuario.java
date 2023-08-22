package biblioteca.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
    
    private final Connection con;
    private String nome, rg, cpf, telefone, rua, numero, bairro,cidade, data, estado, id, cep;
    
    public Usuario (){
            this.con = new Conexao().getConnection();
    }

    public Usuario(String nome, String rg, String cpf, String telefone, String rua, String numero, 
            String bairro, String cidade, String data, String estado, String cep) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.data = data.substring(6,10) + "-" + data.substring(3,5) + "-" + data.substring(0,2);
        this.con = new Conexao().getConnection();
        this.cep = cep;
    }

    public Usuario(String id, String nome, String rg, String cpf, String telefone, String rua, String numero, String bairro, String cidade, String dataNascimento, String estado, String cep) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.data = dataNascimento.substring(6,10) + "-" + dataNascimento.substring(3,5) + "-" + dataNascimento.substring(0,2);  
        this.con = new Conexao().getConnection();
        this.id = id;
        this.cep = cep;
    }

    public Usuario(String id) {
        this.id = id;
        this.con = new Conexao().getConnection();
    }
    
    //grava dados de usuário
    public boolean persistir() throws SQLException {

        String sql = "INSERT INTO tbl_usuarios (nome, rua, numero, bairro, cidade, estado, cep, telefone, rg, "
                    + "cpf, dataNascimento, status)"
                    + " VALUES ('" + nome + "', '" + rua + "', '" + numero + "', '" + bairro + "', '" 
                    + cidade + "', '" + estado + "', '" + cep + "', '" + telefone + "', '" + rg + "', '" + cpf + "', '" 
                    + data + "', 'ativo')"; 
            
            PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
            banco.execute(sql); // cria o vetor
        return true;
    }

    //Gera lista de usuários
    public ArrayList<String> listarUsuarios() {
        String sql = "SELECT tbl_usuarios.id, tbl_usuarios.nome, tbl_usuarios.status "
                + " FROM tbl_usuarios ORDER BY tbl_usuarios.nome";

        ArrayList<String> lista = new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();

            ResultSet resultado = banco.executeQuery(sql);

            while (resultado.next()) {

                lista.add(resultado.getString("id"));
                lista.add(resultado.getString("nome"));
                lista.add(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return lista;
    }

    //Exclui cadastro de usuário
    public boolean deletar(String id) {
        String sql = "DELETE FROM tbl_usuarios WHERE id = '" + id + "'";

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

    //atualiza dados de usuário
    public boolean update() {
        try {
            String sql = "UPDATE tbl_usuarios SET nome='" + nome + "', rua = '" + rua
            + "', numero ='" + numero + "', bairro ='" + bairro + "', cidade ='" + cidade 
            + "', estado ='" + estado + "', cep ='" + cep + "', telefone ='" + telefone + "', rg ='" + rg 
            + "', cpf ='" + cpf + "', dataNascimento ='" + data
            + "' WHERE id = '" + id + "'";

            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            banco.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
            return false;
        }
      
    }

    //recupera dados de um usuário
    public ArrayList<String> recuperarDados() {
        String sql="SELECT * FROM tbl_usuarios WHERE id='"+id+"'";
        ArrayList<String> dados= new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            ResultSet resultado = banco.executeQuery(sql);

            while(resultado.next()){
                this.id = id;
                this.nome= resultado.getString("nome");
                this.rua= resultado.getString("rua");
                this.numero= resultado.getString("numero");
                this.bairro= resultado.getString("bairro");
                this.cidade= resultado.getString("cidade");
                this.estado= resultado.getString("estado");
                this.telefone= resultado.getString("telefone");
                this.rg= resultado.getString("rg");
                this.cpf= resultado.getString("cpf");
                this.data= resultado.getString("dataNascimento");
                this.cep = resultado.getString("cep");
                }
            
            dados.add(id);
            dados.add(nome);
            dados.add(rua);
            dados.add(numero);
            dados.add(bairro);
            dados.add(cidade);
            dados.add(estado);
            dados.add(telefone);
            dados.add(rg);
            dados.add(cpf);
            dados.add(data);
            dados.add(cep);
            
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return dados;
    }
    
    //busca por usuário que tenham id, nome ou cpf conforme o digitado
    public ArrayList<String> buscarUsuario(String texto) {
        ArrayList<String> resultados = new ArrayList<>();

        String sql = "SELECT id, nome, cpf from tbl_usuarios WHERE "
                + "tbl_usuarios.id NOT IN (SELECT tbl_usuarios.id FROM "
                + "tbl_usuarios LEFT JOIN (SELECT idUsuario, COUNT(*) AS "
                + "livrosEmprestados FROM tbl_emprestimos WHERE "
                + "status='emprestado' GROUP BY idUsuario) AS livrosEmprestados "
                + "ON tbl_usuarios.id = livrosEmprestados.idUsuario WHERE "
                + "livrosEmprestados.livrosEmprestados = 3) "
                + "AND (id like '%" + texto + "%' OR nome like '%" + texto + "%'"
                + " OR cpf like '%" + texto + "%') AND status='ativo'";

        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor
            ResultSet resultadoPesquisa = banco.executeQuery(sql);

            if (!resultadoPesquisa.isBeforeFirst()) {
                resultados.add("Nenhum usuário encontrado");
            } else {
                while (resultadoPesquisa.next()) {
                    resultados.add(resultadoPesquisa.getString("id"));
                    resultados.add(resultadoPesquisa.getString("nome"));
                    resultados.add(resultadoPesquisa.getString("cpf"));
                }

            }

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }

        return resultados;
    }

    //Registra bloqueio de usuário
    public ArrayList<String> dadosBloqueio(String idUser) {
       String sql="SELECT tbl_bloqueio.id, tbl_bloqueio.idUsuario, tbl_usuarios.nome, "
               + "tbl_bloqueio.valorDevido, tbl_bloqueio.descricao FROM tbl_bloqueio"
               + " INNER JOIN tbl_usuarios ON tbl_bloqueio.idUsuario = tbl_usuarios.id"
               + " WHERE tbl_bloqueio.idUsuario='"+idUser+"' AND tbl_bloqueio.status='bloqueado'";
        ArrayList<String> dados= new ArrayList<>();
        try {
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            ResultSet resultado = banco.executeQuery(sql);
            String stId = "", idUsuario = "", stNome = "", valorDevido = "", stdescricao = "";
            while(resultado.next()){
                idUsuario = resultado.getString("idUsuario");
                stId = resultado.getString("id");
                stNome = resultado.getString("nome");
                valorDevido = resultado.getString("valorDevido");
                stdescricao = resultado.getString("descricao");
                }
            
            dados.add(idUsuario);
            dados.add(stId);
            dados.add(stNome);
            dados.add(valorDevido);
            dados.add(stdescricao);
            
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        return dados;
    }

    //registra desbloqueio de usuário
    public boolean desbloquear() {
         try {
        String sql = "UPDATE tbl_bloqueio SET status='resolvido' WHERE idUsuario = '" + id + "'";
        PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
        banco.execute();
        banco.executeUpdate(sql);
        
        sql = "UPDATE tbl_usuarios SET status='ativo' WHERE id = '" + id + "'";
        banco = (PreparedStatement) con.prepareStatement(sql);
        banco.execute();
        banco.executeUpdate(sql);
        
        return true;
    } catch (SQLException ex) {
    System.out.println("o erro foi " + ex);
    return false;
    }
    
    }
    
    //registra pagamento parcial de multa
    public boolean pagamentoParcial(Double valorAtualizado) {
       try {
            String sql = "UPDATE tbl_bloqueio SET valorDevido='"+valorAtualizado+"' WHERE idUsuario = '" + id + "'";
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
