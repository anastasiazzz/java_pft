package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.gotoAddContactPage();
    app.initContactCreation();
    app.fillContactForm(new ContactData("firstName", "middleName", "lastName", "NickName", "Company", "Address", "Telephone", "email"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}

