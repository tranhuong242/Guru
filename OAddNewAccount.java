package OPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Common.Com;

public class OAddNewAccount {
	By Addaccountpage=By.xpath("//a[text()='New Account']");
	By CustomerId=By.xpath("//input[@name='cusid']");
	By AccountType=By.xpath("//select[@name='selaccount']");
	By InitialDeposit=By.xpath("//input[@name='inideposit']");
	By BtnSubmit=By.xpath("//input[@name='button2']");
	By AddAcountMsg=By.xpath("//p[contains(text(),'Account Generated Successfully!!!')]");
	String ExpectedAddAccountMsg="Account Generated Successfully!!!";
	By CurrentAccountBalance=By.xpath("//td[text()='Current Amount']/following-sibling::td");
	String ExpectedCurrentBalance="50000";
	
	By AccountNoGet=By.xpath(".//*[@id='account']//td[text()='Account ID']/following-sibling::td");
	
	public void SetAddAccount(String CustID, String InitDepo) throws InterruptedException
	{
		Com.driver.findElement(Addaccountpage).click();
		Com.driver.findElement(CustomerId).sendKeys(CustID);
		
		Select oSelect=new Select(Com.driver.findElement(AccountType));
		oSelect.deselectByVisibleText("Current");
		
		Com.driver.findElement(InitialDeposit).sendKeys(InitDepo);
		Com.driver.findElement(BtnSubmit).click();
	}
	
	public void VerifyAddAccount()
	{
		String ActualAddAccountMsg=Com.driver.findElement(AddAcountMsg).getText();
		Assert.assertEquals(ActualAddAccountMsg, ExpectedAddAccountMsg);
		
		String ActualCurBalance=Com.driver.findElement(CurrentAccountBalance).getText();
		Assert.assertEquals(ActualCurBalance, ExpectedCurrentBalance);
	}
	
	public String GetAccountNo()
	{
		return Com.driver.findElement(AccountNoGet).getText();
	}
	
	public String GetAccountNoP()
	{
		return this.GetAccountNo();
	}
	
	public void AddAccount(String CustomerID,String InitDeposit) throws InterruptedException
	{
		this.SetAddAccount(CustomerID, InitDeposit);
		this.VerifyAddAccount();
	}
	

}
