package stepdefs;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpliLearnStepDef {

	WebDriver driver = Hooks.driver;

@Given("I have launched the application")
public void i_have_launched_the_application() {
	driver.get("https://simplilearn.com/");	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Hooks.test.log(LogStatus.PASS,"Application Launched");
}

@Given("I click on the Login link")
public void i_click_on_the_Login_link() {
    WebElement LoginLink = driver.findElement(By.linkText("Log in"));
    LoginLink.click();
    Hooks.test.log(LogStatus.PASS,"Login Link Clicked");
}

@When("I enter the username")
public void i_enter_the_username() {
	WebElement UserName = driver.findElement(By.name("user_login"));
	UserName.sendKeys("abc@xyz.com");
	 Hooks.test.log(LogStatus.PASS,"Entered User Name");
}

@When("I enter the password")
public void i_enter_the_password() {
	WebElement Password = driver.findElement(By.id("password"));
	Password.sendKeys("Abcd@1234"); 
}

@When("I click on the login button")
public void i_click_on_the_login_button() throws InterruptedException {
	WebElement RememberMe = driver.findElement(By.name("btn_login"));
	RememberMe.click();
	Thread.sleep(1000);
	
}

@Then("I should get the error message as {string}")
public void i_should_get_the_error_message_as(String expMsg) {
	WebElement Error = driver.findElement(By.className("error_msg"));
	String actMsg = Error.getText();
	Assert.assertEquals(expMsg, actMsg);
}
@When("I enter the username {string}")
public void i_enter_the_username(String userNameVal) {
	WebElement UserName = driver.findElement(By.name("user_login"));
	UserName.sendKeys(userNameVal);
}

@When("I enter the password {string}")
public void i_enter_the_password(String password) {
	WebElement Password = driver.findElement(By.id("password"));
	Password.sendKeys(password); 
}
@Given("I click on login links")
public void i_click_on_login_links() {
  
}

@Then("I see the below login options present on the screen")
public void i_see_the_below_login_options_present_on_the_screen(List<String> loginOptions) {

	for (String option : loginOptions) {

		WebElement otherOptions = driver.findElement(By.xpath("//span[text()='" + option + "']"));
		Assert.assertTrue(otherOptions.isDisplayed());
System.out.println(otherOptions.getText());
	}
}}
