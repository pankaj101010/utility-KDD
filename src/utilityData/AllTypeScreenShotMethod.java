package utilityData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AllTypeScreenShotMethod {
	public static String getDate() {
		String fname = "";
		Date d = new Date();
		fname = d.toString().replace(" ", "-");
		return fname;
	}

	public static void currentPageAshot(WebDriver driver) {
		AShot shot = new AShot();
		Screenshot a = shot.takeScreenshot(driver);
		// Screenshot a =
		// shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			ImageIO.write(a.getImage(), "JPG", new File("F:\\1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void fullPageScreenShotAshot(WebDriver driver) {
		AShot shot = new AShot();
		Date ds = new Date();
	    Screenshot a = shot.takeScreenshot(driver);
	             a = shot.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		try {
			ImageIO.write(a.getImage(), "PNG",
					new File("E:\\"+ds.toString()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void elementOnPageScreenShotAshot(WebDriver driver, WebElement element ) {
		AShot shot = new AShot();
		String DateAndTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	   // Screenshot a = shot.takeScreenshot(driver);
	     Screenshot a = shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
		try {
			ImageIO.write(a.getImage(), "PNG",
					new File("E:\\"+DateAndTime+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void defaultScreenShot(WebDriver driver) {
		/* TakesScreenShot is an interface 
		 * WebDriverException on failure.
		 * 
		 * @throws UnsupportedOperationException if the underlying implementation does
		 * not support screenshot capturing.
		 * File is a class 
		 */ 
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try { 
			// for new file == null it throws nullPointerException
			FileUtils.copyFile(screenshot, new File("F:\\shot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void buffredImage(WebDriver driver) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage fullimg = ImageIO.read(screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void elementScreenShot(String locatorType, String locator ) {
	 * Keyword.getData(locatorType, locator); Point point =
	 * Constants.element.getLocation(); int ht =
	 * Constants.element.getSize().getHeight(); int wt =
	 * Constants.element.getSize().getWidth(); File src = ((TakesScreenshot)
	 * Constants.driver).getScreenshotAs(OutputType.FILE); try { BufferedImage
	 * fullimage = ImageIO.read(src); BufferedImage logo =
	 * fullimage.getSubimage(point.getX(), point.getY(), wt, ht);
	 * ImageIO.write(logo, "png", src); FileUtils.copyFile(src, new
	 * File("E:\\Newjava\\KDD\\AllScreenshot\\" + DateAndTime + ".png"));
	 * 
	 * } catch (IOException e) { System.out.println("File Not found: "); } }
	 */
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		// System.out.println(date());
		// currentPageAshot();
		// System.out.println(getDate());
		fullPageScreenShotAshot(driver);
		driver.quit();
	}
   
}
