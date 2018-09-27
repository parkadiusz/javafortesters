package ru.stqa.pft.adressbook.tests.group;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.model.group.Groups;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Set;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (!app.groupHelper().isThereAGroup()) {
      app.groupHelper().createGroup(new GroupData()
              .withName("test")
              .withFooter("test2"));
      app.goTo().returnToGroupPage();
    }
  };
  @Test
  public void testGroupModification(){
    Groups before = app.groupHelper().all();
    GroupData modifiedGroup = (GroupData) before.iterator().next();

    GroupData group = new GroupData()
            .withName("testuje")
            .withFooter("zibi")
            .withHeader("nic")
            .withId(modifiedGroup.getId());
    // nowy obiekt group z ID
    app.groupHelper().selectGroupById(modifiedGroup.getId());
    app.groupHelper().initGroupModification();
    app.groupHelper().fillGroupForm(group);
    app.groupHelper().submitGroupModification();
    app.goTo().groupPage();
    MatcherAssert.assertThat(app.groupHelper().getCountGroup(), CoreMatchers.equalTo(before.size()));//hashCode
    Groups after = app.groupHelper().all();
    //before.remove(modifiedGroup); //usuwa element z listy ponieważ jest zmieniony
    //before.add(group); // dodaje do listy zmieniony element
    //Assert.assertEquals(after, before);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(group).without(modifiedGroup)));
  }
};
