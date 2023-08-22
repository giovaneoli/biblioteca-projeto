package biblioteca.controller;

import biblioteca.model.Senha;
import java.security.NoSuchAlgorithmException;

public class TelaAlterarSenhaController {
    
    //envia os dados para alteração
    public static boolean editarDados(String bibliotecario, char[] senhaAtual, char[] senhaNova) throws NoSuchAlgorithmException {
        Senha s = new Senha(bibliotecario, senhaAtual);
        return s.alterarSenha(senhaNova);
    }
    
    //envia pedido para conferência de alteração
    public static boolean conferirSenhaAtual(String bibliotecario, char[] senhaAtual) {
        Senha s = new Senha(bibliotecario, senhaAtual);
        return s.senhaCorreta(senhaAtual);
    }
    
}
