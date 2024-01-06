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
import PAGES.delete_article_page;

@Test
public class Test_Delete_Article extends BaseSetup {
	private delete_article_page delete_article_page;
	private Loginpage Loginpage;
	private boolean isLoggedIn = false;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	@Test(dataProvider = "testData")
	public void test_Delete_Article(String user, String pass,String title, String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_article_page = new delete_article_page(driver);
		if(!user.equals("tacgia")&&!user.equals("congtacvien")&&!user.equals("thanhvien")) {
		delete_article_page.Delete_article(title,expectedText);
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\delete_article.xlsx", "Sheet1");
	}

}
