package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));

  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    fillField(By.name("firstname"), contactData.getFirstName());
    fillField(By.name("middlename"), contactData.getMiddleName());
    fillField(By.name("lastname"), contactData.getLastName());
    fillField(By.name("nickname"), contactData.getNickName());
    fillField(By.name("company"), contactData.getCompany());
    fillField(By.name("address"), contactData.getAddress());
    fillField(By.name("home"), contactData.getHomePhone());
    fillField(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));

  }

  public void submitUpdateContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void intiEditContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void initContactDeletion() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
  }

  public void acceptContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contactData, boolean creation) {
    initContactCreation();
    fillContactForm(contactData, creation);
    submitContactCreation();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}




