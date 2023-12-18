package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;


public class CheckoutSteps {
    private final AppiumDriver driver;

    public CheckoutSteps() {
        this.driver = DriverFactory.getDriver();
    }

    @And("User has some products in the cart")
    public void userHasSomeProductsInTheCart() {
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        WebElement menuItem = driver.findElement(AppiumBy.androidUIAutomator("text(\"Catalog\")"));
        menuItem.click();
        driver.findElements(AppiumBy.androidUIAutomator("description(\"store item\")")).get(2).click();
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
    }

    @And("User is on the {string} page")
    public void userIsOnThePage(String pageName) {
        driver.findElement(AppiumBy.accessibilityId("cart badge")).click();
        WebElement pageTitle = driver.findElement(AppiumBy.androidUIAutomator("text(\"" + pageName + "\")"));
        assertEquals(pageName, pageTitle.getText());
    }

    @When("User fills {string} input field with {string}")
    public void userFillsInputFieldWith(String inputField, String information) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "descriptionContains(\"" + inputField + " input field\")")).sendKeys(information);
    }

    @When("User checks that his {string} contains {string}")
    public void userChecksThatHisContains(String orderInfo, String information) {
        String xpathExpression =
                "//android.view.ViewGroup[@content-desc='" + orderInfo + "']" +
                        "/android.widget.TextView[contains(@text, '" + information + "')]";
        WebElement pageTitle = driver.findElement(AppiumBy.xpath(xpathExpression));
        assertEquals(information, pageTitle.getText());
    }
}

