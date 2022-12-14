package src.lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    private static String appiumUrl = "http://127.0.0.1:4723/wd/hub";
    protected AppiumDriver driver;

    protected void setUp() throws Exception {

        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Pavel_data\\STUDY\\JavaAppiumAutomation\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.rotateScreenPortrait();

    }

    @Override
    protected void tearDown() throws Exception {

        driver.quit();
        super.tearDown();
    }


    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);

    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);

    }




}
