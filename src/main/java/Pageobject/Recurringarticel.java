package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Recurringarticel
{
    public WebDriver driver;
    By dropdownmenu  = By.cssSelector(".mega-menu-link[href='https://weisetech.dev/adventuregamers/articles']");
    By recurringarticel  = By.cssSelector(".mega-menu-link[href='https://weisetech.dev/adventuregamers/recurring-articles']");
    By classdiv = By.cssSelector(".article-list");
    By Alllinks = By.tagName("a");


    public Recurringarticel(WebDriver driver) {
        this.driver=driver;

    }


    public WebElement getdropdown() {
        return driver.findElement(dropdownmenu);
    }

    public WebElement getrecurringarticel() {
        return driver.findElement(recurringarticel);
    }

    public List<WebElement> getclassdiv() {
        return driver.findElements(classdiv);
    }
    public List<WebElement> getalllinks() {
        return driver.findElements(Alllinks);
    }






}
