package Task;

import Models.Usuarios.POST.UsuarioRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearUsuarioTask implements Task {
    private final String nombre;
    private final String apellido;


    public CrearUsuarioTask(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static CrearUsuarioTask crearUsuario(String nombre,String apellido){
        return instrumented(CrearUsuarioTask.class,nombre,apellido);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UsuarioRequest users = new UsuarioRequest(nombre,apellido);
        actor.attemptsTo(
                Post.to("/posts").with(req-> req.header("Content-Type", "application/json")
                        .body(users))
        );
    }
}
