//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//
//public class ApiDemoTest {
//    private static Object Driver;
//
//    public static void main(String[] args) throws InterruptedException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "Nexus 6 API 27");
//        desiredCapabilities.setCapability("platformVersion", "8.1");
//        desiredCapabilities.setCapability("newCommandTimeout", "300000");
//        desiredCapabilities.setCapability("app", new File("C:/Users/nilch/IdeaProjects/demos/.idea/app/ApiDemos-debug.apk"));
//
//        //1. Run app
//        AppiumDriver driver = null;
//        try {
//            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//
//        }
//        System.out.println(driver.getPageSource());
//
//
//        //2.Find and click on ‘Accessibility’ element
//        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility\")]")).click();
//        Thread.sleep(3000);
//
//        //3. Find and click on ‘Node querying’
//        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility Node Querying\")]")).click();
//
//        // 4. Find and click on first check-box
//        List<MobileElement> list = driver.findElements(By.className("android.widget.CheckBox"));
//        list.get(0).click();
//        final String checked1 = list.get(0).getAttribute("checked");
//        if (checked1.equals("false") ) {
//            System.out.println("Check-box is unchecked");
//        }
//        // 5. Go back
//        driver.navigate().back();
//
//        //6. Repeat step 3
//        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility Node Querying\")]")).click();
//
//        //7. Assert that state of check-box is not the same as in step 4
//        list.get(0);
//        final String checked2 = list.get(0).getAttribute("checked");
//        if (checked2.equals("false") ) {
//            System.out.println("Check-box is still unchecked");
//        } if (checked2.equals("true") ) {
//            System.out.println("ooops Check-box is checked");
//        }
//        else {
//            System.out.println("something wet wrong");
//        }
//
//        //open main page
//        driver.navigate().back();
//        driver.navigate().back();
//
//        // test case 2
//        // 1. open Media
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Media']")).click();
//        //2. open Media Player
//        driver.findElement(By.id("MediaPlayer")).click();
//        //3. OPEN "Play aoudio from Resources"
//        driver.findElement(By.id("io.appium.android.apis:id/resourcesaudio")).click();
//        //
//
//
//
//
//
//    }
//
//  //  private final Wait wait = new Wait(driver).withMessage("Element was not found").withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
//}
