package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd){
    super(wd);
  }

  public void  gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoGroupCreation() {
    click(By.linkText("groups"));
  }

  public void gotoContactCreation(){
   click(By.linkText("add new"));
  }

  public void returnToHomePage(){
    click(By.linkText("home page"));
  }
}

