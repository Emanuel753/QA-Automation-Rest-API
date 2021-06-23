package Questions;

import Models.libros.Libros;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class TitulosQuestion {

    public static Question<Integer> ObtenerTitulo(){
        Libros resp = SerenityRest.lastResponse().jsonPath().getObject("",Libros.class);
        return a-> resp.getId();
    }
}
