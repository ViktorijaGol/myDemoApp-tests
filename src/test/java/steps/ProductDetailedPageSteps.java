package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.assertTrue;

public class ProductDetailedPageSteps {
    private final AppiumDriver driver;
    public ProductDetailedPageSteps() {this.driver = DriverFactory.getDriver(); }

    @And("User can see product's image")
    public void userCanSeeProductSImage() {
        WebElement photo = driver.findElements(AppiumBy.className("android.widget.ImageView")).get(4);
        assertTrue(photo.isDisplayed());
    }

    @And("User can see product's color options")
    public void userCanSeeProductSColorOptions() {
        WebElement color = driver.findElement(
                AppiumBy.androidUIAutomator("descriptionContains(\"circle\")"));
        assertTrue(color.isDisplayed());
    }

    @Then("User can see product's {string}")
    public void userCanSeeProductS(String detail) {
        assertTrue(driver.findElement(AppiumBy.accessibilityId(detail)).isDisplayed());
    }

    @And("User selects the color {string}")
    public void userSelectsTheColor(String color) {
        WebElement selectedColor = driver.findElement(
                AppiumBy.androidUIAutomator("descriptionContains(\"" + color + " circle\")"));
        selectedColor.click();
    }

    @Then("The product is added to the cart")
    public void theProductIsAddedToTheCart() {
        driver.findElement(AppiumBy.accessibilityId("cart badge")).click();
        WebElement checkoutButton = driver.findElement(AppiumBy.accessibilityId("Proceed To Checkout button"));
        assertTrue(checkoutButton.isDisplayed());
    }

    @And("The cart badge displays the total count of items in the cart")
    public void theCartBadgeDisplaysTheTotalCountOfItemsInTheCart() {
        WebElement cartBadge = driver.findElement(
                AppiumBy.xpath("(//android.widget.TextView[@text=\"2\"])[1]"));
        assertTrue(cartBadge.isDisplayed());
    }
}
