package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePage.basePage;
import Pages.homePage;
import Pages.loginPage;


public class addProductToCart extends basePage{
	
	loginPage lp;
	homePage hp;
	
	public addProductToCart() {
		super();
		}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp=new loginPage();
		hp=new homePage();
	}
	
	@Test
	public void logincheck() {
		
		lp.loginMethod();
		hp.selectProduct("Samsung Galaxy A30");
		hp.addToCart();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
