package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Top100alltimesPO {
    public WebDriver driver;

    By dropdownmenu = By.xpath("(//span[@class='mega-indicator'])[1]");
    By alltimes = By.cssSelector(".mega-menu-link[href='https://dev.weisetechdev.com/adventuregamers/article-type/review/']");
    By bodytext = By.cssSelector(".article-single-content-inner");

    public Top100alltimesPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getreviewmenu() {
        return driver.findElement(alltimes);
    }

    public WebElement getbodycontent() {
        return driver.findElement(bodytext);
    }

}
