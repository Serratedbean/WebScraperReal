package com.jointheleague.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebscraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebscraperApplication.class, args);
		  ChromeOptions chromeOptions = new ChromeOptions();
		  WebDriver drive = new ChromeDriver(chromeOptions);
		  drive.navigate().to("https://gpacalculator.net/gpa-scale/3-1-gpa/");
		  WebElement element = drive.findElement(By.xpath("//*[@id=\"cdb_table_wrapper\"]/div[2]/table/tbody"));
		  
		  for(int t=2; t<100; t++)
		  {
			  for (int i=1 ; i<20; i++)
			  {
				  WebElement UniElement = null;
						  try 
						  {
							   UniElement = drive.findElement(By.xpath("/html/body/div/div[2]/div/div/main/article/div/div/div[1]/div[2]/div[2]/table/tbody/tr["+i+"]/td[1]/span"));
						  
						  } 
						  catch(Exception e) 
						  {
							  UniElement = drive.findElement(By.xpath("/html/body/div/div[2]/div/div/main/article/div/div/div[1]/div[2]/div[2]/table/tbody/tr["+i+"]/td[1]/span/a"));
						  }
				  WebElement GpaElement = drive.findElement(By.xpath("/html/body/div/div[2]/div/div/main/article/div/div/div[1]/div[2]/div[2]/table/tbody/tr["+i+"]/td[7]"));

				  System.out.println(UniElement.getText()+", "+GpaElement.getText());
			  }
			  
			  WebElement buttonPress = drive.findElement(By.xpath("/html/body/div/div[2]/div/div/main/article/div/div/div[1]/div[2]/div[3]/div[2]"));
			  buttonPress.click();
		  }
		  
		  
	}

}
