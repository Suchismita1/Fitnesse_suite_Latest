package com.animana.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteBrowserManager {
	
	//ThreadLocal will keep local copy of the driver
		public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
		public static final String username = "suchi1";
		public static final String accesskey = "73d74e9a-b405-46a5-bbc0-5fbb8ed0d7d7";
		public static final String URL ="https://"+username+":"+accesskey+"@ondemand.saucelabs.com:443/wd/hub";

		
		public static void initializeRemoteDriver(String myBrowser, String saucePlatform) throws MalformedURLException{
			RemoteWebDriver driver = null;
			
			if(myBrowser.equalsIgnoreCase("chrome")){
				DesiredCapabilities capability = new DesiredCapabilities().chrome();
				capability.setCapability("platform", saucePlatform);
				//capability.setCapability("platform", "Windows 7");
				capability.setCapability("version", "53.0");
				driver = new RemoteWebDriver(new URL(URL),capability);
								
			}
			
			else if(myBrowser.equalsIgnoreCase("firefox")){
				DesiredCapabilities capability = new DesiredCapabilities().firefox();
				capability.setCapability("platform", saucePlatform);
				//capability.setCapability("platform", "Windows 7");
				capability.setCapability("version", "50.0");
				driver = new RemoteWebDriver(new URL(URL),capability);
				
			}
			
			else if(myBrowser.equalsIgnoreCase("ie")){
				DesiredCapabilities capability =new DesiredCapabilities().internetExplorer();
				capability.setCapability("platform", saucePlatform);
				//capability.setCapability("platform", "Windows 7");
				capability.setCapability("version", "11.0");
				driver = new RemoteWebDriver(new URL(URL),capability);
								
			}
			else if(myBrowser.equalsIgnoreCase("safari")){
				DesiredCapabilities capability =new DesiredCapabilities().safari();
				capability.setCapability("platform", saucePlatform);
				//capability.setCapability("platform", "Windows 7");
				capability.setCapability("version", "5.1");
				driver = new RemoteWebDriver(new URL(URL),capability);
			}

			
			setRemoteDriver(driver);
			
			getRemoteDriver();
		}

		public static WebDriver getRemoteDriver() {
			return dr.get();
			
			
		}

		public static void setRemoteDriver(RemoteWebDriver driver) {
			dr.set(driver);
			
		}
		
		public static void closeRemoteDriver(){
			getRemoteDriver().quit();
			dr.set(null);
		}
			

}
