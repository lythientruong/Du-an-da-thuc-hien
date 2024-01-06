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
import PAGES.update_category_page;

@Test
public class Test_Update_Category extends BaseSetup {
	private update_category_page update_category_page;
	private Loginpage Loginpage;


	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}


	@Test(dataProvider = "testData")
	public void test_Update_Category(String user, String pass,String name, String title, String link, String parent, String describe,String expectedText ) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		if(!user.equals("tacgia")&&!user.equals("congtacvien")){
		Loginpage.loginsuccess(user,pass);
		update_category_page = new update_category_page(driver);
		update_category_page.Update_category(name,title,link,parent,describe,expectedText);
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\update_category.xlsx", "Sheet3");
	}

}
