package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactUpdationTests extends TestBase{

  @Test
  public void testContactUpdation() {
    app.gotoHomePage();
    app.selectContact();
    app.intiEditContact();
    app.updateContact();
    app.returnToHomePage();
  }

}
