package com.animana.Fixtures;



import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.animana.utils.AppiumBrowserManager;
import com.animana.utils.LocalBrowserManager;
import com.animana.utils.RemoteBrowserManager;

public class DefaultWebDriverSupplier {
	public static String browser;
	public static String startEnv;
	public static String driverPath;
	public static WebDriver driver ;
	public static String sauceBrowser;
	public static String saucePlatform;
	public static String devBrowser;
	public static String devPlatform;
	public static String remoteMobileBrowser;
	public static String remoteMobileDevice;
	public static String remoteMobilePlatform;
	
	
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public void setSauceBrowser(String sauceBrowser)
	{
		this.sauceBrowser = sauceBrowser;
	}
			
	public void setDriverpath(String driverPath){
		this.driverPath = driverPath;
	}
	
	public void setSaucePlatform(String saucePlatform)
	{
		this.saucePlatform = saucePlatform;
	}
	
	public void setDevBrowser(String devBrowser){
		this.devBrowser = devBrowser;
	}
	
	public void setDevPlatform(String devPlatform){
		this.devPlatform = devPlatform;
	}
	
	public void setRemoteMobileBrowser(String remoteMobileBrowser)
	{
		this.remoteMobileBrowser = remoteMobileBrowser;
	}
	
	public void setRemoteMobileDevice (String remoteMobileDevice)
	{
		this.remoteMobileDevice = remoteMobileDevice;
	}
	
	public void setRemoteMobilePlatform(String remoteMobilePlatform)
	{
		this.remoteMobilePlatform = remoteMobilePlatform;
	}
	
	public WebDriver newRemoteWebDriver() throws MalformedURLException{
		RemoteBrowserManager.initializeRemoteDriver(sauceBrowser,saucePlatform);
		driver = RemoteBrowserManager.getRemoteDriver();
		return driver;
	}
	
	public WebDriver newDevWebDriver() throws MalformedURLException{
		RemoteBrowserManager.initializeRemoteDriver(devBrowser,devPlatform);
		driver = RemoteBrowserManager.getRemoteDriver();
		return driver;
	}
	
	public WebDriver newWebDriver() throws Exception{
		
		LocalBrowserManager.initializeDriver(browser);
		driver = LocalBrowserManager.getLocalDriver();
		return driver;
		
	}
	
	public WebDriver newMobileWebDriver() throws MalformedURLException{
		AppiumBrowserManager.initializeAppiumDriver(remoteMobileDevice, remoteMobileBrowser, remoteMobilePlatform);
		driver = AppiumBrowserManager.getAppiumDriver();
		return driver;
	}
	
	public void stopBrowser()
	{
		driver.close();
	}
	

}
