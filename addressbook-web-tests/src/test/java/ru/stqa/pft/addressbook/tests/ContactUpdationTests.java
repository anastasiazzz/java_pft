package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactUpdationTests extends TestBase{

  @Test
  public void testContactUpdation() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstName1", "middleName1", "lastName1", "NickName1", "Company1", "Address1", "Telephone1", "email1", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().intiEditContact();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "firstName1", "middleNameUPDATED", "lastNameUPDATED", "NickNameUPDATED", "CompanyUPDATED", "AddressUPDATED", "TelephoneUPDATED", "emailUPDATED", "test1");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitUpdateContact();
    app.returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
