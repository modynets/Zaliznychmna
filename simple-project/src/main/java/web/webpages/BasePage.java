package web.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {


    protected static WebDriver webDriver;
    public JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;

    public BasePage(WebDriver webDriver) {
        BasePage.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

}

