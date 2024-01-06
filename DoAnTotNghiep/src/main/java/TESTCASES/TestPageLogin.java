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

@Test
public class TestPageLogin extends BaseSetup {
	private Loginpage Loginpage;

	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}

	@Test(dataProvider = "testData")
	public void testLogin(String user, String pass, String expectedText) throws Exception {
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		Loginpage.checklogin(expectedText);
		System.out.println("Data from Excel: " + user + ", " + pass + ", " + expectedText);
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() throws IOException {
		return ExcelUtils.getTestData("login.xlsx", "Sheet1");
	}

}
