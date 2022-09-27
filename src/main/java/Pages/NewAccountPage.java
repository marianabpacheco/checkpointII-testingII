package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewAccountPage extends BasePage {
    protected static final String username = "//*[@id=\"loginPanel\"]/form/div[1]/input"; //xpath
    protected static final String password = "//*[@id=\"loginPanel\"]/form/div[2]/input"; //xpath
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[3]/input"; //xpath
    protected static final String newAccount = "//*[@id=\"leftPanel\"]/ul/li[1]/a"; //xpath
    protected static final String checkingType = "type"; //id
    protected static final String savingsType = "//*[@id=\"type\"]/option[2]";
    protected static final String createNewAccount = "//*[@id=\"rightPanel\"]/div/div/form/div/input";
    protected static final String successMessage = "//*[@id=\"rightPanel\"]/div/div/p[1]";

    public void login(String name, String loginPassword){
        WebElement usernameInput = getWebElement(By.xpath(username));
        usernameInput.clear();
        usernameInput.sendKeys(name);

        WebElement passwordInput = getWebElement(By.xpath(password));
        passwordInput.clear();
        passwordInput.sendKeys(loginPassword);

        WebElement loginButton = getWebElement(By.xpath(login));
        loginButton.click();
    }

    public void goToNewAccountPage(){
        WebElement newAccountButton = getWebElement(By.xpath(newAccount));
        newAccountButton.click();
    }

    public void selectSavingsType() throws InterruptedException {
        WebElement checkingOption = getWebElement(By.id(checkingType));
        checkingOption.click();
        Thread.sleep(100);
        WebElement savingsOption = getWebElement(By.xpath(savingsType));
        savingsOption.click();
    }

    public void createNewSavingsAccount(){
        WebElement createNewAccountButton = getWebElement(By.xpath(createNewAccount));
        createNewAccountButton.click();
    }

    public String getMessage(){
        WebElement message = getWebElement(By.xpath(successMessage));
        return message.getText();
    }

}
