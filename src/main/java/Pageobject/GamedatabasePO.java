package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GamedatabasePO {

    public WebDriver driver;
    By Gameshover = By.cssSelector("#mega-menu-item-53");
    By gamesdatabase = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/adventure/all/']");
    By gamessorted= By.cssSelector("div[class='game-batabase'] div div:nth-child(2) h3 a");

    public GamedatabasePO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(Gameshover);
    }

    public WebElement getgamesdatabase() {
        return driver.findElement(gamesdatabase);
    }

    public List<WebElement> getgamessorted() {
        return driver.findElements(gamessorted);
    }

}
