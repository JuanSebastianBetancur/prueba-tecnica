package hotel.task;

import hotel.ui.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TaskSetCaptcha implements Task {

    private final String captcha;

    public TaskSetCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public static TaskSetCaptcha set(String captcha) {
        return new TaskSetCaptcha(captcha);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        theActorInTheSpotlight().attemptsTo(Click.on(Login.FIELD_CAPTCHA));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(captcha).into(Login.FIELD_CAPTCHA));
    }
}
