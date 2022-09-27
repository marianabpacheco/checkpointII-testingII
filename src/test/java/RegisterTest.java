import Base.BasePage;
import Pages.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        BasePage basePage = new BasePage();
        basePage.openApp();
        driver = basePage.getDriver();
    }

    @Test
    @Tag("SmokeTest")
    public void testRegister() throws InterruptedException{
        RegisterPage page = new RegisterPage();
        Thread.sleep(10000);
        page.goToRegisterPage();
        Thread.sleep(10000);
        page.insertCustomerData("Aaron","Preston","Ap #508-5140 Malesuada St.","Kemerovo Oblast","State","3180-67510","1-895-785-0623","123456");
        page.insertUsernameAndPassword("usernameAaron12","123456","123456");
        page.createAccount();
        Thread.sleep(10000);
        String successMessage = page.getMessage();
        assertTrue(successMessage.contains("Your account was created successfully. You are now logged in."));
        System.out.println("Result: " + successMessage);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

}
