package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by anastasia.papko on 05.05.2017.
 */
public class RegistrationTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@locakhost.localdomain");
    app.mail().waitForMail(2,10000);
  }

  @AfterMethod (alwaysRun = true)
  public void startMailServer() {
    app.mail().stop();
  }
}
