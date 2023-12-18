package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.*;

public class SortBySteps {
    private final AppiumDriver driver;
    public SortBySteps() {this.driver = DriverFactory.getDriver(); }

    @Then("First product title is {string}")
    public void firstProductTitleIs(String title) {
        String firstProduct = driver.findElement(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).getText();
        assertEquals(title, firstProduct);
    }
}
