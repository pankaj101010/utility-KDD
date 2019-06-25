package utilityData;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTExcel {
	ChromeDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\copy of workspace\\InitBanking\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
	}

	@Test(dataProvider = "testdata")
	public void DemoProject(String username, String password) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "E:\\copy of workspace\\InitBanking\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();

		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();

		Thread.sleep(5000);

		Assert.assertTrue(driver.getTitle().matches("Find a Flight: Mercury Tours:"), "Invalid credentials");

		System.out.println("Login successful");
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}

	@Test
	public void demo() {
		System.out.println("running this test case");
	}

	@AfterTest
	void ProgramTermination() {
		System.out.println("browser closed");
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() {

		ReadExcelFile config = new ReadExcelFile("C:\\Users\\PANKAJ\\Desktop\\Login.xlsx");

		int rows = config.getRowCount(1);
        int coloumn = config.getColoumnCount(1);
		Object[][] credentials = new Object[rows][coloumn];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < credentials[i].length; j++) {
				credentials[i][j] = config.getData(1, i, j);
			}
		}
		return credentials;
	}
}
