package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.delete_article_page;
@Test
public class Test_Delete_Article2 extends BaseSetup {
	private delete_article_page delete_article_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Delete_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.print("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_article_page = new delete_article_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_article_page.Delete_article("xoa 1","Đãchuyển1bàiviếtvàoThùngrác.LùilạiBỏquathôngbáonày");
		}
	}
	@Test
	public void TC02_test_Delete_Article() throws Exception {
		String user = "bientapvien", pass = "1";
		System.out.print("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_article_page = new delete_article_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_article_page.Delete_article("xoa 1","Không tìm thấy bài viết nào.");
		}
	}
	@Test
	public void TC03_test_Delete_Article() throws Exception {
		String user = "congtacvien", pass = "1";
		System.out.print("TESTCASE: " + this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		delete_article_page = new delete_article_page(driver);
		if (!user.equals("tacgia") && !user.equals("congtacvien") && !user.equals("thanhvien")) {
			delete_article_page.Delete_article("","");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
