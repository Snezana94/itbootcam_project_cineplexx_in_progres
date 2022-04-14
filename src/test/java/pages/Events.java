package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Events {
    private WebDriver wd;
    public Events(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
}
