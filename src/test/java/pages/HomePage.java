package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver wd;
    public HomePage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

//    cookies elements
    @FindBy(xpath = "/html/body/div[3]/div/a[1]")
    WebElement cookiesHere;

    @FindBy(xpath = "/html/body/div[3]/div/a[2]")
    WebElement cookiesOK;

    //    favorite cinema elements
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/form/div/div/a/span")
    WebElement favoriteCinema;

    @FindBy(xpath = "//li[contains(text(),'Cineplexx Promenada')]")
    WebElement cineplexxPromenada;

    @FindBy(xpath = "//a[contains(text(),'OK')]")
    WebElement favoriteCinemaOK;

//    nav bar elements
    @FindBy(xpath = "//span[contains(text(),'Filmovi')]")
    WebElement filmsNav;

    @FindBy(xpath = "//span[contains(text(),'Događaji')]")
    WebElement eventsNav;

    @FindBy(xpath = "//span[contains(text(),'Bioskopi')]")
    WebElement cinemaNav;

    @FindBy(xpath = "//span[contains(text(),'Članstvo')]")
    WebElement membershipNav;

    @FindBy(xpath = "//span[contains(text(),'Novosti')]")
    WebElement newsNav;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
    WebElement searchInput;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[2]/div[1]/form[1]/div[1]/input[2]")
    WebElement searchSubmit;

//    films elements
    @FindBy(xpath = "//*[@id=\"s2id_autogen9\"]/a/span")
    WebElement cinemaInFilms;

//    search page elements
    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[2]/div[1]/a[1]")
    WebElement result;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[1]/ul[1]/li[1]")
    WebElement topFilmNav2;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul/li[2]")
    WebElement inCinemaNav2;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul/li[3]")
    WebElement soonNav2;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul/li[4]")
    WebElement mx4dNav2;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul/li[5]")
    WebElement imaxNav2;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul/li[6]")
    WebElement eventsNav2;

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul/li[7]")
    WebElement operaBaletNav2;

//    social networks elements
    @FindBy(xpath = "//body/div[@id='root']/div[5]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
    WebElement fbIcon;

    @FindBy(xpath = "//*[@id=\"root\"]/div[5]/div/div/div[3]/div/ul[1]/li[3]/a")
    WebElement twitterIcon;

    public void viewCookies() {
        cookiesHere.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        for(String winHandle:wd.getWindowHandles()){
            wd.switchTo().window(winHandle);
        }
    }

    public void acceptCookies() {
        cookiesOK.click();
    }


    public void addFavoriteCinema() throws InterruptedException {
        favoriteCinema.click();
        cineplexxPromenada.click();
        favoriteCinemaOK.click();
        Thread.sleep(2000);
        filmsNav.click();
    }

    public String assertFavoriteCinema() {
        return cinemaInFilms.getText();
    }

    public void navFilms() {
        filmsNav.click();
    }

    public void navEvents() {
        eventsNav.click();
    }

    public void navCinema() {
        cinemaNav.click();
    }

    public void navMembership() {
        membershipNav.click();
    }

    public void navNews() {
        newsNav.click();
    }

    public void search(String key) {
        searchInput.sendKeys(key);
        searchSubmit.click();
    }

    public String getResult() {
        return result.getText();
    }

    public void nav2TopFilms() {
        topFilmNav2.click();
    }

    public String assertTopFilms() {
        return topFilmNav2.getAttribute("class");
    }

    public void nav2InCinema() {
        inCinemaNav2.click();
    }

    public String assertInCinema() {
        return inCinemaNav2.getAttribute("class");
    }

    public void nav2Soon() {
        soonNav2.click();
    }

    public String assertSoon() {
        return soonNav2.getAttribute("class");
    }

    public void nav2Mx4d() {
        mx4dNav2.click();
    }

    public String assertMx4d() {
        return mx4dNav2.getAttribute("class");
    }

    public void nav2Imax() {
        imaxNav2.click();
    }

    public String assertImax() {
        return imaxNav2.getAttribute("class");
    }

    public void nav2Events() {
        eventsNav2.click();
    }

    public String assertEvents() {
        return eventsNav2.getAttribute("class");
    }

    public void nav2OperaBalet() {
        operaBaletNav2.click();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[5]/div[1]/ul")
    WebElement nav2;

    public boolean nav2WithChild() throws InterruptedException {
        List<WebElement> naav2 = nav2.findElements(By.tagName("li"));
        boolean bool = true;

        for (int i = 0; i < 7; i++) {
            naav2.get(i).click();
            if (i < 6) {
                bool = naav2.get(i).getAttribute("class").contains("active");
                if (!bool) {
                    System.out.println("if " + i);
                     return false;
                }
            } else {
                bool = wd.getCurrentUrl().contains("https://www.cineplexx.rs/dogadjaji/eventreihe/opera-i-balet/");
                if (!bool) {
                    System.out.println("else 6");
                    return false;
                }
            }
        }

        return bool;
    }

    public void goToFacebook() {
        fbIcon.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        for(String winHandle:wd.getWindowHandles()){
            wd.switchTo().window(winHandle);
        }
    }

    public void goToTwitter() {
        twitterIcon.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        for(String winHandle:wd.getWindowHandles()){
            wd.switchTo().window(winHandle);
        }
    }


}
