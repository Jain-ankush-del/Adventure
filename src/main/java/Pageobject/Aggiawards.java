package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Aggiawards
{
    public WebDriver driver;
    By dropdownmenu  = By.cssSelector(".mega-menu-link[href='https://weisetech.dev/adventuregamers/adventure/all/']");
    By Aggiawards  = By.cssSelector("li[id='mega-menu-item-60'] a[class='mega-menu-link']");
    By classdiv = By.cssSelector(".award-list-block");
    By Alllinks = By.tagName("a");


    public Aggiawards(WebDriver driver) {
        this.driver=driver;

    }


    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getaggiawards() {
        return driver.findElement(Aggiawards);
    }

    public WebElement getclassdiv() {
        return driver.findElement(classdiv);
    }
    public List<WebElement> getalllinks() {
        return driver.findElements(Alllinks);
    }






}
