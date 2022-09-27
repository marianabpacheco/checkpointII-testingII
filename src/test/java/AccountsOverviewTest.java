import Base.BasePage;
import Pages.AccountsOverviewPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AccountsOverviewTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        BasePage basePage = new BasePage();
        basePage.openApp();
        driver = basePage.getDriver();
    }

    @Test
    @Tag("Regression")
    public void testNewAccount() throws InterruptedException{
        AccountsOverviewPage page = new AccountsOverviewPage();
        Thread.sleep(20000);
        page.login("usernameAaron","123456");
        page.goToAccountsOverview();
        Thread.sleep(10000);
        String successMessage = page.getMessage();
        assertTrue(successMessage.contains("Balance includes deposits that may be subject to holds"));
        System.out.println("Result: " + successMessage);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}
