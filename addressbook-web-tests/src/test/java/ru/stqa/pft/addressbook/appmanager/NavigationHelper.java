package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoAddContactPage() {
    wd.get("http://localhost/addressbook/edit.php");
  }

  public void gotoHomePage() {
    wd.get("http://localhost/addressbook/");
  }
}
