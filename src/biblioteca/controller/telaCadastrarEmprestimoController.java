package biblioteca.controller;

import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import java.util.ArrayList;

public class telaCadastrarEmprestimoController {

    //Solicita busca por usuário
    public static ArrayList<String> buscaUsuarios(String texto) {
       Usuario u = new Usuario ();
       return u.buscarUsuario(texto);
    }
    
    //Solicita busca por livro
    public static ArrayList<String> buscaLivros(String texto) {
       Livro l = new Livro ();
       return l.buscarLivro(texto);
    }
    
    //Envia dados para registro de empréstimo
    public static boolean registrar(String idLivro, String idUsuario, String dataEmprestimo, String dataDevolucao) {
         Emprestimo e = new Emprestimo (idLivro, idUsuario, dataEmprestimo, dataDevolucao);
         return e.persistir();
    }
    
}
