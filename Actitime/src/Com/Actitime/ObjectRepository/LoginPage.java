package Com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	    //Declaration
		@FindBy(id="username")
		private WebElement userbx;
				
		@FindBy(name="pwd")
		private WebElement pwdbx;
		
		@FindBy(xpath="//div[.='Login ']")
		private WebElement Loginbox;	
		
		//Initialization
		public LoginPage(WebDriver data) // creation of parameterized Constructor 
		{
			PageFactory.initElements(data,this); // class.static method 	
		}

		//Utilization
		public WebElement getUserbx() {
			return userbx;
		}

		public WebElement getPwdbx() {
			return pwdbx;
		}

		public WebElement getLoginbox() {
			return Loginbox;
		}
		
		
		

}
