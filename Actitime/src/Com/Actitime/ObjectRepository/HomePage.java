package Com.Actitime.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {
	//Declaration
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement task;
			
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reporter;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement user;
	
	@FindBy(id="logoutLink")
	private WebElement Logout;
	
	//Initialization
	public HomePage(WebDriver data) // creation of parameterized Constructor 
	{
		PageFactory.initElements(data,this); // class.static method 	
	}

	//Utilization
	public WebElement getTask() {
		return task;
	}

	public WebElement getReporter() {
		return reporter;
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getLogout() {
		return Logout;
	}
	
}
