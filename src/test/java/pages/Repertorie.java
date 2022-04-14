package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Repertorie {
    private WebDriver wd;
    public Repertorie(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

//    filter section elements
    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/form[1]/div[1]/div[1]/a[1]")
    WebElement cinema;

    @FindBy(xpath = "//body/div[@id='select2-drop']/ul[1]/li[8]/div[1]")
    WebElement cineplexxPromenada;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/form[1]/div[2]/div[1]/a[1]")
    WebElement date;

    @FindBy(xpath = "//body/div[@id='select2-drop']/ul[1]/li[2]/div[1]")
    WebElement tomorow;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/form[1]/div[3]/div[1]/ul[1]/li[1]")
    WebElement technologies;

    @FindBy(xpath = "//option[contains(text(),'MX4D 3D')]")
    WebElement mx4d;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/form[1]/div[4]/div[1]/a[1]")
    WebElement genre;

    @FindBy(xpath = "//body/div[@id='select2-drop']/ul[1]/li[3]/div[1]")
    WebElement action;

    @FindBy(className = "overview-element")
    List<WebElement> listOfFilms;

    public List<WebElement> getListOfFilms() {
        return listOfFilms;
    }

    //    sort section elements
    @FindBy(xpath = "//label[contains(text(),'Sortiraj hronološki')]")
    WebElement chronologically;

    @FindBy(xpath = "//label[contains(text(),'Sortiraj po abecednom redu')]")
    WebElement alphabetically;

    List<WebElement> listOfSortedFilmsChronologically;
    List<WebElement> listOfSortedFilmsAlphabetically;
    List<Date> datesChronologically = new ArrayList<>();
    List<Character> namesOfMoviesSortedInSite = new ArrayList<>();
    List<Character> namesOfMoviesSortedByClassSort = new ArrayList<>();

//    display mode section elements
    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]")
    WebElement detailedDescription;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[2]/div[3]")
    WebElement divDetailed;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[2]")
    WebElement posterPreview;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[5]/div[2]/div[4]")
    WebElement divPoster;

//     reservation elements
    @FindBy(className = "film-teaser-image")
    WebElement title;

    @FindBy(className = "time-desc")
    WebElement timeToday;

    @FindBy(xpath = "//header/div[1]/div[2]/div[1]/div[1]/fieldset[1]/label[5]/span[1]")
    WebElement iconSeat;

    @FindBy(className = "loveSeat")
    WebElement seat;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/footer[1]/div[1]/div[1]")
    WebElement checkChose;

    @FindBy(xpath = "//*[@id=\"ticketing\"]/div/div/section/footer/div[2]/div[2]/div/button[1]")
    WebElement btnBook;

    @FindBy(css = "div.scale-wrapper:nth-child(4) div.wrapper div.section:nth-child(4) div.program section.reservation main.reservation__main div.reservation__type div.agb-container:nth-child(2) > label.label.label--checkbox:nth-child(2)")
    WebElement termsOfUse;

    @FindBy(css = "div.scale-wrapper:nth-child(4) div.wrapper div.section:nth-child(4) div.program section.reservation footer.reservation__footer div.uk-grid div.uk-width-medium-1-3.uk-width-small-1-1 > button.button.button--secondary.reservation__footer-finish")
    WebElement confirmBooking;

    @FindBy(xpath = "//h2[contains(text(),'Zahvaljujemo na Vašoj rezervaciji!')]")
    WebElement thankYouAssert;

    public WebElement getCheckChose() {
        return checkChose;
    }

//    cancel reservation elements
    @FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement myTickets;

    @FindBy(xpath = "//a[contains(text(),'Izbrisati')]")
    WebElement deleteTickets;

    @FindBy(xpath = "//button[contains(text(),'Obriši rezervaciju')]")
    WebElement deleteReservation;

    @FindBy(xpath = "//p[contains(text(),'Nema zapisa')]")
    WebElement numberOfReservatios;

    public void chooseCinema() {
        cinema.click();
        action(cineplexxPromenada);
        cineplexxPromenada.click();
    }

    public void chooseDate() {
        date.click();
        action(tomorow);
        tomorow.click();
    }

    public void chooseTechnology() {
        technologies.click();
        action(mx4d);
        mx4d.click();
    }

    public void chooseGenre() {
        genre.click();
        action.click();
    }

    public int assertFilter() {
        return listOfFilms.size();
    }

    public void sortChronologically() throws InterruptedException, ParseException {
        WebElement parent = wd.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[5]/div[2]/div[3]"));
        List<WebElement> list = parent.findElements(By.xpath("./child::*"));

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getText());
//        }

        chronologically.click();
        Thread.sleep(5000);
        WebElement parentSorted = wd.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[5]/div[2]/div[3]"));
        List<WebElement> listSorted = parentSorted.findElements(By.xpath("./child::*"));
        for (int i = 0; i < listSorted.size(); i++) {
            String dateS = listSorted.get(i).findElement(By.cssSelector("div.starBoxSmall.three-lines:nth-child(4) > p:nth-child(4)")).getText();
            String[] date = dateS.split(": ");
            Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse(date[1]);
            datesChronologically.add(date1);
        }
    }

    public boolean assertSortChronologically() {
        boolean bool = true;
        for (int i = 0; i < datesChronologically.size() - 1; i++) {
            if (datesChronologically.get(i).before(datesChronologically.get(i+1)) || datesChronologically.get(i).equals(datesChronologically.get(i+1))) {
                bool = true;
            } else bool = false;
        }
        return bool;
    }

    public void sortAlphabetically() throws InterruptedException {
        alphabetically.click();
        Thread.sleep(5000);
        WebElement parentSorted = wd.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div[5]/div[2]/div[3]"));
        List<WebElement> listSorted = parentSorted.findElements(By.xpath("./child::*"));
        for (int i = 0; i < listSorted.size(); i++) {
            String nameOfMovie = listSorted.get(i).findElement(By.tagName("h2")).getText();
            char ch = nameOfMovie.charAt(0);
            namesOfMoviesSortedInSite.add(ch);
            namesOfMoviesSortedByClassSort.add(ch);
        }
    }

    public boolean assertSortAlphabetically() throws InterruptedException {
        Collections.sort(namesOfMoviesSortedByClassSort);
        Thread.sleep(3000);
        for (int i = 0; i < namesOfMoviesSortedInSite.size(); i++) {
            if (!namesOfMoviesSortedInSite.get(i).equals(namesOfMoviesSortedByClassSort.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean displayModeDetailedDescription() {
        if (detailedDescription.getAttribute("class").contains("active")) {
            return true;
        }
        return false;
    }

    public boolean assertDisplayModeDetailedDescription() {
        if (divDetailed.isDisplayed()) return true;
        return false;
    }

    public boolean displayModePosterPreview() {
        posterPreview.click();

        if (posterPreview.getAttribute("class").contains("active")) {
            return true;
        }
        return false;
    }

    public boolean assertDisplayModePosterPreview() throws InterruptedException {
        Thread.sleep(1000);
        if (divPoster.isDisplayed()) return true;
        return false;
    }

    public void reservationFilmTimeNumber() throws InterruptedException {
        title.click();
        timeToday.click();
        iconSeat.click();
        Thread.sleep(1000);
        seat.click();
    }

    public void reservationBooking() {
        btnBook.click();
        termsOfUse.click();
        confirmBooking.click();
    }

    public String assertBooking() {
        return thankYouAssert.getText();
    }

    public void cancelReservation() {
        myTickets.click();
        deleteTickets.click();
        deleteReservation.click();
        System.out.println(numberOfReservatios.getText());
    }




    private void action(WebElement webElement) {
        Actions actions = new Actions(wd);
        actions.moveToElement(webElement).perform();
    }
}
