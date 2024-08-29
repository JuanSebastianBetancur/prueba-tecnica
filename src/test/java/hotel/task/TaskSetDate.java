package hotel.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TaskSetDate implements Task {
    private final Target target;
    private final int daysFromToday;

    public TaskSetDate(Target target, int daysFromToday) {
        this.target = target;
        this.daysFromToday = daysFromToday;
    }

    public static TaskSetDate set(Target target, int daysFromToday) {
        return new TaskSetDate(target, daysFromToday);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        LocalDate date = LocalDate.now().plusDays(daysFromToday);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        String formattedDate = date.format(formatter);
        System.out.println("Fecha: " + formattedDate);
        theActorInTheSpotlight().attemptsTo(Click.on(target));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(formattedDate).into(target));
    }
}
