package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Walkpage {
    public WebDriver driver;

    @FindBy(css = ".mega-menu-link[href='https://weisetech.dev/adventuregamers/walkthrough/']")
    public WebElement walkthrough;

    @FindBy(tagName = "a")
    public List<WebElement> allLinks;


    public Walkpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public List<WebElement> getAllLinks() {
        return allLinks;

    }

    public WebElement getwalkthrough() {
        return walkthrough;
    }
}
