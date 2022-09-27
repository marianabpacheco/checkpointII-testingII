import Base.BasePage;
import Pages.NewAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewAccountTest {

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
        NewAccountPage page = new NewAccountPage();
        Thread.sleep(20000);
        page.login("usernameAaron","123456");
        page.goToNewAccountPage();
        Thread.sleep(10000);
        page.selectSavingsType();
        page.createNewSavingsAccount();
        Thread.sleep(10000);
        String successMessage = page.getMessage();
        assertTrue(successMessage.contains("Congratulations, your account is now open."));
        System.out.println("Result: " + successMessage);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}
