package testsuite;

import homepage.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.BaseTest;

import java.util.List;

public class BankTest extends BaseTest {

    HomePage homepage = new HomePage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();

    CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    CustomersPage customersPage = new CustomersPage();

    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        /*click On "Add Customer" Tab
	enter FirstName
	enter LastName
	enter PostCode
	click On "Add Customer" Button
	popup display
	verify message "Customer added successfully"
	click on "ok" button on popup.*/
        homepage.clickOnLogin();
        sleep(1000);

        addCustomerPage.clickOnAddCustomer();
        sendTextToElement(addCustomerPage.firstName, "Shweta");
        sendTextToElement(addCustomerPage.lastName, "Shah");
        sendTextToElement(addCustomerPage.postCode, "BD1 5AE");
        addCustomerPage.clickOnElement(addCustomerPage.addCustomerButton);

        String message = driver.switchTo().alert().getText();
        Assert.assertTrue(message.contains("Customer added successfully"));
        driver.switchTo().alert().accept();

    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully() {


        bankManagerShouldAddCustomerSuccessfully();
        bankManagerLoginPage.clickOnOpenAccount();

        selectByVisibleTextFromDropDown(bankManagerLoginPage.customerName, "Shweta Shah");
        selectByVisibleTextFromDropDown(bankManagerLoginPage.currencyPound, "Pound");
        bankManagerLoginPage.clickOnElement(bankManagerLoginPage.processButton);
        String message = driver.switchTo().alert().getText();
        Assert.assertTrue(message.contains("Account created successfully"));
        driver.switchTo().alert().accept();

    }

    @Test
    public void customerShouldLoginAndLogoutSuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        customerLoginPage.clickOnElement(customerLoginPage.home);
        customerLoginPage.clickOnElement(customerLoginPage.customerLogin);
        selectByVisibleTextFromDropDown(customerLoginPage.searchName, "Shweta Shah");
        sleep(1000);
        customerLoginPage.clickOnElement(customerLoginPage.loginButton);
        verifyText(customerLoginPage.logoutButton, "Logout");
        customerLoginPage.clickOnElement(customerLoginPage.logoutButton);

        sleep(2000);

        WebElement dropDown = driver.findElement(customerLoginPage.searchName);
        Select select = new Select(dropDown);
        List<WebElement> names = select.getOptions();
        boolean isContains = false;
        for (WebElement name : names) {
            if (name.getText().equals("Shweta Shah")) {
                System.out.println(name.getText());
                isContains = true;
            }
        }
        Assert.assertTrue(isContains);

    }

    @Test
    public void customerShouldDepositMoneySuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        customerLoginPage.clickOnElement(customerLoginPage.home);
        customerLoginPage.clickOnElement(customerLoginPage.customerLogin);
        selectByVisibleTextFromDropDown(customerLoginPage.searchName, "Shweta Shah");
        sleep(1000);
        customerLoginPage.clickOnElement(customerLoginPage.loginButton);
        customersPage.clickOnElement(customersPage.deposit);
        sendTextToElement(customersPage.amount, "100");
        customersPage.clickOnElement(customersPage.depositButton);
        verifyText(customersPage.getDepositSuccessful(), "Deposit Successful");

    }
@Test
    public void customerShouldWithdrawMoneySuccessfully() {

    customerShouldDepositMoneySuccessfully();
        customerLoginPage.clickOnElement(customerLoginPage.home);
        customerLoginPage.clickOnElement(customerLoginPage.customerLogin);
        selectByVisibleTextFromDropDown(customerLoginPage.searchName, "Shweta Shah");
        sleep(1000);
        customerLoginPage.clickOnElement(customerLoginPage.loginButton);
        customersPage.clickOnElement(customersPage.withdrawal);
        sendTextToElement(customersPage.amount, "50");
        customersPage.clickOnElement(customersPage.withdrawButton);
        verifyText(customersPage.getTransactionSuccessful(),"Transaction successful");

    }


}
