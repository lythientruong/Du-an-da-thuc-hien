package TESTCASES;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BASE.BaseSetup;
import PAGES.Loginpage;
import PAGES.add_user_page;
@Test
public class Test_Add_User2 extends BaseSetup {
	private add_user_page add_user_page;
	private Loginpage Loginpage;
	private int count = 1;
	@BeforeClass
	public void setUp() {
		BaseSetup.initializeChromeDriver();
	}
	@Test
	public void TC01_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		String user = "nguoiquanly", pass = "1";
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
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			add_user_page = new add_user_page(driver);

			add_user_page.Add_user("Test 1", "test1@gmail.com", "Test", "1", "test1.com", "test112345",
					"Thành viên đăng ký", "Thành viên mới đã được tạo. Sửa tài khoản\r\nBỏ qua thông báo này");
		} else {
			System.out.println("Không có quyền truy cập");
		}
	}
	@Test
	public void TC02_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user(" ", "test2@gmail.com", "Test", "2", "test2.com", "test212345", "Thành viên đăng ký",
				"LỖI: Xin điền tên người dùng.\r\n"
						+ "LỖI: Tên người dùng này không được chấp nhận vì có chứa các ký tự bị cấm. Hãy điền tên người dùng hợp lệ.");
	}
	@Test
	public void TC03_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 3", "", "Test", "3", "test3.com", "test312345", "Thành viên đăng ký", "");
	}
	@Test
	public void TC04_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 4", "test4@gmail.com", "", "4", "test4.com", "test412345", "Thành viên đăng ký",
				"Thành viên mới đã được tạo. Sửa tài khoản\r\nBỏ qua thông báo này");
	}
	@Test
	public void TC05_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 5", "test5@gmail.com", "Test", "", "test3.com", "test512345", "Thành viên đăng ký",
				"Thành viên mới đã được tạo. Sửa tài khoản\r\nBỏ qua thông báo này");
	}
	@Test
	public void TC06_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 6", "test6@gmail.com", "Test", "6", "", "test612345", "Thành viên đăng ký",
				"Thành viên mới đã được tạo. Sửa tài khoản\r\nBỏ qua thông báo này");
	}
	@Test
	public void TC07_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 7", "test7@gmail.com", "Test", "7", "test7.com", "", "Thành viên đăng ký", "");

	}
	@Test
	public void TC08_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 8", "test8@gmail.com", "Test", "8", "test8.com", "test812345", "",
				"Thành viên mới đã được tạo. Sửa tài khoản\r\nBỏ qua thông báo này");
	}
	@Test
	public void TC09_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 9", "test9gmail.com", "Test", "9", "test9.com", "test912345", "Thành viên đăng ký",
				"LỖI: Địa chỉ email không đúng.");

	}
	@Test
	public void TC10_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		add_user_page.Add_user("Test 1", "test11@gmail.com", "Test", "11", "test11.com", "test1112345",
				"Thành viên đăng ký", "LỖI: Tên người dùng này đã được đăng ký. Vui lòng chọn một tên khác.");
	}
	@Test
	public void TC11_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
			add_user_page.Add_user("Test 11", "test1@gmail.com", "Test", "1", "test1.com", "test112345",
					"Thành viên đăng ký", "Lỗi: Thư điện tử này đã được sử dụng, hãy chọn địa chỉ khác.");
	}
	@Test
	public void TC12_test_Add_user() throws Exception {
		System.out.println("TESTCASE: " + count++);
		String user = "congtacvien", pass = "1";
		WebDriver driver = BaseSetup.getDriver();
		driver.get("http://localhost/khoaddt/wp-login.php");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			// Không có cửa sổ cảnh báo nào xuất hiện, không cần làm gì cả.
		}
		Loginpage = new Loginpage(driver);
		Loginpage.loginsuccess(user, pass);
		if (!user.equals("congtacvien") && !user.equals("tacgia") && !user.equals("bientapvien")
				&& !user.equals("thanhvien")) {
			add_user_page = new add_user_page(driver);

			add_user_page.Add_user("Test 1", "test1@gmail.com", "Test", "1", "test1.com", "test112345",
					"Thành viên đăng ký", "Thành viên mới đã được tạo. Sửa tài khoản\r\nBỏ qua thông báo này");
		} else {
			System.out.println("Không có quyền truy cập");
		}
	}
	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
