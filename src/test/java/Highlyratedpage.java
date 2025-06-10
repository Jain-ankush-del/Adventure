import Pageobject.GamedatabasePO;
import Pageobject.HighlyratedPO;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Highlyratedpage extends base {
    public WebDriver driver;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    public static Logger log = LogManager.getLogger(base.class.getName());
    HighlyratedPO hr = new HighlyratedPO(driver);
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = inilizationdriver();
        log.info("Browser is open");
        driver.get(prop.getProperty("url"));
        log.info("Navigate to url");

        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void verifyassertions() throws InterruptedException {

        hr = new HighlyratedPO(driver);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement dropdown = hr.getdropdown();
        Thread.sleep(3000);
        actions.moveToElement(dropdown).perform();
        Thread.sleep(5000);
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        driver.get("https://dev.weisetechdev.com/adventuregamers/topreviewed/");

        long endTime = System.currentTimeMillis();


        long loadTime = endTime - startTime;

        System.out.println("Page loaded in: " + loadTime + " ms");
        System.out.println("Page loaded in: " + (loadTime / 1000.0) + " seconds");
        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), "Topreviewed – Adventure Gamers");
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/topreviewed/"));
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.className("header")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("footersect")).isDisplayed());
        Thread.sleep(2000);


        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String href = link.getAttribute("href");


        }
    }

    @Test(priority = 2)
    public void tablinks() throws InterruptedException {
        List<WebElement> tabs = hr.getarticelcategory();
        System.out.println("Total tabs: " + tabs.size());

        List<String> tabLinks = new ArrayList<>();
        for (WebElement tab : tabs) {
            String url = tab.getAttribute("href");
            if (url != null && !url.trim().isEmpty()) {
                tabLinks.add(url);
            }
        }


        for (int i = 0; i < tabLinks.size(); i++) {
            driver.navigate().to(tabLinks.get(i));
            Thread.sleep(2000);
            System.out.println("Opened tab: " + driver.getTitle());
        }
        driver.get("https://dev.weisetechdev.com/adventuregamers/topreviewed/");

    }

    @Test(priority = 3)
    public void Allgameslink() throws InterruptedException {
        List<WebElement> games = hr.getratedgames();
        System.out.println("All games title " + games.size());

// Step 3: Collect URLs into a list
        List<String> Alllinks = new ArrayList<>();
        for (WebElement link : games) {
            String url = link.getAttribute("href");
            if (url != null && !url.trim().isEmpty()) {
                Alllinks.add(url);
            }
        }

// Step 4: Now click each link using a for loop
        for (int i = 0; i < Alllinks.size(); i++) {
            driver.navigate().to(Alllinks.get(i));      // Visit the game page
            Thread.sleep(2000);                          // Wait for it to load
            System.out.println("all links: " + driver.getTitle());
            driver.navigate().back();                   // Go back to the reviews page
            Thread.sleep(2000);
        }

    }
    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");


    }
}