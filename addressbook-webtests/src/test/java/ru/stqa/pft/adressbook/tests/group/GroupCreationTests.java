package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //pobierana jest Lista z grupami dlatego w asercji jest size()
    //int before = app.getGroupHelper().getCountGroup(); //tutaj zliczana jest ilość grup, before i after to są tylko zmienne
    app.getGroupHelper().createGroup(new GroupData("nie2", null, "test2"));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getCountGroup();
    //Assert.assertEquals(after, before+1);
    Assert.assertEquals(after.size(), before.size()+1);
    before.add(after.get(0));
    Assert.assertEquals( new HashSet<Object>(after),new HashSet<Object>(before));
  }

}
