package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by anastasia.papko on 23.03.2017.
 */
public class ContactDeletionTests extends TestBase{

  @Test
public void testContactDeletion () {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstName1", "middleName1", "lastName1", "NickName1", "Company1", "Address1", "Telephone1", "email1", "testUPDATED"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    app.returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before-1);

  }



}
