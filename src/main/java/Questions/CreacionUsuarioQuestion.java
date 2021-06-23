package Questions;

import Models.Usuarios.POST.UsuarioResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class CreacionUsuarioQuestion {

    public static Question<Integer> validarCreacion(){
        UsuarioResponse userResp = SerenityRest.lastResponse().jsonPath().getObject("",UsuarioResponse.class);

        return res-> userResp.getId();
    }
}
