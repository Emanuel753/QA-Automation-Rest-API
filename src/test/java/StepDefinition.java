
import Questions.CreacionUsuarioQuestion;
import Questions.TitulosQuestion;
import Questions.UsuariosQuestion;
import Task.CrearUsuarioTask;
import Task.ObtenerTitulos;
import Task.ObtenerUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.core.IsEqual;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class StepDefinition {
    Actor Ema = Actor.named("Emanuel");


    @Dado("el servicio rest")
    public void el_servicio_rest() {
        Ema.whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com"));
    }

    @Cuando("se realiza una peticion GET (.*)")
    public void se_realiza_una_peticion_GET(int id) {
        Ema.attemptsTo(ObtenerTitulos.obtenerDatos(id));
    }

    @Entonces("Se obtine resultado (.*) (.*)")
    public void se_obtine_resultado(int status,int id) {
        Ema.should(
                seeThatResponse("valido el status del servicio",res->res.statusCode(200)),
                GivenWhenThen.seeThat("valido el status del servicio, otra forma de validar el status",get->SerenityRest.lastResponse().statusCode(),IsEqual.equalTo(status)),
                GivenWhenThen.seeThat("Valido el titulo obtenido", TitulosQuestion.ObtenerTitulo(), IsEqual.equalTo(id))
        );

    }

    @Cuando("consulto los usuarios (.*)")
    public void consulto_los_usuarios(int id){
        Ema.attemptsTo(ObtenerUsuario.obtenerUsuarios(id));

    }
    @Entonces("Se valida resultado de usuarios status (.*) nombre (.*)")
    public void Se_valida_resultado_de_usuarios_status_nombre(int status,String company) {


        Ema.should(
                GivenWhenThen.seeThat("Valido el status del servicio",get->SerenityRest.lastResponse().statusCode(),IsEqual.equalTo(status)),
                GivenWhenThen.seeThat("Valido el nombre del usuario", UsuariosQuestion.validarUsuario(),IsEqual.equalTo(company))
        );
    }

    //POST
    @Cuando("creo el nuevo usuario con nombre (.*) y apellido (.*)")
    public void creo_el_nuevo_usuario(String nombre,String apellido) {
        Ema.attemptsTo(
                CrearUsuarioTask.crearUsuario(nombre, apellido)
        );
    }

    @Entonces("Valido la creacion exitosa")
    public void valido_la_creacion_exitosa() {
        Ema.should(
                seeThatResponse("valido el status code",res->res.statusCode(201)),
                GivenWhenThen.seeThat("valido el resultado del body", CreacionUsuarioQuestion.validarCreacion(),IsEqual.equalTo(101))
        );
    }

}
