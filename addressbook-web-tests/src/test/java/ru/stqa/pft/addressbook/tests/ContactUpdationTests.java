package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactUpdationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1").withAddress("Address1").withHomePhone("Telephone1").withEmail("email1").withGroup("test1"), true);
    }
  }
  @Test
  public void testContactUpdation() {
   Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("firstName3").withMiddleName("middleNameUPDATED").withLastName("lastNameUPDATED").withNickName("NickNameUPDATED").withCompany("CompanyUPDATED").withAddress("AddressUPDATED").withHomePhone("TelephoneUPDATED").withEmail("emailUPDATED").withGroup( "test1");
    app.contact().modify(contact);
    app.returnToHomePage();
    Set<ContactData> after = app.contact().all();

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
