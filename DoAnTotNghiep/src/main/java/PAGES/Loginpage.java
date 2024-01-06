package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Loginpage {
	private WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginsuccess(String username, String password) throws Exception {

		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).clear();;
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys(username);
		Thread.sleep(500);
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(500);
		boolean locatorLoginExists = driver.findElements(By.xpath("//*[@id=\"login\"]/form/div/div[2]/a")).size() > 0;
        if(locatorLoginExists){
        	WebElement taglogin = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div/div[2]/a"));
        	Thread.sleep(500);
        	taglogin.click();
        }
		
	}

	public void checklogin(String expectedText) throws Exception {
		String message = driver.findElement(By.id("login_error")).getText();
		Assert.assertEquals(message, expectedText, "Testcase thất bại");
	}
}
