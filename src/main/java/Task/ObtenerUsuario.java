package Task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerUsuario implements Task {
    private final int id;

    public ObtenerUsuario(int id) {
        this.id = id;
    }

    public static ObtenerUsuario obtenerUsuarios(int id){
        return instrumented(ObtenerUsuario.class,id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users/" + id)
        );
    }
}
