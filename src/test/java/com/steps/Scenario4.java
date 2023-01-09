package com.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.page.objects.LoginPage;

public class Scenario4 {
	WebDriver driver ;
    Properties propObj;
  @Test
  public void f() throws InterruptedException, FileNotFoundException, IOException {
	  Properties propObj = new Properties();
      String rootFolder = System.getProperty("user.dir");
      propObj.load(new FileInputStream(rootFolder+ "//src//test//resources//myFile.properties"));
      System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
      driver = new ChromeDriver();
      driver.get(propObj.getProperty("appUrl"));
      driver.findElement(By.xpath("//input[@id=\"mobileNumberPass\"]")).sendKeys(propObj.getProperty("appEmailId"));
      driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(propObj.getProperty("appPwd"));
      driver.findElement(By.xpath("//button[.=\"LOGIN\"]")).click();
      Thread.sleep(31000);
      driver.findElement(By.xpath("//button[.=\"LOGIN\"]")).click();
      

      String Expected = "Hey, it feels so light!";
      driver.get(propObj.getProperty("cart"));
      Thread.sleep(2000);
      String Actual = driver.findElement(By.xpath("//div[@class='emptyCart-base-emptyText']")).getText();

      Assert.assertEquals(Expected, Actual);

      driver.get(propObj.getProperty("itemWatch"));
      driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("(//span[@class='desktop-userTitle'])[3]")).click();

      String expectedCart = "1/1 ITEMS SELECTED";
      //driver.get(propObj.getProperty("cart"));
      String actualCart = driver.findElement(By.xpath("//div[@class='bulkActionStrip-message']")).getText();

      Assert.assertEquals(expectedCart, actualCart);

      driver.quit();
  }
}
