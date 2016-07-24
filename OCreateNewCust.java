package OPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Common.Com;

public class OCreateNewCust {
	By Addcustomerpage=By.xpath("//a[text()='New Customer']");
	By CustomerName=By.xpath("//input[@name='name']");
	By Gender=By.xpath("//input[@value='f']");
	By DateOfBirth=By.xpath(".//*[@id='dob']");
	By Address=By.xpath("//textarea[@name='addr']");
	By City=By.xpath("//input[@name='city']");
	By State=By.xpath("//input[@name='state']");
	By PIN=By.xpath("//input[@name='pinno']");
	By MobileNumber=By.xpath("//input[@name='telephoneno']");	
	By Email=By.xpath("//input[@name='emailid']");
	By Password=By.xpath("//input[@name='password']");
	By Submit=By.xpath("//input[@value='Submit']");
	By CreateNewCusstMessage=By.xpath("//p[text()='Customer Registered Successfully!!!']");
	String SuccessfullyACreateCustMsg="Customer Registered Successfully!!!";
	By CustomerID=By.xpath("//*[@id='customer']/tbody//td[text()='Customer ID']/following-sibling::td");
	
	public void SetCreateNewCust(String CustN, String DateBirth, String Addr, String Cit, String Stat, String PI,String Mobile, String Em,String Pass)
	{
		Com.driver.findElement(Addcustomerpage).click();
		Com.driver.findElement(CustomerName).sendKeys(CustN);
		Com.driver.findElement(Gender).click();
		Com.driver.findElement(DateOfBirth).sendKeys(DateBirth);
		Com.driver.findElement(Address).sendKeys(Addr);
		Com.driver.findElement(City).sendKeys(Cit);
		Com.driver.findElement(State).sendKeys(Stat);
		Com.driver.findElement(PIN).sendKeys(PI);
		Com.driver.findElement(MobileNumber).sendKeys(Mobile);
		Com.driver.findElement(Email).sendKeys(Em);
		Com.driver.findElement(Password).sendKeys(Pass);
		Com.driver.findElement(Submit).click();
	}
	
	public void VerifyCreateNewCust()
	{
		String AddCustMsg= Com.driver.findElement(CreateNewCusstMessage).getText();
		Assert.assertEquals(AddCustMsg, SuccessfullyACreateCustMsg);
	}
	
	public String GetCustID()
	{
		return Com.driver.findElement(CustomerID).getText();
		
	}
	
	public String GetCustIDP()
	{
		return this.GetCustID();
	}
	
	public void CreateCust(String CustName1, String DateBirth1, String Addr1, String Cit1, String Stat1, String PI1,String Mobile1, String Em1,String Pass1)
	{
		this.SetCreateNewCust(CustName1, DateBirth1, Addr1, Cit1, Stat1, PI1, Mobile1, Em1, Pass1);
		this.VerifyCreateNewCust();
	}
}
