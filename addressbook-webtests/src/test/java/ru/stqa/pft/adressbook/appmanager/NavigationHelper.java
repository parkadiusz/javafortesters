package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd){
    super(wd);
  }

  public void gotoGroupPage() {
    waitForClick(By.linkText("groups"),5);
  //waitTillDisplayed(By.name("new"), 15);
    //click(By.linkText("groups"));
  }

  public void gotoContactCreation(){
    waitForClick(By.linkText("add new"),5);
   //click(By.linkText("add new"));
  }

  public void gotoHomePage(){
    waitForClick(By.linkText("home"), 5);
    //click(By.linkText("home"));
  }

}

