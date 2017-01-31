package com.animana.Fixtures;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.animana.Pages.Animana_HomePage;
import com.animana.utils.PageUtils;

public class AnimanaFixture {
	private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	private final WebDriver webDriver;
	public static String user;
	public static String password;
	
	//Animana_HomePage homePage = new Animana_HomePage();
	//PageUtils pageutil = new PageUtils(PageUtils.FILEPATH);
	
	public AnimanaFixture(WebDriver webDriver) {
	    this.webDriver = webDriver;
	  } 
	
	public void setUser(String user)
	{
		this.user = user;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void loginApplication(WebDriver driver, String username,String pwd) throws Exception
	{
		try{
		WebElement username_textbox = driver.findElement(By.id("username"));
		username_textbox.sendKeys("e2e0");
		
		WebElement password_textbox = driver.findElement(By.id("password"));
		password_textbox.sendKeys("123@YesWeCan");
		
		WebElement login_button = driver.findElement(By.cssSelector("body > div > div.login-panel > form > div:nth-child(3) > div > input.button.expand"));
		login_button.click();
		}catch(NoSuchElementException e)
		{
			System.out.println("Login page is not loaded correctly");
		}
		/*try {
			homePage.loginFunction(webDriver, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	public void startApplication()
	{
		webDriver.get("http://google.com");
	}
	
	public boolean closeWalkmeIfPresent() {
		  
		try {
	      if(isElementPresent(By.cssSelector("span.walkme-action-destroy-0.wm-close-link")))
			  webDriver.findElement(By.cssSelector("span.walkme-action-destroy-0.wm-close-link")).click();
		 
	    } catch (Error e) {
		System.out.println(e.toString());
	    return true;
		}
		System.out.println("out of if condition");
	   return true;  
	  
	  }
	  
	  public boolean switchToDefault() {
		  
			try {
		      
				  webDriver.switchTo().defaultContent();
			 
		    } catch (Error e) {
			System.out.println(e.toString());
		    return true;
			}
			System.out.println("out of if condition");
		   return true;  
		  
		  }
	  
	   private boolean isElementPresent(By by) {
	    try {
	      webDriver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	  
	  private boolean isAlertPresent() {
	    try {
	      webDriver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = webDriver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
	  public boolean verifyIfSearchContains(String searchtext) {
	  
	String prefix = " ";
	searchtext=prefix+searchtext;
	int i=0;  	
	WebElement resulttable= webDriver.findElement(By.xpath("//table[@class='simple dynamicTable full-width']"));
			WebElement bodytable = resulttable.findElement(By.tagName("tbody"));
			
			List <WebElement> rows = bodytable.findElements(By.tagName("tr"));
			
			for(WebElement row:rows)
			{
				i=0;
				List <WebElement> cols = row.findElements(By.tagName("td"));
				
				for(WebElement col:cols)
				{
					
					if(col.getText().equalsIgnoreCase(searchtext))
							{
						col.click();
						i=1;
						break;
						
							}
					
					
				}
				if(i==1)break;
				
			}
	  
	    if(i==1)
	    return true; // outcome
	    else
		return false;
	  }
	
	/*public void storBrowser()
	{
		webDriver.close();
	}*/

}
