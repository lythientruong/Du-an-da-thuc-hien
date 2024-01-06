package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class delete_user_page {
	private WebDriver driver;
	public delete_user_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Delete_user(String username, String valueToClick, String nextuser, String expectedText)
			throws Exception {
		clickmenuUser();
		Thread.sleep(200);
		String select_user = select_user(username);
		if (select_user == null) {
			select_radio(valueToClick, nextuser);
			Thread.sleep(200);
			click_submit();
			Thread.sleep(200);
			check_Delete_user(expectedText);
		}
		driver.navigate().refresh();
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
		// a[contains(text(),'lythientruong')]
		String xpath = "//a[contains(text(),'" + username + "')]";

		boolean found = false;
		// Kiểm tra từng phần tử có nội dung mong muốn hay không

		boolean exituser = driver.findElements(By.xpath(xpath)).size() > 0;
		if (exituser) {
			WebElement user = driver.findElement(By.xpath(xpath));
			// Khởi tạo đối tượng Actions
			Actions actions = new Actions(driver);

			// Thực hiện hành động mouse over lên phần tử
			actions.moveToElement(user).perform();
			Thread.sleep(1000);
			// Tìm thẻ a (anchor tag) là thẻ con của thẻ span
			WebElement anchorElement = driver.findElement(By.linkText("Xóa"));
			// Thực hiện hành động click vào thẻ a
			anchorElement.click();
			Thread.sleep(2000);
			// Sau đó, bạn có thể thực hiện các hành động khác sau khi click (ví dụ: chuyển
			// tab, đợi trang mới nạp, etc.)
			found = true;
		}

		if (!found) {
			String customErrorMessage = "Lỗi! Do không có người dùng nào giống vậy.";

			// Đánh dấu bài kiểm tra này là thất bại trong TestNG
			System.out.print(customErrorMessage);
			return customErrorMessage;
		} else {
			return null;
		}
	}
	public void select_radio(String valueToClick, String nextuser) throws Exception {
		// Giá trị (value) của phần tử cần click
		boolean exituser = driver.findElements(By.xpath("//input[@value='" + valueToClick + "']")).size() > 0;
		if (exituser) {
			// Sử dụng XPath để tìm phần tử dựa trên thuộc tính value
			WebElement element = driver.findElement(By.xpath("//input[@value='" + valueToClick + "']"));

			// Thực hiện click vào phần tử
			element.click();
		}
		if (valueToClick.equals("reassign")) {
			boolean exit_reassign_user = driver.findElements(By.id("reassign_user")).size() > 0;
			if (exit_reassign_user) {
				WebElement selectElementRole = driver.findElement(By.id("reassign_user"));
				Thread.sleep(500);
				selectElementRole.click();
				Thread.sleep(500);
				Select selectObjectrole = new Select(selectElementRole);
				Thread.sleep(500);
				selectObjectrole.selectByVisibleText(nextuser);
				Thread.sleep(500);
			}
		}
	}
	public void click_submit() throws Exception {
		boolean submit = driver.findElement(By.id("submit")).isDisplayed();
		if (submit) {
			driver.findElement(By.id("submit")).click();
		}
	}
	public void check_Delete_user(String expectedText) throws Exception {
		boolean exitmessage = driver.findElements(By.id("message")).size() > 0;
		if (exitmessage) {
			String message = driver.findElement(By.id("message")).getText();
			System.out.println(message + " so với \n " + expectedText);
			expectedText = expectedText.replaceAll("\\s", "");  // Loại bỏ khoảng trắng, kể cả dấu xuống dòng và tab
			message = message.replaceAll("\\s", ""); 
			Assert.assertEquals(message, expectedText, "Testcase thất bại");
		}
		Thread.sleep(500);
	}
}
