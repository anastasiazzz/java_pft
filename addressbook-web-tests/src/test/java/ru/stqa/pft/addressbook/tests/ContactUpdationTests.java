package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactUpdationTests extends TestBase{

  @Test
  public void testContactUpdation() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstName1", "middleName1", "lastName1", "NickName1", "Company1", "Address1", "Telephone1", "email1", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().intiEditContact();
    app.getContactHelper().fillContactForm(new ContactData("firstNameUPDATED", "middleNameUPDATED", "lastNameUPDATED", "NickNameUPDATED", "CompanyUPDATED", "AddressUPDATED", "TelephoneUPDATED", "emailUPDATED", "test1"), false);
    app.getContactHelper().submitUpdateContact();
    app.returnToHomePage();
  }

}
