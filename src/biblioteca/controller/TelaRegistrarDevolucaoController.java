package biblioteca.controller;

import biblioteca.model.Emprestimo;
import java.util.ArrayList;


public class TelaRegistrarDevolucaoController {

    //Solicitados dados do empréstimo
    public static ArrayList<String> dadosEmprestimo(String id) {
        Emprestimo e = new Emprestimo (id);
        return e.recuperarDados();
    }

    //Registra devolução de empréstimo
    public static boolean registrarDevolucao(String id) {
        Emprestimo e = new Emprestimo (id);
        return e.registrarDevolucao();
    }

    //envia dados para bloqueio de usuário
    public static boolean bloquearUsuario(String id, String idUsuario, String totalMulta, String descricaoMulta) {
        Emprestimo e = new Emprestimo (id);
        return e.bloquearUsuario(idUsuario, totalMulta, descricaoMulta);
    }
    
    //envia dados para bloqueio de usuário
    public static boolean bloquearUsuario(String id, String idUsuario, Double valDevedor, String descricaoMulta) {
        Emprestimo e = new Emprestimo (id);
        String totalMulta = valDevedor.toString();
        return e.bloquearUsuario(idUsuario, totalMulta, descricaoMulta);
    }
    
}
