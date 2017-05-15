package ru.stqa.pft.mantis.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.addressbook.model.ContactData;
import ru.stqa.pft.mantis.addressbook.model.Contacts;
import ru.stqa.pft.mantis.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by anastasia.papko on 15.05.2017.
 */
public class RemoveContactFromGroupTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() ==0) {
      app.group().create(new GroupData().withName("test").withHeader("Header").withFooter("Footer"));
    }
    app.goTo().homePage();
    if (app.db().contacts().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1").withAddress("Address1").withHomePhone("Telephone1").withEmail2("email1"));
    }
    if (app.db().contactsFromGroup().size() ==0){
      int id  = app.db().groups().iterator().next().getId();
      ContactData contact = app.db().contactsWithoutGroups().iterator().next();
      app.contact().addToGroup(contact, id);
    }
  }

  @Test
  public void testRemoveContactFromGroup() throws InterruptedException {
    app.goTo().homePage();
    ContactData contact = app.db().contactsFromGroup().iterator().next();
    int id  = contact.getGroups().iterator().next().getId();
    app.contact().removeFromGroup(contact, id);
    Thread.sleep(1000);
    contact  = app.db().contactById(contact.getId()).iterator().next();
    assertThat(app.contact().isInGroup(contact, id),equalTo(false));
  }
}
