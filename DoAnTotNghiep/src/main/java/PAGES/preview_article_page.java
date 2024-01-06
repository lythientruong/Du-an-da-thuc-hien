package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class preview_article_page {
	private WebDriver driver;
	public preview_article_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Preview_article(String Title, String expectedTitle, String expectedContent) throws Exception {
		clickmenuarticle();
		String selectarticle = selectarticle(Title);
		if (selectarticle == null) {
			check_Preview_article(expectedTitle, expectedContent);
		}
	}
	private void clickmenuarticle() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a")).click();
		Thread.sleep(500);
	}
	private String selectarticle(String Title) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"post-search-input\"]")).sendKeys(Title);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		// Class name của phần tử cần tìm
		String targetClassName = "row-title";
		// Tìm tất cả các phần tử có class name tương ứng
		java.util.List<WebElement> elementsWithClassName = driver.findElements(By.className(targetClassName));
		boolean found = false;
		// Kiểm tra từng phần tử có nội dung mong muốn hay không
		for (WebElement element : elementsWithClassName) {
			if (element.getText().equals(Title)) {
				// Khởi tạo đối tượng Actions
				Actions actions = new Actions(driver);
				// Thực hiện hành động mouse over lên phần tử
				actions.moveToElement(element).perform();
				// Tìm thẻ a (anchor tag) là thẻ con của thẻ span
				WebElement anchorElement = driver.findElement(By.linkText("Xem"));
				// Thực hiện hành động click vào thẻ a
				anchorElement.click();
				Thread.sleep(2000);
				// Sau đó, bạn có thể thực hiện các hành động khác sau khi click (ví dụ: chuyển
				// tab, đợi trang mới nạp, etc.)
				found = true;
				break; // Kết thúc vòng lặp sau khi tìm thấy phần tử mong muốn
			}
		}
		if (!found) {
			String customErrorMessage = "Lỗi! Do không có bài viết nào giống vậy.";
			System.out.println(customErrorMessage);
			return customErrorMessage;
		} else {
			return null;
		}
	}
	public void check_Preview_article(String expectedTitle, String expectedContent) throws Exception {
		String actualTitle = driver.findElement(By.className("entry-title")).getText();
		String actualContent = driver.findElement(By.className("entry-content")).getText();
		driver.navigate().back();
		System.out.println(actualTitle);
		System.out.println(actualContent);
		Assert.assertEquals(actualTitle, expectedTitle, "Tiêu đề không khớp");
		Assert.assertEquals(actualContent, expectedContent, "Nội dung không khớp");
	}
}
