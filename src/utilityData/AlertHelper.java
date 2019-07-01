package utilityData;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	public WebDriver driver;

	/**
	 * 
	 * @param driver
	 */
	public AlertHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 */
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @return
	 */
	public Alert getAlert() {

		return driver.switchTo().alert();
	}

	/**
	 * 
	 */
	public void AcceptAlert() {

		getAlert().accept();
	}

	/**
	 * 
	 */
	public void DismissAlert() {

		getAlert().dismiss();
	}

	/**
	 * 
	 * @return
	 */
	public String getAlertText() {
		String text = getAlert().getText();

		return text;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();

			return true;
		} catch (NoAlertPresentException e) {
			// Ignore

			return false;
		}
	}

	/**
	 * 
	 */
	public void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			AcceptAlert();

	}

	/**
	 * 
	 */
	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();

	}

	/**
	 * 
	 * @param text
	 */
	public void AcceptPrompt(String text) {

		if (!isAlertPresent())
			return;

		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();

	}
}
