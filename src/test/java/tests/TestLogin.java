package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Login;
import pages.Registration;
import utils.PropertiesReader;
import utils.RandomEmail;

import java.time.Duration;

public class TestLogin {
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

//    Test Case 4
//1.Go to: https://www.cineplekk.rs/
//2.Click the "login" button at the top of the page.
//3.Enter "automation.Testing123qa@gmail.com" in the email field.
//4.Enter "automationQA123" in the password field.
//5.Click on the "login" red button.
//6.Confirm that the user is logged in (that the user's name is at the top of the page and the sign out button).
//7.Click the "sign out" button.
//8.Confirm that the user is logged out.
    @Test
    public void loginUserHappyPath() {
        Login login = new Login(webDriver);
        login.loginUser("automation.Testing123qa@gmail.com", "automationQA123");
        Assert.assertTrue(login.getLogoutBtn().contains("Odjava"));
        login.logoutUser();
        Assert.assertTrue(login.getLoginBtnHeader().contains("Prijava"));

    }

    @AfterClass
    public void close() {
        webDriver.close();
    }
}
