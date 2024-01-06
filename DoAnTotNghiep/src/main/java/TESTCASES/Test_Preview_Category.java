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
import PAGES.preview_category_page;

@Test
public class Test_Preview_Category extends BaseSetup {
	private preview_category_page preview_category_page;
	private Loginpage Loginpage;


	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test(dataProvider = "testData")
	public void test_Preview_Category(String user, String pass,String title) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		if(!user.equals("congtacvien")&&!user.equals("tacgia")&&!user.equals("thanhvien")){
		preview_category_page = new preview_category_page(driver);
		preview_category_page.Preview_category(title);
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\preview_category.xlsx", "Sheet1");
	}

}
