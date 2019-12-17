package zipy_test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import zipy_elements.Elements;

public class Tests_main {
	
	static WebDriver driver;

	@Before 
	public void closeEnteringPopUp() {	
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Sveta/eclipse/java-2019-09/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		
		driver.get(Elements.Zipy_site_heb);
		
		//close the pop-up window if exist
		if (driver.findElements(By.xpath(Elements.Popup_welcome_close)).size() != 0){
			driver.findElement(By.xpath(Elements.Popup_welcome_close)).click();
		}
		
		//press login button		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", driver.findElement(By.xpath(Elements.Login_button)));
				
		//enter login+password
		driver.findElement(By.id("i_signin-email")).sendKeys(Elements.Username, Keys.TAB, Elements.Password, Keys.ENTER);
				
	}
	
	@After	
	public void closeBrowser() {		
		driver.quit();	// Closing all windows of the browser, opened by the test.		 
	}	
	
	@AfterClass		
	public static void killDriverProcess() throws IOException {		
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");	// Killing the chromedriver process in the end of the test.
	 
	}

}
