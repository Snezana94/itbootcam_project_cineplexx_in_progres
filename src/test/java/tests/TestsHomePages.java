package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.PropertiesReader;

import java.time.Duration;
import java.util.ArrayList;

public class TestsHomePages {
    private WebDriver webDriver;

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

//    Test Case 1
//1.Go to: https://www.cineplekk.rs/
//2.Click on the "here" link at the top of the page.
//3.Confirm that a new tab with "Privacy Policy and General Terms of Personal Data Protection" has been opened.
//4.Close the newly opened tab.
//5.Click the "ok" button at the top of the page.
//6.Confirm that the cookies have been accepted, ie that the bar at the top has disappeared.
    @Test
    public void cookiesHappyPath() {
        HomePage homePage = new HomePage(webDriver);
        homePage.viewCookies();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://www.cineplexx.rs/media/rs/services/pravila_o_privatnosti/Politika_privatnosti_i_opsti_uslovi_za_tite_podataka_o_li_1.pdf"));
        webDriver.close();

        for(String winHandle:webDriver.getWindowHandles()){
           webDriver.switchTo().window(winHandle);
        }

        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://www.cineplexx.rs"));
        homePage.acceptCookies();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("#"));

    }

//    Test Case 2
//1.Go to: https://www.cineplekk.rs/
//2.Click on the dropdown arrow and then select the Chinaplex Promenade from the one favorite cinema.
//3.Click the "ok" button at the top of the page.
//4.Click on "films" in the navigation bar.
//5.Confirm that "Cinemaplex Promenade" is written in the "cinemas" field.
    @Test
    public void favoriteCinemaHappyPath() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        homePage.addFavoriteCinema();
        Assert.assertTrue(homePage.assertFavoriteCinema().contains("Cineplexx Promenada"));
    }

//    Test Case 5
//1.Go to: https://www.cineplekk.rs/
//2.Click on "movies" in the navigation menu.
//3.Confirm current url "https://www.cineplexx.rs/filmovi/".
//4.Click on "events" in the navigation menu.
//5.Confirm current url "https://www.cineplexx.rs/dogadjaji/".
//6.Click on "cinemas" in the navigation menu.
//7.Confirm current url "https://www.cineplexx.rs/bioskopi/".
//8.Click on "membership" in the navigation menu.
//9.Confirm current url "https://www.cineplexx.rs/clanstvo/".
//10.Click on "news" in the navigation menu.
//11.Confirm current url "https://www.cineplexx.rs/novosti/".
    @Test
    public void navBarHappyPath() {
        HomePage homePage = new HomePage(webDriver);

        homePage.navFilms();
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://www.cineplexx.rs/filmovi/"));

        homePage.navEvents();
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://www.cineplexx.rs/dogadjaji/"));

        homePage.navCinema();
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://www.cineplexx.rs/bioskopi/"));

        homePage.navMembership();
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://www.cineplexx.rs/clanstvo/"));

        homePage.navNews();
        Assert.assertTrue(webDriver.getCurrentUrl().equals("https://www.cineplexx.rs/novosti/"));
    }

//    Test Case 6
//1.Go to: https://www.cineplekk.rs/
//2.Enter the text "MX4D" in the search field and then click on the search button.
//3.Confirm that movies are included in the search results (search is successful if the search result is more than zero).
    @Test
    public void searchHappyPath() {
        HomePage homePage = new HomePage(webDriver);
        homePage.search("MX4D");
        Assert.assertTrue(homePage.getResult().contains("SVI REZULTATI"));
    }

//    Test Case 7
//1.Go to: https://www.cineplekk.rs/
//2.Find the navigation menu second in order, then click on "in cinema".
//3.Confirm that the section below now contains other films compared to the previous state.
//4.Find the navigation menu second in order, then click on "soon".
//5.Confirm that the section below now contains other films compared to the previous state.
//6.Find the navigation menu second in order, then click on "MX4D".
//7.Confirm that the section below now contains other films compared to the previous state.
//8.Find the navigation menu second in order, then click on "IMAX".
//9.Confirm that the section below now contains other films compared to the previous state.
//10.Find the navigation menu second in order, then click on "events".
//11.Confirm that the section below now contains other films compared to the previous state.
//12.Find the navigation menu second in order, then click on "opera&ballet".
//13.Confirm current url "https://www.cineplexx.rs/dogadjaji/eventreihe/opera-i-balet/".
    @Test
    public void navBar2HappyPath() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        SoftAssert sa = new SoftAssert();

        homePage.nav2TopFilms();
        sa.assertTrue(homePage.assertTopFilms().contains("active"), "The home page - top films should contain class 'active'");

        homePage.nav2InCinema();
        sa.assertTrue(homePage.assertInCinema().contains("active"), "The home page - in cinema should contain class 'active'");

        homePage.nav2Soon();
        sa.assertTrue(homePage.assertSoon().contains("active"), "The home page - soon should contain class 'active'");

        homePage.nav2Mx4d();
        sa.assertTrue(homePage.assertMx4d().contains("active"), "The home page - mx4d should contain class 'active'");

        homePage.nav2Imax();
        sa.assertTrue(homePage.assertImax().contains("active"), "The home page - imax should contain class 'active'");

        homePage.nav2Events();
        sa.assertTrue(homePage.assertEvents().contains("active"), "The home page - events should contain class 'active'");

        homePage.nav2OperaBalet();
        Thread.sleep(2000);
        sa.assertTrue(webDriver.getCurrentUrl().contains("https://www.cineplexx.rs/dogadjaji/eventreihe/opera-i-balet/"), "The curent url should be https://www.cineplexx.rs/dogadjaji/eventreihe/opera-i-balet/ ");

        sa.assertAll();
    }

//    Test Case 7
    @Test
    public void nav2WithListChild() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        Assert.assertTrue(homePage.nav2WithChild());
    }

//    Test Case 9
//1.Go to: https://www.cineplekk.rs/
//2.Scroll to the bottom of the page, find the Facebook icon and click on it.
//3.Confirm that a new tab has opened with the url "https://www.facebook.com/sharer.php?u=https%3A%2F%2Fwww.cineplexx.rs%2F".
//4.Shut down the newly opened tab, then click on the Twitter icon.
//5.Confirm that a new tab has opened with the url "https://twitter.com/i/flow/login".
    @Test
    public void socialNetworksHappyPath() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        SoftAssert sa = new SoftAssert();

        homePage.goToFacebook();
        Thread.sleep(2000);
        sa.assertTrue(webDriver.getCurrentUrl().contains("https://www.facebook.com/login.php?skip_api_login=1&api_key=966242223397117&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fsharer.php%3Fu%3Dhttps%253A%252F%252Fwww.cineplexx.rs%252F&cancel_url=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Fclose_window%2F%3Fapp_id%3D966242223397117%26connect%3D0%23_%3D_&display=popup&locale=en_US"), "Eror with FB");

        webDriver.get("https://www.cineplexx.rs");
        homePage.goToTwitter();
        Thread.sleep(2000);
        sa.assertTrue(webDriver.getCurrentUrl().contains("https://twitter.com/i/flow/login"), "Eror with Twitter");

        sa.assertAll();
    }



    @AfterClass
    public void close() {
        webDriver.quit();
    }


}
