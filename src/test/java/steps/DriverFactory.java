package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void startAppiumServer() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5556")
                .setPlatformName("Android")
                .setPlatformVersion("12.0")
                .setApp("/Users/viktorijagolovinova/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk")
                .setAutomationName("UiAutomator2")
                .setDeviceName("Android Emulator")
                .setAvdReadyTimeout(Duration.ofSeconds(5))
                .setAvdLaunchTimeout(Duration.ofSeconds(5))
                .eventTimings();

        System.out.println("Initializing Appium driver...");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void stopAppiumServer() {
        if (driver != null) {
            driver.quit();
        }
    }
}
