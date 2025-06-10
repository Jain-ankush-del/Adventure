package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UpcominPO {
    public WebDriver driver;
    By Gameshover = By.cssSelector("#mega-menu-item-53");
    By upcoming = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/topreviewed/']");

    By upcominggames= By.cssSelector("div[class='new-realse-parent'] div div a");

    public UpcominPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(Gameshover);
    }

    public WebElement getupcoming() {
        return driver.findElement(upcoming);
    }

    public List<WebElement> getupcominggames() {
        return driver.findElements(upcominggames);
    }

}
