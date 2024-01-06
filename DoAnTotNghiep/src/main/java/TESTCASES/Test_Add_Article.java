package TESTCASES;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import BASE.ExcelUtils;
import PAGES.Loginpage;
import PAGES.add_article_page;
@Test
public class Test_Add_Article extends BaseSetup {
	private add_article_page add_article_page;
	private Loginpage Loginpage;
	private boolean isLoggedIn = false;
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

	@Test(dataProvider = "testData")
	public void test_Add_Article(String title,String content,String choice,String chuyenmuc,String excerpt, String author,String targetImageName, String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		add_article_page = new add_article_page(driver);
		add_article_page.Add_article(title,content,choice,chuyenmuc,excerpt,author,targetImageName,expectedText);
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}
	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\add_article.xlsx", "Sheet1");
	}
}
