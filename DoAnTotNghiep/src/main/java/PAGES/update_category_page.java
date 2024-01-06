package PAGES;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class update_category_page {
	private WebDriver driver;

	public update_category_page(WebDriver driver) {
		this.driver = driver;
	}

	public void Update_category(String name, String title, String link, String parent, String describe,
			String expectedText) throws Exception {
		clickmenuCategory();
		String selectCategory = selectCategory(name);
		if(selectCategory==null) {
		settagname(title);

		settaglink(link);

		selectparent(parent);

		setdescribe(describe);
		Thread.sleep(2000);
		clickpost();
		Thread.sleep(500);
		if (!title.isEmpty()) {
			check_Update_category(expectedText);
		}
		}
	}

	public void clickmenuCategory() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a")).click();

	}

	public String selectCategory(String name) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).clear();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"tag-search-input\"]")).sendKeys(name);
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[@id=\"search-submit\"]")).click();
		Thread.sleep(300);
		// Class name của phần tử cần tìm
		String targetClassName = "row-title";
		// Tìm tất cả các phần tử có class name tương ứng
		java.util.List<WebElement> elementsWithClassName = driver.findElements(By.className(targetClassName));
		boolean found = false;

		for (WebElement element : elementsWithClassName) {

			if (element.getText().equals(name)) {

				Actions actions = new Actions(driver);
				actions.moveToElement(element).perform();
				WebElement anchorElement = driver.findElement(By.linkText("Chỉnh sửa"));

				Thread.sleep(1000);

				anchorElement.click();

				found = true;
				break; // Kết thúc vòng lặp sau khi tìm thấy phần tử mong muốn
			}
		}

		if (!found) {
			String customErrorMessage = "Lỗi! Do không có chuyên mục nào giống vậy.";

			System.out.println(customErrorMessage);
			return customErrorMessage;
		}return null;
	}

	public void settagname(String title) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(title);
	}

	public void settaglink(String link) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"slug\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"slug\"]")).sendKeys(link);
	}

	public void selectparent(String parent) throws Exception {
	    WebElement selectElementRole = driver.findElement(By.xpath("//*[@id=\"parent\"]"));
	    Select selectObjectRole = new Select(selectElementRole);

	    // Lấy danh sách các tùy chọn
	    List<WebElement> options = selectObjectRole.getOptions();

	    // Sử dụng biến để kiểm tra xem có tùy chọn nào giống với tùy chọn mẹ không
	    boolean roleFound = false;
	    for (WebElement option : options) {
	        if (option.getText().equals(parent)) {
	            roleFound = true;
	            break;
	        }
	    }

	    // Nếu không tìm thấy tùy chọn mẹ giống, chọn "Trống"
	    if (!roleFound) {
	        parent = "Trống";
	    }

	    // Thực hiện hành động tương ứng
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, arguments[0]);", "400");
	    selectElementRole.click();
	    Thread.sleep(500);
	    selectObjectRole.selectByVisibleText(parent);
	    Thread.sleep(500);
	}

	public void setdescribe(String describe) throws Exception {
		driver.findElement(By.xpath("//*[@id=\"description\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys(describe);
	}

	public void clickpost() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"edittag\"]/div/input")).click();
		Thread.sleep(500);
	}

	public void check_Update_category(String expectedText) throws Exception {
		String actualText = driver.findElement(By.xpath("//*[@id=\"message\"]/p[1]")).getText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText);
		Thread.sleep(2000);

	}
}
