package Pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BasePage.basePage;

public class homePage extends basePage {
	
public homePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchItem;
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
	WebElement searchBtn;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement searchResults;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement selectProduct;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addToCartBtn;
	
	
	
	public void selectProduct(String product) {
		wait.until(ExpectedConditions.elementToBeClickable(searchItem));
		searchItem.sendKeys(product);
		searchBtn.click();
		wait.until(ExpectedConditions.visibilityOf(searchResults));
		selectProduct.click();
		
	}
	
	public void addToCart() {
		String parentwindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
			}
			
		}
		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		addToCartBtn.click();
		
	}


}
