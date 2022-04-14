package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class News {
    private WebDriver wd;
    public News(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
}
