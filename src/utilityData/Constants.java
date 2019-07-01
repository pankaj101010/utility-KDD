package utilityData;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.Screenshot;

public class Constants {
			public static WebDriver driver;
			public static WebElement element;
			public static Screenshot sceenshot;		
			public static Properties property;
			public static FileInputStream file;
			public static String DateAndTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
			//public static String file_path = "E:\\test\\SampleWS\\test\\MyntraProject\\Config\\data.properties";
  }
