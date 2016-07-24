package OPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Common.Com;

public class OEditCustomer {
	By Editcustomerpage=By.xpath("//a[text()='Edit Customer']");
	By CustomerID=By.xpath("//input[@name='cusid']"); //68509
	By AccSubmit=By.xpath("//input[@name='AccSubmit']");
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
	//By EditNewCustMessage=By.xpath("//p[contains(text(),'Customer details updated Successfully!!!')]");
	By EditNewCustMessage=By.xpath("//*[@id='customer']//p[contains(text(),'Customer details updated Successfully!!!')]");
	
	String SuccessfullyEditCustMsg="Customer details updated Successfully!!!";
	
public void SearchCustomer(String CustID)
{
	Com.driver.findElement(Editcustomerpage).click();
	Com.driver.findElement(CustomerID).sendKeys(CustID);
	Com.driver.findElement(AccSubmit).click();
}

public void EditInfoCustomer(String Addr, String Cit, String Stat, String PI, String Mobile, String Em)
{
	Com.driver.findElement(Address).clear();
	Com.driver.findElement(Address).sendKeys(Addr);
	Com.driver.findElement(City).clear();
	Com.driver.findElement(City).sendKeys(Cit);
	Com.driver.findElement(State).clear();
	Com.driver.findElement(State).sendKeys(Stat);
	Com.driver.findElement(PIN).clear();
	Com.driver.findElement(PIN).sendKeys(PI);
	Com.driver.findElement(MobileNumber).clear();
	Com.driver.findElement(MobileNumber).sendKeys(Mobile);
	Com.driver.findElement(Email).clear();
	Com.driver.findElement(Email).sendKeys(Em);
	Com.driver.findElement(Submit).click();
}

public void VerifyEditCustomer()
{
	String actualMsg=Com.driver.findElement(EditNewCustMessage).getText();
	Assert.assertEquals(actualMsg, SuccessfullyEditCustMsg);
}

public void EditCust(String CustID1, String Addr1, String Cit1, String Stat1, String PI1, String Mobile1, String Em1)
{
	this.SearchCustomer(CustID1);
	this.EditInfoCustomer(Addr1, Cit1, Stat1, PI1, Mobile1, Em1);
	this.VerifyEditCustomer();
}
}
