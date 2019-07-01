package utilityData;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	
	
	static String DateAndTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	/**
	 * launch the Browser
	 * 
	 * @param browsername
	 */

	static Logger log = Logger.getLogger("Keyword");

	public static void openBrowser(String browsername) {
		PropertyConfigurator.configure("log4j.properties");
		switch (browsername) {
		case "chrome":
			if (browsername.equalsIgnoreCase("CHROME")) {
				Constants.driver = new ChromeDriver();
				log.info(browsername + "successfully launch");
				break;
			}
		case "firefox":
			if (browsername.equalsIgnoreCase("FIREFOX")) {
				Constants.driver = new FirefoxDriver();
				log.info(browsername + "successfully launch");
				break;
			}
		case "ie":
			if (browsername.equalsIgnoreCase("IE")) {
				Constants.driver = new InternetExplorerDriver();
				break;
			}
		case "opera":
			Constants.driver = new OperaDriver();
			break;
		default:
			System.out.println("No such broswer found or invalid broswer name");
			break;

		}
	}

	/**
	 * 
	 * @param locatorType it should be in lower Case .
	 * @param locator
	 * @return
	 */
	private static WebElement getData(String locatorType, String locator) {

		switch (locatorType) {
		case "xpath":
			Constants.element = Constants.driver.findElement(By.xpath(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "name":
			Constants.element = Constants.driver.findElement(By.name(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "id":
			Constants.element = Constants.driver.findElement(By.id(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "linkText":
			Constants.element = Constants.driver.findElement(By.linkText(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "partialLinkText":
			Constants.element = Constants.driver.findElement(By.partialLinkText(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "cssSelector":
			Constants.element = Constants.driver.findElement(By.cssSelector(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "tagName":
			Constants.element = Constants.driver.findElement(By.tagName(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		case "className":
			Constants.element = Constants.driver.findElement(By.className(locator));
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		default:
			System.out.println("Locator Type or Locator Value didn't find");
			log.info("locate successfully locatorType and locatorValue in DOM");
			break;
		}
		return Constants.element;
	}

	/**
	 * maximize your webPage
	 */
	public static void windowMaximize() {
		Constants.driver.manage().window().maximize();
		log.info("Window size maximize successfully");
	}

	/**
	 * Use to wait the WebPage or WebElement for particular seconds
	 * 
	 * @param timeInMiliSeconds
	 */
	public static void sleepTime(long timeInMiliSeconds) {
		try {
			Thread.sleep(timeInMiliSeconds);
			log.info("wait for " + timeInMiliSeconds);
		} catch (InterruptedException e) {
			System.out.println("Invalid TimeSecond" + e.getMessage());
		}
	}

	/**
	 * This Method to launch the webPage
	 * 
	 * @param url which you want to open
	 */
	public static void LaunchUrl(String url) {
		Constants.driver.get(url);
		log.info("website launch successfully");
	}

	/**
	 * close your current HomePage
	 */
	public static void closeBrowser() {
		Constants.driver.close();
		log.info("Browser closed successfully");
	}

	/**
	 * Close All WebBrowser Tab open in Browser
	 */
	public static void quiteBrowsers() {
		Constants.driver.quit();
		log.info("all tab closed successfully");
	}

	/**
	 * 
	 * @param timeInSecond
	 * @param time_Unit    is the unit which is use for time duration
	 * 
	 */
	public static void implicitWaitTime(long timeInSecond, String time_Unit) {
		switch (time_Unit) {
		case "seconds":
			if (time_Unit.equalsIgnoreCase("SECONDS")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
				log.info("Implicit wait for every web elements is" + timeInSecond + " " + time_Unit);
				break;
			}
		case "hours":
			if (time_Unit.equalsIgnoreCase("HOURS")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.HOURS);
				log.info("Implicit wait for every web elements is" + timeInSecond + " " + time_Unit);
				break;
			}
		case "days":
			if (time_Unit.equalsIgnoreCase("DAYS")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.DAYS);
				log.info("Implicit wait for every web elements is" + timeInSecond + " " + time_Unit);
				break;
			}
		case "minutes":
			if (time_Unit.equalsIgnoreCase("MINUTES")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.MINUTES);
				log.info("Implicit wait for every web elements is" + timeInSecond + " " + time_Unit);
				break;
			}
		}

	}

	/**
	 * 
	 * @param time
	 * @return
	 */
	public static FluentWait explicitWaitTime(long time) {
		FluentWait wait = new FluentWait(Constants.driver);
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		wait.withTimeout(time, TimeUnit.SECONDS);
		wait.ignoring(TimeoutException.class);
		return wait;
	}

	/**
	 * 
	 * @param time
	 */
	public static void waitForAlert(long time) {
		explicitWaitTime(time).until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * 
	 */
	public static void takeScreenShot() {
		AShot shot = new AShot();
		//Date date = new Date();
		//SimpleDateFormat Format = new SimpleDateFormat("E, dd MMM yyyy, HH_mm_ss");
		//String DateFormat = Format.format(date);
		Constants.sceenshot = shot.shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(Constants.driver);
		try {
			ImageIO.write(Constants.sceenshot.getImage(), "PNG",
					new File("E:\\test\\SampleWS\\test\\MyntraProject\\ScreenShot\\" + DateAndTime + ".png"));
			log.info(" ScreenShot taken successfully ");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 */
	public static void onClick(String locatorType, String locator) {
		getData(locatorType, locator).click();
		log.info("clicking on web element successfull");
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param text_Value
	 */
	public static void sendValue(String locatorType, String locator, String text_Value) {
		getData(locatorType, locator).sendKeys(text_Value);
		log.info("sending web text" + text_Value + "successfull");
	}

	/**
	 * 
	 */
	public static void handleAlert() {
		Alert alert = Constants.driver.switchTo().alert();
		alert.dismiss();
		Constants.driver.switchTo().defaultContent();
	}

	/**
	 * Use to check String has digit or Not
	 * 
	 * @param str String which is digit or not
	 * @return boolean true or false
	 */
	private static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param nameOrIdOrInt_Index
	 */
	public static void handleFrame(String locatorType, String locator, String nameOrIdOrInt_Index) {
		if (isNumeric(nameOrIdOrInt_Index)) {
			Constants.driver.switchTo().frame(Integer.parseInt(nameOrIdOrInt_Index));
			getData(locatorType, locator).click();
			Constants.driver.switchTo().defaultContent();
		} else {
			Constants.driver.switchTo().frame(nameOrIdOrInt_Index);
			getData(locatorType, locator).click();
			Constants.driver.switchTo().defaultContent();
		}
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param index
	 */
	public static void selectDropDown(String locatorType, String locator, int index) {

		Select sel = new Select(getData(locatorType, locator));
		sel.selectByIndex(index);
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param by_Value
	 */
	public static void selectDropDown(String locatorType, String locator, String by_Value) {
		Select sel = new Select(getData(locatorType, locator));
		sel.selectByValue(by_Value);
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 */
	public static void handlePopUp(String locatorType, String locator) {
		getData(locatorType, locator).click();
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param text
	 */
	public static void getDynamicText(String locatorType, String locator, String text) {
		Constants.element = getData(locatorType, locator);
		Constants.element.sendKeys(text);
		Constants.element.sendKeys(Keys.ARROW_DOWN);
		Constants.element.sendKeys(Keys.ENTER);
	}

	/**
	 * 
	 */
	public static void switchToDefault() {
		Constants.driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @return
	 */
	public static Alert getAlert() {

		return Constants.driver.switchTo().alert();
	}

	/**
	 * 
	 */
	public static void AcceptAlert() {

		getAlert().accept();
	}

	/**
	 * 
	 */
	public static void DismissAlert() {

		getAlert().dismiss();
	}

	/**
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String text = getAlert().getText();

		return text;
	}

	/**
	 * 
	 * @return
	 */
	private static boolean isAlertPresent() {
		try {
			Constants.driver.switchTo().alert();

			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}
	}

	/**
	 * 
	 */
	public static void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			AcceptAlert();

	}

	/**
	 * 
	 */
	public static void DismissAlertIfPresent() {

		if (!isAlertPresent())
			DismissAlert();

	}

	/**
	 * 
	 * @param text
	 */
	public void AcceptPrompt(String text) {
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();

	}
/*	
	public void elementScreenShot(String locatorType, String locator ) {
		getData(locatorType, locator);
		Point point = Constants.element.getLocation();
		int ht = Constants.element.getSize().getHeight();
		int wt = Constants.element.getSize().getWidth();
		File src = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage fullimage = ImageIO.read(src);
			BufferedImage logo = fullimage.getSubimage(point.getX(), point.getY(), wt, ht);
			ImageIO.write(logo, "png", src);
			FileUtils.copyFile(src, new File("E:\\Newjava\\KDD\\AllScreenshot\\" + DateAndTime + ".png"));

		} catch (IOException e) {
			System.out.println("File Not found: ");
		}
	}
	*/
}
