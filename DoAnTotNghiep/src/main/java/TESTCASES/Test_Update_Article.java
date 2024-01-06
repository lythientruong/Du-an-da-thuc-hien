package TESTCASES;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BASE.BaseSetup;
import BASE.ExcelUtils;
import PAGES.Loginpage;
import PAGES.update_article_page;

@Test
public class Test_Update_Article extends BaseSetup {
	private update_article_page update_article_page;
	private Loginpage Loginpage;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	@Test(dataProvider = "testData")
	public void test_Update_Article(String user, String pass, String tenmau, String title, String content,
			String choice, String chuyenmuc, String excerpt, String author, String targetImageName,
			String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("tacgia") && !user.equals("thanhvien")) {
			update_article_page = new update_article_page(driver);
			update_article_page.Update_article(user, tenmau, title, content, choice, chuyenmuc, excerpt, author,
					targetImageName, expectedText);
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\update_article.xlsx", "Sheet1");
	}

}
