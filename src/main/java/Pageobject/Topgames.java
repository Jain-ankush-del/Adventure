package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Topgames {

    public WebDriver driver;

    @FindBy(css = ".mega-menu-link[href='https://weisetech.dev/adventuregamers/topgames/']")
    public WebElement topdeals;

    @FindBy(tagName = "a")
    public List<WebElement> allLinks;


    public Topgames(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public List<WebElement> getAllLinks() {
        return allLinks;

    }

    public WebElement getDealslinks() {
        return topdeals;
    }




}


