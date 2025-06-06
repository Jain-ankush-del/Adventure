import Pageobject.Dealspage;
import Pageobject.Topgames;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static java.io.File.separator;

public class Topgamespage extends base {
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
    public void verifyAllLinksOnDealsPage() throws InterruptedException {

        Topgames tg = new Topgames(driver);
        Thread.sleep(3000);
        tg.topdeals.click();
        Thread.sleep(3000);
        List<WebElement> links = tg.getAllLinks();

        int totalLinks = 0;
        int validLinks = 0;
        int brokenLinks = 0;
        int exceptionLinks = 0;

        System.out.println("============================================================");
        System.out.println("---- All Links on Deals Page ----");
        System.out.println("============================================================");

        for (WebElement link : links) {
            String href = link.getAttribute("href");
            String text = link.getText().trim();
            if (href != null && !href.isEmpty()) {
                totalLinks++;
                System.out.println("Text: " + (text.isEmpty() ? "[No Text]" : text));
                System.out.println("Link: " + href);
                int status = verifyLink(href);
                if (status == 200) {
                    validLinks++;
                } else if (status == -1) {
                    exceptionLinks++;
                } else {
                    brokenLinks++;
                }
                System.out.println("============================================================");
            }
        }

        System.out.println("Total Valid Links Found: " + validLinks);
        log.info("Total Valid Links Found: " + validLinks);
        System.out.println("Total Broken Links Found: " + brokenLinks);
        log.info("Total Broken Links Found: " + brokenLinks);
        System.out.println(" Total Links with Exceptions: " + exceptionLinks);
        log.info("Total Links with Exceptions: " + exceptionLinks);
        System.out.println("Total Links Processed: " + totalLinks);
        log.info("Total Links Processed: " + totalLinks);
        log.info("============================================================");
        log.info(separator);
        test.info("Total Valid Links Found: " + validLinks);
        test.info(" Total Broken Links Found: " + brokenLinks);
        test.info(" Total Links with Exceptions: " + exceptionLinks);
        test.info(" Total Links Processed: " + totalLinks);
        System.out.println("============================================================");
    }

    public int verifyLink(String linkUrl) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(linkUrl).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Broken Link: " + linkUrl + " - Response Code: " + responseCode);
            } else {
                System.out.println(" Working Link: " + linkUrl + " - Response Code: " + responseCode);
            }
            return responseCode;
        } catch (Exception e) {
            System.out.println("Exception for Link: " + linkUrl + " - " + e.getMessage());
            return -1;
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");


    }
}
