package com.animana.Fixtures;

import org.openqa.selenium.WebDriver;

public class AnimanaFixture {
	private final WebDriver webDriver;
	
	public AnimanaFixture(WebDriver webDriver) {
	    this.webDriver = webDriver;
	  } 
	
	public void startApplication()
	{
		webDriver.get("http://google.com");
	}
	
	public void storBrowser()
	{
		webDriver.close();
	}

}
