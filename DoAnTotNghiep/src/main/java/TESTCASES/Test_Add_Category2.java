package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.add_category_page;
@Test
public class Test_Add_Category2 extends BaseSetup {
	private add_category_page add_category_page;
	private Loginpage Loginpage;
	private int count = 1;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	public void TC01_test_Add_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			add_category_page = new add_category_page(driver);
			add_category_page.Add_category("test1", "test1", "Trống", "test1", "");
		}
	}
	public void TC02_test_Add_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			add_category_page = new add_category_page(driver);
			add_category_page.Add_category("test1", "test1", "Trống", "test1", "Thẻ này đã được sử dụng.");
		}
	}
	public void TC03_test_Add_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			add_category_page = new add_category_page(driver);
			add_category_page.Add_category("", "test2", "Trống", "test2", "");
		}
	}
	public void TC04_test_Add_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			add_category_page = new add_category_page(driver);
			add_category_page.Add_category("test3", "", "Trống", "test3", "");
		}
	}
	public void TC05_test_Add_Category() throws Exception {
		String user = "tacgia", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			add_category_page = new add_category_page(driver);
			add_category_page.Add_category("test4", "test4", "Trống", "test4", "");
		}else {
			System.out.println("Không đủ quyền truy cập.");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}


}
