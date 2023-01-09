package com.steps;

import org.testng.annotations.Test;
import org.testng.annotations.Test;



import com.app.page.objects.LoginPage;

 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Scenario5 {
	WebDriver driver ;
    Properties propObj;
    LoginPage login;
    
    private static String[] getData() throws Exception{
        String rootFolder = System.getProperty("user.dir");
        System.out.println("root folder: " + rootFolder);

 

        Properties propObj = new Properties();
        propObj.load(new FileInputStream(rootFolder + "//src//test//resources//myFile.properties"));
        //String url = propObj.getProperty("appUrl");
        String email = propObj.getProperty("appUseremailId");
        String pwd = propObj.getProperty("appPwd");
        return new String[] {email, pwd};


    }

  @BeforeMethod
  public void launchBrowser() throws Exception {

      String rootFolder = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
        driver=new ChromeDriver();
        login = new LoginPage(driver);
        propObj= new Properties();
        propObj.load(new FileInputStream(rootFolder + "//src//test//resources//myFile.properties"));
        String appUrl = propObj.getProperty("appUrl");
        driver.manage().window().maximize(); 
        driver.get(appUrl);
        Thread.sleep(2000);
  }


  @Test
  public void Scenario() throws Exception, IOException {
      String rootFolder = System.getProperty("user.dir");
      propObj= new Properties();
      propObj.load(new FileInputStream(rootFolder + "//src//test//resources//myFile.properties"));
      String email = propObj.getProperty("appEmailId");
      String password = propObj.getProperty("appPwd");
      login.enterEmail(email);
      login.enterPassword(password);
      driver.findElement(By.xpath("//button[@class='btn primary  lg block submitButton']")).click();
      Thread.sleep(34000);
      driver.findElement(By.xpath("//button[@class='btn primary  lg block submitButton']")).click();
      driver.findElement(By.xpath("//span[@class='desktop-userTitle']")).click();
      driver.findElement(By.xpath("//div[@class='desktop-accInfoSection']")).click();
      String webpage = driver.findElement(By.xpath("//div[text()='Naman Deep Shamra']")).getText();
      String correct = "Naman Deep Shamra";
      Assert.assertEquals(webpage, correct);
  }
  
}