package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    wd.get("http://localhost:8081/addressbook/addressbook/group.php");
    type(By.name("user"),username);
    type(By.name("pass"), password);
    //wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void logout(){
    click(By.linkText("logout"));
  }
}
