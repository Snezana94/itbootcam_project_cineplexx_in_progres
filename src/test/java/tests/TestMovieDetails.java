package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Login;
import pages.MovieDetails;
import utils.PropertiesReader;

import java.time.Duration;

public class TestMovieDetails {
    private WebDriver webDriver;
    private Faker faker;

    @BeforeSuite
    public void beforSuit() {
        System.out.println("Home Page Suit");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforClass() {
//        System.setProperty("webdriver.chrome.driver", PropertiesReader.fetchProperty("WEBDRIVER.CHROME.PATH"));
        webDriver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
        webDriver.get("https://www.cineplexx.rs/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().getPageLoadTimeout();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//  Test Case 8
//1.Go to: https://www.cineplexx.rs/
//2.From the "top movies" section, select the first movie.
//3.Confirm that the movie information is now displayed.
//4.Click on the "play" button and start the trailer.
//5.Confirm that the trailer is working.
//6.Stop the trailer.
//7.Scroll down and make sure there is a section with times and halls of screenings of this film.
    @Test
    public void filmDetailsHappyPath() throws InterruptedException {
        MovieDetails movieDetails = new MovieDetails(webDriver);
        movieDetails.clickFilmDetails();
        Assert.assertTrue(movieDetails.assertfilmDetails().contains("NAZAD NA REPERTOAR"));
        Thread.sleep(2000);
        movieDetails.playTreiler();
        Thread.sleep(2000);
        Assert.assertTrue(movieDetails.getTreiler().getAttribute("class").contains("bmpui-ui-pla"));
        Thread.sleep(2000);
        movieDetails.playTreiler();
        Thread.sleep(2000);
        Assert.assertTrue(movieDetails.getTreiler().getAttribute("class").contains("bmpui-off"));

        Assert.assertTrue(movieDetails.assertTimesAndHalls().contains("VREMENSKI RASPORED SVIH PROJEKCIJA"));
    }

    @AfterClass
    public void close() {
        webDriver.close();
    }
}
