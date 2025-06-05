import Pageobject.Discoveradv;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Discoverpage extends base {

    public WebDriver driver;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    public static Logger log = LogManager.getLogger(base.class.getName());
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = inilizationdriver();
        log.info("Browser is open");
        driver.get(prop.getProperty("url"));
        log.info("Navigate to url");

        Thread.sleep(2000);
        extent.createTest("Browser is open");
    }

    @Test
    public void discover() throws InterruptedException {

        test = extent.createTest("Test discover pass", "Discover page text");

        Discoveradv ds = new Discoveradv(driver);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement dropdown = ds.getdropdown();
        Thread.sleep(3000);
        actions.moveToElement(dropdown).perform();
        Thread.sleep(5000);
        ds.getdiscoveradvanture().click();
        Thread.sleep(5000);
        WebElement dropdownelement =  ds.getgenerdropdown();
        Select dropdown1 = new Select(dropdownelement);
        dropdown1.selectByVisibleText("Action");
        Thread.sleep(2000);
        WebElement dropdownelement1 =  ds.getpresentataiondropdown();
        Select dropdown2 = new Select(dropdownelement1);
        dropdown2.selectByVisibleText("2D or 2.5D");
        Thread.sleep(2000);
        WebElement dropdownelement2 =  ds.getprespectivedropdown();
        Select dropdown3 = new Select(dropdownelement2);
        dropdown3.selectByVisibleText("First-Person");
        Thread.sleep(2000);
       // WebElement dropdownelement3 =  ds.getgameplaydropdown();
       // Select dropdown4 = new Select(dropdownelement3);
       // dropdown4.selectByVisibleText("Casual");
       // Thread.sleep(3000);

        ds.getdiscoverbuttonn().click();

        Thread.sleep(2000);

       List<WebElement> actusl =  ds.getgamecontent();
        System.out.println(actusl.size());

       if(actusl.equals(3)) {
           System.out.println("Game content match as 3");
       }else {
           System.out.println("Game content not match as 3"+ actusl.size());
           extent.createTest("verify the cards");
       }

        List<WebElement> games = ds.getgamecontent();
        System.out.println("All games title " + games.size());

        List<String> Alllinks = new ArrayList<>();
        for(WebElement link : games) {
            String url = link.getAttribute("href");
            if(url != null && !url.trim().isEmpty()) {
                Alllinks.add(url);
            }
        }
        for (int i = 0; i < Alllinks.size(); i++) {
            driver.navigate().to(Alllinks.get(i));      // Visit the game page
            Thread.sleep(2000);                          // Wait for it to load
            System.out.println("all links: " + driver.getTitle());
            driver.navigate().back();                   // Go back to the reviews page
            Thread.sleep(2000);

        test.log(Status.PASS, "Test is passed");
        //
        }
    }
    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");
        extent.flush();

    }

}
