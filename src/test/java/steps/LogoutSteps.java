package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LogoutSteps {
    private final AppiumDriver driver;
    public LogoutSteps() {this.driver = DriverFactory.getDriver(); }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String button) {
        driver.findElement(AppiumBy.androidUIAutomator("text(\""+button+"\")")).click();
    }

    @Then("User is redirected to {string} page")
    public void userIsRedirectedToPage(String page) {
        WebElement pageName = driver.findElement(AppiumBy.androidUIAutomator("text(\""+page+"\")"));
        assertEquals(page, pageName.getText());
    }

    @Then("User is still logged in")
    public void userIsStillLoggedIn() {
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        assertEquals("No Items",
                driver.findElement(AppiumBy.androidUIAutomator("text(\"No Items\")")).getText());
    }
}
