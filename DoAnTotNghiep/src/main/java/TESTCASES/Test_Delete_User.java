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
import PAGES.delete_user_page;

@Test
public class Test_Delete_User extends BaseSetup {
	private delete_user_page delete_user_page;
	private Loginpage Loginpage;


	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test(dataProvider = "testData")
	public void test_Delete_User(String user,String pass,String username, String valueToClick,String nextuser , String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_user_page = new delete_user_page(driver);
		if(!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_user_page.Delete_user(username,valueToClick,nextuser,expectedText);
		}
		
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\delete_user.xlsx", "Sheet1");
	}

}
