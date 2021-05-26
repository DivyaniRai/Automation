package stepdefs;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.BaseUtility;
import Pages.ExcelDataReader;
import Pages.PaymentValidationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentValidationStepdef extends BaseUtility {

	private PaymentValidationPage paymentValidation = new PaymentValidationPage(openBrowser());
	ExcelDataReader excelDataReader = new ExcelDataReader();

	String FileName = "./src/test/resources/ExcelData/Login.xlsx";

	@Given("^I click on the signIn button$")
	public void i_click_on_the_signIn_button() throws Throwable {
		paymentValidation.clickFirstSignInButton();
	}

	@Given("^I give valid credentials to login$")
	public void i_give_valid_credentials_to_login() throws Throwable {
		List<Map<String, String>> testData = excelDataReader.getData(FileName, "LoginDetails");
		String EmailID = testData.get(1).get("emailID");
		String password = testData.get(1).get("password");
		paymentValidation.enterEmailID(EmailID).enterPassword(password).clickSignInButton();
	}

	@Given("^I add a product to cart$")
	public void i_add_a_product_to_cart() throws Throwable {
		paymentValidation.clickWomenTab().hoverOverProduct().clickOnAddToCart();
	}

	@When("^I click on checkout page and proceed$")
	public void i_click_on_checkout_page_and_proceed() throws Throwable {
		paymentValidation.ProceedToCheckoutPopUpButton().scrollToBottom().ProceedToCheckoutButton().scrollToBottom()
				.addressAndShippingCheckoutButton().scrollToBottom().clickTermsAndConditionCheckbox()
				.addressAndShippingCheckoutButton().scrollToBottom().clickPaymentOption().iconfirmOrderButton();
	}

	@Then("^I see the payment page$")
	public void i_see_the_payment_page() throws Throwable {
		Assert.assertTrue(paymentValidation.isConfirmationMessagePresent());
	}
}