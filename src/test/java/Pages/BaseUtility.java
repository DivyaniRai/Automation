package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseUtility {

	public static WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/BrowserDrivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("ignore-certificate-errors");
		chromeOptions.addArguments("--enable-automation");
		chromeOptions.addArguments("disable-extensions");
		chromeOptions.addArguments("--remote-debugging-port=9222");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
}
}
