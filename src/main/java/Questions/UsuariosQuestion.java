package Questions;

import Models.Usuarios.Usuarios;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class UsuariosQuestion {
    public static Question<String> validarUsuario(){
        Usuarios user = SerenityRest.lastResponse().jsonPath().getObject("",Usuarios.class);
        return actor -> user.getCompany().getName();
    }
}
