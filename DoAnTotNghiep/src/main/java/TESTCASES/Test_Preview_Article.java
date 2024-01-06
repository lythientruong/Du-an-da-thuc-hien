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
import PAGES.preview_article_page;

@Test
public class Test_Preview_Article extends BaseSetup {
	private preview_article_page preview_article_page;
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
	public void test_Preview_Article(String Title,String expectedTitle, String expectedContent) throws Exception {
        	WebDriver driver = BaseSetup.getDriver();
    		preview_article_page = new preview_article_page(driver);
    		preview_article_page.Preview_article(Title,expectedTitle,expectedContent);
    		
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\preview_article.xlsx", "Sheet1");
	}

}
