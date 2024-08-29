package hotel.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class TaskClick implements Task {
    private final Target target;

    public TaskClick(Target target) {
        this.target = target;
    }

    public static TaskClick set(Target target) {
        return new TaskClick(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
    }
}
