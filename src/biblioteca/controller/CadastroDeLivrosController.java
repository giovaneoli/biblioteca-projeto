package biblioteca.controller;

import biblioteca.model.Livro;
import java.sql.SQLException;

public class CadastroDeLivrosController {
    
    //envia solicitação de cadastro de livro
    public static boolean cadastroDeLivros(String titulo, String autor, String editora, String quantidade) throws SQLException {
        Livro l = new Livro(titulo, autor, editora, quantidade);
        return l.persistir();
    }
    
}
