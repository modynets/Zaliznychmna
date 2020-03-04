import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;

public class HomeTest extends BaseWebTest {

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

}
