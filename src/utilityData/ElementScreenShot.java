package utilityData;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ElementScreenShot {
	public static void elementOnPageScreenShotAshot(WebDriver driver, WebElement element) {
		AShot shot = new AShot();
		String DateAndTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		Screenshot a = shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element);
		try {
			ImageIO.write(a.getImage(), "PNG", new File("E:\\" + DateAndTime + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.unionbankofindia.co.in/english/home.aspx");
		WebElement el = driver.findElement(By.xpath("//div[@class='logo']"));
		elementOnPageScreenShotAshot(driver, el);

	}

}
