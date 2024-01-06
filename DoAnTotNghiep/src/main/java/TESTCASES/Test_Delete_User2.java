package TESTCASES;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.delete_user_page;
@Test
public class Test_Delete_User2 extends BaseSetup {
	private delete_user_page delete_user_page;
	private Loginpage Loginpage;


	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Delete_User() throws Exception {
		String user = "nguoiquanly";
		String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_user_page = new delete_user_page(driver);
		if(!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_user_page.Delete_user("test1","","","Đã xóa 1 người sử dụng.\r\n"
				+ "Bỏ qua thông báo này");
		}
		
	}
	@Test
	public void TC02_test_Delete_User() throws Exception {
		String user = "nguoiquanly";
		String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_user_page = new delete_user_page(driver);
		if(!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_user_page.Delete_user("test2","reassign","admin (admin)","Đã xóa 1 người sử dụng.\r\n"
				+ "Bỏ qua thông báo này");
		}
		
	}
	@Test
	public void TC03_test_Delete_User() throws Exception {
		String user = "nguoiquanly";
		String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_user_page = new delete_user_page(driver);
		if(!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_user_page.Delete_user("test3","delete","","Đã xóa 1 người sử dụng.\r\n"
				+ "Bỏ qua thông báo này");
		}
		
	}
	@Test
	public void TC04_test_Delete_User() throws Exception {
		String user = "nguoiquanly";
		String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_user_page = new delete_user_page(driver);
		if(!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_user_page.Delete_user("test1","","","");
		}
		
	}
	@Test
	public void TC05_test_Delete_User() throws Exception {
		String user = "tacgia";
		String pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/khoaddt/wp-login.php");
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user,pass);
		delete_user_page = new delete_user_page(driver);
		if(!user.equals("tacgia")&&!user.equals("bientapvien")&&!user.equals("congtacvien")&&!user.equals("thanhvien")){
		delete_user_page.Delete_user("test1","","","");
		}
		
	}

	@AfterClass
	public void tearDown() {
		quitDriver();
	}


}
