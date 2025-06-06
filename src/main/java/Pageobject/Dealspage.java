package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dealspage {

    public WebDriver driver;

    @FindBy(css = "li[id='mega-menu-item-1571'] a[class='mega-menu-link']")
    public WebElement dealslinks;

    @FindBy(tagName = "a")
    public List<WebElement> allLinks;


    public Dealspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public List<WebElement> getAllLinks() {
        return allLinks;

    }

    public WebElement getDealslinks() {
        return dealslinks;
    }




}
