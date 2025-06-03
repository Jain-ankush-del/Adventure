import Pageobject.Landingpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.util.List;

public class Allvideo extends base {

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
    public void playAndCloseAllVideos() throws InterruptedException {
        // Scroll to video section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");

        // Wait for the page to fully load (adjust if needed)
        Thread.sleep(2000);
        Landingpage la = new Landingpage(driver);

        // Get all video play buttons (adjust selector if needed)
        List<WebElement> videoThumbnails = la.getallvideo(); // update this CSS if needed

        log.info("Total videos found: " + videoThumbnails.size());

        for (int i = 0; i < videoThumbnails.size(); i++) {
            try {
                videoThumbnails.get(i).click();  // Click to open video modal
                Thread.sleep(5000);              // Wait for the video to play a bit

                // Press ESC to close modal or click close button
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.ESCAPE).build().perform();

                Thread.sleep(2000);  // Wait before next iteration

            } catch (Exception e) {
                log.info("Failed to play video #" + (i + 1));
            }
        }
    }
    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");

    }
}
