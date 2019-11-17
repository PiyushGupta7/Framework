package BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	
	public basePage()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C://Users//piyushgupta7//eclipse-workspace//Ecommerce//src//main//java//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C://Users//piyushgupta7//Pictures//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C://Users//piyushgupta7//Pictures//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		//System.setProperty("webdriver.chrome.driver","C://Users//piyushgupta7//Pictures//chromedriver.exe");
		//driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,50);
	}


}
