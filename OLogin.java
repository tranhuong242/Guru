package OPage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Common.*;


public class OLogin {
	By UserID=By.xpath("//input[@name='uid']");
	By  Password =By.xpath("//input[@name='password']");
	By Login=By.xpath("//input[@name='btnLogin']");
	
	public OLogin()
	{
		
	}
	
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver",
				Com.CHROME_PATH);
		Com.driver = new ChromeDriver();
		Com.driver.get(Com.URL);
	}
	
	public void SetLogin(String Usern, String Passw)
	{
		Com.driver.findElement(UserID).sendKeys(Usern);
		Com.driver.findElement(Password).sendKeys(Passw);
		Com.driver.findElement(Login).click();
	}
	
	public void Login(String User, String Pass)
	{
		this.OpenBrowser();
		this.SetLogin(User, Pass);
	}

}
