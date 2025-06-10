package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LatestnewsPO {
    public WebDriver driver;

    By dropdownmenu = By.xpath("(//span[@class='mega-indicator'])[1]");
    By Latestnewsmenu = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/article-type/review/']");
    By airticalcategory = By.cssSelector(".article-category ul li a ");
    By image = By.tagName("img");
    By Latestnews =  By.cssSelector("div[class='news-head'] a h2");
    By halfaritcle = By.cssSelector("div[class='half-artical'] a h2");




    public LatestnewsPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getlatestwmenu() {
        return driver.findElement(Latestnewsmenu);
    }

    public List<WebElement> getarticelcategory() {
        return driver.findElements(airticalcategory);
    }
    public List<WebElement> getallimag() {
        return this.driver.findElements(image);

    }
    public List<WebElement> getallnews() {
        return this.driver.findElements(Latestnews);

    }
    public List<WebElement> gethalfaritcle() {
        return this.driver.findElements(halfaritcle);

    }
}
