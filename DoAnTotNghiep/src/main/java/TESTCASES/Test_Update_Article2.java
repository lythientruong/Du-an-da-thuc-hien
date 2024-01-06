package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.update_article_page;
@Test
public class Test_Update_Article2 extends BaseSetup {
	private update_article_page update_article_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test(priority = 1)
	public void TC01_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 1", "Chinhsua 2", "nội dung bài viết", "chuẩn",
					"Giới thiệu", "tóm tắt bài viết", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 2)
	public void TC02_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 3", "", "nội dung bài viết", "chuẩn", "Giới thiệu",
					"tóm tắt bài viết", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 3)
	public void TC03_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 5", "Chinhsua 6", "", "chuẩn", "Giới thiệu",
					"tóm tắt bài viết", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 4)
	public void TC04_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 7", "Chinhsua 8", "nội dung bài viết", "",
					"Giới thiệu", "tóm tắt bài viết", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 5)
	public void TC05_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 9", "Chinhsua 10", "nội dung bài viết", "chuẩn", "",
					"tóm tắt bài viết", "", "tintuc.png",
					"Bài viết chưa được cập nhật. Vui lòng chọn chuyên mục.");
		}
	}
	@Test(priority = 6)
	public void TC06_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 11", "Chinhsua 12", "nội dung bài viết", "chuẩn",
					"Giới thiệu", "", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 7)
	public void TC07_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 13", "Chinhsua 14", "nội dung bài viết", "chuẩn",
					"Giới thiệu", "tóm tắt bài viết", "", "",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 8)
	public void TC08_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 15", "Chinhsua 2", "nội dung bài viết", "chuẩn",
					"Giới thiệu", "tóm tắt bài viết", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 9)
	public void TC09_test_Update_Article() throws Exception {
		String user = "admin", pass = "admin";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "Chinhsua 17", "Chinhsua 18", "nội dung bài viết", "chuẩn",
					"Giới thiệu", "tóm tắt bài viết", "", "tintuc.png",
					"Bài viết đã được cập nhật. Xem bài viết\nBỏ qua thông báo này");
		}
	}
	@Test(priority = 10)
	public void TC010_test_Update_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "abcd", "", "", "", "", "", "", "", "");
		}
	}
	@Test(priority = 11)
	public void TC011_test_Update_Article() throws Exception {
		String user = "thanhvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, "", "", "", "", "", "", "", "", "");
		} else {
			System.out.println("Không đủ quyền truy cập.");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
