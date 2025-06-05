package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Discoveradv
{
    public WebDriver driver;
    By dropdownmenu  = By.cssSelector(".mega-menu-link[href='https://weisetech.dev/adventuregamers/adventure/all/']");
    By Discoveradvatnure  = By.cssSelector(".mega-menu-link[href='https://weisetech.dev/adventuregamers/discover']");
    By gener  =  By.cssSelector("select[name='genre']");
    By discoverbutton = By.cssSelector("button[type='submit']");
    By presentataiondropdown = By.cssSelector("select[name='pres']");
    By prespectivedropdown = By.cssSelector("select[name='persp']");
    By gameplaydropdown = By.cssSelector("select[name='gameplay']");
    By gamecontent = By.cssSelector("div[class='game-content'] h2");

    public Discoveradv(WebDriver driver) {
        this.driver=driver;

    }


    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getdiscoveradvanture() {
        return driver.findElement(Discoveradvatnure);
    }

    public WebElement getgenerdropdown() {
        return driver.findElement(gener);
    }

    public WebElement getdiscoverbuttonn() {
        return driver.findElement(discoverbutton);
    }
    public WebElement getpresentataiondropdown() {
        return driver.findElement(presentataiondropdown);
    }
    public WebElement getprespectivedropdown() {
        return driver.findElement(prespectivedropdown);
    }
    public WebElement getgameplaydropdown() {
        return driver.findElement(gameplaydropdown);
    }
    public List<WebElement> getgamecontent() {
        return this.driver.findElements(gamecontent);

    }


}
