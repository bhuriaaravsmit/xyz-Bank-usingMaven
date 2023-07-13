package homepage;

import org.openqa.selenium.By;
import utilities.Utility;

public class CustomersPage extends Utility {

  public By deposit = By.xpath("//button[@ng-class='btnClass2']");

  public By amount=By.xpath("//input[@placeholder='amount']");

  public By depositButton= By.xpath("//button[text()='Deposit']");



    public By depositSuccessful =By.xpath("//span[text()='Deposit Successful']");
    public By getDepositSuccessful() {
        return depositSuccessful;
    }

  public By withdrawal = By.xpath("//button[@ng-class='btnClass3']");

  public By withdrawButton= By.xpath("//button[text()='Withdraw']");



  public By transactionSuccessful = By.xpath("//span[text()='Transaction successful']");
  public By getTransactionSuccessful() {
    return transactionSuccessful;
  }
}
