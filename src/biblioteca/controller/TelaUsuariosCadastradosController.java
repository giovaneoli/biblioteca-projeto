package biblioteca.controller;

import biblioteca.model.Usuario;
import java.util.ArrayList;

public class TelaUsuariosCadastradosController {

    //solicita lista de usuários
    public static ArrayList<String> selectUsuarios() {
        Usuario u = new Usuario ();
        return u.listarUsuarios();
    }

    //Solicita exclusão de cadastro de usuário
    public static boolean deleteUsuario(String id) {
    Usuario uzi = new Usuario ();
    return uzi.deletar(id);
    }

}
