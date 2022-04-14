package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {
    private WebDriver wd;
    public Registration(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    //    header elements
    @FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement registrationBtnHeader;

    //    registrations form elements
    @FindBy(xpath = "//input[@id='nickname']")
    WebElement nicknameInput;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput1;

    @FindBy(xpath = "//input[@id='repeatpassword']")
    WebElement getPasswordInput2;

    @FindBy(xpath = "//label[contains(text(),'Muški')]")
    WebElement ganderMale;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement fNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lNameInput;

//  birthday elements
    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/form[1]/div[2]/div[1]/div[1]/div[4]/div[1]/select[1]")
    WebElement daysOfBirthday;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/form[1]/div[2]/div[1]/div[1]/div[4]/div[2]/select[1]")
    WebElement monthsOfBirthday;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/form[1]/div[2]/div[1]/div[1]/div[4]/div[3]/select[1]")
    WebElement yearsOfBirthday;

//    favorite cinema elements
    @FindBy(xpath = "//select[@id='favoriteCinema1']")
    WebElement favoriteCinema;

//  privacy policy and terms of use elements
    @FindBy(css = "div.scale-wrapper:nth-child(4) div.wrapper div.section.register:nth-child(4) div.container.separator:nth-child(5) div.row div.span12.bottom-box div.custom-checkbox:nth-child(1) > label.inline:nth-child(2)")
    WebElement privacyPolicy;

    @FindBy(xpath = "//body/div[@id='root']/div[4]/div[1]/div[4]/form[1]/div[5]/div[1]/div[1]/div[2]/label[1]")
    WebElement termsOfUse;

//    registration btn
    @FindBy(xpath = "//button[contains(text(),'Registruj se')]")
    WebElement registrationBtn;

//    assert elements
    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div[4]/div/p")
    WebElement assertRegistration;

    public void registration(String nick, String email, String paswword, String fName, String lName) {
        registrationBtnHeader.click();
        nicknameInput.sendKeys(nick);
        emailInput.sendKeys(email);
        passwordInput1.sendKeys(paswword);
        getPasswordInput2.sendKeys(paswword);
        ganderMale.click();
        fNameInput.sendKeys(fName);
        lNameInput.sendKeys(lName);
    }

    public void setDayOfBirthday(String day, String month, String year) {
        Select days = new Select(daysOfBirthday);
        days.selectByValue(day);

        Select months = new Select(monthsOfBirthday);
        months.selectByValue(month);

        Select years = new Select(yearsOfBirthday);
        years.selectByValue(year);
    }

    public void setFavoriteCinema(String cinema) {
        Select cinemas = new Select(favoriteCinema);
        cinemas.selectByVisibleText(cinema);
    }

    public void requiredBox() {
        Actions actions = new Actions(wd);
        actions.moveToElement(privacyPolicy).moveByOffset(-200, 0).click().build().perform();
        termsOfUse.click();
    }

    public void registrationFinish() {
        registrationBtn.click();
    }

    public String getAssertRegistration() {
        return assertRegistration.getText();
    }
}
