package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.basePage;



public class loginPage extends basePage {
	
    homePage hp;
	
	public loginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Hello. Sign in')]")
	WebElement signIn;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]")
	WebElement signIn1;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	

	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginBtn;
	
	public void loginMethod() {
		signIn.click();
		wait.until(ExpectedConditions.elementToBeClickable(signIn1));
		signIn1.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(emailId));
		emailId.sendKeys(prop.getProperty("userName"));
		continueBtn.click();
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		//return new homePage();
		
		
		
		
	}
	
	


}
