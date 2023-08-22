package biblioteca.controller;

import biblioteca.model.Livro;
import java.util.ArrayList;

public class EditarCadastroDeLivrosController {

    //solicita dados do cadastro de livro
    public static ArrayList<String> dadosLivro(String id) {
        Livro lvr = new Livro();
        return lvr.recuperarDados(id);
    }

    //envia as alterações nos dados do livro
    public static boolean editarDados(String id, String titulo, String autor, String editora, String quantidade) {
    Livro lvr = new Livro(id, titulo, autor, editora, quantidade);
    return lvr.update();
    }
    
}
