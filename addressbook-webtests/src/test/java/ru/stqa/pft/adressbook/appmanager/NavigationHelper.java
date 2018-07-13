package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd){
    super(wd);
  }

  public void  gotoGroupPage() {
    click("groups");
  }

  public void gotoGroupCreation() {
    click("groups");
  }
}
