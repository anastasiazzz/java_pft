package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by anastasia.papko on 05.05.2017.
 */
public class RegistrationHelper extends HelperBase {


  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start (String username, String email){
    wd.get(app.getProperty("web.baseUrl")+"/signup_page.php");
    fillField(By.name("username"),username);
    fillField(By.name("email"),email);
    click(By.cssSelector("input[value='Signup']"));
  }
}

