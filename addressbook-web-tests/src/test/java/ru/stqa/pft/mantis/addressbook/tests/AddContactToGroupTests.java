package ru.stqa.pft.mantis.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.addressbook.model.ContactData;
import ru.stqa.pft.mantis.addressbook.model.Contacts;
import ru.stqa.pft.mantis.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by anastasia.papko on 04.05.2017.
 */
public class AddContactToGroupTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1").withAddress("Address1").withHomePhone("Telephone1").withEmail2("email1"));
    }
    app.goTo().groupPage();
    if (app.db().groups().size() ==0) {
      app.group().create(new GroupData().withName("test").withHeader("Header").withFooter("Footer"));
    }
  }

  @Test
  public void testAddContactToGroup(){
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    int id  = app.db().groups().iterator().next().getId();
    System.out.println(id);
    //if (contact.getGroups())
    ContactData contact = before.iterator().next();
    app.contact().addToGroup(contact, id);
    app.returnToHomePage();
    assertThat(app.contact().isInGroup(contact, id),equalTo(true));
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));

  }


}


