package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Membership {
    private WebDriver wd;
    public Membership(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
}
