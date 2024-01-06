package PAGES;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class update_article_page {
	private WebDriver driver;

	public update_article_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Update_article(String user, String tenMau, String title, String content, String choice,
			String chuyenmuc, String excerpt, String author, String targetImageName, String expectedText)
			throws Exception {
		clickmenuarticle();
		Thread.sleep(1000);
		String selectarticle = selectarticle(tenMau);
		Thread.sleep(1000);
		if (selectarticle == null) {
			settitle(title);
			Thread.sleep(1000);
			setcontent(content);
			Thread.sleep(1000);
			selectformat(choice);
			Thread.sleep(1000);
			selectcategory(chuyenmuc);
			Thread.sleep(1000);
			if (user.equals("admin")) {
				setexcert(excerpt);
				Thread.sleep(1000);
			}
			if (user.equals("admin")) {
				selectauthor(author);
				Thread.sleep(1000);
			}
			if (!targetImageName.isEmpty() && targetImageName != null) {
				setthumbnail(targetImageName);
				Thread.sleep(1000);
			}
			clickpost();
			Thread.sleep(1000);
			check_Update_article(expectedText);
			Thread.sleep(3000);
		}

	}
	private void clickpost() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", "-1000");
		driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
		Thread.sleep(3000);
	}
	private void setthumbnail(String targetImageName) throws Exception {

		boolean locatorRemoveExists = driver.findElements(By.id("remove-post-thumbnail")).size() > 0;
		if (locatorRemoveExists) {
			WebElement tagRemove = driver.findElement(By.id("remove-post-thumbnail"));
			Thread.sleep(500);
			tagRemove.click();
			Thread.sleep(500);
		}

		driver.findElement(By.id("set-post-thumbnail")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"menu-item-browse\"]")).click();
		driver.findElement(By.id("media-search-input")).clear();
		driver.findElement(By.id("media-search-input")).sendKeys(targetImageName);
		Thread.sleep(3000);
		if (driver.findElements(By.className("thumbnail")).size() > 0) {
			if (driver.findElement(By.className("thumbnail")).isDisplayed()) {
				Thread.sleep(500);
				driver.findElement(By.className("thumbnail")).click();

				Thread.sleep(500);
				driver.findElement(By.xpath("//*[@id=\"__wp-uploader-id-0\"]/div[4]/div/div[2]/button")).click();
				Thread.sleep(500);
			}
		} else {

			driver.findElement(By.xpath("//*[@id=\"__wp-uploader-id-2\"]/div[1]/button/span")).click();
		}
	}
	private void selectauthor(String author) throws Exception {
		WebElement selectElementRole = driver.findElement(By.id("post_author_override"));
		Select selectObjectRole = new Select(selectElementRole);
		List<WebElement> options = selectObjectRole.getOptions();
		boolean roleFound = false;
		for (WebElement option : options) {
			if (option.getText().equals(author)) {
				roleFound = true;
				break;
			}
		}
		if (!roleFound) {
			author = "admin (admin)";
		}
		selectElementRole.click();
		Thread.sleep(500);
		selectObjectRole.selectByVisibleText(author);
		Thread.sleep(500);
	}
	private void setexcert(String excerpt) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("excerpt")));
		driver.findElement(By.id("excerpt")).clear();
		driver.findElement(By.id("excerpt")).sendKeys(excerpt);
	}
	private void selectcategory(String chuyenmuc) {
		driver.findElement(By.xpath("//*[@id=\"category-tabs\"]/li[2]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, arguments[0]);", "500");
		String className = "popular-category";

		List<WebElement> checkboxElements = driver.findElements(By.className(className));

		for (WebElement checkboxElement : checkboxElements) {
			String id = checkboxElement.getAttribute("id");
			String[] parts = id.split("-");
			String number = parts[parts.length - 1];
			int numericValue = Integer.parseInt(number);

			String idCheckbox = "in-popular-category-" + numericValue;

			boolean checkCm = driver.findElement(By.id(idCheckbox)).isSelected();
			if (checkCm) {
				driver.findElement(By.id(idCheckbox)).click();
			}
		}

		if (!chuyenmuc.isEmpty() && ((chuyenmuc != null))) {
			List<WebElement> checkboxElementss = driver.findElements(By.className("selectit"));

			String[] giaTriMongMuon = chuyenmuc.split(", ");

			for (WebElement checkboxElement : checkboxElementss) {

				String checkboxText = checkboxElement.getText();
				for (String giaTri : giaTriMongMuon) {
					if (checkboxText.equals(giaTri)) {
						checkboxElement.click();
						break;
					}
				}
			}
		}

	}
	private void selectformat(String choice) throws Exception {
		String choicelower = choice.toLowerCase();
		switch (choicelower) {
		case "chuẩn":
			WebElement radioButton1 = driver
					.findElement(By.xpath("//*[@id=\"post-formats-select\"]/fieldset/label[1]"));

			radioButton1.click();
			break;
		case "đứng riêng":
			WebElement radioButton2 = driver
					.findElement(By.xpath("//*[@id=\"post-formats-select\"]/fieldset/label[2]"));
			radioButton2.click();
			break;
		case "bộ sưu tập":
			WebElement radioButton3 = driver
					.findElement(By.xpath("//*[@id=\"post-formats-select\"]/fieldset/label[3]"));
			radioButton3.click();
			break;
		case "video":
			WebElement radioButton4 = driver
					.findElement(By.xpath("//*[@id=\"post-formats-select\"]/fieldset/label[4]"));
			radioButton4.click();
			break;
		case "audio":
			WebElement radioButton5 = driver
					.findElement(By.xpath("//*[@id=\"post-formats-select\"]/fieldset/label[5]"));
			radioButton5.click();
			break;
		default:
			WebElement radioButton6 = driver
					.findElement(By.xpath("//*[@id=\"post-formats-select\"]/fieldset/label[1]"));
			radioButton6.click();
			System.out.println("Lựa chọn không hợp lệ nên mặc định chọn là dạng 'Chuẩn' ");
			break;
		}

	}
	private void setcontent(String content) {
		driver.findElement(By.id("content-html")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"content\"]")).sendKeys(content);

	}
	private void settitle(String title) throws Exception {
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys(title);
	}
	private String selectarticle(String tenMau) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).sendKeys(tenMau);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		boolean found = false;
		List<WebElement> elements = driver.findElements(By.className("row-title"));

		for (WebElement element : elements) {
			String tenBaiViet = element.getText();

			if (tenBaiViet.equals(tenMau)) {
				element.click();
				found = true;
				break;
			}
		}
		if (!found) {
			String messega = "Không tìm thấy bài viết.";
			System.out.println(messega);
			return messega;

		}
		return null;
	}
	private void clickmenuarticle() {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();

	}
	public void check_Update_article(String expectedText) throws Exception {
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(message, expectedText, "Testcase thất bại");
	}
}
