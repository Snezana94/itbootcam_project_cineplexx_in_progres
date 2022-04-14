package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.Registration;
import utils.PropertiesReader;
import utils.RandomEmail;

import java.time.Duration;

public class TestRegistration {
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

//    Test Case 3
// 1.Go to: https://www.cineplekk.rs/
//2.Click the "registration" button at the top of the page.
//3.Enter "automationQA" in the nickname field.
//4.Enter "automation.Testing123qa@gmail.com" in the email field.
//5.Enter "automationQA123" in the password fields.
//6.Choose male.
//7.Enter "Automation" in the first name field.
//8.Enter "Testing" in the last name field.
//9.For the birthday, choose "01" from the drop-down menu, for the month "02", for the year "1994".
//10..Click on the dropdown arrow and then select the Chinaplex Promenade from the one favorite cinema.
//11.Check the boxes to comply with the privacy policy and terms of use.
//12.Click on the "registration" red button.
//13.Confirm that the email has received a message to complete the registration, then click on "activate" in the message.
//14.Confirm that the message "successful registration" is displayed on the screen.
//    @Test
//    public void registrationHappyPath() {
//        Registration registration = new Registration(webDriver);
////        this data was used
//        registration.registration("automationQA", "automation.Testing123qa@gmail.com",
//                "automationQA123", "Automation", "Testing" );
//        registration.setDayOfBirthday("01", "02", "1994");
//        registration.setFavoriteCinema("Cineplexx Promenada");
//        registration.requiredBox();
//        registration.registrationFinish();
//        Assert.assertTrue(registration.getAssertRegistration().contains("Uspešno ste se registrovali!"));
//    }

    @DataProvider (name = "dpRegistration")
    public Object[][] users() {
        faker = new Faker();
        return new Object[][] {
                {faker.name().username()},
                {faker.name().username()},
                {faker.name().username()}
        };
    }

    @Test(dataProvider = "dpRegistration")
    public void registrationHappyPathDataProvider(String name) {
        Registration registration = new Registration(webDriver);
        registration.registration(name, RandomEmail.getRandomUserEmail(),
                "automationQA123", "Automation", "Testing" );
        registration.setDayOfBirthday("01", "02", "1994");
        registration.setFavoriteCinema("Cineplexx Promenada");
        registration.requiredBox();
        registration.registrationFinish();
        Assert.assertTrue(registration.getAssertRegistration().contains("Uspešno ste se registrovali!"));
    }

    @AfterClass
    public void close() {
        webDriver.close();
    }
}
