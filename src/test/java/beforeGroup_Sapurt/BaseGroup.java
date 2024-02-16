package beforeGroup_Sapurt;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class BaseGroup {
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

	
	
	
	
	@BeforeGroups(value = "group-2")
	public static void startUpGroup() {
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

	@AfterSuite
	public void close() {
		page.close();
		browser.close();
		playwright.close();
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

	@AfterGroups
	public void closeGroup() {
		page.close();
		browser.close();
		playwright.close();
	}
}
