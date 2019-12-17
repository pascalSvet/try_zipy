package zipy_test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import zipy_elements.Elements;

public class Test_buy_item extends Tests_main {
	
	
	
	@Test		
	public  void buy_from_search() throws InterruptedException {
		
				
		// perform search and enter the product
		WebDriverWait wait = new WebDriverWait(driver, 20);				
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desktop_search_fild")))
			.sendKeys(Elements.SearchItem, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(Elements.SearchItem_thumb)))).click();;

		// choose the color and the length		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.Dropbox_color)))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements.Dropbox_color_black)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.Dropbox_length)))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements.Dropbox_length_1m)).click();
		
		//buy
		driver.findElement(By.xpath(Elements.Checkout_button)).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.Buy_button)))).click();
		
		// if we managed to buy:
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("BackToMain_button")));
		Assert.assertTrue(driver.findElement(By.xpath(Elements.Thanks_box)).getText().contains(Elements.ThanksForBuying_heb));

	}
	
	
	@Test		
	public  void buy_from_deal() throws InterruptedException {
		
	
		
				
		
	}
}
