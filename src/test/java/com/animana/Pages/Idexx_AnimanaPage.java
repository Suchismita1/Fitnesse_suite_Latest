package com.animana.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.animana.utils.PageUtils;

public class Idexx_AnimanaPage {
	
	PageUtils pageutil = new PageUtils(PageUtils.FILEPATH);

	public void logOut(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,30);
		/*WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mana")));
		driver.switchTo().frame(iframeElement);*/
		try{
				
			WebElement logout_button = wait.until(ExpectedConditions.presenceOfElementLocated(pageutil.getLocator("Logout")));
			logout_button.click();
			
		}catch(NoSuchSessionException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Logout button not visible");
			e.printStackTrace();
		}
		
	}

	public void search(WebDriver driver, String searchOption) throws Exception {
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mana")));
		driver.switchTo().frame(iframeElement);
		//driver.navigate().to("https://dev.animana.com/web2/index/");
		try{
			WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content-body > header > div.header-row.clearfix > form > div > div > button.searchbar-down-arrow.icon-angle-right")));
			option.click();
			Thread.sleep(5000);
			String search_option_path = "//a[text()='"+searchOption+"']";
			try{
			WebElement searchInputType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(search_option_path)));
			searchInputType.click();
			Thread.sleep(5000);
			//findSearchResult(driver,searchType);
			}catch(NoSuchElementException e){
				System.out.println("search option is not correct");
			}
			
		}catch(NoSuchElementException e){
			System.out.println("no such element found");
		}
	}
	

}
