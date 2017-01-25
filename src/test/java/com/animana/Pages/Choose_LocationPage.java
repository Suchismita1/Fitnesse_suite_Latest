package com.animana.Pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.animana.utils.PageUtils;

public class Choose_LocationPage {
	
	PageUtils pageutil = new PageUtils(PageUtils.FILEPATH);
	public Idexx_AnimanaPage selectLocation(WebDriver driver, String location) throws Exception {
		WebElement Location = null;
		try{
			if(location.equalsIgnoreCase("Second location"))
			{
				Location = driver.findElement(pageutil.getLocator("Second Location"));
			}
			else if(location.equalsIgnoreCase("Main location"))
			{
				Location = driver.findElement(pageutil.getLocator("Main Location"));
			}
			else{
				throw new Exception("Location '" + location
						+ "' not defined!!");
			}
			Location.click();
		}catch(NoSuchElementException e)
		{
			System.out.println("Location not correct");
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, Idexx_AnimanaPage.class);
	}


}
