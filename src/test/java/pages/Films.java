package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Films {

    private WebDriver wd;
    public Films(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[1]")
    WebElement repertorie;

    @FindBy(xpath = "//h1[contains(text(),'Repertoar')]")
    WebElement assertRepertorie;

    public WebElement getRepertorie() {
        return repertorie;
    }

    public WebElement getAssertRepertorie() {
        return assertRepertorie;
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[2]/a[1]")
    WebElement inTheCinema;

    @FindBy(xpath = "//h1[contains(text(),'U bioskopu')]")
    WebElement assertInTheCinema;

    public WebElement getInTheCinema() {
        return inTheCinema;
    }

    public WebElement getAssertInTheCinema() {
        return assertInTheCinema;
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[3]/a[1]")
    WebElement soon;

    @FindBy(xpath = "//h1[contains(text(),'Uskoro u bioskopu')]")
    WebElement assertSoon;

    public WebElement getSoon() {
        return soon;
    }

    public WebElement getAssertSoon() {
        return assertSoon;
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[4]/a[1]")
    WebElement mX4D;

    @FindBy(xpath = "//h1[contains(text(),'MX4D')]")
    WebElement assertMX4D;

    public WebElement getMX4D() {
        return mX4D;
    }

    public WebElement getAssertMX4D() {
        return assertMX4D;
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[5]/a[1]")
    WebElement iMAX;

    @FindBy(xpath = "//h1[contains(text(),'IMAX')]")
    WebElement assertIMAX;

    public WebElement getIMAX() {
        return iMAX;
    }

    public WebElement getAssertIMAX() {
        return assertIMAX;
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[7]/a[1]")
    WebElement movieArchive;

    @FindBy(xpath = "//h1[contains(text(),'Arhiva filmova')]")
    WebElement assertMovieArchive;

    public WebElement getMovieArchive() {
        return movieArchive;
    }

    public WebElement getAssertMovieArchive() {
        return assertMovieArchive;
    }

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/ul[1]/li[6]/a[1]")
    WebElement trilers;

    @FindBy(xpath = "//h1[contains(text(),'Trejler')]")
    WebElement assertTrilers;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/button[1]/div[1]")
    WebElement triler1;

    @FindBy(xpath = "//span[@id='bmpui-id-56']")
    WebElement triler1Time;

    @FindBy(xpath = "//button[@id='bmpui-id-66']")
    WebElement btnPlayStop;

    public boolean checkingNavigationElements(WebElement element, WebElement assertElements, String expectedText) {
        element.click();
        if (assertElements.getText().contains(expectedText)) return true;
        return false;
    }
    public boolean checkingNavigationElementsTrilers() {
        trilers.click();
        if (!assertTrilers.getText().contains("TREJLER")) return false;

        triler1.click();
        if (triler1Time.getText().contains("00:00")) return false;
        btnPlayStop.click();

        return true;
    }
}
