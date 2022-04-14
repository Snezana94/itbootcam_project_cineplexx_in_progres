package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver wd;
    public Login(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

//    header elements
    @FindBy(xpath = "//a[contains(text(),'Prijava')]")
    WebElement loginBtnHeader;

//    login elements
    @FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement emailInput;

    @FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/form[1]/div[3]/input[1]")
    WebElement passwordInput;

    @FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/form[1]/button[1]")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Odjava')]")
    WebElement logoutBtn;

    public String getLogoutBtn() {
        return logoutBtn.getText();
    }

    public String getLoginBtnHeader() {
        return loginBtnHeader.getText();
    }

    public void loginUser(String email, String password) {
        loginBtnHeader.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void logoutUser() {
        logoutBtn.click();
    }
}
