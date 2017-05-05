package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by anastasia.papko on 05.05.2017.
 */
public class RegistrationTests extends TestBase{

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@locakhost.localdomain");
  }
}
