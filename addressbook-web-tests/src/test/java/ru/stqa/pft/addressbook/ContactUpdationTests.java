package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ContactUpdationTests extends TestBase{

  @Test
  public void testContactUpdation() {
    gotoHomePage();
    selectContact();
    intiEditContact();
    updateContact();
    returnToHomePage();
  }

}
