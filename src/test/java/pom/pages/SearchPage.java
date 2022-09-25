package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

WebDriver driver;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchInput;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//ul[contains(@class,'sf-menu')]/li[2]/a[text()='Dresses']")
	WebElement dresesLink;
	
	@FindBy(xpath="//h2[normalize-space(text())='Dresses']")
	WebElement dresesHeader;
	
	/**
	 * Method to search in Searchpage using a search String
	 * @param sString - search string
	 * @return true if successful, else false
	 * @throws Exception
	 */
	public boolean search(String sString) throws Exception {
		System.out.println(searchInput.isDisplayed());
		if ( !searchInput.isDisplayed()) {
			System.out.println("Search page not found");
			return false;
		}
		searchInput.sendKeys(sString);
		Thread.sleep(2000);
		searchBtn.click();
		return true;
	}
	
	
	/**
	 *  Method to click on dresses and verify header
	 * @return
	 * @throws Exception
	 */
	public String clickDresses() throws Exception {
		if(!dresesLink.isDisplayed()) {
			return "Dresses link not displayed";
		}
		dresesLink.click();
		Thread.sleep(5000);
		if(!dresesHeader.isDisplayed()) {
			return "Dresses header not displayed";
		}
		System.out.println("Header displayed");
		return "";
	}
	

	
}
