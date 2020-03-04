package web.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    // "Domains" section
    @FindBy(xpath = "(//h3[@class='panel-toggle'][contains(.,'Domains')])") //
    public WebElement domainsSectionPopUp;

    @FindBy(xpath = "(//IMG[@src='/static/banner-test.png'])") //
    public WebElement staticBanner;

    @FindBy(xpath = "(//INPUT[@class='hero-input form-control'])")//
    public WebElement searchDomainField;

    @FindBy(xpath = "(//BUTTON[@class='btn btn-primary hero-input-btn search'][text()='Search'])") //
    public WebElement searchDomainButton;

    @FindBy(xpath = "(//a[@class='btn btn-primary' and contains(.,'Manage') and contains(.,'domains')])") //
    public WebElement manageDomainsBtn;

    @FindBy(xpath = "(//A[@class='btn btn-link fr' and contains (text(), 'Change Renewals')])") //
    public WebElement changeRenewalsLink;

    @FindBy(xpath = "((//A[1][contains(@href, '/domain')][contains(@href, 'manage')][@class='manage-link ellipsis'])[1])")
    //
    public WebElement firstExistingDomainLink;

    @FindBy(xpath = "((//A[@class='btn btn-sm btn-warning btn-warning-bootstrap'])[1])") //
    public WebElement firstMangeStartersiteLink;

    @FindBy(xpath = "((//A[@class='btn btn-sm btn-success btn-business-card-activate ladda-button' and contains (., 'Activate Free StarterSite')])[1])")
    //
    public WebElement firstActivateFreeStartersiteLink;

    // "Need a little help?" section

    @FindBy(xpath = "(//h3[@class='panel-toggle'][contains(.,'Need a little help?')])")//
    public WebElement needALittleHelpSectionPopUp;

    @FindBy(xpath = "(//A[@class='btn btn-primary'][text()='Contact Our Support Team'])") //
    public WebElement contactSupportBtn;

    @FindBy(xpath = "(//BUTTON[@class='btn btn-primary support-pin-btn'])") //
    public WebElement showTelSupportPinBtn;

    public String getTelephonePin() {
        showTelSupportPinBtn.click();
        WebElement pin1 = webDriver.findElement(By.xpath("//*[@class='support-pin hidden']"));

        String pin = pin1.getText();
        if (pin != "") {
            showTelSupportPinBtn.click();
            WebElement pin2 = webDriver.findElement(By.xpath("//*[@class='support-pin hidden']"));
            pin = pin2.getText();
        }
        return pin;
    }
    // "Payments & Billing" section

    @FindBy(xpath = "(//h3[@class='panel-toggle'][contains(.,'Payments & Billing')])") //
    public WebElement paymentsAndBillingSectionPopUp;

    @FindBy(xpath = "(//A[@class=''][text()='View All Your Services'])")//
    public WebElement viewAllYourServicesLink;

    @FindBy(xpath = "(//A[@class='btn btn-link fr'][text()='Edit Your Details'])")//
    public WebElement editYourDetailsLink;

    @FindBy(xpath = "(//A[@class='btn btn-primary'and contains(text(),'Manage Payments ')])")//
    public WebElement managePaymentsAndBillingBtn;

    // "Refer A Friend" section

    @FindBy(xpath = "(//h3[@class='panel-toggle'][contains(.,'Refer A Friend')])")//
    public WebElement referAfriendSectionPopUp;

    @FindBy(xpath = "(//A[@href='/account/referrals'][text()='Account/Refer a Friend'])")//
    public WebElement accountRefferAFriendLink;

    @FindBy(xpath = "(//A[@href='/account/referrals'][text()='View Active Referrals'])")//
    public WebElement viewActiveRefferalsBtn;

    // "Shared Hosting For your Website Section" section

    @FindBy(xpath = "(//h3[@class='panel-toggle'][contains(.,'Shared Hosting For Your Website')])")//
    public WebElement sharedHostingForYourWebsiteSectionPopUp;

    @FindBy(xpath = "(//A[@class='btn btn-primary'][contains (text(),'Set up Hosting Now')][@href='shared-hosting/buy'])")
//
    public WebElement setUpHostingNowBtn;

    public HomePage clicksetUpHostingNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", sharedHostingForYourWebsiteSectionPopUp);
        Thread.sleep(3000);
        if (setUpHostingNowBtn.isDisplayed()) {

            setUpHostingNowBtn.click();
        } else
            sharedHostingForYourWebsiteSectionPopUp.click();
        Thread.sleep(3000);
        setUpHostingNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "Get a Dedicated Server" section

    @FindBy(xpath = "(//h3[@class='panel-toggle'][contains(.,'Get a Dedicated Server')])")  //
    public WebElement getADedicatedServerSectionPopUp;

    @FindBy(xpath = "(//A[@class='btn btn-primary'][contains (text(),'Get Your Own Server Now')])") //
    public WebElement getYourOwnServerNowBtn;

    public HomePage clickgetYourOwnServerNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", getADedicatedServerSectionPopUp);
        Thread.sleep(3000);
        if (getYourOwnServerNowBtn.isDisplayed()) {


            getYourOwnServerNowBtn.click();
        } else
            getADedicatedServerSectionPopUp.click();
        Thread.sleep(3000);
        getYourOwnServerNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "Get a VPS Cloud" section

    @FindBy(xpath = "(//h3[@class='panel-toggle'and contains(.,'Get') and contains(., 'Cloud' )])") //
    public WebElement getAVPSCloudSectionPopUp;

    @FindBy(xpath = "(//A[@class='btn btn-primary'][contains (text(),' Cloud ')])") //
    public WebElement getAVPSCloudNowBtn;

    public HomePage clickGetAVPSCloudNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", getAVPSCloudSectionPopUp);
        Thread.sleep(3000);
        if (getAVPSCloudNowBtn.isDisplayed()) {

            getAVPSCloudNowBtn.click();
        } else
            getAVPSCloudSectionPopUp.click();
        Thread.sleep(3000);
        getAVPSCloudNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "Website Builder" section

    @FindBy(xpath = "//h3[@class='panel-toggle'][contains(.,'Website Builder')]") //
    public WebElement websiteBuilderSectionPopUp;

    @FindBy(xpath = "//a[@href='/websitebuilder/buy'][contains(.,'Start Building Your Site Now')]") //
    public WebElement startBuildingYourSiteNowBtn;

    public HomePage clickStartBuildingYourSiteNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", websiteBuilderSectionPopUp);
        if (startBuildingYourSiteNowBtn.isDisplayed()) {

            startBuildingYourSiteNowBtn.click();
        } else
            websiteBuilderSectionPopUp.click();
        Thread.sleep(3000);
        startBuildingYourSiteNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "Business Hosting For Your Website" section

    @FindBy(xpath = "//h3[@class='panel-toggle'][contains(.,'Business Hosting For Your Website')]") //
    public WebElement businessHostingSectionPopUp;

    @FindBy(xpath = "//A[@class='btn btn-primary'][contains (text(),'Set up Hosting Now')][@href='business-hosting/buy']")
//
    public WebElement setUpBusinessHostingNowBtn;

    public HomePage clicksetUpBusinessHostingNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", businessHostingSectionPopUp);
        Thread.sleep(3000);
        if (setUpBusinessHostingNowBtn.isDisplayed()) {


            setUpBusinessHostingNowBtn.click();
        } else
            businessHostingSectionPopUp.click();
        Thread.sleep(3000);
        setUpBusinessHostingNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "SSL Certificates" section

    @FindBy(xpath = "//h3[@class='panel-toggle'][contains(.,'SSL Certificates')]")//
    public WebElement sSLSertificatesSectionPopUp;

    @FindBy(xpath = "//A[@href='/ssl-certificate/buy'][contains(.,'Get Started Now')]")//
    public WebElement setUpSSLCertificatesBtn;

    public HomePage clicksetUpSSLCertificatesBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", sSLSertificatesSectionPopUp);
        Thread.sleep(3000);
        if (setUpSSLCertificatesBtn.isDisplayed()) {


            setUpSSLCertificatesBtn.click();
        } else
            sSLSertificatesSectionPopUp.click();
        Thread.sleep(3000);
        setUpSSLCertificatesBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "Get a SSD VPS" section

    @FindBy(xpath = "//h3[@class='panel-toggle'][contains(.,'Get a SSD VPS')]")  //
    public WebElement getASSDVPSSectionPopUp;

    @FindBy(xpath = "//A[@href='/vps-fixed'][contains(.,'Get an SSD VPS Now')]") //
    public WebElement getASSDVPSNowBtn;

    public HomePage clickgetASSDVPSNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", getASSDVPSSectionPopUp);
        Thread.sleep(3000);
        if (getASSDVPSNowBtn.isDisplayed()) {


            getASSDVPSNowBtn.click();
        } else
            getASSDVPSSectionPopUp.click();
        Thread.sleep(3000);
        getASSDVPSNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }

    // "Get Optimised WordPress Hosting" section

    @FindBy(xpath = "//h3[@class='panel-toggle'][contains(.,'Get Optimised WordPress Hosting')]") //
    public WebElement getWordpressSectionPopUp;

    @FindBy(xpath = "//A[@href='/wordpress'][contains(.,'Order your WordPress Hosting Now')]") //
    public WebElement orderWordPressNowBtn;

    public HomePage clickorderWordPressNowBtn() throws InterruptedException {
        webDriver.manage().window().maximize();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", getWordpressSectionPopUp);
        Thread.sleep(3000);
        if (orderWordPressNowBtn.isDisplayed()) {


            orderWordPressNowBtn.click();
        } else
            getWordpressSectionPopUp.click();
        Thread.sleep(3000);
        orderWordPressNowBtn.click();

        return PageFactory.initElements(webDriver, HomePage.class);
    }
}
