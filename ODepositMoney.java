package OPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Common.Com;

public class ODepositMoney {
	By Adddepositpage=By.xpath("//a[text()='Deposit']");
	By AccountNo=By.xpath("//input[@name='accountno']");
	By Amount=By.xpath("//input[@name='ammount']");
	By Description=By.xpath("//input[@name='desc']");
	By BtnSubmit=By.xpath("//input[@name='AccSubmit']");
	By DepositMsg=By.xpath("//p[contains(text(),'Transaction details of Deposit for Account')]"); // lam sao + "accountID"
	String ExpectedDepositMsg="Transaction details of Deposit for Account";
	
	public void SetDeposit(String AccNo, String Amoun, String Desc) 
	{
		Com.driver.findElement(Adddepositpage).click();
		Com.driver.findElement(AccountNo).sendKeys(AccNo);
		Com.driver.findElement(Amount).sendKeys(Amoun);
		Com.driver.findElement(Description).sendKeys(Desc);
		Com.driver.findElement(BtnSubmit).click();
	}
	
	public void VerifyDeposit()
	{
		String ActualDepositMsg=Com.driver.findElement(DepositMsg).getText();
		Assert.assertEquals(ActualDepositMsg, ExpectedDepositMsg);
	}
	
	public void DepositAmount(String AccountN, String Amountt, String Descrip)
	{
		this.SetDeposit(AccountN,Amountt,Descrip);
		this.VerifyDeposit();
	}

}
