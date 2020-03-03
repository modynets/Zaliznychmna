/*******************************************************************************
 * (c)  Mykola Odynets
 *******************************************************************************/

package home1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    protected static WebDriver webDriver;
    protected Home home;
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
        home = PageFactory.initElements(webDriver, Home.class);
        webDriver.manage().window().maximize();
    }

    // open pop-up check
/*
	public boolean popUpShowsProperly(WebElement element) {
		Actions actions = new Actions(webDriver);
		String clasofElement = element.getClass().toString();
		if (clasofElement.equals("island closed")) {
			element.click();
			String clasofElement1 = element.getClass().toString();
			if (clasofElement1.equals("closed"));
			return true;
		}
		return true;
		if (clasofElement.equals("closed")) {
			element.click();
			String clasofElement2 = element.getClass().toString();
			if (clasofElement2.equals("island closed"));
			return true;
		}
		return true;
		
		
	
	}

	*/


    @AfterMethod
    public void killDriverInstance() {
        webDriver.quit();

    }

}
