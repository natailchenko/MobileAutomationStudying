import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiDemoTest {
    public static void main(String[] args) {
        DesiredCapabilities desiredCapabilities  = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Xiaomi- Redmi Note 5");
        desiredCapabilities.setCapability ("platformVersion", "8.1");
        desiredCapabilities.setCapability("app", new File("C:/Users/nilch/IdeaProjects/demos/.idea/app/ApiDemos-debug.apk"));

        AppiumDriver driver = null;
        try {
             driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        System.out.println(driver.getPageSource());


    }

}
