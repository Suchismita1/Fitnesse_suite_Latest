package com.animana.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.animana.utils.PageUtils;

public class Animana_HomePage {
	
	PageUtils pageutil = new PageUtils(PageUtils.FILEPATH);
	
	
	
	public void loginFunction(WebDriver driver, String userName, String password) throws Exception {
		try{
			WebElement username_textbox = driver.findElement(pageutil.getLocator("username"));
			username_textbox.sendKeys(userName);
			
			WebElement password_textbox = driver.findElement(pageutil.getLocator("password"));
			password_textbox.sendKeys(password);
			
			WebElement login_button = driver.findElement(pageutil.getLocator("Login"));
			login_button.click();
			
			Thread.sleep(3000);
			
			
		}catch(NoSuchElementException e)
		{
			System.out.println("Login page is not loaded correctly");
		}
		
	}

	public Choose_LocationPage validateLogin(WebDriver driver) {
		String status = null;
		try{
			String PageTitle = driver.getTitle();
			if(PageTitle.equalsIgnoreCase(PageUtils.PAGE_TITLE)){
				status = "LOGIN SUCCESS";
			}
			else
			{
				status = "LOGIN FAILURE";
			}
		}catch(NoSuchElementException e)
		{
			System.out.println("Login is not successful");
			e.printStackTrace();
		}
		System.out.println(status);
		return PageFactory.initElements(driver, Choose_LocationPage.class);
	}

	

}
