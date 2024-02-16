package base;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Base {
	public static Playwright playwright;
	public static Browser browser;
	public static Page page;

	@BeforeSuite
	public static void startUp() {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		// playwright declaration and creation
		// Playwright playwright;
		playwright = Playwright.create();

		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");

		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)
				.setExecutablePath(Paths.get(chromePath));

		// Browser browser;
		browser = playwright.chromium().launch(launchOptions);

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		// Page page;
		page = context.newPage();
	}

	public static String innerText(String xpath) {
		String s = page.locator(xpath).innerText();
		return s;
	}

	public static void fill(String xpath, String value) {
		page.locator(xpath).fill(value);
	}

	public static void navigate(String url) {
		page.navigate(url);
	}

	public static void click(String xpath) {
		page.locator(xpath).click();
	}

	public static void selectOption(String xpath, String value) {
		page.selectOption(xpath, value);
	}

	public static void assertion(String xpath, String text) {
		assertThat(page.locator(xpath)).hasText(text);
	}

	// Screen shot Method
	public static void captureScreenshot(String fileName) {
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(fileName)));
	}

	@AfterSuite
	public  void close() {
		page.close();
		browser.close();
		playwright.close();
	}

	// @AfterSuite
	// @AfterMethod
//	public static void close(ITestResult result) {
//		if (result.getStatus() != 1)
//
//			page.screenshot(new Page.ScreenshotOptions()
//					.setPath(Paths.get("C:\\Java\\Playwright Webpage\\Screenshots\\customerLoginPage.png")));
//		page.close();
//		browser.close();
//		playwright.close();
//	}

	/*
	 * @BeforeTest public static void beforeTest() throws InterruptedException {
	 * System.out.println("@BeforeTest Executed"); }
	 * 
	 * @AfterTest public static void afterTest() {
	 * System.out.println("@AfterTest Executed"); }
	 * 
	 * @BeforeClass public static void beforeTestClass() throws InterruptedException
	 * { System.out.println("@BeforeClass Executed"); }
	 * 
	 * @AfterClass public static void afterTestClass() throws InterruptedException {
	 * System.out.println("@AfterClass Executed"); }
	 * 
	 * @BeforeMethod public static void beforeTestMethod() throws
	 * InterruptedException { System.out.println("@BeforeMethod Executed"); }
	 * 
	 * @AfterMethod public static void afterTestMethod() {
	 * System.out.println("@AfterMethod Executed"); }
	 */
	/*
	@BeforeGroups(value = "regression")
	public static void groupstartUp() {
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // playwright

		playwright = Playwright.create();

		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");

		LaunchOptions launchOptions;
		launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)
				.setExecutablePath(Paths.get(chromePath));

		browser = playwright.chromium().launch(launchOptions);

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		page = context.newPage();
	}

	@BeforeGroups(value = "regression")
	public static void beforeTestGroup() throws InterruptedException {
		System.out.println("@BeforeGroups Executed");
	}

	@AfterGroups(value = "regression")
	public static void afterTestGroup() throws InterruptedException {
		System.out.println("@AfterGroups Executed");
	}
*/
}
