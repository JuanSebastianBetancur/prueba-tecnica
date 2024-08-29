package hotel.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import hotel.question.VerifyClassAttribute;
import hotel.question.VerifyText;
import hotel.task.TaskLogin;
import hotel.task.TaskSetCaptcha;
import hotel.task.TaskOpenPage;
import hotel.ui.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefsLogin {
    @Given("the {actor} is on the login page")
    public void theUserIsOnTheLoginPage(Actor actor) {
        actor.attemptsTo(TaskOpenPage.withUrl("https://demos.devexpress.com/rwa/dxhotels/"));
        actor.attemptsTo(Click.on(Login.BUTTON_LOGIN));
    }

    @When("the user attempts to log in with an empty email and a valid {string}")
    public void theUserAttemptsToLogInWithAnEmptyEmailAndAValidPassword(String password) {
        theActorInTheSpotlight().attemptsTo(TaskLogin.login("",password));
    }

    @And("the user press the button summit")
    public void theUserPressTheButtonSummit() {
        theActorInTheSpotlight().attemptsTo(Click.on(Login.BUTTON_SUMMIT));
    }

    @Then("the user should see an email field with red border")
    public void theUserShouldSeeAnUsernameFieldWithRedBorder() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(VerifyClassAttribute.is(Login.FIELD_EMAIL_PARENT, "dxeErrorFrameWithoutError_Metropolis")).isTrue()
        );
    }

    @When("the user attempts to log in with an empty password and a valid {string}")
    public void theUserAttemptsToLogInWithAnEmptyPasswordAndAValidEmail(String email) {
        theActorInTheSpotlight().attemptsTo(TaskLogin.login(email,""));
    }

    @Then("the user should see a password field with red border")
    public void theUserShouldSeeAPasswordFieldWithRedBorder() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(VerifyClassAttribute.is(Login.FIELD_PASSWORD_PARENT, "dxeErrorFrameWithoutError_Metropolis")).isTrue()
        );
    }

    @When("the user attempts to log in with an valid email {string} and password {string}")
    public void theUserAttemptsToLogInWithAnValidEmailAndPassword(String email, String password) {
        theActorInTheSpotlight().attemptsTo(TaskLogin.login(email,password));
    }

    @And("the user enters a wrong {string}")
    public void theUserEntersAWrongCatpcha(String captcha) {
        theActorInTheSpotlight().attemptsTo(TaskSetCaptcha.set(captcha));
    }

    @Then("the user should see an error message captcha")
    public void theUserShouldSeeAnErrorMessageCaptcha() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(VerifyText.is(Login.FIELD_CAPTCHA_NOTIFICATION, "The submitted code is incorrect")).isTrue()
        );
    }
}
