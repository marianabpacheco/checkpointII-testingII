import Base.BasePage;
import Pages.TransferFundsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TransferFundsTest {

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
        TransferFundsPage page = new TransferFundsPage();
        Thread.sleep(20000);
        page.login("usernameAaron","123456");
        page.goToTransferFundsPage();
        Thread.sleep(10000);
        page.insertAmount("10");
        page.setAcounts();
        page.transferFunds();
        Thread.sleep(10000);
        String successMessage = page.getMessage();
        assertTrue(successMessage.contains("Transfer Complete!"));
        System.out.println("Result: " + successMessage);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}
