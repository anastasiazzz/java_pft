package ru.stqa.pft.mantis.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.addressbook.model.GroupData;
import ru.stqa.pft.mantis.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() ==0) {
      app.group().create(new GroupData().withName("test").withHeader("Header").withFooter("Footer"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}