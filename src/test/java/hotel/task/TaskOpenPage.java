package hotel.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class TaskOpenPage implements Task {

    private final String url;


    public TaskOpenPage(String url) {
        this.url = url;
    }

    public static TaskOpenPage withUrl(String url) {
        return new TaskOpenPage(url);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Open.url(url));
    }
}
