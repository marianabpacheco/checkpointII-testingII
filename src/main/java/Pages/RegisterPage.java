package Pages;
import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    protected static final String register = "//*[@id=\"loginPanel\"]/p[2]/a"; //xpath
    protected static final String firstName = "customer.firstName"; // id
    protected static final String lastName = "customer.lastName"; // id
    protected static final String address = "customer.address.street"; //id
    protected static final String city = "customer.address.city"; //id
    protected static final String state = "customer.address.state"; //id
    protected static final String zipCode = "customer.address.zipCode"; //id
    protected static final String phone = "customer.phoneNumber"; //id
    protected static final String ssn = "customer.ssn"; //id
    protected static final String username = "customer.username"; //id
    protected static final String password = "customer.password"; //id
    protected static final String repeatedPassword = "repeatedPassword"; //id
    protected static final String registerSubmit = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"; //xpath
    protected static final String successMessage = "//*[@id=\"rightPanel\"]/p"; //xpath


    public void goToRegisterPage() throws InterruptedException{
        WebElement registerButton = getWebElement(By.xpath(register));
        registerButton.click();
        Thread.sleep(1000);
    }


    public void insertCustomerData(String name,String secondName, String addressStreet, String addressCity, String addressState, String addressZipCode,String phoneNumber,String socialSecurityNumber){
        WebElement firstNameInput = getWebElement(By.id(firstName));
        firstNameInput.clear();
        firstNameInput.sendKeys(name);

        WebElement lastNameInput = getWebElement(By.id(lastName));
        lastNameInput.clear();
        lastNameInput.sendKeys(secondName);

        WebElement addressInput = getWebElement(By.id(address));
        addressInput.clear();
        addressInput.sendKeys(addressStreet);

        WebElement cityInput = getWebElement(By.id(city));
        cityInput.clear();
        cityInput.sendKeys(addressCity);

        WebElement stateInput = getWebElement(By.id(state));
        stateInput.clear();
        stateInput.sendKeys(addressState);

        WebElement zipCodeInput = getWebElement(By.id(zipCode));
        zipCodeInput .clear();
        zipCodeInput .sendKeys(addressZipCode);

        WebElement phoneInput = getWebElement(By.id(phone));
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        WebElement ssnInput = getWebElement(By.id(ssn));
        ssnInput.clear();
        ssnInput.sendKeys(socialSecurityNumber);
    }

    public void insertUsernameAndPassword(String uniqueUsername,String personalPassword, String confirm){
        WebElement usernameInput = getWebElement(By.id(username));
        usernameInput.clear();
        usernameInput.sendKeys(uniqueUsername);

        WebElement passwordInput = getWebElement(By.id(password));
        passwordInput.clear();
        passwordInput.sendKeys(personalPassword);

        WebElement confirmPasswordInput = getWebElement(By.id(repeatedPassword));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirm);
    }

    public void createAccount(){
        WebElement createAccount = getWebElement(By.xpath(registerSubmit));
        createAccount.click();
    }

    public String getMessage(){
        WebElement message = getWebElement(By.xpath(successMessage));
        return message.getText();
    }

}
