package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    File photo = new File("src/test/resources/Download.png");
    ContactData contact = new ContactData().withFirstName("firstName").withMiddleName("middleName")
            .withLastName("lastName").withNickName("NickName").withCompany("Company").withAddress("Address").withHomePhone("Telephone").withEmail1("email").withEmail2("email23232@@@@").withEmail3("email").withPhoto(photo);
    app.contact().create(contact, true);
    app.returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}

