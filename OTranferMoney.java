package OPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Common.Com;

public class OTranferMoney {
	By FundTranferpage=By.xpath("//a[text()='Fund Transfer']");
	By PayerAccountNo=By.xpath("//input[@name='payersaccount']");
	By PayeeAccountNo=By.xpath("//input[@name='payeeaccount']");
	By Amount=By.xpath("//input[@name='ammount']");
	
	By Description=By.xpath("//input[@name='desc']");
	By BtnSubmit=By.xpath("//input[@name='AccSubmit']");
	By DepositMsg=By.xpath("//p[contains(text(),'Transaction details of Deposit for Account')]"); // lam sao + "accountID"
	String ExpectedDepositMsg="Transaction details of Deposit for Account";
	
	public void SetFundTranfer(String PayerAccNo,String PayeeAccNo, String Amoun, String Desc) 
	{
		Com.driver.findElement(FundTranferpage).click();
		Com.driver.findElement(PayerAccountNo).sendKeys(PayerAccNo);
		Com.driver.findElement(PayeeAccountNo).sendKeys(PayeeAccNo);
		Com.driver.findElement(Description).sendKeys(Desc);
		Com.driver.findElement(BtnSubmit).click();
	}
	
	public void VerifyFundTranfer()
	{
		String ActualDepositMsg=Com.driver.findElement(DepositMsg).getText();
		Assert.assertEquals(ActualDepositMsg, ExpectedDepositMsg);
	}
	
	public void TranferMoney(String PayerAccount,String PayeeAccount, String Amountt, String Descrip)
	{
		this.SetFundTranfer(PayerAccount, PayeeAccount, Amountt, Descrip);
		this.VerifyFundTranfer();
	}

}
