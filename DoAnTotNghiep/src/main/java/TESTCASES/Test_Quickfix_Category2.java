package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.quickfix_category_page;
@Test
public class Test_Quickfix_Category2 extends BaseSetup {
	private quickfix_category_page quickfix_category_page;
	private Loginpage Loginpage;
	private boolean isLoggedIn = false;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@BeforeMethod
	public void checkLogin() throws Exception {
		if (!isLoggedIn) {
			WebDriver driver = BaseSetup.getDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost/khoaddt/wp-login.php");
			Loginpage = new Loginpage(driver);
			Loginpage.loginsuccess("admin","admin");
			isLoggedIn = true;
		}
	}
	@Test
	public void TC01_test_Quickfix_Category() throws Exception {
		System.out.println("TESTCASE: "+count++);
		WebDriver driver = BaseSetup.getDriver();
		quickfix_category_page = new quickfix_category_page(driver);
		quickfix_category_page.Quickfix_category("Suanhanh 1","Suanhanh 1","Suanhanh1","");
	}
	@Test
	public void TC02_test_Quickfix_Category() throws Exception {
		System.out.println("TESTCASE: "+count++);
		WebDriver driver = BaseSetup.getDriver();
		quickfix_category_page = new quickfix_category_page(driver);
		quickfix_category_page.Quickfix_category("Suanhanh 2","","Suanhanh2","Yêu cầu nhập tên cho điều kiện này.");
	}
	@Test
	public void TC03_test_Quickfix_Category() throws Exception {
		System.out.println("TESTCASE: "+count++);
		WebDriver driver = BaseSetup.getDriver();
		quickfix_category_page = new quickfix_category_page(driver);
		quickfix_category_page.Quickfix_category("Suanhanh 3","Suanhanh 3","","");
	}
	@Test
	public void TC04_test_Quickfix_Category() throws Exception {
		System.out.println("TESTCASE: "+count++);
		WebDriver driver = BaseSetup.getDriver();
		quickfix_category_page = new quickfix_category_page(driver);
		quickfix_category_page.Quickfix_category("Suanhanh 3","Suanhanh 1","Suanhanh1","Slug “suanhanh1” đã sử dụng bởi một mục khác.");
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
