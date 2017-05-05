package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {

    super(wd);
  }

  public void login(String username, String password) {
    fillField(By.name("user"),username);
    fillField(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

  }
}

