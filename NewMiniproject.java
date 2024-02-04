import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewMiniproject {

	//public RemoteWebDriver driver;

	@Test
	
	public void verifypage() {
		
		String url="https://www.pepperfry.com/";
		System.out.println("Chose 1 for ChromeDriver or 2 For EdgeDriver   ");
		int a;
		try (Scanner sc = new Scanner(System.in)) {
			a=sc.nextInt();
		}
		
		WebDriver driver = null;
	
		switch(a) {
		case 1:System.setProperty("Webdriver.chrome.driver","C:\\Users\\Jayvant\\eclipse-workspaces\\FirstSeleniumProject1\\Driver1\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get(url);
			driver.manage().window().maximize();

		break;
		
		
		
		case 2:System.setProperty("webdriver.edge.driver", "C:\\Users\\Jayvant\\eclipse-workspaces\\FirstSeleniumProject1\\Driver1\\msedgedriver.exe");
		 driver = new EdgeDriver();
		 		 driver.get(url);
		 		driver.manage().window().maximize();

		}
	

		//verify PageTitle
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle,"Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		//*****sideClick
		driver.findElement(By.xpath("//*[@id='Mattresses']/a")).click();
		
		
		//*******Mouse Hour
		
		WebElement fernituer = driver.findElement(By.cssSelector("#Furniture > a"));
		
		Actions actioon = new Actions(driver);
		actioon.moveToElement(fernituer).build().perform();

		//************click chair
				//driver.findElement(By.xpath("//*[@id=\"meta-Furniture\"]/div/div/div/div/div[3]/ul[1]/li[1]/a")).click();
				
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Chair = driver.findElement(By.xpath("//*[@id=\"meta-Furniture\"]/div/div/div/div/div[3]/ul[1]/li[1]/a"));
		js.executeScript("arguments[0].click();", Chair);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		try { 
			Thread.sleep(6000);
		    } catch (InterruptedException e) {
			
			 e.printStackTrace();
		   }
		
		//*******Chair Element data******
		
		//Get the Data of Specific Row
				List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div"));
				System.out.println("***********Data of all table************");
				for (WebElement column : columns) {
				System.out.println(column.getText());
				}
				
				//************/Verify data******
				//gerterthan
				WebElement aName=driver.findElement(By.xpath("//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[6]/pf-clip-category-list/div/a/div"));
				String Text=aName.getText();
				System.out.println(Text);
				
				WebElement aprice=driver.findElement(By.xpath("//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[6]/pf-clip-category-list/div/a/div/div[2]"));
				String Text1=aprice.getText();
				System.out.println("***********Cafechair options************");//*[@id="dataTable"]

				System.out.println(Text1);

//				String a;
//				a=Text1;
//				//int b=0;
//				if(a!= null)
//				{
//					System.out.println("  Cafe Chair Avalebelin Stock");
//				}
//				else {
//					System.out.println("  Not Avalebel in Stock");	
//				}				
//				
				
				
				String cafeChair = Text1;
				String[] value = cafeChair.split(" ",2);



				int secondValue =Integer.parseInt(value[0]);
					
					if(secondValue > 0)
					{
						System.out.println("Avalebel in stock   ");
						System.out.println(secondValue);

					}
					else {
						System.out.println("false");	
					}
					
				
		
	//  ********close Browser***
		driver.quit();
	}
}
