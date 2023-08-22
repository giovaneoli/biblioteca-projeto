package biblioteca.controller;

import biblioteca.model.Usuario;
import java.util.ArrayList;

public class TelaDesbloquearUsuarioController {

    //Envia dados para bloqueio de usuário
    public static ArrayList<String> dadosBloqueio(String id) {
        Usuario u = new Usuario();
        return u.dadosBloqueio(id);
    }
    
    //Envia dados para desbloqueio de usuário
    public static boolean desbloquear(String id) {
        Usuario u = new Usuario(id);
        return u.desbloquear();
    }

    //envia dados de pagamento parcial de multa
    public static boolean pagamentoParcial(String id, Double valorAtualizado) {
        Usuario u = new Usuario(id);
        return u.pagamentoParcial(valorAtualizado);
    }
    
}
