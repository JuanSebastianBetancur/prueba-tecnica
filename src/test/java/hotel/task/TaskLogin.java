package hotel.task;

import hotel.ui.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TaskLogin implements Task {

    private final String email;
    private final String password;

    public TaskLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static TaskLogin login(String email, String password) {
        return new TaskLogin(email, password);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        theActorInTheSpotlight().attemptsTo(Click.on(Login.FIELD_EMAIL_PARENT));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(email).into(Login.FIELD_EMAIL));
        theActorInTheSpotlight().attemptsTo(Click.on(Login.FIELD_PASSWORD_PARENT));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(Login.FIELD_PASSWORD));
    }
}
