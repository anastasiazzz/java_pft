package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class ContactHelper extends BaseHelper {

  public Contacts contactCache = null;

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));

  }

  public void fillContactForm(ContactData contactData) {
    fillField(By.name("firstname"), contactData.getFirstName());
    fillField(By.name("middlename"), contactData.getMiddleName());
    fillField(By.name("lastname"), contactData.getLastName());
    fillField(By.name("nickname"), contactData.getNickName());
    fillField(By.name("company"), contactData.getCompany());
    fillField(By.name("address"), contactData.getAddress());
    fillField(By.name("home"), contactData.getHomePhone());
    fillField(By.name("mobile"), contactData.getMobilePhone());
    fillField(By.name("work"), contactData.getWorkPhone());
    fillField(By.name("email"), contactData.getEmail1());
    fillField(By.name("email2"), contactData.getEmail2());
    fillField(By.name("email3"), contactData.getEmail3());
    //attach(By.name("photo"), contactData.getPhoto());


   /* if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    } */

  }

  public void initContactCreation() {
    click(By.linkText("add new"));

  }

  public void submitUpdateContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void initEditContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public ContactData infoFromEditForm(ContactData contact) {
    initEditContactById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String middleName = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withMiddleName(middleName).withLastName(lastName).withAddress(address)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }

  public String infoFromDetailsForm(ContactData contact) {
    openContactDetailsById(contact.getId());

    String details = wd.findElement(By.cssSelector("div[id='content']")).getText().replaceAll("\\s","").replaceAll("H:","").replaceAll("M:","").replaceAll("W:","");
    wd.navigate().back();
    return details;

  }

  public void initEditContactById(int id) {
    click(By.cssSelector("a[href = 'edit.php?id=" + id + "'"));

  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void create(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initEditContactById(contact.getId());
    fillContactForm(contact);
    submitUpdateContact();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    acceptContactDeletion();
    contactCache = null;
  }

  public void openContactDetailsById(int id) {
    wd.findElement(By.cssSelector("a[href = 'view.php?id="+ id +"']")).click();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      String firstName = element.findElements(By.tagName("td")).get(2).getText();
      String address = element.findElements(By.tagName("td")).get(3).getText();
      String allEmails = element.findElements(By.tagName("td")).get(4).getText();
      String allPhones = element.findElements(By.tagName("td")).get(5).getText();
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return contactCache;
  }

}





