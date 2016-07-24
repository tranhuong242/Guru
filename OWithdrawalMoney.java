package OPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Common.Com;

public class OWithdrawalMoney {
	By AddWithdrawalpage=By.xpath("//a[text()='Withdrawal']");
	By AccountNo=By.xpath("//input[@name='accountno']");
	By Amount=By.xpath("//input[@name='ammount']");
	By Description=By.xpath("//input[@name='desc']");
	By BtnSubmit=By.xpath("//input[@name='AccSubmit']");
	By WithdrawalMsg=By.xpath("//p[contains(text(),'Transaction details of Withdrawal for Account')]"); // lam sao + "accountID"? // not found?
	String ExpectedWithdrawalMsg="Transaction details of Withdrawal for Account";
	By CurrentBalance=By.xpath(".//*[@id='withdraw']//td[text()='Current Balance']/following-sibling::td"); //kiem tra dong ntn, get before_withdrawal, get after_withdrawal?
	
	
	public void SetWithdrawal(String AccNo, String Amoun, String Desc) 
	{
		Com.driver.findElement(AddWithdrawalpage).click();
		Com.driver.findElement(AccountNo).sendKeys(AccNo);
		Com.driver.findElement(Amount).sendKeys(Amoun);
		Com.driver.findElement(Description).sendKeys(Desc);
		Com.driver.findElement(BtnSubmit).click();
	}
	
	public void VerifyWithdrawal()
	{
		String ActualWithdrawalMsg=Com.driver.findElement(WithdrawalMsg).getText();
		Assert.assertEquals(ActualWithdrawalMsg, ExpectedWithdrawalMsg);
		String CurrentBal= Com.driver.findElement(CurrentBalance).getText();
		Assert.assertEquals(CurrentBal, "15000");
	}
	
	public void WithdrawalAmount(String AccountN, String Amountt, String Descrip)
	{
		this.SetWithdrawal(AccountN,Amountt,Descrip);
		this.VerifyWithdrawal();
	}



}
