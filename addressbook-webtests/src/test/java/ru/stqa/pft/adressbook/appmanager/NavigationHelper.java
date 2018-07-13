package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
  private FirefoxDriver wd; //wd musi byc w private

  public NavigationHelper(FirefoxDriver wd){
    this.wd=wd;
  }

  public void  gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoGroupCreation() {
    wd.findElement(By.linkText("groups")).click();
  }
}
