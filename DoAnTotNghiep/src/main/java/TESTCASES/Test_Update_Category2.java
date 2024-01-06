package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.update_category_page;
@Test
public class Test_Update_Category2 extends BaseSetup {
	private update_category_page update_category_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("Test Chinh Sua 1", "Test Chinh Sua 2", "testchinhsua2", "Trống",
					"Test Chinh Sua 2", "Chuyện mục đã được cập nhật.");
		}
	}
	@Test
	public void TC02_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("Test Chinh Sua 3", "", "testchinhsua4", "Trống", "Test Chinh Sua 4",
					"");
		}
	}
	@Test
	public void TC03_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("Test Chinh Sua 5", "Test Chinh Sua 6", " ", "Trống",
					"Test Chinh Sua 6", "Chuyện mục đã được cập nhật.");
		}
	}
	@Test
	public void TC04_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("Test Chinh Sua 7", "Test Chinh Sua 8", "testchinhsua8", "", "Test Chinh Sua 8", "Chuyện mục đã được cập nhật.");
		}
	}
	@Test
	public void TC05_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("Test Chinh Sua 9", "Test Chinh Sua 10", "testchinhsua10", "Trống", "", "Chuyện mục đã được cập nhật.");
		}
	}
	@Test
	public void TC06_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("Test Chinh Sua 11", "Test Chinh Sua 2", "testchinhsua2", "Trống", "Test Chinh Sua 12", "Chuyên mục chưa được cập nhật.");
		}
	}
	@Test
	public void TC07_test_Update_Category() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("abcd", "", "", "", "", "");
		}
	}
	@Test
	public void TC08_test_Update_Category() throws Exception {
		String user = "tacgia", pass = "1";
		System.out.println("TESTCASE: " + count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien")) {
			Loginpage.loginsuccess(user, pass);
			update_category_page = new update_category_page(driver);
			update_category_page.Update_category("", "", "", "", "", "");
		}else {
			System.out.println("Không đủ quyền truy cập");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}
}
