package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactUpdationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1")
              .withAddress("Address1").withHomePhone("5551").withMobilePhone("4331").withWorkPhone("98761").withEmail2("email1"));
    }
  }
  @Test
  public void testContactUpdation() {
   Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("firstName3").withMiddleName("middleNameUPDATED").withLastName("lastNameUPDATED").withNickName("NickNameUPDATED")
            .withCompany("CompanyUPDATED").withAddress("AddressUPDATED").withHomePhone("TelephoneUPDATED").withMobilePhone("321").withWorkPhone("4343")
            .withEmail1("aaaaaa1").withEmail2("aaa2").withEmail3("emailUPDATED").withGroup( "test1");
    app.contact().modify(contact);
    app.returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
