package biblioteca.controller;

import biblioteca.model.Emprestimo;
import java.util.ArrayList;

public class TelaEmprestimosController {

    //Solicita lista de empréstimos
    public static ArrayList<String> selectEmprestimos() {
        Emprestimo e = new Emprestimo ();
        return e.listarEmprestimos();
    }
    
}
