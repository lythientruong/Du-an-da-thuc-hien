package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.quickfix_article_page;
@Test
public class Test_Quickfix_Article2 extends BaseSetup {
	private quickfix_article_page quickfix_article_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 1", "Suanhanh 1", "Suanhanh 1", "Suanhanh1", "30",
					"10-Th10", "2023", "10", "53", "admin (admin)", "", "0", "Giới thiệu, HỌC BỔNG", "Suanhanh",
					"Đã xuất bản", "0", "");
		}
	}
	@Test
	public void TC02_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 2", "Suanhanh 2", "", "Suanhanh2", "30", "10-Th10", "2023",
					"10", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản", "0",
					"Vui lòng nhập tiêu đề bài viết.");
		}
	}
	@Test
	public void TC03_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 3", "Suanhanh 3", "Suanhanh 3", "", "30", "10-Th10",
					"2023", "10", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản", "0", "");
		}
	}
	@Test
	public void TC04_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 4", "Suanhanh 4", "Suanhanh 4", "Suanhanh4", "32",
					"10-Th10", "2023", "10", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản",
					"0", "Ngày không hợp lệ.");
		}
	}
	@Test
	public void TC05_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 5", "Suanhanh 5", "Suanhanh 5", "Suanhanh5", "30",
					"02-Th2", "2023", "10", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản",
					"0", "Ngày tháng không hợp lệ");
		}
	}
	@Test
	public void TC06_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 6", "Suanhanh 6", "Suanhanh 6", "Suanhanh6", "30",
					"10-Th10", "abcd", "10", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản",
					"0", "Năm không hợp lệ");
		}
	}
	@Test
	public void TC07_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 7", "Suanhanh 7", "Suanhanh 7", "Suanhanh7", "30",
					"10-Th10", "2023", "25", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản",
					"0", "Giờ không hợp lệ");
		}
	}
	@Test
	public void TC08_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 8", "Suanhanh 8", "Suanhanh 8", "Suanhanh8", "30",
					"10-Th10", "2023", "10", "61", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản",
					"0", "Phút không hợp lệ.");
		}
	}
	@Test
	public void TC09_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 9", "Suanhanh 9", "Suanhanh 9", "Suanhanh9", "30",
					"10-Th10", "2023", "10", "53", " ", "", "0", "Giới thiệu", "Suanhanh", "Đã xuất bản", "0", "");
		}
	}
	@Test
	public void TC10_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 10", "Suanhanh 10", "Suanhanh 10", "Suanhanh10", "30",
					"10-Th10", "2023", "10", "53", "admin (admin)", "", "1", "Giới thiệu", "Suanhanh", "Đã xuất bản",
					"0", "");
		}
	}
	@Test
	public void TC11_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 11", "Suanhanh 11", "Suanhanh 11", "Suanhanh11", "30",
					"10-Th10", "2023", "10", "53", "admin (admin)", "", "0", " ", "Suanhanh", "Đã xuất bản", "0",
					"Vui lòng lựa chọn chuyên mục.");
		}
	}
	@Test
	public void TC12_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 12", "Suanhanh 12", "Suanhanh 12", "Suanhanh12", "30",
					"10-Th10", "2023", "10", "53", "admin (admin)", "", "0", "Giới thiệu", "", "Đã xuất bản", "0", "");
		}
	}
	@Test
	public void TC13_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 13", "Suanhanh 13", "Suanhanh 13", "Suanhanh13", "30",
					"10-Th10", "2023", "10", "53", "admin (admin)", "", "0", "Giới thiệu", "Suanhanh", "", "0", "");
		}
	}
	@Test
	public void TC14_test_Quickfix_Article() throws Exception {
		String user = "congtacvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("Suanhanh 14", "Suanhanh 14", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "");
		}else {
			System.out.println("Không có quyền truy cập");
		}
	}
	@Test
	public void TC15_test_Quickfix_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article("", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "");
		}else {
			System.out.println("Không có quyền truy cập");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
