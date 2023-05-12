package Com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Actitime.GenericLibrary.FileLibrary;

public class TaskPage {

	
	    //Declaration
		@FindBy(xpath="//div[.='Add New']")
		private WebElement AddNew;
				
		@FindBy(xpath="//div[.='+ New Customer']")
		private WebElement NewCustomer;
		
		@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
		private WebElement Name;
		
		@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
		private WebElement Description;
		
		@FindBy(xpath="//div[.='Create Customer']")
		private WebElement CreateCustomer;
		
		@FindBy(xpath="(//div[.='Cancel'])[27]")
		private WebElement CancelBtn;
		
//		@FindBy(xpath="(//div[.='"+CustName+"']")
//		private WebElement Custname;
		
		
		//Initialization
		public TaskPage(WebDriver data) // creation of parameterized Constructor 
		{
			PageFactory.initElements(data,this); // class.static method 	
		}


		public WebElement getAddNew() {
			return AddNew;
		}


		public WebElement getNewCustomer() {
			return NewCustomer;
		}


		public WebElement getName() {
			return Name;
		}


		public WebElement getDescription() {
			return Description;
		}


		public WebElement getCreateCustomer() {
			return CreateCustomer;
		}


		public WebElement getCancelbtn() {
			return CancelBtn;
		}

		
}
