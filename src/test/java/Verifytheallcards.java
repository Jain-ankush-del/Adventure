import Pageobject.Landingpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Verifytheallcards extends base {
    public WebDriver driver;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = inilizationdriver();
        log.info("Browser is open");
        driver.get(prop.getProperty("url"));
        log.info("Navigate to url");

        Thread.sleep(2000);
    }


    @Test
    public void verifyallcards() throws InterruptedException {
        Landingpage la = new Landingpage(driver);
        List<WebElement> actual = la.getlatestgamesrelease();
        log.info(actual.size());

        if(actual.size()==9) {
          System.out.println("Cards are matched");
        }else {
            System.out.println("Expected 9 cards, but found"  + actual.size());
        }
        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("window.scrollBy(0,8000)");

        List<WebElement> cards = la.getlatestscreenshot();
        log.info(cards.size());

        if(cards.size()==15) {
            System.out.println("Cards are matched");
        }else {
            System.out.println("Expected 15 cards, but found"  + actual.size());
        }

        Thread.sleep(3000);
        Actions action = new Actions(driver);
        la.Clickonsearchicon().click();
        la.Clickonsearchfield().click();
        la.Clickonsearchfield().sendKeys("test");
        action.sendKeys(Keys.ENTER).perform();
        String actualurl = driver.getCurrentUrl();
        if(actualurl.equals("https://weisetech.dev/adventuregamers/?s=test")) {
            System.out.println("Url is matched");
        }else
        {
            System.out.println("Url is not matched" +actualurl);
        }


    }
    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");

    }



}
