package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.preview_user_page;
@Test
public class Test_Preview_User2 extends BaseSetup {
	private preview_user_page preview_user_page;
	private Loginpage Loginpage;
	private int count = 1;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	@Test
	public void TC01_test_Preview_User() throws Exception {
		System.out.println("TESTCASE: "+this.count++);
		String user = "nguoiquanly"; String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			preview_user_page = new preview_user_page(driver);
			preview_user_page.Preview_user("admin");
		} else {
			System.out.println("Không truy cập vào menu thành viên được.");
		}
	}
	@Test
	public void TC02_test_Preview_User() throws Exception {
		System.out.println("TESTCASE: "+this.count++);
		String user = "nguoiquanly"; String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			preview_user_page = new preview_user_page(driver);
			preview_user_page.Preview_user("abcd");
		} else {
			System.out.println("Không truy cập vào menu thành viên được.");
		}
	}
	@Test
	public void TC03_test_Preview_User() throws Exception {
		System.out.println("TESTCASE: "+this.count++);
		String user = "tacgia"; String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			preview_user_page = new preview_user_page(driver);
			preview_user_page.Preview_user("admin");
		} else {
			System.out.println("Không truy cập vào menu thành viên được.");
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
