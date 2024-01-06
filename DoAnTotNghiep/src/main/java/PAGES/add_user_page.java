package PAGES;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class add_user_page {
	private WebDriver driver;
	public add_user_page(WebDriver driver) {
		this.driver = driver;
	}
	public void Add_user(String username, String email, String fname, String lname, String url, String password,
			String role, String expectedText) throws Exception {
		clickaddUser();
		Thread.sleep(200);
		set_Username(username);
		Thread.sleep(200);
		set_Email(email);
		Thread.sleep(200);
		set_fisrtName(fname);
		Thread.sleep(200);
		set_lastName(lname);
		Thread.sleep(200);
		set_Url(url);
		Thread.sleep(200);
		setpassword(password);
		Thread.sleep(200);
		click_WeakPw();
		Thread.sleep(200);
		click_SentInfo();
		Thread.sleep(200);
		selectRole(role);
		Thread.sleep(200);
		if (!password.isEmpty()) {
			click_Add();
			check_Add_user(expectedText);
			
		} else {
			System.out.println("Nút thêm người dùng mới chưa được click!!!");
		}	
	}
	public void clickmenuUser() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-users\"]/a/div[3]")).click();
	}
	public void clickaddUser() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"menu-users\"]/a/div[3]")).click();
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[@id=\"menu-users\"]/ul/li[3]/a")).click();
	}
	public void set_Username(String username) {
		boolean display = driver.findElement(By.id("user_login")).isDisplayed();
		if (display) {
			driver.findElement(By.id("user_login")).clear();
			driver.findElement(By.id("user_login")).sendKeys(username);
		}
	}
	public void set_Email(String email) {
		boolean display = driver.findElement(By.id("email")).isDisplayed();
		if (display) {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(email);
		}
	}
	public void set_fisrtName(String fname) {
		boolean display = driver.findElement(By.id("first_name")).isDisplayed();
		if (display) {
			driver.findElement(By.id("first_name")).clear();
			driver.findElement(By.id("first_name")).sendKeys(fname);
		}
	}
	public void set_lastName(String lname) {
		boolean display = driver.findElement(By.id("last_name")).isDisplayed();
		if (display) {
			driver.findElement(By.id("last_name")).clear();
			driver.findElement(By.id("last_name")).sendKeys(lname);
		}
	}
	public void set_Url(String Url) {
		boolean display = driver.findElement(By.id("url")).isDisplayed();
		if (display) {
			driver.findElement(By.id("url")).clear();
			driver.findElement(By.id("url")).sendKeys(Url);
		}
	}
	public void setpassword(String password)throws Exception {
		boolean display = driver.findElement(By.xpath("//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button"))
				.isDisplayed();
		if (display) {
			driver.findElement(By.xpath("//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")).click();
			driver.findElement(By.id("pass1")).clear();
			driver.findElement(By.id("pass1")).sendKeys(password);
			
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
	public void click_SentInfo() {
		boolean display = driver.findElement(By.id("send_user_notification")).isDisplayed();
		if (display) {
			boolean checked = driver.findElement(By.id("send_user_notification")).isSelected();
			if (!checked) {
				driver.findElement(By.id("send_user_notification")).click();
			}
		}
	}
	public void selectRole(String role) throws Exception {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, arguments[0]);", "200");
	    Thread.sleep(500);

	    WebElement selectElementauthor = driver.findElement(By.id("role"));
	    Select selectObjectauthor = new Select(selectElementauthor);
	    List<WebElement> options = selectObjectauthor.getOptions();
	    boolean found = false;
	    for (WebElement option : options) {
	        String optionText = option.getText();
	        if (optionText.equals(role)) {
	            selectObjectauthor.selectByVisibleText(optionText);
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        selectObjectauthor.selectByVisibleText("Thành viên đăng ký");
	    }
	}
	public void click_Add() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean display = driver.findElement(By.id("createusersub")).isDisplayed();
		if (display) {
			driver.findElement(By.id("createusersub")).click();
		}
		js.executeScript("window.scrollBy(0, arguments[0]);", "-500");
		Thread.sleep(2000);
	}

	public void check_Add_user(String expectedText) throws Exception {
		boolean exiterror = driver.findElements(By.className("error")).size() > 0;
		boolean exitmessage = driver.findElements(By.id("message")).size() > 0;
		if (exiterror) {
			String error = driver.findElement(By.className("error")).getText();
			System.out.println(error);
			expectedText = expectedText.replaceAll("\\s", "");
			error = error.replaceAll("\\s", ""); 
			Assert.assertEquals(error, expectedText, "Testcase thất bại");
		}
		if (exitmessage) {
			String message = driver.findElement(By.id("message")).getText();
			System.out.println(message);
			expectedText = expectedText.replaceAll("\\s", "");
			message = message.replaceAll("\\s", ""); 
			Assert.assertEquals(message, expectedText, "Testcase thất bại");
		}
		Thread.sleep(500);
	}
}
