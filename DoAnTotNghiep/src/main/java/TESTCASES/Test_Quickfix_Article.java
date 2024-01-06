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
import PAGES.quickfix_article_page;

@Test
public class Test_Quickfix_Article extends BaseSetup {
	private quickfix_article_page quickfix_article_page;
	private Loginpage Loginpage;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	@Test(dataProvider = "testData")
	public void test_Quickfix_Article(String user, String pass, String search, String sampletitle, String title,
			String link, String day, String month, String year, String hour, String minute, String author,
			String password, String check_private, String chuyenmuc, String tag, String status, String check_ontop,
			String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("congtacvien")&&!user.equals("thanhvien")) {
			quickfix_article_page = new quickfix_article_page(driver);
			quickfix_article_page.Quickfix_article(search, sampletitle, title, link, day, month, year, hour, minute,
					author, password, check_private, chuyenmuc, tag, status, check_ontop, expectedText);
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\quick_fix_article.xlsx", "Sheet1");
	}

}
