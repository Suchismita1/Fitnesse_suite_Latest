package com.animana.scenario;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.animana.Pages.Animana_HomePage;
import com.animana.Pages.Choose_LocationPage;
import com.animana.Pages.Idexx_AnimanaPage;
import com.animana.utils.LocalBrowserManager;
import com.animana.utils.PageUtils;
import com.animana.utils.RemoteBrowserManager;

public class Animana {
	public static WebDriver driver;
	
	//initializing the object of the pages
	Animana_HomePage homePage = new Animana_HomePage();
	Choose_LocationPage chooseLocation = new Choose_LocationPage();
	Idexx_AnimanaPage idexxPage = new Idexx_AnimanaPage();
	
	@BeforeClass
	@Parameters({"Browser","envType"})
	public void setupDriver(String Browser, String envType) throws MalformedURLException{
		if(envType.equalsIgnoreCase("local")){
		   LocalBrowserManager.initializeDriver(Browser);
		   this.driver = LocalBrowserManager.getLocalDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(envType.equalsIgnoreCase("remote")){
			RemoteBrowserManager.initializeRemoteDriver(Browser);
			this.driver = RemoteBrowserManager.getRemoteDriver();
		}
	}

	@Test(priority = 1)
	@Parameters({"userName","password"})
	public void login(String userName, String password) throws Exception
	{
		//Start the dev.animana.com page
		driver.get(PageUtils.appURL);
		
		//Login to dev.animana.com page using username and password
		homePage.loginFunction(driver, userName, password);
		
		//Validate if login is successful or not & if login is successful, it will return an object to choose location
		chooseLocation = homePage.validateLogin(driver);
		//System.out.println(Status);
	}
	
	@Test(priority = 2)
	@Parameters({"location"})
	public void selectLocation(String location) throws Exception{
		//Select the valid location to proceed with and then move to Idexx main page
		idexxPage = chooseLocation.selectLocation(driver,location);
	}
	
	@Test(priority = 3)
	@Parameters({"SearchOption"})
	public void searchWithOption(String SearchOption) throws Exception
	{
		idexxPage.search(driver,SearchOption);
	}
	
	/*@AfterTest
	public void logOut() throws Exception{
		idexxPage.logOut(driver);
	}*/
	
	@AfterClass
	@Parameters({"envType"})
	public void tearDown(String envType) throws Exception{
		idexxPage.logOut(driver);
		Thread.sleep(3000);
		if(envType.equalsIgnoreCase("local")){
			LocalBrowserManager.closeLocalDriver();
		}
		else if(envType.equalsIgnoreCase("remote")){
			RemoteBrowserManager.closeRemoteDriver();
		}
	}

}
