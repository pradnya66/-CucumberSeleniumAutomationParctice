package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
	
		public WebDriver driver;
		
		public SignInPage(WebDriver driver){
			this.driver = driver;
		}
		String signInLink="//a[normalize-space(text())='Sign in']";
		String createBtn = "//button[@name='SubmitCreate']";
		String mrRadio = "//input[@id='id_gender1']";
		String mrsRadio = "//input[@id='id_gender2']";
		
		String custFnameInput="//input[@id='customer_firstname']";
		String custLnameInput="//input[@id='customer_lastname']";
		String pwdInput = "//input[@name='passwd']";
		
		String dobDaySlt = "//select[@name='days']";
		String dobMnthSlt = "//select[@name='months']";
		String dobYrsSlt = "//select[@name='years']";
		
		String nlChkbox = "//input[@name='newsletter']";
		String opChkbox = "//input[@name='optin']";
		
		String addFnameInput="//input[@id='firstname']";
		String lastFnameInput="//input[@id='lastname']";
		String addr1Input="//input[@id='address1']";
		String cityInput="//input[@name='city']";
		
		String stateSelect="//select[@id='id_state']";
		String zipInput="//input[@id='postcode']";
		String countrySelect="//select[@id='id_country']";
		String addInfotxtArea = "//textarea[@id='other']";
		
		String mobileInput="//input[@name='phone_mobile']";
		String aliasInput = "//input[@id='alias']";
		String registerBtn = "//button[@name='submitAccount']";
		String errLabel = "//div[@id='create_account_error']//li";
		String emailInput = "//input[@id='email_create']";
		String emailVerify = "//input[@id='email']";
		String signOutLink = "//a[normalize-space(text())='Sign out']";
		
		public boolean launchSignin(String emailID) throws Exception {
					
			driver.findElement(By.xpath(signInLink)).click();
			Thread.sleep(5000);
			boolean tempFlag = driver.findElement(By.xpath(emailInput)).isDisplayed();
			if(tempFlag) {
				System.out.println("Found Email input");
			} else {
				System.out.println("Failed to locate email input");
				return false;
			}
			driver.findElement(By.xpath(emailInput)).sendKeys(emailID);		
			Thread.sleep(2000);
			driver.findElement(By.xpath(createBtn)).click();
			Thread.sleep(5000);
//			try {
//				if(driver.findElement(By.xpath(errLabel)).isDisplayed()) {
//					String errMsg = driver.findElement(By.xpath(errLabel)).getText();
//					System.out.println(errMsg);
//					return false;
//				} 
//			}catch(NoSuchElementException e) {
//				e.printStackTrace();
//				System.out.println("Not found error");
//			}
			return true;
		}
		
		public boolean registerUser(String emailID) throws Exception {
			
			driver.findElement(By.xpath(mrsRadio)).click();
			driver.findElement(By.xpath(custFnameInput)).sendKeys("Prad");
			driver.findElement(By.xpath(custLnameInput)).sendKeys("Kav");
			driver.findElement(By.xpath(pwdInput)).sendKeys("testpass");
			
			String emailVal = driver.findElement(By.xpath(emailVerify)).getAttribute("value");
			System.out.println(emailVal);
			
			if(emailVal.equals(emailID)) {
				System.out.println("Email validation successful");
			} else {
				System.out.println("Email validation not successful");
				return false;
			}
			
			Select dayObj = new Select(driver.findElement(By.xpath(dobDaySlt)));
			dayObj.selectByIndex(2);

			Select mnthObj = new Select(driver.findElement(By.xpath(dobMnthSlt)));
			mnthObj.selectByValue("4");
			
			Select yearObj = new Select(driver.findElement(By.xpath(dobYrsSlt)));
			yearObj.selectByValue("2000");
			
			System.out.println("Is Checkbox Selected : " + driver.findElement(By.xpath(nlChkbox)).isSelected());
			driver.findElement(By.xpath(nlChkbox)).click();
			System.out.println("Is Checkbox Selected : " + driver.findElement(By.xpath(nlChkbox)).isSelected());
			
			driver.findElement(By.xpath(cityInput)).sendKeys("Las angeles");
			
			driver.findElement(By.xpath(addr1Input)).sendKeys("10 Las Vegas");
			
			Select stObj = new Select(driver.findElement(By.xpath(stateSelect)));
			stObj.selectByVisibleText("California");
			
			driver.findElement(By.xpath(zipInput)).sendKeys("50345");
			
			driver.findElement(By.xpath(addInfotxtArea)).sendKeys("1 MG Road \n Bangalore \n India");
			
			driver.findElement(By.xpath(mobileInput)).sendKeys("1234567890");
			
			driver.findElement(By.xpath(aliasInput)).clear();
			driver.findElement(By.xpath(aliasInput)).sendKeys("sample text");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(registerBtn)).click();
			
			Thread.sleep(5000);

			boolean tFlag = driver.findElement(By.xpath(signOutLink)).isDisplayed();
			if(tFlag) {
				System.out.println("User created successfully");
			} else {
				System.out.println("User not created");
				return false;
			}
			Thread.sleep(5000);
			return true;
		}
}
