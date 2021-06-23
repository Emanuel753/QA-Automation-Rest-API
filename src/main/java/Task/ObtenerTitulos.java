package Task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerTitulos implements Task {
    private final int id;
    public ObtenerTitulos(int id) {
        this.id = id;
    }

    public static ObtenerTitulos obtenerDatos(int id){
        return instrumented(ObtenerTitulos.class,id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/todos/" + id)
        );
    }
}
