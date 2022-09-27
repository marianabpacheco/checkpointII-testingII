package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountActivityPage extends BasePage {
    protected static final String username = "//*[@id=\"loginPanel\"]/form/div[1]/input"; //xpath
    protected static final String password = "//*[@id=\"loginPanel\"]/form/div[2]/input"; //xpath
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[3]/input"; //xpath
    protected static final String accountsOverview = "//*[@id=\"leftPanel\"]/ul/li[2]/a"; //xpath
    protected static final String successMessage = "//*[@id=\"accountTable\"]/tfoot/tr/td"; //xpath
    protected static final String account = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"; //xpath
    protected static final String title = "//*[@id=\"rightPanel\"]/div/div[1]/h1";
    protected static final String period = "month"; //id
    protected static final String type = "transactionType"; //id
    protected static final String allPeriod = "//*[@id=\"month\"]/option[1]";
    protected static final String allType = "//*[@id=\"transactionType\"]/option[1]";
    protected static final String go = "//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input";

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

    public void goToAccountDetails(){
        WebElement accountButton = getWebElement(By.xpath(account));
        accountButton.click();
    }

    public String getTitle(){
        WebElement accountDetailsTitle = getWebElement(By.xpath(title));
        return accountDetailsTitle.getText();
    }

    public void setOptions() throws InterruptedException {
        WebElement periodSelect = getWebElement(By.id(period));
        periodSelect.click();
        Thread.sleep(500);

        WebElement periodOption = getWebElement(By.xpath(allPeriod));
        periodOption.click();

        WebElement typeSelect = getWebElement(By.id(type));
        typeSelect.click();
        Thread.sleep(500);

        WebElement typeOption = getWebElement(By.xpath(allType));
        typeOption.click();
    }

    public void getDetails(){
        WebElement goButton = getWebElement(By.xpath(go));
        goButton.click();
    }
}
