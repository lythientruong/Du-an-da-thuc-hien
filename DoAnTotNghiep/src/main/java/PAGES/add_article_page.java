package PAGES;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
public class add_article_page {
	private WebDriver driver;
	public add_article_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Add_article(String title, String content, String choice, String chuyenmuc, String excerpt,
			String author, String targetImageName,String expectedText) throws Exception {
		clickmenuarticle();
		settitle(title);
		setcontent(content);
		setexcerpt(excerpt);
		selectauthor(author);
		setformat(choice);
		if(chuyenmuc !=null && !chuyenmuc.isEmpty()){
		setcategory(chuyenmuc);
		}
		setthumbnail(targetImageName);
		buttonpost();
		check_Add_article(expectedText);
	}
	private void buttonpost() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", "-1000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"publish\"]")).click();
		Thread.sleep(3000);

	}
	private void setthumbnail(String targetImageName) throws Exception {
		driver.findElement(By.id("set-post-thumbnail")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"menu-item-browse\"]")).click();
		driver.findElement(By.id("media-search-input")).clear();
		driver.findElement(By.id("media-search-input")).sendKeys(targetImageName);
		if(driver.findElement(By.xpath("//*[@id=\"__attachments-view-48\"]/li[1]/div")).isDisplayed()){
		driver.findElement(By.xpath("//*[@id=\"__attachments-view-48\"]/li[1]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"__wp-uploader-id-0\"]/div[4]/div/div[2]/button")).click();
		Thread.sleep(2000);
		}else{
			driver.findElement(By.xpath("//*[@id=\"__wp-uploader-id-2\"]/div[1]/button/span")).click();
		}
	}
	private void setcategory(String chuyenmuc) {
		driver.findElement(By.xpath("//*[@id=\"category-tabs\"]/li[2]/a")).click();
		List<WebElement> checkboxElementss = driver.findElements(By.className("selectit"));
		String[] giaTriMongMuon = chuyenmuc.split(", ");
		for (WebElement checkboxElement : checkboxElementss) {
			String checkboxText = checkboxElement.getText();
			for (String giaTri : giaTriMongMuon) {
				System.out.println(checkboxText);
				if (checkboxText.equals(giaTri)) {
					checkboxElement.click();
					break;
				}
			}
		}

	}
	private void setformat(String choice) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", "-200");
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
			System.out.println("Lựa chọn không hợp lệ");
			break;
		}
	}
	public void selectauthor(String author) throws Exception {
		WebElement selectElementauthor = driver.findElement(By.id("post_author_override"));
		Select selectObjectauthor = new Select(selectElementauthor);
		List<WebElement> options = selectObjectauthor.getOptions();
		boolean found = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(author)) {
				selectObjectauthor.selectByVisibleText(optionText);
				found = true;
				break;
			}
		}
		if (!found) {
			selectObjectauthor.selectByVisibleText("admin (admin)");
		}
	}
	private void setexcerpt(String excerpt) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		js.executeScript("window.scrollBy(0, arguments[0]);", "200");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("excerpt")));
		driver.findElement(By.id("excerpt")).sendKeys(excerpt);
		Thread.sleep(1000);
	}
	private void setcontent(String content) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0]);", "200");
		Thread.sleep(500);
		driver.findElement(By.id("content-html")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]")).sendKeys(content);
		Thread.sleep(500);
	}
	private void settitle(String title) throws Exception {
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys(title);
		Thread.sleep(500);
	}
	private void clickmenuarticle() {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[3]/a")).click();
	}
	public void check_Add_article(String expectedText) throws Exception {
		String message = driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();
		Assert.assertEquals(message, expectedText, "Testcase thất bại");
	}
}
