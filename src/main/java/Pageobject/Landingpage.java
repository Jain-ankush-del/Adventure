package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Landingpage {
    public WebDriver driver;
By dropdownmenu  = By.cssSelector("#mega-menu-menu-1");
By Homepagelink  = By.tagName("a");
By image = By.tagName("img");
By videolink = By.cssSelector(".lazyload");
By LAGR = By.cssSelector(".newrelease_box");
By latestscreenshot = By.cssSelector(".reader_box.styled-reader-box");


    public Landingpage(WebDriver driver) {
        this.driver= driver;
    }


    public List<WebElement> getalllinks() {
    return this.driver.findElements(Homepagelink);

}
    public List<WebElement> getallvideo() {
        return this.driver.findElements(videolink);

    }
    public List<WebElement> getlatestgamesrelease() {
        return this.driver.findElements(LAGR);

    }

    public List<WebElement> getlatestscreenshot() {
        return this.driver.findElements(latestscreenshot);

    }

    public WebElement getnavbar() {
        return this.driver.findElement(dropdownmenu);

    }

    public List<WebElement> getallimag() {
        return this.driver.findElements(image);

    }
}
