package biblioteca.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {
    
    private String usuario;
    private String senha;
    private final Connection con;
    
    public Login(){
        this.con = new Conexao().getConnection();
    }
    
    /**
     * 
     * @param usuario
     * @param senha
     * @return 
     */
    
    // valida dados de acesso
    public boolean acessar (String usuario, String senha) {
        this.usuario = usuario;
        this.senha = Senha.getHashMd5(senha);
        
        String sql = "SELECT * from tbl_bibliotecarios WHERE login='" + usuario +"'";
        
        String loginBanco = null, senhaBanco = null;
        try {
           PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
           banco.execute(); // cria o vetor
           ResultSet resultadoLogin = banco.executeQuery(sql);
           
                    while(resultadoLogin.next()){
                        loginBanco = resultadoLogin.getString("login");
                        senhaBanco = resultadoLogin.getString("senha");
                    }
        }
                    
        catch (SQLException ex)  {
            System.out.println("o erro foi " +ex);
        }
        
        if (this.usuario.equals(loginBanco) && this.senha.equals(senhaBanco)){
             return true;
        }
        else {
            return false;
        }
        
   }
    
}
