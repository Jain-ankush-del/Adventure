import Pageobject.GenerIntroductionsPO;
import Pageobject.ReveiwPO;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Generintroductionpage extends base {

    public WebDriver driver;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    public static Logger log = LogManager.getLogger(base.class.getName());
    GenerIntroductionsPO gn = new GenerIntroductionsPO(driver);
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

        gn = new GenerIntroductionsPO(driver);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement dropdown = gn.getdropdown();
        Thread.sleep(3000);
        actions.moveToElement(dropdown).perform();
        Thread.sleep(5000);
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        driver.get("https://dev.weisetechdev.com/adventuregamers/article/what-are-adventure-games/");

        long endTime = System.currentTimeMillis();


        long loadTime = endTime - startTime;

        System.out.println("Page loaded in: " + loadTime + " ms");
        System.out.println("Page loaded in: " + (loadTime / 1000.0) + " seconds");
        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), "What are adventure games? – Adventure Gamers");
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/article/what-are-adventure-games/"));
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.className("header")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("footersect")).isDisplayed());
        Thread.sleep(2000);


        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String href = link.getAttribute("href");


        }

        String bodytext = gn.getbodycontent().getText();
        int charCount = bodytext.replaceAll("\\s+", "").length();
        int wordCount = bodytext.trim().split("\\s+").length;

        System.out.println("Character Count (without spaces): " + charCount);
        System.out.println("Word Count: " + wordCount);

    }

}
