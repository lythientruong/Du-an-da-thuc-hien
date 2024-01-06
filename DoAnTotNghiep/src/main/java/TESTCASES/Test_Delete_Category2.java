package TESTCASES;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.delete_category_page;

@Test
public class Test_Delete_Category2 extends BaseSetup {
	private delete_category_page delete_category_page;
	private Loginpage Loginpage;
	private int count = 1;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Delete_Category() throws Exception {
		System.out.print("TESTCASE: "+this.count++);
		String user = "bientapvien", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_category_page = new delete_category_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_category_page.Delete_category("test 1","Các chuyên mục đã bị xóa.\r\n"
					+ "Bỏ qua thông báo này");
		}else {
			System.out.print("Không có quyền truy cập vào chuyên mục");
		}
		Thread.sleep(1000);
	}
	@Test
	public void TC02_test_Delete_Category() throws Exception {
		System.out.print("TESTCASE: "+this.count++);
		String user = "bientapvien", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_category_page = new delete_category_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_category_page.Delete_category("test 2","Xóa chuyên mục không thành công, có 1 bài viết được liên kết.");
		}else {
			System.out.print("Không có quyền truy cập vào chuyên mục");
		}
		Thread.sleep(1000);
	}
	@Test
	public void TC03_test_Delete_Category() throws Exception {
		System.out.print("TESTCASE: "+this.count++);
		String user = "bientapvien", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_category_page = new delete_category_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_category_page.Delete_category("test 3","Không tìm thấy mục nào.");
		}else {
			System.out.print("Không có quyền truy cập vào chuyên mục");
		}
		Thread.sleep(1000);
	}
	@Test
	public void TC04_test_Delete_Category() throws Exception {
		System.out.print("TESTCASE: "+this.count++);
		String user = "tacgia", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_category_page = new delete_category_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_category_page.Delete_category("","");
		}else {
			System.out.print("Không có quyền truy cập vào chuyên mục");
		}
		Thread.sleep(1000);
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
