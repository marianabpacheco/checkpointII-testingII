package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static WebDriver driver;

    protected static final String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";

    public BasePage(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void openApp(){
        driver.get(URL);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebElement getWebElement(By locator){
        WebElement element = null;
        try{
            element = driver.findElement(locator);
        }catch(Exception e){
            System.out.println("Elemento não encontrado");
            System.out.println("Mensagem de erro: " + e);
        }
        return element;
    }
}
