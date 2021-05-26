package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PaymentValidationPage {

	private WebDriver driver;
	
	public static WebElement element = null;
	
	private By emailID = By.cssSelector("input[id='email']");
	
	private By password = By.cssSelector("input[id='passwd']");

	private By signInButton = By.cssSelector("button[class^='button btn ']");
	
	private By firstSignInButton = By.cssSelector("a[class='login']");
	
	private By womenTab = By.cssSelector("a[title='Women']");
	
	private By product = By.cssSelector("img[title='Faded Short Sleeve T-shirts']");
	
	private By addToCartButton = By.xpath("(//a[@class='button ajax_add_to_cart_button btn btn-default']//span)[1]");
	
	private By proceedToCheckoutPopUpButton = By.cssSelector("a[title='Proceed to checkout']");
	
	private By proceedToCheckoutButton = By.xpath("(//a[@title='Proceed to checkout'])[2]");
	
	private By addressAndShippingCheckoutButton = By.cssSelector("button[class^='button btn btn-default ']");
	
	private By termAndConditionCheckbox = By.cssSelector("div[class='checker']");
	
	private By paymentOption = By.cssSelector("a[class='bankwire']");
	
	private By iConfirmOrderButton = By.cssSelector("button[class^='button btn ']");
	
	private By confirmationMessage = By.xpath("//h1[text()='Order confirmation']");

	public PaymentValidationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public PaymentValidationPage clickFirstSignInButton() {
		driver.findElement(firstSignInButton).click();
		return this;
	}
	
	public PaymentValidationPage enterEmailID(String mailID) {
		driver.findElement(emailID).sendKeys(mailID);
		return this;
	}

	public PaymentValidationPage enterPassword(String passwrd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(password).sendKeys(passwrd);
		return this;
	}

	public PaymentValidationPage clickSignInButton() {
		driver.findElement(signInButton).click();
		return this;
	}

	public PaymentValidationPage clickWomenTab() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(womenTab).click();
		return this;
	}

	public PaymentValidationPage clickOnAddToCart() throws InterruptedException {
		driver.findElement(addToCartButton).click();
	    Thread.sleep(20);
		return this;
	}
	
	public PaymentValidationPage hoverOverProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(product)).perform();
		return this;
	}

	public PaymentValidationPage ProceedToCheckoutButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",driver.findElement(proceedToCheckoutButton));
		return this;
	}
	
	public PaymentValidationPage ProceedToCheckoutPopUpButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",driver.findElement(proceedToCheckoutPopUpButton));
		return this;
	}
	
	public PaymentValidationPage addressAndShippingCheckoutButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",driver.findElement(addressAndShippingCheckoutButton));
		return this;
	}
	
	public PaymentValidationPage scrollToBottom(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		return this;
	}

	public PaymentValidationPage clickTermsAndConditionCheckbox() {
		driver.findElement(termAndConditionCheckbox).click();
		return this;
	}

	public PaymentValidationPage clickPaymentOption() {
		driver.findElement(paymentOption).click();
		return this;
	}

	public PaymentValidationPage iconfirmOrderButton() {
		driver.findElement(iConfirmOrderButton).click();
		return this;
	}
	
	public boolean isConfirmationMessagePresent() {
		return driver.findElement(confirmationMessage).isDisplayed();
	}
}