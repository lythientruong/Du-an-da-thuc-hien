package TESTCASES;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BASE.BaseSetup;
import BASE.ExcelUtils;
import PAGES.Loginpage;
import PAGES.update_user_page;

@Test
public class Test_Update_User extends BaseSetup {
	private update_user_page update_user_page;
	private Loginpage Loginpage;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}


	@Test(dataProvider = "testData")
	public void test_Update_User(String user, String pass,String username,String role, String fname, String lname, String email, String password,String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            // Không có cửa sổ cảnh báo nào xuất hiện, không cần làm gì cả.
        }
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		if(!user.equals("congtacvien")&&!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("thanhvien")) {
		update_user_page = new update_user_page(driver);
		update_user_page.Update_user(username,role,fname,lname,email,password,expectedText);
		}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\update_user.xlsx", "Sheet1");
	}

}
