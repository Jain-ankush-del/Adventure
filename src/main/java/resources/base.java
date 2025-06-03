package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {
    public WebDriver driver;
    public Properties prop;
    public WebDriver inilizationdriver() throws IOException {

        prop = new Properties();
        //System.getPropoerty("user.dir");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        //String browserName = System.getProperty("browser");
         String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome") ) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if(browserName.contains("headless")) {
                options.addArguments("headless");

            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        }
        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\aparp\\Downloads\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else if(browserName.equals("Edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;

    }

    public String getScreenShotPath (String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String Destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(Destinationfile));
        //FileUtils.copyFile(source, new File(Destinationfile));
        return Destinationfile;

    }
}
