package homepage;

import org.openqa.selenium.By;
import utilities.Utility;

public class HomePage extends Utility {


 By BankLogin=By.xpath("(//button[@class='btn btn-primary btn-lg'])[2]");





public void clickOnLogin(){
   sleep(2000);
   clickOnElement(BankLogin);

}






}
