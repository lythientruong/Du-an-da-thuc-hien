package PAGES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class quickfix_category_page {
	private WebDriver driver;
	public quickfix_category_page(WebDriver driver) {
		this.driver = driver;

	}
	public void Quickfix_category(String titlecategory, String title, String link, String expectedText)
			throws Exception {
		clickmenuCategory();
		Thread.sleep(1000);
		String selectCategory = selectCategory(titlecategory);
		if (selectCategory == null) {
			setptitle(title);
			Thread.sleep(1000);
			setlink(link);
			btnsubmit();
			String getmessage = getmessage();
			if (getmessage != null && !getmessage.isEmpty()) {
				check_Quickfix_category(expectedText, getmessage);
			}
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
		// Class name của phần tử cần tìm
		String targetClassName = "row-title";
		// Tìm tất cả các phần tử có class name tương ứng
		java.util.List<WebElement> elementsWithClassName = driver.findElements(By.className(targetClassName));
		boolean found = false;

		for (WebElement element : elementsWithClassName) {

			if (element.getText().equals(title)) {
				WebElement parentTrElement = element.findElement(By.xpath("./ancestor::tr"));
				String id = parentTrElement.getAttribute("id");
				String xpathExpression = "//*[@id='" + id + "']/td[1]/div[2]/span[2]/button";

				Actions actions = new Actions(driver);
				actions.moveToElement(element).perform();
				WebElement anchorElement = driver.findElement(By.xpath(xpathExpression));

				Thread.sleep(1000);

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
	public void setptitle(String ptitle) throws Exception {
		WebElement elementptitle = driver.findElement(By.className("ptitle"));
		boolean exitptitle = elementptitle.isDisplayed();
		if (exitptitle) {
			elementptitle.clear();
			elementptitle.sendKeys(ptitle);
		}
	}
	public void setlink(String link) throws Exception {
		WebElement elementlink = driver.findElement(By.xpath("(//input[@name='slug'])[2]"));
		boolean exitlink = elementlink.isDisplayed();
		if (exitlink) {
			elementlink.clear();
			elementlink.sendKeys(link);
		}
	}
	public void btnsubmit() throws Exception {
		WebElement elementlink = driver.findElement(By.xpath("//button[contains(.,'Lưu các thay đổi')]"));
		boolean exitlink = elementlink.isDisplayed();
		if (exitlink) {
			elementlink.click();
			Thread.sleep(2000);
		}
	}
	public String getmessage() throws Exception {
		if (driver.findElements(By.xpath("//td/div/div/p")).size() > 0) {
			if (driver.findElement(By.xpath("//td/div/div/p")).isDisplayed()) {
				String actualText = driver.findElement(By.xpath("//td/div/div/p")).getText();
				System.out.println(actualText);
				return actualText;
			}
		}
		return null;
	}
	public void check_Quickfix_category(String actualText, String expectedText) throws Exception {
		Assert.assertEquals(actualText, expectedText, "Lỗi ");
	}
}
