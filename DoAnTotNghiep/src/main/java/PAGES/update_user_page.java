package PAGES;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class update_user_page {
	private WebDriver driver;
	public update_user_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Update_user(String username, String role, String fname, String lname, String email, String password,
			String expectedText) throws Exception {
		clickmenuUser();
		Thread.sleep(200);
		String select_user = select_user(username);
		if (select_user == null) {
			selectRole(role);
			set_fisrtName(fname);
			Thread.sleep(200);
			set_lastName(lname);
			Thread.sleep(200);
			set_Email(email);
			Thread.sleep(200);
			setpassword(password);
			Thread.sleep(200);
			click_WeakPw();
			Thread.sleep(200);
			if (!password.isEmpty()) {
				clickpost();
				check_Update_user(expectedText);
			}
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
			WebElement anchorElement = driver.findElement(By.linkText("Chỉnh sửa"));
			// Thực hiện hành động click vào thẻ a
			anchorElement.click();
			Thread.sleep(2000);
			// Sau đó, bạn có thể thực hiện các hành động khác sau khi click (ví dụ: chuyển
			// tab, đợi trang mới nạp, etc.)
			found = true;
		}

		if (!found) {
			String customErrorMessage = "Lỗi! Do không có người dùng nào giống vậy.";
			System.out.println(customErrorMessage);
			return customErrorMessage;
		}
		return null;
	}
	public void selectRole(String role) throws Exception {
		WebElement selectElementRole = driver.findElement(By.xpath("//*[@id=\"role\"]"));
		Select selectObjectRole = new Select(selectElementRole);

		// Lấy danh sách các tùy chọn
		List<WebElement> options = selectObjectRole.getOptions();

		// Kiểm tra xem role có nằm trong danh sách tùy chọn hay không
		boolean roleFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(role)) {
				roleFound = true;
				break;
			}
		}

		// Nếu role không hợp lệ, mặc định chọn "Thành viên đăng ký"
		if (!roleFound) {
			role = "Thành viên đăng ký";
		}

		// Thực hiện hành động tương ứng
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", "600");

		selectElementRole.click();
		Thread.sleep(500);
		selectObjectRole.selectByVisibleText(role);
		Thread.sleep(500);
	}
	public void set_fisrtName(String fname) {
		boolean display = driver.findElement(By.xpath("//*[@id=\"first_name\"]")).isDisplayed();
		if (display) {
			driver.findElement(By.id("first_name")).clear();
			driver.findElement(By.id("first_name")).sendKeys(fname);
		}
	}
	public void set_lastName(String lname) {
		boolean display = driver.findElement(By.xpath("//*[@id=\"last_name\"]")).isDisplayed();
		if (display) {
			driver.findElement(By.id("last_name")).clear();
			driver.findElement(By.id("last_name")).sendKeys(lname);
		}
	}
	public void set_Email(String email) {
		boolean display = driver.findElement(By.xpath("//*[@id=\"email\"]")).isDisplayed();
		if (display) {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(email);
		}
	}
	public void setpassword(String password) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", "12000");

		driver.findElement(By.xpath("//button[contains(.,'Tạo mật khẩu')]")).click();
		boolean display = driver.findElement(By.xpath("//*[@id=\"pass1\"]")).isDisplayed();
		if (display) {
			driver.findElement(By.xpath("//*[@id=\"pass1\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"pass1\"]")).sendKeys(password);

		}
	}
	public void click_WeakPw() {
		boolean display = driver.findElement(By.className("pw-checkbox")).isDisplayed();
		if (display) {
			boolean checked = driver.findElement(By.className("pw-checkbox")).isSelected();
			if (!checked) {
				driver.findElement(By.className("pw-checkbox")).click();
			}
		}
	}
	public void clickpost() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(500);
	}
	public void check_Update_user(String expectedText) throws Exception {
		boolean errorexit = driver.findElements(By.className("error")).size() > 0;
		if (errorexit) {
			boolean errorDisplay = driver.findElement(By.className("error")).isDisplayed();
			if (errorDisplay) {
				String actualText = driver.findElement(By.className("error")).getText();
				Assert.assertEquals(actualText, expectedText);
				System.out.println(actualText);
			}
		}
		boolean messageexit = driver.findElements(By.xpath("//*[@id=\"message\"]")).size() > 0;
		if (messageexit) {
			boolean messageDisplay = driver.findElement(By.xpath("//*[@id=\"message\"]")).isDisplayed();
			if (messageDisplay) {
				String actualText2 = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
				Assert.assertEquals(actualText2, expectedText);
				System.out.println(actualText2);
			}
		}
	}
}
