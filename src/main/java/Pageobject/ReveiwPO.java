package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReveiwPO {
    public WebDriver driver;

    By dropdownmenu = By.xpath("(//span[@class='mega-indicator'])[1]");
    By Reviewmenu = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/article-type/review/']");
    By airticalcategory = By.cssSelector(".article-category ul li a ");
    By image = By.tagName("img");
    By Gametitle =  By.cssSelector("div[class='article-right'] h2 a");




    public ReveiwPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getreviewmenu() {
        return driver.findElement(Reviewmenu);
    }

    public List<WebElement> getarticelcategory() {
        return driver.findElements(airticalcategory);
    }
    public List<WebElement> getallimag() {
        return this.driver.findElements(image);

    }
    public List<WebElement> getallgames() {
        return this.driver.findElements(Gametitle);

    }
}
