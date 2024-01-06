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
import PAGES.add_category_page;

@Test
public class Test_Add_Category extends BaseSetup {
	private add_category_page add_category_page;
	private Loginpage Loginpage;


	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}


// 
	@Test(dataProvider = "testData")
	public void test_Add_Category(String user, String pass, String title,String link,String parent,String describe,String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		if(!user.equals("tacgia")&&!user.equals("congtacvien")&&!user.equals("thanhvien")) {
		add_category_page = new add_category_page(driver);
		add_category_page.Add_category(title,link,parent,describe,expectedText);
	}
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData(".\\resourses\\data\\add_category.xlsx", "Sheet1");
	}

}
