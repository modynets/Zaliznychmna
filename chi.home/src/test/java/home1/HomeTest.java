/*******************************************************************************
 * (c)  Mykola Odynets
 *******************************************************************************/

package home1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Coordinates;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.sun.jdi.Locatable;

import junit.framework.Assert;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import org.testng.annotations.*;

public class HomeTest extends TestBase {

    // Domains section

    @Title("Test Manage domains button")
    @Description("")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test001ManageDomainBtn(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);
        Thread.sleep(10000);

        home.manageDomainsBtn.click();
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "domain/overview", attr);
        System.out.println("1. Redirect  ManageDomainsBtn properly yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        Thread.sleep(10);
    }

    @Title("Test Static banner")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test002StaticBaner(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.staticBanner.click();
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "startersite/overview", attr);

        System.out.println("2. Redirect StaticBaner properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

    }

    @Title("Test Searching of domain")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "eXistingDomain", "URL"})
    public void test003SearchDomainField(String userLogin, String userPassword, String eXistingDomain, String uRL)
            throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.searchDomainField.sendKeys(eXistingDomain);
        home.searchDomainButton.click();
        Thread.sleep(500);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "domain/buy?search=" + eXistingDomain, attr);

        System.out.println("3. Search for domain properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

    }

    @Title("Test Change Renewals link")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test004ChangeRenewalsLink(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.changeRenewalsLink.click();
        Thread.sleep(500);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "account?search=Domain%20names", attr);

        System.out.println("4. Change Renewals link works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Title("Test true redirect domain  link")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test005DomainRedirectLink(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.firstExistingDomainLink.click();
        Thread.sleep(10000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(attr.startsWith(uRL + "domain"), attr.endsWith("manage"));

        System.out.println("5. Redirect domain  link works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Title("Test true redirect 'manage Startersite' button")
    @Test(enabled = false) // till Startersite feature do not ready
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test006ManageStartersiteButton(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.firstMangeStartersiteLink.click();
        Thread.sleep(500);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(attr.startsWith(uRL + "startersite"), attr.endsWith("configure"));

        System.out.println("6. Manage Startersite button works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // "Need a little help?" section

    @Title("Test Contact Our Support Team button")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test007ContactSupportBtn(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.contactSupportBtn.click();
        Thread.sleep(500);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "support/new", attr);

        System.out.println("7. Contact support button works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Title("Test Show Telephone Support PIN button")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "tPin",})
    public void test008PhonePin(String userLogin, String userPassword, String expectedPin) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.showTelSupportPinBtn.click();
        Thread.sleep(3000);
        String pin = home.getTelephonePin();
        System.out.println("pin=" + pin);
        System.out.println("expectedPin=" + expectedPin);
        Thread.sleep(500);
        Assert.assertEquals(pin, expectedPin);
        System.out.println("8. Telephone support PIN shows properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // "Payments & Billing" section

    @Title("Test View All Your Services link")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test009AllYourServicesLink(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.viewAllYourServicesLink.click();
        Thread.sleep(3000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "account", attr);

        System.out.println("9. All Your Services link works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Title("Test Manage Payments and Billing button")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test010ManagePaymentsAndBillingBtn(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.managePaymentsAndBillingBtn.click();
        Thread.sleep(3000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertTrue(attr.startsWith(uRL + "account/payments-and-billing"));

        System.out.println(
                "10. Manage Payments and Billing button works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Title("Test Edit Your Details link")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test011EditYoutDetailsLink(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.editYourDetailsLink.click();
        Thread.sleep(3000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "account/personal-details", attr);

        System.out.println("11. Edit Your Details link works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // "Refer A Friend" section

    @Title("Test Account/Refer a friend link")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test012AccountReferAFriendLink(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.accountRefferAFriendLink.click();
        Thread.sleep(3000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "account/referrals", attr);

        System.out.println(
                "12. Account/Refer a friend link works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Title("Test View Active Refferals button")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test013ViewActiveReferralsBtn(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.viewActiveRefferalsBtn.click();
        Thread.sleep(3000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "account/referrals", attr);

        System.out.println(
                "13. View Active Refferals button works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // Shared Hosting For your Website Section

    @Title("Test Shared Hosting For your Website Section")
    @Description("Test Shared Hosting For your Website Section")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test014SharedhostingForYourWebsiteSection(String userLogin, String userPassword, String uRL)
            throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.clicksetUpHostingNowBtn();

        Thread.sleep(5000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "shared-hosting/buy", attr);

        System.out.println(
                " 14. Redirect to Shared Hosting For your Website Section works properly  yyyyyyyyyyy");
    }

    // Get a Dedicated Server Section

    @Title("Test Get a Dedicated Server Section")
    @Description("")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test015GetADedicatedServerSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.clickgetYourOwnServerNowBtn();

        Thread.sleep(5000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "dedicated-server/buy", attr);

        System.out.println("15. Redirect to Dedicated Server Section works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // Get a VPS Cloud Section

    @Title("Test Get a VPS Cloud Section")
    @Description("")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test016GetAVPSCloudSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.clickGetAVPSCloudNowBtn();

        Thread.sleep(5000);
        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);

        Assert.assertEquals(attr.startsWith(uRL + "vps"), attr.endsWith("/buy"));
        Thread.sleep(5000);
        System.out.println("16. redirect to VPS Cloud Section works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // Website Builder Section

    @Title("Test Website Builder Section")
    @Description("")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test017WebsiteBuilderSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);

        home.clickStartBuildingYourSiteNowBtn();

        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "websitebuilder/buy", attr);
        Thread.sleep(5000);
        System.out.println("17. Redirect to Website Builder Section works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // "Business Hosting For Your Website" section

    @Title("Test Business Hosting Section")
    @Description("")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test018BusinessHostingSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);
        Thread.sleep(10000);
        home.clicksetUpBusinessHostingNowBtn();

        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "business-hosting/buy", attr);
        Thread.sleep(5000);
        System.out.println("18. Redirect to Business Hosting Section works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // "SSL Certificates" section

    @Title("Test SSL Certificates Section")
    @Description("")
    @Test(enabled = true, priority = 3)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test019SSLSertificatesSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);
        Thread.sleep(10000);
        home.clicksetUpSSLCertificatesBtn();

        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "ssl-certificate/buy", attr);
        Thread.sleep(5000);
        System.out.println("19. Redirect to SSL Certificates Section works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // "Get a SSD VPS" section

    @Title("Test Get a SSD VPS Section")
    @Description("")
    @Test(enabled = true)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test020GetASSDVPSSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);

        Thread.sleep(10000);
        home.clickgetASSDVPSNowBtn();

        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "vps-fixed/buy", attr);
        Thread.sleep(5000);
        System.out.println("20. Redirect to SSD VPS Section  works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    // // "Get Optimised WordPress Hosting" section

    @Title("Test Get Optimised Wordpress Hosting Section")
    @Description("")
    @Test(enabled = true, priority = 2)
    @Parameters({"lUsername", "lPassword", "URL"})
    public void test021GetWordPressSection(String userLogin, String userPassword, String uRL) throws InterruptedException {

        loginPage.loginWith(userLogin, userPassword);
        Thread.sleep(10000);
        home.clickorderWordPressNowBtn();

        String attr = webDriver.getCurrentUrl();
        System.out.println(attr);
        Assert.assertEquals(uRL + "wordpress/buy", attr);
        Thread.sleep(5000);
        System.out.println("21. Redirect to Wordpress Hosting Section works properly  yyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

}