package hotel.stepDefinitions;

import hotel.question.VerifyText;
import hotel.task.*;
import hotel.ui.Reservation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefsReservation {
    @Given("the {actor} is on the hotel booking page")
    public void theUserIsOnTheLoginPage(Actor actor) {
        actor.attemptsTo(TaskOpenPage.withUrl("https://demos.devexpress.com/rwa/dxhotels/"));
    }

    @When("the user selects {string} on location field")
    public void theUserSelectsOnLocationField(String location) {
        theActorInTheSpotlight().attemptsTo(TaskSetText.set(Reservation.FIELD_LOCATION, location));
    }

    @When("the user selects the check-in date {int} days from today")
    public void theUserSelectsTheCheckInDateDaysFromToday(int daysFromToday) {
        theActorInTheSpotlight().attemptsTo(TaskSetDate.set(Reservation.FIELD_CHECK_IN, daysFromToday));
    }

    @And("the user selects the check-out date {int} days from today")
    public void theUserSelectsTheCheckOutDateDaysFromToday(int daysFromToday) {
        theActorInTheSpotlight().attemptsTo(TaskSetDate.set(Reservation.FIELD_CHECK_OUT, daysFromToday));
    }

    @And("the user selects {string} rooms")
    public void theUserSelectsRooms(String totalRooms) {
        theActorInTheSpotlight().attemptsTo(TaskSetText.set(Reservation.FIELD_ROOMS, totalRooms));
    }

    @And("the user selects {string} adults")
    public void theUserSelectsAdults(String totalAdults) {
        theActorInTheSpotlight().attemptsTo(TaskSetText.set(Reservation.FIELD_ADULTS, totalAdults));
    }

    @And("the user selects {string} children")
    public void theUserSelectsChildren(String totalChildren) {
        theActorInTheSpotlight().attemptsTo(TaskSetText.set(Reservation.FIELD_CHILDRENS, totalChildren));
    }

    @And("the user press the button search")
    public void theUserPressTheButtonSearch() {
        theActorInTheSpotlight().attemptsTo(TaskClick.set(Reservation.BUTTON_SEARCH_RESERVATION));
    }

    @And("the user selects a price range above {string} USD")
    public void theUserSelectsAPriceRangeAboveUSD(String priceRange) {
        theActorInTheSpotlight().attemptsTo(SetTrackbarValue.set(18));
    }

    @And("the user selects 3 stars rating or more")
    public void theUserSelectsAStarRatingOfOrMore() {
        theActorInTheSpotlight().attemptsTo(TaskClick.set(Reservation.CHECK_STAR_1));
        theActorInTheSpotlight().attemptsTo(TaskClick.set(Reservation.CHECK_STAR_2));
    }

    @And("the user applies the selected filters")
    public void theUserAppliesTheSelectedFilters() {
        theActorInTheSpotlight().attemptsTo(TaskClick.set(Reservation.BUTTON_APPLY_FILTERS));
    }

    @And("the user selects the cheapest hotel that meets the filters")
    public void theUserSelectsTheCheapestHotelThatMeetsTheFilters() {
        theActorInTheSpotlight().attemptsTo(TaskSelectHotelWithLowestPrice.set());
    }

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String message) {
        theActorInTheSpotlight().attemptsTo( Ensure.that(VerifyText.is(Reservation.FIELD_RESERVATION_CONFIRMS, message)).isTrue());
    }
}
