package biblioteca.controller;

import biblioteca.model.Livro;
import java.util.ArrayList;

public class TelaLivrosCadastradosController {

    //solicita lista de livros cadastrados
    public static ArrayList<String> selectLivros() {
        Livro l = new Livro();
        return l.listarLivros();
    }

    //solicita exclusão de livro
    public static boolean deleteLivros(String id) {
        Livro l = new Livro();
        return l.deletar(id);
    }
    
}
