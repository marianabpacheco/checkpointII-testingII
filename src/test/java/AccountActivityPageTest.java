
import Base.BasePage;
import Pages.AccountActivityPage;
import Pages.AccountsOverviewPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountActivityPageTest {
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
        AccountActivityPage page = new AccountActivityPage();
        Thread.sleep(20000);
        page.login("usernameAaron","123456");
        page.goToAccountsOverview();
        Thread.sleep(10000);
        String successMessage = page.getMessage();
        assertTrue(successMessage.contains("Balance includes deposits that may be subject to holds"));
        System.out.println("Result: " + successMessage);
        page.goToAccountDetails();
        Thread.sleep(2000);
        String title = page.getTitle();
        assertTrue(title.contains("Account Details"));
        page.setOptions();
        page.getDetails();
        System.out.println("Teste concluído com sucesso!");
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

}