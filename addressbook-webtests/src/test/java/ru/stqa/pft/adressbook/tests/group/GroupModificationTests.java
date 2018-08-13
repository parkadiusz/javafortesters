package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test", null, "test2"));
    }
    //int before = app.getGroupHelper().getCountGroup();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size()-1).getId(), "zibi", "nic", "eloszka");
    // nowy obiekt group z ID
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    before.remove(before.size()-1); //usuwa ostatni element z listy ponieważ jest zmieniony
    before.add(group); // dodaje do listy zmieniony element

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    Assert.assertEquals(after.size(), before.size());

    //int after = app.getGroupHelper().getCountGroup();
    //Assert.assertEquals(after, before);
  }
}
