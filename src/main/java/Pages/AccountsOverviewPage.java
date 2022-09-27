package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountsOverviewPage extends BasePage {
    protected static final String username = "//*[@id=\"loginPanel\"]/form/div[1]/input"; //xpath
    protected static final String password = "//*[@id=\"loginPanel\"]/form/div[2]/input"; //xpath
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[3]/input"; //xpath
    protected static final String accountsOverview = "//*[@id=\"leftPanel\"]/ul/li[2]/a"; //xpath
    protected static final String successMessage = "//*[@id=\"accountTable\"]/tfoot/tr/td"; //xpath


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

    public void goToAccountsOverview(){
        WebElement accountsOverviewButton = getWebElement(By.xpath(accountsOverview));
        accountsOverviewButton.click();
    }

    public String getMessage(){
        WebElement message = getWebElement(By.xpath(successMessage));
        return message.getText();
    }
}
