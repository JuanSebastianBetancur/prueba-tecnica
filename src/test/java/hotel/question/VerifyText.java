package hotel.question;


import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyText implements Question<Boolean> {

    private final String expectedMessage;
    private final Target target;

    public VerifyText(Target id, String expectedMessage) {
        this.target = id;
        this.expectedMessage = expectedMessage;
    }

    public static VerifyText is(Target id, String expectedMessage) {
        return new VerifyText(id, expectedMessage);
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        String actualMessage = Text.of(target).answeredBy(actor);
        return actualMessage.equals(expectedMessage);
    }
}
