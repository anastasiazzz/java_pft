package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by anastasia.papko on 23.03.2017.
 */
public class ContactDeletionTests extends TestBase{

  @Test
public void testContactDeletion () {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    app.returnToHomePage();

  }



}
