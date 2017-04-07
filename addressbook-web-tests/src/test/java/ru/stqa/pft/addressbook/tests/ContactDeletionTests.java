package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by anastasia.papko on 23.03.2017.
 */
public class ContactDeletionTests extends TestBase{

  @Test
public void testContactDeletion () {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstName1", "middleName1", "lastName1", "NickName1", "Company1", "Address1", "Telephone1", "email1", "testUPDATED"), true);
    }
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    app.returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size() -1);
    Assert.assertEquals(before, after);


  }



}
