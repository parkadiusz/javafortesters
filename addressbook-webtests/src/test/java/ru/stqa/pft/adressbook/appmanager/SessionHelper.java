package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    wd.get("http://localhost/addressbook/addressbook/group.php");
    type(By.name("user"),username);
    type(By.name("pass"), password);
    //wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}
