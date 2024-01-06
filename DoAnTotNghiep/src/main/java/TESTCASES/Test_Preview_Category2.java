package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.preview_category_page;
@Test
public class Test_Preview_Category2 extends BaseSetup {
	private preview_category_page preview_category_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Preview_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("thanhvien")) {
			preview_category_page = new preview_category_page(driver);
			preview_category_page.Preview_category("Giới thiệu");
		}
	}
	@Test
	public void TC02_test_Preview_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("thanhvien")) {
			preview_category_page = new preview_category_page(driver);
			preview_category_page.Preview_category("abcd");
		}
	}
	@Test
	public void TC03_test_Preview_Category() throws Exception {
		String user = "congtacvien", pass = "1";
		System.out.println("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("thanhvien")) {
			preview_category_page = new preview_category_page(driver);
			preview_category_page.Preview_category("Giới thiệu");
		}else {
			System.out.println("Không đủ quyền truy cập");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
