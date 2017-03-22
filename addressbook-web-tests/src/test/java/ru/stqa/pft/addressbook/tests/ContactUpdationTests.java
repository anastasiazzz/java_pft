package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactUpdationTests extends TestBase{

  @Test
  public void testContactUpdation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().intiEditContact();
    app.getContactHelper().fillContactForm(new ContactData("firstNameUPDATED", "middleNameUPDATED", "lastNameUPDATED", "NickNameUPDATED", "CompanyUPDATED", "AddressUPDATED", "TelephoneUPDATED", "emailUPDATED"));
    app.getContactHelper().submitUpdateContact();
    app.returnToHomePage();
  }

}
