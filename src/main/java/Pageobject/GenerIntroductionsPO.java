package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenerIntroductionsPO {
    public WebDriver driver;

    By dropdownmenu = By.xpath("(//span[@class='mega-indicator'])[1]");
    By generintroduction = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/article/what-are-adventure-games/']");
    By bodycontent = By.cssSelector(".article-single-content-inner");






    public GenerIntroductionsPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getgenerintroduction() {
        return driver.findElement(generintroduction);
    }

    public WebElement getbodycontent() {
        return driver.findElement(bodycontent);
    }

}
