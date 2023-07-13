package homepage;

import org.openqa.selenium.By;
import utilities.Utility;

public class AddCustomerPage extends Utility {


    By addCustomer = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]");

    public By firstName = By.xpath("//input[@placeholder='First Name']");
    public By lastName = By.xpath("//input[@placeholder='Last Name']");

    public By postCode = By.xpath("//input[@placeholder='Post Code']");

    public By addCustomerButton = By.xpath("//button[@class='btn btn-default']");

    public void clickOnAddCustomer() {
        sleep(2000);
        clickOnElement(addCustomer);

    }


}
