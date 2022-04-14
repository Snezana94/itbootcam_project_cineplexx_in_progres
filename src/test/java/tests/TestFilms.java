package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Films;
import utils.PropertiesReader;

import java.time.Duration;

public class TestFilms {
    private WebDriver webDriver;
    private Faker faker;

    @BeforeSuite
    public void beforSuit() {
        System.out.println("Home Page Suit");
    }

    @BeforeClass
    public void beforClass() {
        System.setProperty("webdriver.chrome.driver", PropertiesReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
        webDriver.get("https://www.cineplexx.rs/filmovi/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().getPageLoadTimeout();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void close() {
        webDriver.close();
    }
//    Test Case 15
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2. Click on the "cinema repertoire" from the navigation bar.
//3. Confirm that the title "Repertoire" is displayed on the screen, while the films in the image format are listed below, to the right of the image is the title and time of the screening.
    @Test
    public void filmsRepertorieHapptPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElements(films.getRepertorie(), films.getAssertRepertorie(), "REPERTOAR"));
    }

//    Test Case 16
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2.Click "in the cinema" from the navigation bar.
//3. Confirm that the title "in the cinema" is shown, as well as that the list of films is in poster format, and below the poster is the title of the film.
    @Test
    public void filmsInCinemaHapptPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElements(films.getInTheCinema(), films.getAssertInTheCinema(), "U BIOSKOPU"));
    }

//    Test Case 17
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2.Click "soon" from the navigation bar.
//3. Confirm that the title "soon" is shown, as well as that the list of films is in poster format, and below the poster is the title of the film.
    @Test
    public void filmsSoonHapptPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElements(films.getSoon(), films.getAssertSoon(), "USKORO"));
    }

//    Test Case 18
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2.Click "MX4D" from the navigation bar.
//3. Confirm that the title "MX4D" is shown, as well as that the list of films is in poster format, and below the poster is the title of the film.
    @Test
    public void filmsMX4DHapptPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElements(films.getMX4D(), films.getAssertMX4D(), "MX4D"));
    }

//    Test Case 19
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2.Click "IMAX" from the navigation bar.
//3. Confirm that the title "IMAX" is shown, as well as that the list of films is in poster format, and below the poster is the title of the film.
    @Test
    public void filmsIMAXHapptPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElements(films.getIMAX(), films.getAssertIMAX(), "IMAX"));
    }

//    Test Case 20
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2. Click on the "trailers" from the navigation bar.
//3. Confirm that the title "trailer" is displayed, as well as that one of the trailers is displayed, while below is a list of trailers.
//4. Launch the trailer by clicking the "play" button.
//5. Make sure the trailer works.
//6. Select the third one from the list of trailers, start it.
//7. Confirm that the trailer is working.
    @Test
    public void filmsTrilersHappyPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElementsTrilers());

    }

//    Test Case 21
//1.Go to:  https://www.cineplexx.rs/filmovi/
//2.Click "movie archive" from the navigation bar.
//3. Confirm that the title "movie archive" is shown, as well as that the list of films is in poster format, and below the poster is the title of the film.
    @Test
    public void filmsMovieArchiveHappyPath() {
        Films films = new Films(webDriver);
        Assert.assertTrue(films.checkingNavigationElements(films.getMovieArchive(), films.getMovieArchive(), "ARHIVA FILMOVA"));
    }
}
