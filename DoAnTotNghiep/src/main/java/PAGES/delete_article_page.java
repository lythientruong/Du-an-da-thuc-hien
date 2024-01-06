package PAGES;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class delete_article_page {
	private WebDriver driver;
	public delete_article_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Delete_article(String title, String expectedText) throws Exception {
		clickmenu();
		String selectArticle = selectArticle(title, expectedText);
		if (selectArticle == null) {
			clickDelete(title);
			check_Delete_article(expectedText);
		}
	}
	private void clickDelete(String title) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"delete-action\"]/a")).click();
		Thread.sleep(2000);
	}
	private void clickmenu() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		Thread.sleep(1000);
	}
	private String selectArticle(String title, String expectedText) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).sendKeys(title);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		Thread.sleep(300);
		List<WebElement> elements = driver.findElements(By.className("row-title"));
		boolean found = false;
		for (WebElement element : elements) {
			String tenBaiViet = element.getText();
			// So sánh tên bài viết với tên mẫu
			if (tenBaiViet.equals(title)) {
				// Click vào dòng đầu tiên có tên giống tên mẫu
				element.click();
				found = true; // Đánh dấu đã tìm thấy phần tử
				break; // Dừng vòng lặp sau khi đã click vào dòng đầu tiên
			}
		}
		if (!found) {
			if (driver.findElements(By.xpath("//td[contains(.,'Không tìm thấy bài viết nào.')]")).size() > 0) {
				if (driver.findElement(By.xpath("//td[contains(.,'Không tìm thấy bài viết nào.')]")).isDisplayed()) {
					String customErrorMessage = driver
							.findElement(By.xpath("//td[contains(.,'Không tìm thấy bài viết nào.')]")).getText();
					System.out.println(customErrorMessage);
					expectedText = expectedText.replaceAll("\\s", "");
					customErrorMessage = customErrorMessage.replaceAll("\\s", "");
					Assert.assertEquals(expectedText, customErrorMessage);
					return customErrorMessage;
				}
			} else {
				String mesage = "Không tìm thấy bài viết nào.";
				expectedText = expectedText.replaceAll("\\s", "");
				mesage = mesage.replaceAll("\\s", "");
				Assert.assertEquals(expectedText, mesage);
				return mesage;
			}
		}
		return null;
	}
	public void check_Delete_article(String expectedText) throws Exception {
		String message = driver.findElement(By.id("message")).getText();
		expectedText = expectedText.replaceAll("\\s", ""); 
		message = message.replaceAll("\\s", "");
		Assert.assertEquals(message, expectedText, "Testcase thất bại");
	}
}
