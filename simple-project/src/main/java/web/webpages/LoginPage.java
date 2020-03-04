package web.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "login-username")
    public WebElement loginUsername;

    @FindBy(id = "login-password")
    public WebElement loginPassword;

    @FindBy(xpath = "(//SPAN[@class='ladda-label'][text()='Log In'])")
    public WebElement loginButton;

    public HomePage loginWith(String userLogin, String userPassword) throws InterruptedException {
        Thread.sleep(2000);
        loginUsername.sendKeys(userLogin);

        loginPassword.sendKeys(userPassword);
        loginButton.click();
        Thread.sleep(2500);
        return PageFactory.initElements(webDriver, HomePage.class);
    }
}
