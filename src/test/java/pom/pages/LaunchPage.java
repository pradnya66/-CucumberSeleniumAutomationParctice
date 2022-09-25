package pom.pages;

import org.openqa.selenium.WebDriver;

public class LaunchPage {
WebDriver driver;
	
	public LaunchPage(WebDriver d){
		this.driver = d;
	}
	
	public void quitBrowser() throws Exception {
		driver.quit();
		Thread.sleep(2000);
	}
	
	public boolean verifyUrl(String expURL) {
		String actURL = driver.getCurrentUrl();
		if(actURL.contains(expURL)) {
			System.out.println("URL verification successful");
		} else {
			System.out.println("URL verification failed. Acutal:" + actURL + " Expected : " + expURL);
			return false;
		}
		return true;
	}
}
