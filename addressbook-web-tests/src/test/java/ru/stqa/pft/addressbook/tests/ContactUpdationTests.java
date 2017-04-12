package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactUpdationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1").withAddress("Address1").withHomePhone("Telephone1").withEmail("email1").withGroup("test1"), true);
    }
  }
  @Test
  public void testContactUpdation() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("firstName1").withMiddleName("middleNameUPDATED").withLastName("lastNameUPDATED").withNickName("NickNameUPDATED").withCompany("CompanyUPDATED").withAddress("AddressUPDATED").withHomePhone("TelephoneUPDATED").withEmail("emailUPDATED").withGroup( "test1");
    app.contact().modify(index, contact);
    app.returnToHomePage();
    List<ContactData> after = app.contact().list();

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
