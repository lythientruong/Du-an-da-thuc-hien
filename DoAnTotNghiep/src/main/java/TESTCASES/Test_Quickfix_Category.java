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
import PAGES.quickfix_category_page;

@Test
public class Test_Quickfix_Category extends BaseSetup {
	private quickfix_category_page quickfix_category_page;
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
	public void test_Quickfix_Category(String titlecategory,String title,String link,String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		quickfix_category_page = new quickfix_category_page(driver);
		quickfix_category_page.Quickfix_category(titlecategory,title,link,expectedText);
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\quickfix_category.xlsx", "Sheet1");
	}

}
