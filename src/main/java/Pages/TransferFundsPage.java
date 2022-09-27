package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferFundsPage extends BasePage {
    protected static final String username = "//*[@id=\"loginPanel\"]/form/div[1]/input"; //xpath
    protected static final String password = "//*[@id=\"loginPanel\"]/form/div[2]/input"; //xpath
    protected static final String login = "//*[@id=\"loginPanel\"]/form/div[3]/input";
    protected static final String transferFunds = "//*[@id=\"leftPanel\"]/ul/li[3]/a"; //xpath
    protected static final String amount = "amount"; //id
    protected static final String fromAccount = "fromAccountId"; //id
    protected static final String toAccount = "toAccountId"; //id
    protected static final String optionFromAccount = "//*[@id=\"fromAccountId\"]/option[1]";
    protected static final String optionToAccount = "//*[@id=\"toAccountId\"]/option[2]";
    protected static final String transferBtn = "//*[@id=\"rightPanel\"]/div/div/form/div[2]/input";
    protected static final String successMessage = "//*[@id=\"rightPanel\"]/div/div/h1";

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

    public void goToTransferFundsPage(){
        WebElement transferFundsButton = getWebElement(By.xpath(transferFunds));
        transferFundsButton.click();
    }

    public void insertAmount(String value){
        WebElement amountInput = getWebElement(By.id(amount));
        amountInput.clear();
        amountInput.sendKeys(value);
    }

    public void setAcounts() throws InterruptedException {
        WebElement fromAccountsInput = getWebElement(By.id(fromAccount));
        fromAccountsInput.click();
        Thread.sleep(500);
        WebElement optionInput = getWebElement(By.xpath(optionFromAccount));
        optionInput.click();

        WebElement toAccountsInput = getWebElement(By.id(toAccount));
        toAccountsInput.click();
        Thread.sleep(500);
        WebElement optionToInput = getWebElement(By.xpath(optionToAccount));
        optionToInput.click();

    }

    public void transferFunds(){
        WebElement transferFundsButton = getWebElement(By.xpath(transferBtn));
        transferFundsButton.click();
    }

    public String getMessage(){
        WebElement message = getWebElement(By.xpath(successMessage));
        return message.getText();
    }

}
