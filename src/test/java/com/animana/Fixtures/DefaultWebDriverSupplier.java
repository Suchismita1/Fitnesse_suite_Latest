package com.animana.Fixtures;



import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.animana.utils.AppiumBrowserManager;
import com.animana.utils.LocalBrowserManager;
import com.animana.utils.PageUtils;
import com.animana.utils.RemoteBrowserManager;

public class DefaultWebDriverSupplier {
	public static String browser;
	public static WebDriver driver ;
	
	RemoteBrowserManager remoteBrowser = new RemoteBrowserManager();
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
		
//	public void setDriverpath(String driverPath){
//		this.driverPath = driverPath;
//	}

	public WebDriver newWebDriver() throws Exception{
			
		if(browser.contains("Sauce")){
			/*PageUtils.convertJsonString(browser);
			String sauceBrowserNew = PageUtils.readProperty("browserName");
			String saucePlatformNew = PageUtils.readProperty("platform");
			RemoteBrowserManager.initializeRemoteDriver(sauceBrowserNew,saucePlatformNew);
			driver = RemoteBrowserManager.getRemoteDriver();*/

			remoteBrowser.RemoteWebDriverSupplier(browser);
			driver = remoteBrowser.get();
		}
		else{
		LocalBrowserManager.initializeDriver(browser);
		driver = LocalBrowserManager.getLocalDriver();
		}
		return driver;
		
	}
	
	public void stopBrowser()
	{
		driver.close();
	}
	

}
