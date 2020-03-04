import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import web.webpages.HomePage;
import web.webpages.LoginPage;

public class BaseWebTest {
    protected static WebDriver webDriver;
    protected HomePage home;
    protected LoginPage loginPage;

    @BeforeMethod
    @Parameters({"browser", "URL", "lUsername", "lPassword"})

    public void setup(String browser, String URL, String lUsername, String lPassword) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            webDriver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            webDriver = new SafariDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        webDriver.get(URL);
        Thread.sleep(1000);


        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        home = PageFactory.initElements(webDriver, HomePage.class);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void killDriverInstance() {
        webDriver.quit();
    }

}
