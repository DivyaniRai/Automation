package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	public static WebElement element = null;

	private By signInButton = By.cssSelector("a[class='login']");

	private By emailToRegisterField = By.cssSelector("input[id='email_create']");

	private By createAccountButton = By.cssSelector("button[id='SubmitCreate']");

	private By femaleGenderRdioButton = By.id("uniform-id_gender2");

	private By customerFirstName = By.cssSelector("input[id='customer_firstname']");

	private By customerLastName = By.cssSelector("input[id='customer_lastname']");

	private By customerPassword = By.cssSelector("input[id='passwd']");

	private By primaryAddress = By.cssSelector("input[id='address1']");

	private By cityName = By.cssSelector("input[id='city']");

	private By zipCode = By.cssSelector("input[class='form-control uniform-input text']");

	private By phoneNumber = By.cssSelector("input[id='phone_mobile']");

	private By aliasAddress = By.cssSelector("input[id='alias']");

	private By dayOfBirthValues = By.cssSelector("select[id='days']");
	
	private By MonthOfBirthValues = By.cssSelector("select[id='months']");
	
	private By yearOfBirthValues = By.cssSelector("select[id='years']");
	
	private By stateVlaues = By.cssSelector("select[id='id_state']");
	
	private By nameValidation = By.xpath("//a[@title='View my customer account']//span[text()='testingname lastName']");
	
	private By registerButton = By.cssSelector("button[name='submitAccount']");

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public RegistrationPage clickSignInButton() {
		driver.findElement(signInButton).click();
		return this;
	}

	public RegistrationPage enterEmailID(String mailID) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(emailToRegisterField).sendKeys(mailID);
		return this;
	}

	public RegistrationPage clickCreateAccountButton() {
		driver.findElement(createAccountButton).click();
		return this;
	}

	public RegistrationPage clickFemaleGenderRadioButton() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(femaleGenderRdioButton).click();
		return this;
	}

	public RegistrationPage enterFirstName(String firstName) {
		driver.findElement(customerFirstName).sendKeys(firstName);
		return this;
	}

	public RegistrationPage enterLastName(String lastName) {
		driver.findElement(customerLastName).sendKeys(lastName);
		return this;
	}

	public RegistrationPage enterPassword(String password) {
		driver.findElement(customerPassword).sendKeys(password);
		return this;
	}

	public RegistrationPage enterCity(String city) {
		driver.findElement(cityName).sendKeys(city);
		return this;
	}

	public RegistrationPage enterPhoneNumber(String number) {
		driver.findElement(phoneNumber).sendKeys(number);
		return this;
	}

	public RegistrationPage enterAliasAddress(String address) {
		driver.findElement(aliasAddress).sendKeys(address);
		return this;
	}

	public RegistrationPage enterAddress(String address) {
		driver.findElement(primaryAddress).sendKeys(address);
		return this;
	}

	public void Dropdown(WebElement element, int num) {
		Select dropDwonValue = new Select(element);
		dropDwonValue.selectByIndex(num);
	}

	public RegistrationPage enterState() {
		Dropdown(driver.findElement(stateVlaues), 1);
		return this;
	}

	public RegistrationPage enterZipCode(String code) {
		driver.findElement(zipCode).sendKeys(code);
		return this;
	}

	public RegistrationPage dayOfBirth() {
		Dropdown(driver.findElement(dayOfBirthValues), 3);
		return this;
	}

	public RegistrationPage monthOfBirth() {
		driver.findElement(MonthOfBirthValues).click();
		Dropdown(driver.findElement(MonthOfBirthValues), 1);
		return this;
	}

	public RegistrationPage yearOfBirth() {
		Dropdown(driver.findElement(yearOfBirthValues), 1);
		return this;
	}

	public String validation() {
		return driver.findElement(nameValidation).getText();
	}
	
	public RegistrationPage clickRegisterButton() {
		driver.findElement(registerButton).click();
		return this;
	}
}