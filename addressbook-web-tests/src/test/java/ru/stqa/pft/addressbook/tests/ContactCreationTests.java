package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts(){
    File photo = new File("src/test/resources/Download.png");
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstName("name1").withLastName("surname1").withAddress("address1").withEmail1("email11").withEmail3("email13").withHomePhone("1111").withPhoto(photo).withGroup("test1")});
    list.add(new Object[] {new ContactData().withFirstName("name2").withLastName("surname2").withAddress("address2").withEmail2("email22").withMobilePhone("22223").withWorkPhone("188888888").withGroup("test1")});
    list.add(new Object[] {new ContactData().withFirstName("name3").withLastName("surname3").withAddress("address3").withEmail1("email31").withEmail2("email23").withHomePhone("1111").withGroup("test1")});
    list.add(new Object[] {new ContactData().withFirstName("name4").withLastName("surname4").withAddress("address4").withEmail1("email11").withEmail3("email13").withMobilePhone("144444444").withGroup("test1")});
    return list.iterator();
  }


  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    app.contact().create(contact, true);
    app.returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}

