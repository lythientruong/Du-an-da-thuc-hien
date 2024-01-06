package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class delete_category_page {
	private WebDriver driver;

	public delete_category_page(WebDriver driver) {
		this.driver = driver;
	}

	public void Delete_category(String title, String expectedText) throws Exception {
		clickmenuCategory();
		String selectCategory = selectCategory(title, expectedText);
		if (selectCategory == null) {
			Thread.sleep(500);
			clickAlert();
			check_Delete_category(expectedText);
		}

	}

	public void clickmenuCategory() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a")).click();

	}

	public String selectCategory(String title, String expectedText) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).sendKeys(title);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		Thread.sleep(300);
		String targetClassName = "row-title";
		// Tìm tất cả các phần tử có class name tương ứng
		java.util.List<WebElement> elementsWithClassName = driver.findElements(By.className(targetClassName));
		boolean found = false;

		for (WebElement element : elementsWithClassName) {

			if (element.getText().equals(title)) {
				WebElement parentTrElement = element.findElement(By.xpath("./ancestor::tr"));
				String id = parentTrElement.getAttribute("id");
				String[] parts = id.split("-");
				String xpathExpression = "//*[@id=\"cb-select-" + parts[1] + "\"]";
				WebElement anchorElement = driver.findElement(By.xpath(xpathExpression));
				Thread.sleep(1000);

				anchorElement.click();

				found = true;
				break; // Kết thúc vòng lặp sau khi tìm thấy phần tử mong muốn
			}
		}

		if (!found) {
			String customErrorMessage = driver.findElement(By.xpath("//*[@id=\"the-list\"]/tr/td")).getText();
			System.out.println(customErrorMessage);
			Assert.assertEquals(customErrorMessage, expectedText);
			return customErrorMessage;	
		}

		return null;
	}

	public void clickAlert() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"bulk-action-selector-top\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"bulk-action-selector-top\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"doaction\"]")).click();
	}

	public void check_Delete_category(String expectedText) throws Exception {
		String getText = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
		expectedText = expectedText.replaceAll("\\s", "");
		getText = getText.replaceAll("\\s", ""); 
		Assert.assertEquals(getText, expectedText, "Lỗi do ");
	}

}
