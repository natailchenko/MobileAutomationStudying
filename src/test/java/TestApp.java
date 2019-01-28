import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.OutputType.FILE;

public class TestApp {
    AppiumDriver driver = null;
    String destDir;
    DateFormat dateFormat;

    @BeforeMethod
    public void setUp() throws InterruptedException {
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

    @Test
    public void testCase1() {

        //2.Find and click on ‘Accessibility’ element
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility\")]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //3. Find and click on ‘Node querying’
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility Node Querying\")]")).click();

        // 4. Find and click on first check-box
        List<MobileElement> list = driver.findElements(By.className("android.widget.CheckBox"));
        list.get(0).click();
        final String checked1 = list.get(0).getAttribute("checked");
        if (checked1.equals("false")) {
            System.out.println("Check-box is unchecked");
        }
        // 5. Go back
        driver.navigate().back();

        //6. Repeat step 3
        driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc,\"Accessibility Node Querying\")]")).click();

        //7. Assert that state of check-box is not the same as in step 4
        list.get(0);
        final String checked2 = list.get(0).getAttribute("checked");
        if (checked2.equals("false")) {
            System.out.println("Check-box is still unchecked");
        }
        if (checked2.equals("true")) {
            System.out.println("ooops Check-box is checked");
        } else {
            System.out.println("something wet wrong");
        }


        //open main page (не знала как веркуться на стартовую страницу? или стопнуть драйвер и новый тест начать с нового класса?
        driver.navigate().back();
        driver.navigate().back();

    }

    @Test
    public void testCase2() throws IOException {
        //  1. open Media
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Media']")).click();
        //2. open Media Player
        driver.findElement(By.id("MediaPlayer")).click();
        //3. OPEN "Play audio from Resources"
        driver.findElement(By.id("io.appium.android.apis:id/resourcesaudio")).click();
//        //4. Check "Plying audio" is shown
        WebElement mediaPlayer = driver.findElement(By.className("android.widget.FrameLayout"));

        //ДОБАВИть ВЕЙТЕР
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        takeScreenShot();


        WebElement audioText = driver.findElement(By.xpath("//android.widget.TextView [contains(@text,'Playing audio...')]"));
// не придумала как можно проверить что звук появился
//       if (audioText.equals("Playing audio...")) {
//           System.out.println("text 'Playing audio...' is shown");
//      } else {
//           System.out.println("ШОТО НЕ ТО=(");
//       }

    }

    public void takeScreenShot() {
        // Set folder name to store screenshots.
        destDir = "screenshots";
        // Capture screenshot.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Set date format to set It as screenshot file name.
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // Create folder under project with name "screenshots" provided to destDir.
        new File(destDir).mkdirs();
        // Set file name using current date time.
        String destFile = dateFormat.format(new Date()) + ".png";

        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void End() {
        driver.quit();
    }

}


