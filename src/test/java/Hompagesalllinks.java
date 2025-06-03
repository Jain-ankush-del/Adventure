import Pageobject.Landingpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Hompagesalllinks extends base {

    public WebDriver driver;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {
        driver = inilizationdriver();

        driver.get(prop.getProperty("url"));

        Thread.sleep(2000);
    }

    @Test
    public void gethompage() throws InterruptedException {
        test = extent.createTest("Home Page Title Verification");
        Landingpage la = new Landingpage(driver);
        List<WebElement> links = la.getalllinks();

        List<String> hrefs = new ArrayList<>();
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty() && href.startsWith("https://weisetech.dev")) {
                hrefs.add(href);
            }
        }

        System.out.println("Total internal links to click: " + hrefs.size());

        // Now click each link one by one
        for (String href : hrefs) {
            try {
                driver.navigate().to(href);
                log.info("Visited: " + driver.getTitle());
                Thread.sleep(2000); // Wait for page to load
                driver.navigate().back();
                Thread.sleep(2000);
            } catch (Exception e) {
                log.info("Error visiting: " + href);
            }
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");

    }

}
