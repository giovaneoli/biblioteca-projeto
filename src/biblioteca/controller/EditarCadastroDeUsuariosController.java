package biblioteca.controller;

import biblioteca.model.Usuario;
import java.util.ArrayList;

public class EditarCadastroDeUsuariosController {

    //Envia dados de usuário para edição
    public static boolean editarDados(String id, String nome, String rg, String cpf, 
            String telefone, String rua, String numero, String bairro, String cidade, 
            String dataNascimento, String estado, String cep) {
     
        Usuario u = new Usuario (id, nome, rg, cpf, telefone, rua, numero, bairro, 
                cidade, dataNascimento, estado, cep);
        return u.update();
    }
    
    //solicita dados do usuário
    public static ArrayList<String> dadosUsuario(String id) {
        Usuario u = new Usuario (id);
        return u.recuperarDados();
    }


    
}
