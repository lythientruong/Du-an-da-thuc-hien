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
import PAGES.preview_user_page;

@Test
public class Test_Preview_User extends BaseSetup {
	private preview_user_page preview_user_page;
	private Loginpage Loginpage;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test(dataProvider = "testData")
	public void test_Preview_User(String user, String pass,String username) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		if(!user.equals("congtacvien")&&!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("thanhvien")) {
		preview_user_page = new preview_user_page(driver);
		preview_user_page.Preview_user(username);	
		}else {
			System.out.println("Không truy cập vào menu thành viên được.");
		}
		
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\preview_user.xlsx", "Sheet1");
	}

}
