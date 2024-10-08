package hotel.task;

import hotel.ui.Reservation;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class TaskSelectHotelWithLowestPrice implements Task {

    public TaskSelectHotelWithLowestPrice() {
    }

    public static TaskSelectHotelWithLowestPrice set() {
        return new TaskSelectHotelWithLowestPrice();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();

        // Obtener todos los elementos que contienen precios
        ListOfWebElementFacades priceElements = Reservation.PRICE_LOCATOR.resolveAllFor(actor);

        double minPrice = Double.MAX_VALUE;
        WebElement minPriceElement = null;

        for (WebElement priceElement : priceElements) {
            // Obtener el texto del precio y convertirlo a un número
            String priceText = priceElement.getText().replace("$", "").replace(",", "");
            System.out.println("PRICE: " + priceText);
            double price = Double.parseDouble(priceText);

            // Verificar si este es el precio más bajo encontrado
            if (price < minPrice) {
                minPrice = price;
                minPriceElement = priceElement;
            }
        }

        // Hacer clic en el botón de "Book It" correspondiente al precio más bajo
        if (minPriceElement != null) {
            WebElement bookItButton = minPriceElement.findElement(By.xpath("./ancestor::tr//div[contains(@id, 'MainContentPlaceHolder_HotelsDataView_IT2_BookItButton_2_CD')]"));
            bookItButton.click();
        }
    }
}
