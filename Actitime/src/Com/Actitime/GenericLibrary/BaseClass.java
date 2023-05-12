package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Com.Actitime.ObjectRepository.HomePage;
import Com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {
public static WebDriver driver;
public FileLibrary f=new FileLibrary();

@BeforeSuite
public void DataBaseConnection() {
	Reporter.log("Database is Connected",true);
    }

@BeforeClass
public void LaunchBrowser() throws IOException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	String url = f.ReadDataFromPropertyFile("url");
	driver.get(url);
	//driver.get("https://demo.actitime.com/"); hardcoding 
	Reporter.log("Browser Launched",true);
	}	
	
@BeforeMethod
public void Login() throws InterruptedException, IOException {	
	LoginPage page=new LoginPage(driver);
	
	String username = f.ReadDataFromPropertyFile("Username");
	page.getUserbx().sendKeys(username);
	
	String pwd = f.ReadDataFromPropertyFile("Password");		
	page.getPwdbx().sendKeys(pwd);
	
	page.getLoginbox().click();
	Reporter.log("Login Succefully",true);
		
//	String username = f.ReadDataFromPropertyFile("Username");
//	driver.findElement(By.name("username")).sendKeys(username);
	
	//driver.findElement(By.name("username")).sendKeys("admin"); hardcoding 

//	String pwd = f.ReadDataFromPropertyFile("Password");
//	driver.findElement(By.name("username")).sendKeys(pwd);
	
   // driver.findElement(By.name("pwd")).sendKeys("manager");  hardcoding 
	
    Thread.sleep(2000);
//    driver.findElement(By.xpath("//div[.='Login ']")).click();
//    Reporter.log("Login Succefully",true);
	}

@AfterMethod
public void LogOut() throws InterruptedException {
	Thread.sleep(2000);
	HomePage hp=new HomePage(driver);
	hp.getLogout().click();
//	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("LogOut Succefully",true);
}	

@AfterClass
public void AfterTest() {
	driver.close();
	Reporter.log("Browser Closed",true);
}

@AfterSuite
public void DataBaseClose() {
	Reporter.log("Database Connection is Close",true);	
}
}
