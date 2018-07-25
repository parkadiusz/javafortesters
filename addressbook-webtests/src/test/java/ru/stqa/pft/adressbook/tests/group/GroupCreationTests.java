package ru.stqa.pft.adressbook.tests.group;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test", null, "test2"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
