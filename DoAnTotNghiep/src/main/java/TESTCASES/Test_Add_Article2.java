package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.add_article_page;
@Test
public class Test_Add_Article2 extends BaseSetup {
	private add_article_page add_article_page;
	private Loginpage Loginpage;
	private int count = 1;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test(priority = 1)
	public void TC01_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess("admin", "admin");
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 1", "nội dung bài viết", "Chuẩn", "Giới thiệu", "tóm tắt bài viết",
				"admin (admin)", "tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 2)
	public void TC02_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("", "nội dung bài viết", "Chuẩn", "Giới thiệu", "tóm tắt bài viết",
				"admin (admin)", "tintuc.png", "Bài viết chưa được đăng. Vui lòng thêm tiêu đề bài viết.");
	}
	@Test(priority = 3)
	public void TC03_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 3", "", "Chuẩn", "Giới thiệu", "tóm tắt bài viết", "admin (admin)",
				"tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 4)
	public void TC04_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 4", "nội dung bài viết", "Chuẩn", "Giới thiệu", "", "admin (admin)",
				"tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 5)
	public void TC05_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 5", "nội dung bài viết", "Chuẩn", "Giới thiệu", "tóm tắt bài viết", "",
				"tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 6)
	public void TC06_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 6", "nội dung bài viết", "", "Giới thiệu", "tóm tắt bài viết",
				"admin (admin)", "tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 7)
	public void TC07_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 7", "nội dung bài viết", "Chuẩn", "", "tóm tắt bài viết",
				"admin (admin)", "tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 8)
	public void TC08_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 8", "nội dung bài viết", "Chuẩn", "Giới thiệu", "tóm tắt bài viết",
				"admin (admin)", "", "Bài viết đã được đăng. Xem bài viết");
	}
	@Test(priority = 9)
	public void TC09_test_Add_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		System.out.println("TESTCASE: " + count++);
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article("Test Add 1", "nội dung bài viết", "Chuẩn", "Giới thiệu", "tóm tắt bài viết",
				"admin (admin)", "tintuc.png", "Bài viết đã được đăng. Xem bài viết");
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
