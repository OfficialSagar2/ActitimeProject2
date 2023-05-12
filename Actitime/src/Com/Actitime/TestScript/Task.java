package Com.Actitime.TestScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.Actitime.GenericLibrary.BaseClass;
import Com.Actitime.ObjectRepository.HomePage;
import Com.Actitime.ObjectRepository.TaskPage;

public class Task extends BaseClass{
	@Test
	public void CreateCustomer() throws InterruptedException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTask().click();
	
		TaskPage tp=new TaskPage(driver);	
		tp.getAddNew().click();
		tp.getNewCustomer().click();
		
		Thread.sleep(2000);				
		String CustName = f.ReadDataFromExcelFile("Sheet1",3,1);
		tp.getName().sendKeys(CustName);
	    
		Thread.sleep(2000);	
		String Description = f.ReadDataFromExcelFile("Sheet1",3,2);
		tp.getDescription().sendKeys(Description);
		
		tp.getCreateCustomer().click();
		
		String ExpectedResult = CustName;
		String ActualResult = driver.findElement(By.xpath("(//div[.='"+CustName+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(ActualResult,ExpectedResult);
		s.assertAll();
			
	}
}

