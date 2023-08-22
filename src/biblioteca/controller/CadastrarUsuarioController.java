package biblioteca.controller;

import biblioteca.model.Usuario;
import java.sql.SQLException;

public class CadastrarUsuarioController {
    
    //envia solicitação de cadastro de usuário
    public static boolean cadastrarUsuario (String nome, String rg, String cpf, String telefone, String rua,
                                           String numero, String bairro, String cidade, String data, 
                                           String estado, String cep) throws SQLException {
        Usuario u = new Usuario (nome, rg, cpf, telefone, rua, numero, bairro, cidade, data, estado, cep);
        return u.persistir();
    }

}
