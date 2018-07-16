package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.model.group.GroupData;

public class GroupHelper extends HelperBase {


  public GroupHelper(FirefoxDriver wd) {
    super(wd); //zwrócenie do konstruktora w HeleprBase
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectGroups() {
      click(By.name("delete"));
  }

  public void selectGroup() {
      click(By.name("selected[]"));
  }
}
