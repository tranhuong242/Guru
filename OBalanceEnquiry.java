package OPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Common.Com;

public class OBalanceEnquiry {
	By BalaceEnquirypage=By.xpath("//a[text()='Balance Enquiry']");
	By AccountNo=By.xpath("//input[@name='accountno']");
	
	By BtnSubmit=By.xpath("//input[@name='AccSubmit']");
	By CurrentBalance=By.xpath("//*[@id='balenquiry']//td[text()='Balance']/following-sibling::td");
	
	public void CheckBalanceEnquiry(String AccNo) 
	{
		Com.driver.findElement(BalaceEnquirypage).click();
		Com.driver.findElement(AccountNo).sendKeys(AccNo);
		
		Com.driver.findElement(BtnSubmit).click();
	}
	
	public void VerifyBalanceEnquiry()//lay before_balance-funds_tranfer=after_balance
	{
		String ActualCurrentBalance=Com.driver.findElement(CurrentBalance).getText();
		Assert.assertEquals(ActualCurrentBalance, "5000");
	}
	
	public void BalanEnqui(String AccountN)
	{
		this.CheckBalanceEnquiry(AccountN);
		this.VerifyBalanceEnquiry();
	}

}
