package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.gotoGroupCreation();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test", "test1", "test2"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
