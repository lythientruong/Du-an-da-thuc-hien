package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.preview_article_page;
@Test
public class Test_Preview_Article2 extends BaseSetup {
	private preview_article_page preview_article_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Preview_Article() throws Exception {
		System.out.println("TESTCASE: "+this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess("admin", "admin");
		preview_article_page = new preview_article_page(driver);
		preview_article_page.Preview_article("Quỹ khuyến học","Quỹ khuyến học", "Quỹ khuyến học");
	}
	@Test
	public void TC02_test_Preview_Article() throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		preview_article_page = new preview_article_page(driver);
		preview_article_page.Preview_article("abcd","abcd", "abcd");
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
