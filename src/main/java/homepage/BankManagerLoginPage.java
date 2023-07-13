package homepage;

import org.openqa.selenium.By;
import utilities.Utility;

public class BankManagerLoginPage extends Utility {


    By openAccount = By.xpath("//button[@ng-class='btnClass2']");

    public By customerName = By.id("userSelect");
    public By currencyPound = By.id("currency");

    public By processButton = By.xpath("//button[text()='Process']");


    public void clickOnOpenAccount() {
        sleep(2000);
        clickOnElement(openAccount);

    }

}
