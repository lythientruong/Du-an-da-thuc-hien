package PAGES;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class quickfix_article_page {
	private WebDriver driver;
	public quickfix_article_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Quickfix_article(String search, String sampletitle, String title, String link, String day, String month,
			String year, String hour, String minute, String author, String password, String check_private,
			String chuyenmuc, String tag, String status, String check_ontop, String expectedText) throws Exception {

		clickArticle();
		setkeyword(search);
		String selectArticle = selectArticle(sampletitle);
		if (selectArticle == null) {
			settitle(title);
			setlink(link);
			setTime(day, month, year, hour, minute);
			selectauthor(author);
			setpassword(password);
			clickprivate(check_private);
			selectcategory(chuyenmuc);
			selectstatus(status);
			clickontop(check_ontop);
			settag(tag);
			clickpost();
			check_Quickfix_article(expectedText);
			Thread.sleep(1000);
		}
	}
	private void setkeyword(String search) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).sendKeys(search);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
	}
	public void clickArticle() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		// *[@id="menu-posts"]/a/div[3]
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a")).click();
	}
	public String selectArticle(String sampletitle) throws Exception {
		// Class name của phần tử cần tìm
		String targetClassName = "row-title";
		// Tìm tất cả các phần tử có class name tương ứng
		java.util.List<WebElement> elementsWithClassName = driver.findElements(By.className(targetClassName));
		boolean found = false;
		// Kiểm tra từng phần tử có nội dung mong muốn hay không
		for (WebElement element : elementsWithClassName) {
			if (element.getText().equals(sampletitle)) {
				// Khởi tạo đối tượng Actions
				Actions actions = new Actions(driver);

				// Thực hiện hành động mouse over lên phần tử
				actions.moveToElement(element).perform();
				// *[@id="post-3094"]/td[1]/div[3]/span[2]/button
				WebElement parentTr = element.findElement(By.xpath("./ancestor::tr"));
				String parentId = parentTr.getAttribute("id");
				String xpath = "//*[@id=\"" + parentId + "\"]/td[1]/div[3]/span[2]/button";
				// Tìm thẻ a (anchor tag) là thẻ con của thẻ span
				By elementLocator = By.xpath(xpath);

				WebDriverWait wait = new WebDriverWait(driver, 5); // 10 giây timeout
				WebElement anchorElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
				// Thực hiện hành động click vào thẻ a
				anchorElement2.click();
				Thread.sleep(1000);
				// Sau đó, bạn có thể thực hiện các hành động khác sau khi click (ví dụ: chuyển
				// tab, đợi trang mới nạp, etc.)
				found = true;
				break; // Kết thúc vòng lặp sau khi tìm thấy phần tử mong muốn
			}
		}

		if (!found) {
			String customErrorMessage = "Lỗi! Do không có bài viết nào giống vậy.";

			// Đánh dấu bài kiểm tra này là thất bại trong TestNG
			return customErrorMessage;
		}
		return null;
	}
	public void settitle(String title) throws Exception {
		driver.findElement(By.xpath("//input[@name='post_title']")).clear();
		driver.findElement(By.xpath("//input[@name='post_title']")).sendKeys(title);
	}
	public void setlink(String link) throws Exception {
		driver.findElement(By.xpath("//input[@name='post_name']")).clear();
		driver.findElement(By.xpath("//input[@name='post_name']")).sendKeys(link);
	}
	public void setTime(String day, String month, String year, String hour, String minute) throws Exception {
		driver.findElement(By.xpath("//input[@name='jj']")).clear();
		driver.findElement(By.xpath("//input[@name='jj']")).sendKeys(day);

		WebElement selectElement = driver.findElement(By.name("mm"));
		selectElement.click();
		Thread.sleep(300);
		Select selectObject = new Select(selectElement);
		Thread.sleep(300);
		selectObject.selectByVisibleText(month);
		Thread.sleep(300);

		driver.findElement(By.xpath("//input[@name='aa']")).clear();
		driver.findElement(By.xpath("//input[@name='aa']")).sendKeys(year);

		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@name='hh']")).clear();
		driver.findElement(By.xpath("//input[@name='hh']")).sendKeys(hour);

		driver.findElement(By.xpath("//input[@name='mn']")).clear();
		driver.findElement(By.xpath("//input[@name='mn']")).sendKeys(minute);
	}
	public void selectauthor(String author) throws Exception {
		WebElement selectElementauthor = driver.findElement(By.name("post_author"));
		Select selectObjectauthor = new Select(selectElementauthor);

		// Lặp qua tất cả các tùy chọn trong trình chọn
		List<WebElement> options = selectObjectauthor.getOptions();
		boolean found = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(author)) {
				// Nếu tìm thấy tùy chọn trùng, chọn nó và đánh dấu tìm thấy
				selectObjectauthor.selectByVisibleText(optionText);
				found = true;
				break;
			}
		}

		// Nếu không tìm thấy tùy chọn trùng, chọn "admin (admin)"
		if (!found) {
			selectObjectauthor.selectByVisibleText("admin (admin)");
		}
	}
	public void setpassword(String password) throws Exception {
		boolean pw = driver.findElement(By.xpath("//input[@name='post_password']")).isEnabled();
		if (pw) {
			driver.findElement(By.xpath("//input[@name='post_password']")).clear();
			driver.findElement(By.xpath("//input[@name='post_password']")).sendKeys(password);
			Thread.sleep(500);
			// *[@id="edit-3094"]/td/fieldset[1]/div/div/label[1]/span[2]/input
		}
	}
	public void clickprivate(String check_private) throws Exception {
		boolean riengtu2 = driver.findElement(By.name("keep_private")).isSelected();
		if (check_private.equals("1")) {
			if (!riengtu2) {
				driver.findElement(By.name("keep_private")).click();
			}
		} else if (check_private.equals("0")) {
			if (riengtu2) {
				driver.findElement(By.name("keep_private")).click();
			}
		} else {
			Assert.fail("Dữ liệu nạp vào ô check riêng tư hay không là không phù hợp!!!");
		}
	}
	public void selectcategory(String chuyenmuc) throws Exception {
		String className = "popular-category";
		if (chuyenmuc == null || chuyenmuc.isEmpty()) {

			List<WebElement> checkboxElements = driver.findElements(By.className(className));

			for (WebElement checkboxElement : checkboxElements) {
				String id = checkboxElement.getAttribute("id");
				String[] parts = id.split("-");
				String number = parts[1]; // Lấy phần tử thứ 2 sau dấu "-"

				// Chuyển đổi số thành kiểu int nếu cần
				int numericValue = Integer.parseInt(number);

				String idCheckbox = "in-category-" + numericValue;

				boolean checkCm = driver.findElement(By.id(idCheckbox)).isSelected();
				if (checkCm) {
					driver.findElement(By.id(idCheckbox)).click();
				}
			}
			return;
		}
		List<WebElement> categoryCheckboxes = driver.findElements(By.className(className));
		String[] giaTriMongMuon = chuyenmuc.split(", ");

		for (WebElement checkbox : categoryCheckboxes) {
			String checkboxText = checkbox.getText();
			if (Arrays.asList(giaTriMongMuon).contains(checkboxText)) {
				String id = checkbox.getAttribute("id");
				int numericValue = Integer.parseInt(id.split("-")[1]);
				String idCheckbox = "in-category-" + numericValue;
				WebElement inCategoryCheckbox = driver.findElement(By.id(idCheckbox));

				if (!inCategoryCheckbox.isSelected()) {
					inCategoryCheckbox.click();
				}
			}
		}

	}
	public void settag(String tag) throws Exception {
		driver.findElement(By.xpath("//textarea[@name='tax_input[post_tag]']")).clear();
		driver.findElement(By.xpath("//textarea[@name='tax_input[post_tag]']")).sendKeys(tag);
		Thread.sleep(300);

	}
	public void selectstatus(String status) throws Exception {
		WebElement selectElementstatus = driver.findElement(By.name("_status"));
		Select selectObjectstatus = new Select(selectElementstatus);

		// Lặp qua tất cả các tùy chọn trong trình chọn
		List<WebElement> options = selectObjectstatus.getOptions();
		boolean found = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(status)) {
				// Nếu tìm thấy tùy chọn trùng, chọn nó và đánh dấu tìm thấy
				selectObjectstatus.selectByVisibleText(optionText);
				found = true;
				break;
			}
		}

		// Nếu không tìm thấy tùy chọn trùng, chọn "Đã xuất bản"
		if (!found) {
			selectObjectstatus.selectByVisibleText("Đã xuất bản");
		}
	}
	public void clickontop(String check_ontop) throws Exception {
		boolean pasteontop2 = driver.findElement(By.name("sticky")).isSelected();
		if (check_ontop.equals("1")) {
			if (!pasteontop2) {
				driver.findElement(By.name("sticky")).click();
			}
		} else if (check_ontop.equals("0")) {
			if (pasteontop2) {
				driver.findElement(By.name("sticky")).click();
			}
		} else {
			Assert.fail("Dữ liệu nạp vào ô check riêng tư hay không là không phù hợp!!!");
		}
	}
	public void clickpost() throws Exception {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
	public void check_Quickfix_article(String expectedText) throws Exception {
		Thread.sleep(2000);
		By elementLocator = By.className("error");
		boolean MesDisplay = driver.findElement(elementLocator).isDisplayed();
		if (MesDisplay) {
			WebDriverWait wait = new WebDriverWait(driver, 10); // 10 giây timeout
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

			String message = element.getText();
			System.out.println(message);

			Assert.assertEquals(message, expectedText, "Testcase thất bại");
		} else {
			String message2 = driver.findElement(elementLocator).getText();
			Assert.assertEquals(message2, expectedText, "Testcase thất bại");
		}

	}
}
