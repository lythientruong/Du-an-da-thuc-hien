package TESTCASES;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.update_user_page;

@Test
public class Test_Update_User2 extends BaseSetup {
	private update_user_page update_user_page;
	private Loginpage Loginpage;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	@Test
	public void TC01_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 1", "Thành viên đăng ký", "Test Update", "User 2",
					"tesupdateuser2@gmail.com", " tesupdateuser",
					"Thành viên đã được cập nhật.\n← Quay lại Người Dùng\nBỏ qua thông báo này");
		}
	}

	@Test
	public void TC02_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 3", "", "Test Update", "User 4", "tesupdateuser4@gmail.com",
					"tesupdateuser", "Thành viên đã được cập nhật.\n← Quay lại Người Dùng\nBỏ qua thông báo này");
		}
	}

	@Test
	public void TC03_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 5", "Thành viên đăng ký", " ", "User 6",
					"tesupdateuser6@gmail.com", "tesupdateuser",
					"Thành viên đã được cập nhật.\n← Quay lại Người Dùng\nBỏ qua thông báo này");
		}
	}

	@Test
	public void TC04_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 7", "Thành viên đăng ký", "Test Update", " ",
					"tesupdateuser8@gmail.com", "tesupdateuser",
					"Thành viên đã được cập nhật.\n← Quay lại Người Dùng\nBỏ qua thông báo này");
		}
	}

	@Test
	public void TC05_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 9", "Thành viên đăng ký", "Test Update", "User 10", "",
					"tesupdateuser", "LỖI: Vui lòng nhập địa chỉ email.");
		}
	}

	@Test
	public void TC06_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 11", "Thành viên đăng ký", "Test Update", "User 12",
					"tesupdateuser12@gmail.com", "", "");
		}
	}

	@Test
	public void TC07_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("Test Update User 13", "Thành viên đăng ký", "Test Update", "User 14",
					"tesupdateuser2@gmail.com", "tesupdateuser",
					"Lỗi: Thư điện tử này đã được sử dụng, hãy chọn địa chỉ khác.");
		}
	}

	@Test
	public void TC08_test_Update_User() throws Exception {
		String user = "nguoiquanly", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("abcd", "", "", "", "", "", "");
		}
	}

	@Test
	public void TC09_test_Update_User() throws Exception {
		String user = "tacgia", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			update_user_page = new update_user_page(driver);
			update_user_page.Update_user("", "", "", "", "", "", "");
		} else {
			System.out.println("Không đủ quyền truy cập!!");
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
