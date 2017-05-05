package ru.stqa.pft.mantis.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.addressbook.model.GroupData;
import ru.stqa.pft.mantis.addressbook.model.Groups;

import java.util.List;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    fillField(By.name("group_name"), groupData.getName());
    fillField(By.name("group_header"), groupData.getHeader());
    fillField(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initGroupUpdation() {
    click((By.name("edit")));
  }

  public void submitGroupUpdation() {
    click((By.name("update")));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }
  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupUpdation();
    fillGroupForm(group);
    submitGroupUpdation();
    groupCache = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroup();
    groupCache = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Groups groupCache = null;

  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }

   groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }

}
