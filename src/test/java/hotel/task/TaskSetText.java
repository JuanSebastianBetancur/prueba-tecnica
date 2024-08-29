package hotel.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class TaskSetText implements Task {
    private final Target target;
    private final String value;

    public TaskSetText(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static TaskSetText set(Target target, String value) {
        return new TaskSetText(target, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
        actor.attemptsTo(SendKeys.of(Keys.BACK_SPACE).into(target));
        actor.attemptsTo(Enter.theValue(value).into(target));
        actor.attemptsTo(SendKeys.of(Keys.ENTER).into(target));
    }
}
