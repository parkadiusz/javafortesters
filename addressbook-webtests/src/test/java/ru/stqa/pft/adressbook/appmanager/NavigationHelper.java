package ru.stqa.pft.adressbook.appmanager;

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

  public void gotoContactCreation(){
    click("add new");
  }

  public void returnToHomePage(){
    click("home page");
  }
}

