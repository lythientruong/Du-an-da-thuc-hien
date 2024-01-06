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
import PAGES.delete_category_page;

@Test
public class Test_Delete_Category extends BaseSetup {
	private delete_category_page delete_category_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test(dataProvider = "testData")
	public void test_Delete_Category(String user, String pass,String title, String expectedText) throws Exception {
		System.out.print("TESTCASE: "+this.count++);
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_category_page = new delete_category_page(driver);
		if(!user.equals("tacgia")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_category_page.Delete_category(title,expectedText);
		}
		Thread.sleep(1000);
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\delete_category.xlsx", "Sheet1");
	}

}
