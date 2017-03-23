package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class GroupUpdationTests extends TestBase{
  @Test

  public void testGroupUpdation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupUpdation();
    app.getGroupHelper().fillGroupForm(new GroupData("testUPDATED", "HeaderUPDATED", "FooterUPDATED"));
    app.getGroupHelper().submitGroupUpdation();
    app.getGroupHelper().returnToGroupPage();
  }


}
