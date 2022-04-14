package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDetails {
    private WebDriver wd;
    public MovieDetails(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

//    top films elements
    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]")
    WebElement film1;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[1]/div[1]/div[1]/a[1]")
    WebElement backToTheRepertoire;

    @FindBy(xpath = "//button[@id='bmpui-id-66']")
    WebElement treiler;

    @FindBy(xpath = "//h2[contains(text(),'Vremenski raspored svih projekcija')]")
    WebElement timesAndHalls;

    public WebElement getTreiler() {
        return treiler;
    }

    public void clickFilmDetails() {
        film1.click();
    }

    public String assertfilmDetails() {
        return backToTheRepertoire.getText();
    }

    public void playTreiler() {
        treiler.click();
    }

    public String assertTimesAndHalls() {
        return timesAndHalls.getText();
    }
}
