package com.animana.Fixtures;

import org.openqa.selenium.WebDriver;

import com.animana.utils.LocalBrowserManager;

public class SeleniumDriverFixture {
	DefaultWebDriverSupplier defaultWebDriverSupplier = new DefaultWebDriverSupplier();
	public static String url;
	
	public void setBrowser(String browser) {
		
		defaultWebDriverSupplier.setBrowser(browser);
	}
		
	public void setPath(String path){
		defaultWebDriverSupplier.setDriverpath(path);
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public void setSauceBrowser(String sauceBrowser){
		defaultWebDriverSupplier.setSauceBrowser(sauceBrowser);
	}
	
	public void startDriverOnUrl(WebDriver driver, String url) throws Exception{
		driver.get("https://dev.animana.com");
	}
	
	public void stopBrowser(){
		defaultWebDriverSupplier.stopBrowser();
		//LocalBrowserManager.closeLocalDriver();
	}
	
}
