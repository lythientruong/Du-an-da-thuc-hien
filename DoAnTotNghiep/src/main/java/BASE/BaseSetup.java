package BASE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSetup {
    private static WebDriver driver;

    public static void initializeChromeDriver() {
        if (driver != null) {
            return; // Already initialized
        }

        System.setProperty("webdriver.chrome.driver", "..\\DoAnTotNghiep\\resourses\\drivers\\chromedriver.exe");

		
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized. Call initializeChromeDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}