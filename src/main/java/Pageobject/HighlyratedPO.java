package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HighlyratedPO {
    public WebDriver driver;
    By Gameshover = By.cssSelector("#mega-menu-item-53");
    By Highelyrated = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/topreviewed/']");
    By airticalcategory = By.cssSelector(".article-category ul li a ");
    By ratedgames= By.cssSelector("div[class='top-view-cell'] div:nth-child(2) div h5 a");

    public HighlyratedPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(Gameshover);
    }

    public WebElement getHighelyrated() {
        return driver.findElement(Highelyrated);
    }

    public List<WebElement> getratedgames() {
        return driver.findElements(ratedgames);
    }
    public List<WebElement> getarticelcategory() {
        return driver.findElements(airticalcategory);
    }
}
