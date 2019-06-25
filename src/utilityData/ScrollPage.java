package utilityData;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPage{
  WebDriver driver;
  public ScrollPage(WebDriver driver) {
	  this.driver= driver;
  }
	public  void scrollingToBottomofPage() {
		 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollingToElementofPage(String link_Test) {
		WebElement element = driver.findElement(By.linkText(link_Test));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}
	
	public void scrollingByCoordinatesofPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}
	
}


