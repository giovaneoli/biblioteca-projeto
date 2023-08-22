package biblioteca.controller;
import biblioteca.model.Login;

public class TelaLoginController {
    
    //solicita validação de acesso ao sistema
    public static boolean validarAcesso (String usuario, String senha) {
        Login l = new Login ();
        return l.acessar(usuario, senha);
    }
}
