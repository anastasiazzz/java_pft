package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    gotoAddContactPage();
    initContactCreation();
    fillContactForm(new ContactData("firstName", "middleName", "lastName", "NickName", "Company", "Address", "Telephone", "email"));
    submitContactCreation();
    returnToHomePage();
  }

}

