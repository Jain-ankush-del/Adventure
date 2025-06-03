import Pageobject.Landingpage;
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
import java.util.List;

public class Allimages extends base {

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
        public void allimg() throws InterruptedException {
            Landingpage la = new Landingpage(driver);


            List<WebElement> img = la.getallimag();
            log.info(img.size());

            for (int i = 0; i < img.size(); i++) {
                img = la.getallimag();
                WebElement Imagename = img.get(i);
                String text = Imagename.getText();
                String imagepath = Imagename.getAttribute("src");

                if (imagepath != null && !imagepath.trim().isEmpty()) {
                    log.info(  text + " (" + imagepath + ")");

                } else {
                    log.info("Skipped any attribute not available" + i);
                }
            }
        }
    @AfterTest
    public void teardown() {
        driver.close();
        log.info("driver is close");

    }
    }


