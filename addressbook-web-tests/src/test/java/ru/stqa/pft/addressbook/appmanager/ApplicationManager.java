package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.tests.DbHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by anastasia.papko on 22.03.2017.
 */
public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;

  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;
  private DbHelper dbHelper;

  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    dbHelper = new DbHelper();

    if (browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    } else if (browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if (browser == BrowserType.IE) {
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }



  public void stop() {
    contactHelper.wd.quit();
  }

  public void returnToHomePage() {
    contactHelper.wd.findElement(By.linkText("home")).click();
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public DbHelper db(){
    return dbHelper;
  }
}

