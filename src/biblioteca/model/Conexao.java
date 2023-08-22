package biblioteca.model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    /**
     * 
     * @return 
     */
    //Conexão com o banco de dados
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "123456"; // Windows

        Connection result = null;
        try {
            result = DriverManager.getConnection(url, usuario, senha);
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}
