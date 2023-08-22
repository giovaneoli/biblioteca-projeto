package biblioteca.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;


public class Senha {
    
    private char[] senhaAtual, senhaNova;
    private final Connection con;
    private String login;

    
    public Senha(String bibliotecario, char[] senhaAtual) {
        this.con = new Conexao().getConnection();
        this.senhaAtual = senhaAtual;
        this.login = bibliotecario;
    }
    
   // Cria um hash em MD5 a partir da senha
    public static String getHashMd5(String value) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
        return hash.toString(16);
    }

    //altera senha
    public boolean alterarSenha(char[] senhaNova) throws NoSuchAlgorithmException {
        try {
            String senhaNew = new String(senhaNova);
            String senhaAct = new String(senhaAtual);
            String senhaNewCriptograda = getHashMd5(senhaNew);
            String senhaActCriptograda = getHashMd5(senhaAct);
            
            
            String sql = "UPDATE tbl_bibliotecarios SET senha='" + senhaNewCriptograda + "'"
            + " WHERE login = '" + login + "' AND senha = '"+senhaActCriptograda+"'";
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            banco.executeUpdate(sql);
            return true;
        } 
        catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
            return false;
        }
    }

    //verifica se a senha atual está correta
    public boolean senhaCorreta(char[] senhaAtual) {
       try {
           String senhaAct = new String(senhaAtual);
           String senhaActCriptograda = getHashMd5(senhaAct);

           String sql = "SELECT * FROM tbl_bibliotecarios "
                    + "WHERE senha = '" + senhaActCriptograda + "' "
                    + "AND login = '" + this.login + "'";
            
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute();
            ResultSet resultado = banco.executeQuery(sql);
            
            int size = 0;
            if (resultado != null)  {
                resultado.last();    // moves cursor to the last row
                size = resultado.getRow(); // get row id 
            }


            return size > 0;
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
            return false;
        }
    }
}
