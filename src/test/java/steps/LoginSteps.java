package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class LoginSteps {
    private final AppiumDriver driver;
    public LoginSteps() {this.driver = DriverFactory.getDriver(); }

    @And("User clicks {string} button")
    public void userClicksLoginButton(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).click();
    }

    @Given("User is on {string} page")
    public void userIsOnPage(String page) {
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        WebElement menuItem = driver.findElement(AppiumBy.androidUIAutomator("text(\""+page+"\")"));
        assertEquals(page, menuItem.getText());
        menuItem.click();
    }
}
