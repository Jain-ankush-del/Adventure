import Pageobject.Previewpage;
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

public class PReviewpage extends base {

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
    }

    @Test
    public void reviewpage() throws InterruptedException {
        Previewpage pp = new Previewpage(driver);
       Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement dropdown = pp.getdropdown();
        Thread.sleep(3000);
        actions.moveToElement(dropdown).perform();
        Thread.sleep(5000);
        long startTime = System.currentTimeMillis();

        pp.getreviewmenu().click();

        long endTime = System.currentTimeMillis();

        long loadTime = endTime - startTime;

        System.out.println("Page loaded in: " + loadTime + " ms");
        System.out.println("Page loaded in: " + (loadTime / 1000.0) + " seconds");
        Thread.sleep(3000);
        //

        Thread.sleep(2000);

        List<WebElement> tabs = pp.getarticelcategory();
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

        Thread.sleep(5000);
        List<WebElement> img = pp.getallimag();
        log.info(img.size());

        for (int i = 0; i < img.size(); i++) {
            img = pp.getallimag();
            WebElement Imagename = img.get(i);
            String text = Imagename.getText();
            String imagepath = Imagename.getAttribute("src");

            if (imagepath != null && !imagepath.trim().isEmpty()) {
                log.info(text + " (" + imagepath + ")");

            } else {
                log.info("Skipped any attribute not available" + i);
            }
        }

        driver.get("https://dev.weisetechdev.com/adventuregamers/article-type/preview/");
        Thread.sleep(5000);

// Step 2: Get all game elements
        List<WebElement> games = pp.getallgames();
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

    @Test
    public void verifyassertions() throws InterruptedException {

        Assert.assertEquals(driver.getTitle(), "Adventure game review | Adventure Gamers");
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/article-type/preview/"));
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.className("header")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("footersect")).isDisplayed());
        Thread.sleep(2000);



        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String href = link.getAttribute("href");


        }

    }


    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");
        extent.flush();

    }

    }