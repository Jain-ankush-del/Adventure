package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Macpage {
    public WebDriver driver;

    @FindBy(css = ".cat-link.inactive[href='https://weisetech.dev/adventuregamers/categories/mac']")
    public WebElement macpage;

    @FindBy(tagName = "a")
    public List<WebElement> allLinks;


    public Macpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public List<WebElement> getAllLinks() {
        return allLinks;

    }

    public WebElement getmacpage() {
        return macpage;
    }
}
