package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Register;
import resources.base;

public class stepDefinition extends base {

	private static Register reg;

	@Before
	public void setup() {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^I am in the Moneygaming website signup page$")
	public void i_am_in_the_Moneygaming_website_signup_page() {

		driver.get(getData("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.findElement(By.cssSelector("a.newUser.green")).click();
		reg = new Register(driver);
		reg.JoinNow().click();

	}

	@When("^I select the title from the title dropdown$")
	public void i_select_the_title_from_the_title_dropdown() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		reg.TitleSelection();

	}

	@When("^I enter the firstname and surname in the form$")
	public void i_enter_the_firstname_and_surname_in_the_form() {
		reg.FirstName().sendKeys(getData("firstname"));
		reg.Surname().sendKeys(getData("surname"));
	}

	@When("^I check the terms and conditions checkbox$")
	public void i_check_the_terms_and_conditions_checkbox() {
		reg.TermsCheckBox().click();

	}

	@When("^I click on Join Now buttton$")
	public void i_click_on_Join_Now_buttton() {
		reg.Submit().click();

	}

	@Then("^I should see an error Message \"([^\"]*)\" under the Date of birth field$")
	public void i_should_see_an_error_Message_under_the_Date_of_birth_field(String msg) {
		String errormsg = reg.DobErrorMessage().getText();
		System.out.println("ErrorMessage:" + errormsg);
		Assert.assertEquals(msg, errormsg);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void close() {
		driver.quit();
	}

}
