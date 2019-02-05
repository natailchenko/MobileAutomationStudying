package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    protected static AppiumDriver<MobileElement> driver;

    @BeforeSuite(alwaysRun = true)
    public void setEnv() {
        System.out.println("I;m setting environment");

    }

    @BeforeTest(alwaysRun = true)
    public void initDataBase() {
        System.out.println("iticializing of the user");
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {
        //    Properties properties =System.getProperties(); properties: size=54
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Nexus 6 API 27");
        desiredCapabilities.setCapability("platformVersion", "8.1");
        desiredCapabilities.setCapability("newCommandTimeout", "300000");
        desiredCapabilities.setCapability("app", new File("C:/Users/nilch/IdeaProjects/demos/.idea/app/ApiDemos-debug.apk"));


        //1. Run app

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        System.out.println(driver.getPageSource());
    }

}
