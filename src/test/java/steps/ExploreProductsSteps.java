package steps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class ExploreProductsSteps {
    private final AppiumDriver driver;
    public ExploreProductsSteps() {this.driver = DriverFactory.getDriver(); }

    @When("User clicks on a {int} rd product")
    public void userClicksOnARdProduct(int productNumber) {
        driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item\")")).get(productNumber).click();
    }

    @Then("User is navigated to the detailed product page")
    public void userIsNavigatedToTheDetailedProductPage() {
        assertTrue(driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).isDisplayed());
    }

    @When("User clicks on the {int} star next to a {int} rd product")
    public void userClicksOnTheStarNextToARdProduct(int starNumber, int productNumber) {
        WebElement chosenElementStar = driver.findElement(AppiumBy.xpath(
                "(//android.view.ViewGroup" +
                        "[@content-desc=\"review star "+starNumber+"\"])["+productNumber+"]"));
        chosenElementStar.click();
    }

    @Then("User can see product {int} and it's photo, title, price")
    public void userCanSeeProductProductNumberAndItSPhotoTitlePrice(int productNumber) {
        WebElement product = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item\")")).get(productNumber);
        assertTrue(product.isDisplayed());
        WebElement photo = driver.findElement(AppiumBy.xpath(
                "(//android.view.ViewGroup[@content-desc=\"store item\"])["+productNumber+"]" +
                        "/android.view.ViewGroup[1]/android.widget.ImageView"));
        assertTrue(photo.isDisplayed());
        WebElement title = driver.findElement(AppiumBy.xpath(
                "(//android.view.ViewGroup[@content-desc=\"store item\"])["+productNumber+"]" +
                        "/android.view.ViewGroup[1]//android.widget.TextView"));
        assertTrue(title.isDisplayed());
        WebElement price = driver.findElement(AppiumBy.xpath(
                "(//android.view.ViewGroup[@content-desc=\"store item\"])["+productNumber+"]" +
                        "/android.widget.TextView[@content-desc=\"store item price\"]"));
        assertTrue(price.isDisplayed());
    }

    @When("User scrolls down the page")
    public void userScrollsDownThePage() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 404,
                "top", 400,
                "width", 100,
                "height", 800,
                "direction", "down",
                "percent", 1.0,
                "speed", 1000
        ));
    }

    @Then("User sees message {string}")
    public void userSeesMessage(String message) {
        String errorMessage = driver.findElement(
                AppiumBy.androidUIAutomator("text(\""+message+"\")")).getText();
        assertEquals(errorMessage, message);
    }
}
