package com.animana.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

public class PageUtils {
	public static String appURL = "https://dev.animana.com";
	public static String FILEPATH = "./src/test/resources/Object_Repository.json";
	public static String PAGE_TITLE = "=== ANIMANA ASP ===";
	public static String SAUCEDETALPATH = "./src/test/resources/SauceCredentials.properties";
	public static Properties config;
	
	JSONParser parser;
	JSONObject jsonObject;
	public PageUtils()
	{
		
	}
	
	public PageUtils(String FilePath){
		FileReader jsonFile;
		try {
			jsonFile = new FileReader(FilePath);
			parser = new JSONParser();
			Object obj = parser.parse(jsonFile);
			jsonObject = (JSONObject) obj;
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	public By getLocator(String ElementName) throws Exception{
		//Read the value using logical name as key
		String Locator = (String) jsonObject.get(ElementName);
		
		// Split the value which contains locator type and locator value
		String locatorType = Locator.split(";")[0];
		String locatorValue = Locator.split(";")[1];
		// Return a instance of By class based on type of locator
		if(locatorType.toLowerCase().equals("id")){
			return By.id(locatorValue);
		}
		else if (locatorType.toLowerCase().equals("name")){
			return By.name(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class"))){
			return By.className(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag"))){
			return By.className(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link"))){
			return By.linkText(locatorValue);
		}
		else if (locatorType.toLowerCase().equals("partiallinktext")){
			return By.partialLinkText(locatorValue);
		}
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css"))){
			return By.cssSelector(locatorValue);
		}
		else if (locatorType.toLowerCase().equals("xpath")){
			return By.xpath(locatorValue);
		}
		
		else
			throw new Exception("Locator type '" + locatorType
					+ "' not defined!!");

	
		
	}
	
	public static String  readProperty(String propertyKey) throws IOException{
		config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\SauceCredentials.properties");
		config.load(fis);
		String propertyValue=config.getProperty(propertyKey);
		return propertyValue;
	}
	
	
}
