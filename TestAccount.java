package Test;

import org.testng.annotations.Test;

import OPage.OAddNewAccount;
import OPage.OBalanceEnquiry;
import OPage.OCreateNewCust;
import OPage.ODepositMoney;
import OPage.OEditCustomer;
import OPage.OLogin;
import OPage.OTranferMoney;
import OPage.OWithdrawalMoney;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

//71359,71359
//chua xu ly chuoi dau vao verify cua ham funds_tranfer
//ghi data lai
public class TestAccount extends AbtrackPage {
	 OLogin OLG;
	 OCreateNewCust ONCust;
	 OEditCustomer OECust;
	 OAddNewAccount OAAcct;
	 ODepositMoney ODepMoney;
	 OWithdrawalMoney OWithdrMoney;
	 OTranferMoney OTranfMoney;
	 OBalanceEnquiry OBalEnq;
	 
 /* @Test (priority=1) 
  public void AddNewCustomer() {
	  ONCust.CreateCust("AUTOMATION TESTING", "01/01/1989", "PO Box 911 8331 Duis Avenue", "Tampa", "FL", "466250", "4555442476",randomString() + "@gmail.com","automation");
	  ONCust.VerifyCreateNewCust();
  }*/
  
 /* @Test (priority=2)
  public void EditCustomer() {
  String custIDE=ONCust.GetCustIDP(); //truyen gia tri CustID tao tu ham AddNewCustomer
	  OECust.EditCust(custIDE, "1883 Cursus Avenue", "Houston", "Texas", "166455", "4779728081",randomString()+"@gmail.com");
  }*/
  
 @Test (priority=1)
  public void AddAccount() throws InterruptedException {
	 //String custIDG=ONCust.GetCustIDP();
	 //System.out.println(custIDG);
	  OAAcct.AddAccount("60407", "50000");
  }
  
 /* @Test (priority=4)
  public void DepositMoney() 
  {
	  String accountG= OAAcct.GetAccountNoP();
	  ODepMoney.DepositAmount(accountG, "5000", "Deposit 5000 vnđ");
  }
  
  @Test (priority=5)
  public void WithdrawalMoney() 
  {
	  String accountG= OAAcct.GetAccountNoP(); //Q&A: co nen khai bao the nay khong?
	  OWithdrMoney.WithdrawalAmount(accountG, "15000", "Withdrawal 15000 vnđ");
  }

  @Test (priority=6)
  public void FundTranfer() 
  {
	  String accountG= OAAcct.GetAccountNoP();//Q&A: co nen khai bao the nay khong?
	  OTranfMoney.TranferMoney(accountG, "15877", "10000", "Tranfer 10000");
  }
  

  @Test (priority=6)
  public void BalanceEnquiry() 
  {
	  String accountG= OAAcct.GetAccountNoP();//Q&A: co nen khai bao the nay khong?
	  OBalEnq.BalanEnqui(accountG);
  }*/
  
  @BeforeTest
  public void beforeTest() {
	  OLG=new OLogin();
	  OLG.Login("mngr42349", "ususazy");
	  ONCust = new OCreateNewCust();
	  OECust=new OEditCustomer();
	  ODepMoney=new ODepositMoney();
	  OWithdrMoney=new OWithdrawalMoney();
	  OTranfMoney=new OTranferMoney();
	  OBalEnq = new OBalanceEnquiry();
  }

  @AfterTest
  public void afterTest() {
  }

}
