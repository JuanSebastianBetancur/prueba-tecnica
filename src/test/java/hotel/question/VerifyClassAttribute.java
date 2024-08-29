package hotel.question;


import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyClassAttribute implements Question<Boolean> {

    private final String expectedClass;
    private final Target target;

    public VerifyClassAttribute(Target id, String expectedClass) {
        this.target = id;
        this.expectedClass = expectedClass;
    }

    public static VerifyClassAttribute is(Target id, String expectedClass) {
        return new VerifyClassAttribute(id, expectedClass);
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        String classAttribute = Attribute.of(target).named("class").answeredBy(actor);
        return classAttribute.contains(expectedClass);
    }
}
