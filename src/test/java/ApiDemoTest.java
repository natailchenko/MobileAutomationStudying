import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

public class ApiDemoTest {
    private static Object Driver;

    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities desiredCapabilities  = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Xiaomi- Redmi Note 5");
        desiredCapabilities.setCapability ("platformVersion", "8.1");
        desiredCapabilities.setCapability ("newCommandTimeout", "300000");
        desiredCapabilities.setCapability("app", new File("C:/Users/nilch/IdeaProjects/demos/.idea/app/ApiDemos-debug.apk"));

        AppiumDriver driver = null;
        try {
             driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        System.out.println(driver.getPageSource());

        //step 0 - Run app


       // driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc=\"API Demos\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility\")]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility Node Querying\")]")).click();
        List<MobileElement> list= driver.findElements(By.className("android.widget.CheckBox"));
        list.get(0).click();
        driver.navigate().back();

//        private static void ANP{
//            driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility Node Querying\")]")).click();
//
//        }




}}
