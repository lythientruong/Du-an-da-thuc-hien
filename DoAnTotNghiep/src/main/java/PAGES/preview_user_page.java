package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class preview_user_page {
	private WebDriver driver;

	public preview_user_page(WebDriver driver) {
		this.driver = driver;
	}

	public void Preview_user(String username) throws Exception {
		clickmenuUser();
		Thread.sleep(200);
		String select_user = select_user(username);
		if (select_user == null) {
			check_Preview_user();
		}
	}

	public void clickmenuUser() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-users\"]/a/div[3]")).click();
		Thread.sleep(200);

	}

	public String select_user(String username) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"user-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"user-search-input\"]")).sendKeys(username);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();

		String xpath = "//a[contains(text(),'" + username + "')]";

		boolean found = false;

		boolean exituser = driver.findElements(By.xpath(xpath)).size() > 0;
		if (exituser&&driver.findElement(By.xpath(xpath)).isDisplayed()) {
			WebElement user = driver.findElement(By.xpath(xpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(user).perform();
			Thread.sleep(1000);
			WebElement anchorElement = driver.findElement(By.linkText("Xem"));
			anchorElement.click();
			found = true;
		}

		if (!found) {
			String customErrorMessage = driver.findElement(By.xpath("//*[@id=\"the-list\"]/tr/td")).getText();
			
			if (customErrorMessage.equals("Không tìm được thành viên nào!")) {
				System.out.println(customErrorMessage);
				return customErrorMessage;
			}else{
				System.out.println("Không tìm thấy thành viên "+username+" và cũng không báo lỗi chỉ hiện các thành viên có tên chứa ký tự trùng với "+username);
				Assert.fail("Không tìm thấy thành viên "+username+" và cũng không báo lỗi chỉ hiện các thành viên có tên chứa ký tự trùng với "+username);
			}
		}
		return null;
	}

	public void check_Preview_user() throws Exception {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);

	}
}
