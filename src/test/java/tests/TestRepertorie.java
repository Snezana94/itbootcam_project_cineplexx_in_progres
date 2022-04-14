package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.Login;
import pages.Repertorie;
import utils.PropertiesReader;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRepertorie {
    private WebDriver webDriver;
    private Faker faker;

    @BeforeSuite
    public void beforSuit() {
        System.out.println("Repertorie Suit");
    }

    @BeforeClass
    public void beforClass() {
        System.setProperty("webdriver.chrome.driver", PropertiesReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
        webDriver.get("https://www.cineplexx.rs/filmovi/repertoar/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().getPageLoadTimeout();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void close() {
        webDriver.close();
    }

//    Test Case 10
//1.Go tu: https://www.cineplexx.rs/filmovi/repertoar/
//2.In the cinema selection field, select "Cineplex Promenada".
//3.From the date selection field, select tomorrow in relation to the test day.
//4.Select "MX4D" from the technology selection field.
//5.Select "action" from the genre selection field
//6.Confirm that after each individual selection from the previous fields, the list of films on the repertoire changes.
    @Test
    public void movieFilterHappyPath() throws InterruptedException {
        Repertorie repertorie = new Repertorie(webDriver);
        int films = repertorie.assertFilter();
        repertorie.chooseCinema();
        Thread.sleep(1000);
        repertorie.chooseDate();
        Thread.sleep(1000);
        repertorie.chooseTechnology();
        Thread.sleep(1000);
        repertorie.chooseGenre();
        Assert.assertTrue(films != repertorie.assertFilter(), "Numbuer of films must be different!");

    }

//    Test Case 11
//1.Go tu: https://www.cineplexx.rs/filmovi/repertoar/
//2.In the "sort by" section, select the "sort chronologically" option.
//3.Confirm that the films are listed in the same order from the original, confirm that the films are sorted chronologically.
//4.In the "sort by" section, select the "sort alphabetically" option.
//5.Confirm that the films are listed in a different order from the original, confirm that the films are sorted alphabetically.
    @Test
    public void sortFilmsHappyPath() throws InterruptedException, ParseException {
        SoftAssert sa = new SoftAssert();
        Repertorie repertorie = new Repertorie(webDriver);
        repertorie.sortChronologically();
        sa.assertTrue(repertorie.assertSortChronologically(), "Movies do not sorting chronologically!");

        repertorie.sortAlphabetically();
        sa.assertTrue(repertorie.assertSortAlphabetically(), "Movies do not sorting alphabetically!");

        sa.assertAll();
    }

//    Test Case 12
//1.Go tu: https://www.cineplexx.rs/filmovi/repertoar/
//2.In the section of the cinema repertoire, find the "detailed description" button.
//3.Confirm that the button is currently active.
//4.Confirm that the display of films is such that it is visible: image, title, screening times.
//5.Find the "poster preview" button and click it.
//6.Confirm that the movie display has now been changed, enlarged images are displayed, and the movie name is below the poster.
    @Test
    public void displayModeHappyPath() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        Repertorie repertorie = new Repertorie(webDriver);

        sa.assertTrue(repertorie.displayModeDetailedDescription(), "Display mode DETAIL should be active.");
        sa.assertTrue(repertorie.assertDisplayModeDetailedDescription(), "Content should be displayed.");

        sa.assertTrue(repertorie.displayModePosterPreview(), "Display mode POSTER should be active.");
        sa.assertTrue(repertorie.assertDisplayModePosterPreview(), "Content should not be displayed.");

        sa.assertAll();
    }

//    Test Case 13
//1.Go tu: https://www.cineplexx.rs/filmovi/repertoar/
//2.Select the first film from the list of films on the repertoire.
//3.From the section of total tickets, select two (by clicking on the armchair icon), and then confirm that the box now says number 2 (previously 1).
//4.From the section for selecting places, select the 1th row and any two places from the vacancies (confirm based on the legend which places are vacant).
//5.Scroll and at the bottom I will find the linked text "Login", click and log in.
//6.Enter "automation.Testing123qa@gmail.com" in the email field.
//7.Enter "automationQA123" in the password field.
//8.Click on the "login" red button.
//9.Confirm that it is now possible to click, and click on "book".
//10.Confirm the terms of use.
//11.Click on the "confirm booking" button.
//12.Confirm that the text "Thank you for your reservation" is on the screen, as well as answering the reservation code.
    @Test
    public void reservationHappyPath() throws InterruptedException {
        Repertorie repertorie = new Repertorie(webDriver);
        repertorie.chooseCinema();
        Thread.sleep(1000);
        repertorie.reservationFilmTimeNumber();
        Thread.sleep(2000);
        Assert.assertTrue(repertorie.getCheckChose().isDisplayed());

        Login login = new Login(webDriver);
        login.loginUser("automation.Testing123qa@gmail.com", "automationQA123");
        Assert.assertTrue(login.getLogoutBtn().contains("Odjava"));

        repertorie.reservationBooking();
//        Assert.assertTrue(repertorie.assertBooking().contains("Zahvaljujemo na Vašoj rezervaciji!"));

    }

//    Test Case 14
//1.Go tu: https://www.cineplexx.rs/filmovi/repertoar/
//2. Select the first film from the list of films on the repertoire.
//3. From the section of total tickets, select two (by clicking on the armchair icon), and then confirm that the box now says number 2 (previously 1).
//3. From the section for selecting places, select the 4th row and any two places from the vacancies (confirm based on the legend which places are vacant).
//5. Scroll and at the bottom I will find the linked text "Login", click and log in.
//6.Enter "automation.Testing123qa@gmail.com" in the email field.
//7.Enter "automationQA123" in the password field.
//8.Click on the "login" red button.
//9.Confirm that it is now possible to click, and click on "book".
//10.Confirm the terms of use.
//11.Click on the "confirm booking" button.
//13.Confirm that the text "Thank you for your reservation" is on the screen, as well as answering the reservation code.
//14.Click on the "my tickets" button.
//15.Click on the "delete" button.
//16.Click on the "yes" button to confirm the deletion of the reservation.
//17.Confirm that the screen reads "Your reservation xxxxxxxx has been canceled.
    @Test
    public void cancelationHappyPath() throws InterruptedException {
        Repertorie repertorie = new Repertorie(webDriver);
        repertorie.chooseCinema();
        Thread.sleep(1000);
        repertorie.reservationFilmTimeNumber();
        Thread.sleep(2000);
        Assert.assertTrue(repertorie.getCheckChose().isDisplayed());

        Login login = new Login(webDriver);
        login.loginUser("automation.Testing123qa@gmail.com", "automationQA123");
        Assert.assertTrue(login.getLogoutBtn().contains("Odjava"));
        repertorie.reservationBooking();
        repertorie.cancelReservation();


    }



}
