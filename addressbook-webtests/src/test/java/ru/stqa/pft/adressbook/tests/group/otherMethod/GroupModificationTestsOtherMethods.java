package ru.stqa.pft.adressbook.tests.group.otherMethod;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTestsOtherMethods extends TestBase {

  @Test
  public void testGroupModification(){
    app.goTo().groupPage();
    if(!app.groupHelper().isThereAGroup()){
      app.groupHelper().createGroup(new GroupData()
              .withName("test")
              .withFooter("test2"));
      app.goTo().returnToGroupPage();
    }
    //int before = app.groupHelper().getCountGroup();
    List<GroupData> before = app.groupHelper().list();
    app.groupHelper().selectGroup();
    app.groupHelper().initGroupModification();
    GroupData group = new GroupData()
            .withFooter("zibi")
            .withHeader("nic")
            .withFooter("eloszka")
            .setId(before.get(0).getId());
    // nowy obiekt group z ID
    app.groupHelper().fillGroupForm(group);
    app.groupHelper().submitGroupModification();
    app.goTo().groupPage();
    List<GroupData> after = app.groupHelper().list();
    before.remove(0); //usuwa ostatni element z listy ponieważ jest zmieniony
    before.add(group); // dodaje do listy zmieniony element

    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    Comparator<?super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);

    //int after = app.groupHelper().getCountGroup();
    //Assert.assertEquals(after, before);
  }
}
