package hotel.task;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;

public class SetTrackbarValue implements Task{
    private final int value;

    public SetTrackbarValue(int value) {
        this.value = value;
    }

    public static SetTrackbarValue set(int value) {
        return new SetTrackbarValue(value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement trackbarElement = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_MD"))
            );

            // Simular el arrastre del slider
            Actions actions = new Actions(driver);
            actions.clickAndHold(trackbarElement)
                    .moveByOffset(value, 0) // xOffset indica la cantidad de píxeles a mover horizontalmente
                    .release()
                    .perform();

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            String script = "arguments[0].style.left = '" + value + "px';";
//            js.executeScript(script, trackbarElement);
//
//            // Disparar el evento de cambio para actualizar el valor
//            String eventScript =
//                    "var event = new Event('input', { bubbles: true });" +
//                            "arguments[0].dispatchEvent(event);";
//            js.executeScript(eventScript, trackbarElement);
        } catch (Exception e) {
            System.err.println("ESTE ERROR: " + e.getLocalizedMessage());
        }

    }
}
