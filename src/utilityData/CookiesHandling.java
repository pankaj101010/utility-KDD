package utilityData;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookiesHandling {
	WebDriver driver;
 public CookiesHandling(WebDriver driver) {
	 this.driver=driver;
 }
	
	
	/***
	 * This method is used to get all cookies in the form of array .
	 * 
	 * @param driver
	 * @return it will return all cookies in arrays.
	 */
	public Set getCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies;
	}

	/***
	 * 
	 * @param driver
	 * @return it will return {@code int} size of all cookies
	 */
	public int cookieSize() {
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies.size();
	}

	/***
	 * 
	 * @param driver
	 */
	public Cookie cookieName() {
//    	 Set<Cookie> cookies  = driver.manage().getCookies();
//    	 for (Cookie string : cookies) {
// 			System.out.println(string.getName());
// 		}
		//System.out.println(driver.manage().getCookieNamed("session-id-time"));
		return driver.manage().getCookieNamed("session-id-time");
	}

	public void addCookie( String name, String value) {
		Cookie cookies = new Cookie(name, value);
		driver.manage().addCookie(cookies);

	}

	public String getCookieName() {
		String name = "";
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie string : cookies) {
			name = string.getName();
		}
		return name;
	}

	public void deletcookies() {
		driver.manage().deleteAllCookies();
	}
}
