package biblioteca.controller;

import biblioteca.model.Emprestimo;
import java.util.ArrayList;

public class TelaRenovacaoEmprestimosController {

    //Solicita dados do empréstimo
    public static ArrayList<String> dadosEmprestimo(String id) {
        Emprestimo e = new Emprestimo(id);
        return e.dadosRenovar();
    }
    
    //grava renovação de empréstimo
    public static boolean gravarRenovacao(String idEmprestimo, String renovacaoNumero, String novaDataDevolucao) {
        Emprestimo e = new Emprestimo (idEmprestimo);
        return e.renovacao(renovacaoNumero, novaDataDevolucao);
    }
    
}
