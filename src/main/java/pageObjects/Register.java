package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {
	public static WebDriver driver;

	public Register(WebDriver driver) {
		Register.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.newUser.green")
	WebElement joinnow;

	@FindBy(id = "title")
	WebElement title;

	@FindBy(css = "#forename")
	WebElement firstname;

	@FindBy(xpath = "//*[@id=\"signupForm\"]/fieldset[1]/input[2]")
	WebElement surname;

	@FindBy(css = "#checkbox")
	WebElement terms;

	@FindBy(css = "#form")
	WebElement submit;

	@FindBy(xpath = "//*[@id=\"signupForm\"]/fieldset[1]/label[5]")
	WebElement dobmsg;

	public WebElement JoinNow() {
		return joinnow;
	}

	public void TitleSelection() {
		Select s = new Select(title);
		s.selectByValue("Mrs");
	}

	public WebElement FirstName() {
		return firstname;
	}

	public WebElement Surname() {
		return surname;
	}

	public WebElement TermsCheckBox() {
		return terms;
	}

	public WebElement Submit() {
		return submit;
	}

	public WebElement DobErrorMessage() {
		return dobmsg;
	}

}
