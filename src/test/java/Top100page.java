import Pageobject.ReveiwPO;
import Pageobject.Top100alltimesPO;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Top100page extends base {

    public WebDriver driver;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    public static Logger log = LogManager.getLogger(base.class.getName());
    Top100alltimesPO TA = new Top100alltimesPO(driver);
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

        TA = new Top100alltimesPO(driver);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement dropdown = TA.getdropdown();
        Thread.sleep(3000);
        actions.moveToElement(dropdown).perform();
        Thread.sleep(5000);
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        driver.get("https://dev.weisetechdev.com/adventuregamers/article/top-100-all-time-adventure-games/");

        long endTime = System.currentTimeMillis();


        long loadTime = endTime - startTime;

        System.out.println("Page loaded in: " + loadTime + " ms");
        System.out.println("Page loaded in: " + (loadTime / 1000.0) + " seconds");
        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), "Top 100 All-Time Adventure Games – Adventure Gamers");
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/top-100-all-time-adventure-games/"));
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.className("header")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("footersect")).isDisplayed());
        Thread.sleep(2000);


        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String href = link.getAttribute("href");


        }
        String bodytext = TA.getbodycontent().getText();
        int charCount = bodytext.replaceAll("\\s+", "").length();
        int wordCount = bodytext.trim().split("\\s+").length;

        System.out.println("Character Count (without spaces): " + charCount);
        System.out.println("Word Count: " + wordCount);

    }

}
