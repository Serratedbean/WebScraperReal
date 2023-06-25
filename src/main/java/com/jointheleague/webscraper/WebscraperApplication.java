package com.jointheleague.webscraper;

import java.io.*;

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
		  drive.navigate().to("https://cwur.org/2021-22/country/usa.php");
		  WebElement element = drive.findElement(By.xpath("/html/body/div/div/div/div/div[2]/table/tbody"));
		  
		  try 
		  {
			PrintWriter pw = new PrintWriter(new File("text.txt"));
		  
		//  for(int t=2; t<100; t++)
		//  {
			  for (int i=1 ; i<348; i++)
			  {
				  WebElement UniElement = null;
						  try 
						  {
							  
							   UniElement = drive.findElement(By.xpath("/html/body/div/div/div/div/div[2]/table/tbody/tr["+i+"]/td[2]"));
						  
						  } 
						  catch(Exception e) 
						  {
							  UniElement = drive.findElement(By.xpath("/html/body/div/div/div/div/div[2]/table/tbody/tr["+i+"]/td[2]/a"));
						  }
				  WebElement GpaElement = drive.findElement(By.xpath("/html/body/div/div/div/div/div[2]/table/tbody/tr["+i+"]/td[4]"));

				  pw.println(UniElement.getText().replaceAll(",", "")+", "+GpaElement.getText());
			  }
			  
			  pw.close();
			//  WebElement buttonPress = drive.findElement(By.xpath("/html/body/div/div[2]/div/div/main/article/div/div/div[1]/div[2]/div[3]/div[2]"));
			//  buttonPress.click();
		  //}
		  } 
		  
		  catch (FileNotFoundException e1) {
			  
			  e1.printStackTrace();
		  }
		  
		  
	}

}
