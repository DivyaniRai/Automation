package stepdefs;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.BaseUtility;
import Pages.ExcelDataReader;
import Pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationStepdefs extends BaseUtility {

	private RegistrationPage registrationPage = new RegistrationPage(openBrowser());

	ExcelDataReader reader = new ExcelDataReader();

	String FileName = "./src/test/resources/ExcelData/Login.xlsx";

	@Given("^I click on the sign in button$")
	public void i_click_on_the_sign_in_button() throws Throwable {
		registrationPage.clickSignInButton();
	}

	@Given("^I give my mail id$")
	public void i_give_my_mail_id() throws Throwable {
		List<Map<String, String>> testData = reader.getData(FileName, "LoginDetails");
		String EmailID = testData.get(0).get("emailID");
		registrationPage.enterEmailID(EmailID);
	}

	@Then("^I click on create an account button$")
	public void i_click_on_create_an_account_button() throws Throwable {
		registrationPage.clickCreateAccountButton();
	}

	@Then("^I Enter my details from given sheet name$")
	public void i_Enter_my_details_from_given_sheet_name_and_rownumber() throws Throwable {

		List<Map<String, String>> testData = reader.getData(FileName, "LoginDetails");
		String FirstName = testData.get(0).get("FirstName");
		String LastName = testData.get(0).get("LastName");
		String password = testData.get(0).get("password");
		String address = testData.get(0).get("address");
		String aliasAddress = testData.get(0).get("aliasAddress");
		String phoneNumber = testData.get(0).get("phoneNumber");
		String city = testData.get(0).get("city");
		String zipCode = testData.get(0).get("zipCode");
		registrationPage.clickFemaleGenderRadioButton().enterFirstName(FirstName).enterLastName(LastName)
				.enterPassword(password).dayOfBirth().monthOfBirth().yearOfBirth().enterCity(city).enterState()
				.enterZipCode(zipCode).enterAddress(address).enterPhoneNumber(phoneNumber)
				.enterAliasAddress(aliasAddress);
	}

	@When("^I click on register$")
	public void i_click_on_register() throws Throwable {
		registrationPage.clickRegisterButton();
	}

	@Then("^I see correct name and surname$")
	public void i_see_correct_name_and_surname() throws Throwable {

		List<Map<String, String>> testData = reader.getData(FileName, "LoginDetails");
		String FirstName = testData.get(0).get("FirstName");
		String LastName = testData.get(0).get("LastName");
		Assert.assertTrue(registrationPage.validation().contains(FirstName + " " + LastName));

	}
}
