package com.animana.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppiumBrowserManager {
	
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	public static final String username = "suchi1";
	public static final String accesskey = "73d74e9a-b405-46a5-bbc0-5fbb8ed0d7d7";
	public static final String URL ="https://"+username+":"+accesskey+"@ondemand.saucelabs.com:443/wd/hub";
	
	public static void initializeAppiumDriver(String deviceName, String browserName, String platformName) throws MalformedURLException{
		RemoteWebDriver appium_driver = null;
		
		if(platformName.equalsIgnoreCase("Android")){
			DesiredCapabilities caps = DesiredCapabilities.android();
			caps.setCapability("appiumVersion", "1.5.3");
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("browserName", browserName);
			caps.setCapability("platformVersion", "6.0");
			caps.setCapability("platformName",platformName);
			appium_driver = new RemoteWebDriver(new URL(URL),caps);
		}
		
		else if(platformName.equalsIgnoreCase("iOS")){
			DesiredCapabilities caps = DesiredCapabilities.iphone();
			caps.setCapability("appiumVersion", "1.5.3");
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("platformVersion","9.3");
			caps.setCapability("platformName", platformName);
			caps.setCapability("browserName", browserName);
			appium_driver = new RemoteWebDriver(new URL(URL),caps);
		}
		
		setAppiumDriver(appium_driver);
		
		getAppiumDriver();
		
	}
	
	public static WebDriver getAppiumDriver() {
		return dr.get();
			
	}

	public static void setAppiumDriver(RemoteWebDriver driver) {
		dr.set(driver);
		
	}
	


}
