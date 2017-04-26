package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by anastasia.papko on 20.04.2017.
 */
public class ContactInfoTests extends TestBase{

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","");
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() ==0) {
      app.contact().create(new ContactData().withFirstName("firstName1").withMiddleName("middleName1").withLastName("lastName1").withNickName("NickName1").withCompany("Company1")
              .withAddress("Address1").withHomePhone("5551").withMobilePhone("4331").withWorkPhone("+987-22261").withEmail1("email1").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    String contactDetails = app.contact().infoFromDetailsForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contactDetails, equalTo(mergeDetails(contactInfoFromEditForm)));
  }

  private String mergeDetails(ContactData contact) {
    return Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail1(), contact.getEmail2(),contact.getEmail3())
           .stream().filter(s -> !(s==null || s.equals("")))
           .map(ContactInfoTests::cleaned)
           .collect(Collectors.joining(""));
  }
}

