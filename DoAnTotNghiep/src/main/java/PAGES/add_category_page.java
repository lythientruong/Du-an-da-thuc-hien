package PAGES;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class add_category_page {
	private WebDriver driver;
	public add_category_page(WebDriver driver) {
		this.driver = driver;

	}
	public void Add_category(String title, String link, String parent, String describe, String expectedText)
			throws Exception {
		clickmenuCategory();
		Thread.sleep(200);
		settagname(title);
		Thread.sleep(200);
		settaglink(link);
		Thread.sleep(200);
		selectparent(parent);
		Thread.sleep(200);
		setdescribe(describe);
		Thread.sleep(200);
		clickpost();
		Thread.sleep(200);
		if (title != null && !title.trim().isEmpty()||link != null && !link.trim().isEmpty()) {
			check_Add_category(expectedText);
		}
	}
	public void clickmenuCategory() throws Exception {
		WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
		elementToHover.click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a")).click();
	}
	public void settagname(String title) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"tag-name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"tag-name\"]")).sendKeys(title);
	}
	public void settaglink(String link) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"tag-slug\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"tag-slug\"]")).sendKeys(link);
	}
	public void selectparent(String parent) throws Exception {

		WebElement selectElementRole = driver.findElement(By.xpath("//*[@id=\"parent\"]"));
		Select selectObjectRole = new Select(selectElementRole);

		// Lấy danh sách các tùy chọn
		List<WebElement> options = selectObjectRole.getOptions();

		// Kiểm tra xem role có nằm trong danh sách tùy chọn hay không
		boolean roleFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(parent)) {
				roleFound = true;
				break;
			}
		}

		if (roleFound) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, arguments[0]);", "400");
			selectElementRole.click();
			Thread.sleep(500);
			selectObjectRole.selectByVisibleText(parent);
			Thread.sleep(500);
		} else {
			Assert.fail("Chuyên mục hiện tại không hợp lệ.");
		}
	}
	public void setdescribe(String describe) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"tag-description\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"tag-description\"]")).sendKeys(describe);
	}
	public void clickpost() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(500);
	}
	public void check_Add_category(String expectedText) throws Exception {
		boolean locatorExit = driver.findElements(By.xpath("//*[@id=\"ajax-response\"]/div")).size() > 0;
		if (locatorExit) {
			String actualText = driver.findElement(By.xpath("//*[@id=\"ajax-response\"]/div")).getText();
			Assert.assertEquals(actualText, expectedText);
			System.out.println(actualText);
		} else {
			Assert.assertEquals("", expectedText);
		}

	}
}
