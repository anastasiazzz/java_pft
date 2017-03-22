package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactUpdationTests extends TestBase{

  @Test
  public void testContactUpdation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().intiEditContact();
    app.getContactHelper().updateContact();
    app.returnToHomePage();
  }

}
