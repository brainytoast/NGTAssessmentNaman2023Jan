package com.app.page.objects;
	import java.time.Duration;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {


	@FindBy(id="mobileNumberPass")
	WebElement email;

	@FindBy(xpath = "//input[@class='form-control has-feedback']")
    public static WebElement password;

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void enterEmail(String s) {
		
		driver.findElement(By.id("mobileNumberPass")).sendKeys(s);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	public void enterPassword(String s) {
		
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(s);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	}

