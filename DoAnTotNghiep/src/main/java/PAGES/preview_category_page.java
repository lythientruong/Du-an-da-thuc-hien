package PAGES;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class preview_category_page {
	private WebDriver driver;
	public preview_category_page(WebDriver driver) {
		this.driver = driver;

	}
	public void Preview_category(String title) throws Exception {
		clickmenuCategory();
		String selectCategory = selectCategory(title);
		Thread.sleep(3000);
		if (selectCategory == null) {
			check_Preview_category();
		}
	}

	public void clickmenuCategory() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a")).click();
	}
	public String selectCategory(String title) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).sendKeys(title);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		Thread.sleep(300);
		String targetClassName = "row-title";
		java.util.List<WebElement> elementsWithClassName = driver.findElements(By.className(targetClassName));
		boolean found = false;
		for (WebElement element : elementsWithClassName) {
			if (element.getText().equals(title)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).perform();
				WebElement anchorElement = driver.findElement(By.linkText("Xem"));
				anchorElement.click();
				found = true;
				break;
			}
		}

		if (!found) {
			String customErrorMessage = "Lỗi! Do không có chuyên mục nào giống vậy.";
			System.out.println(customErrorMessage);
			return customErrorMessage;
		}
		return null;
	}
	public void check_Preview_category() throws Exception {
		WebElement mainElement = driver.findElement(By.xpath("//*[@id='main']"));
		// Tìm các phần tử con là thẻ <article>
		List<WebElement> articles = mainElement.findElements(By.tagName("article"));
		// Đếm số lượng phần tử <article>
		int articleCount = articles.size();
		// In ra số lượng phần tử <article>
		System.out.println("Số lượng phần tử <article> trong #main: " + articleCount);
		WebElement actualName = driver.findElement(By.className("entry-header"));
		Assert.assertTrue(actualName.isDisplayed(), "Tên chuyên mục không hiển thị");
		System.out.println(actualName.getText());
		WebElement actualTitle = driver.findElement(By.xpath("//*[@id=\"main\"]/header/h1"));
		Assert.assertTrue(actualTitle.isDisplayed(), "Tiêu đề chuyên mục không hiển thị");
		System.out.println(actualTitle.getText());

	}
}
