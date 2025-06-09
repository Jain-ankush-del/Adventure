import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
import java.util.List;

public class rr extends base {
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException, InterruptedException {

        driver = inilizationdriver();

        driver.get(prop.getProperty("url"));


        Thread.sleep(2000);
    }

    @Test
    public void testcase()

    {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");



        // Navigate to the recurring articles page
        driver.get("https://weisetech.dev/adventuregamers/recurring-articles");

        // Get all <a> tags
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links found: " + links.size());

        for (int i = 0; i < links.size(); i++) {
            links = driver.findElements(By.tagName("a")); // Re-fetch DOM
            WebElement link = links.get(i);

            String linkText = link.getText().trim();
            String href = link.getAttribute("href");

            if (href != null && !href.isEmpty()) {
                System.out.println("Clicking on: " + linkText + " → " + href);

                try {
                    link.click();
                    Thread.sleep(2000); // Wait for 2 seconds after navigation

                    // Go back to the original page
                    driver.navigate().back();
                    Thread.sleep(1000); // Wait for page to reload
                } catch (Exception e) {
                    System.out.println("Failed to click: " + href);
                }
            }
        }

        driver.quit();
    }
}

