package homepage;

import org.openqa.selenium.By;
import utilities.Utility;

public class CustomerLoginPage extends Utility {


    public By home =By.xpath("//button[@class='btn home']");

    public By customerLogin=By.xpath("//button[text()='Customer Login' ]");

    public By searchName=By.xpath("//select[@id='userSelect']");

    public By loginButton=By.xpath("//button[text()='Login']");

    public By logoutButton=By.xpath("//button[@class='btn logout']");

    public By getLogoutButton() {
        return logoutButton;
    }




}
