package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by anastasia.papko on 23.03.2017.
 */
public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1").withAddress("Address1").withHomePhone("Telephone1").withEmail2("email1"));
    }
  }

  @Test
public void testContactDeletion () {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
