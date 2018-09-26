package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

//import sun.plugin2.util.BrowserType;

public class ApplicationManager {

  WebDriver wd; //wczesniej byl FirefoxDriver, i nie potrzbe

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    //wd = new FirefoxDriver();
    //wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files (x86)/Mozilla Firefox/firefox.exe"));
    if(browser==BrowserType.FIREFOX){
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if(browser==BrowserType.CHROME){
      System.setProperty("webdriver.chrome.driver", "C://Users//Arkadiusz Purski//Documents//drivers//chromedriver.exe");
      wd = new ChromeDriver();//new ChromeOptions().setBinary("C://Users//Arkadiusz Purski//Documents//drivers//chromedriver.exe"));
    } else if(browser==BrowserType.IE){
      System.setProperty("webdriver.ie.driver", "C://Users//Arkadiusz Purski//Documents//drivers//IEDriverServer.exe");
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    groupHelper = new GroupHelper(wd); //tworzenie konstruktora wd w GroupHelper
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper groupHelper() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contactHelper() {
    return contactHelper;
  }
}
