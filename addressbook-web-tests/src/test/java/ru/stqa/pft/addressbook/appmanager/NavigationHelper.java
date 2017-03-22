package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddContactPage() {
    wd.get("http://localhost/addressbook/edit.php");
  }

  public void gotoHomePage() {
    wd.get("http://localhost/addressbook/");
  }
}
