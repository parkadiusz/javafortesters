package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
public void ensurePrecondition(){
    app.goTo().groupPage();
    if(!app.groupHelper().isThereAGroup()){
      app.groupHelper().createGroup(new GroupData()
              .withName("test")
              .withFooter("test2"));
      app.goTo().returnToGroupPage();
    }

  }

    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.groupHelper().all();
        //int before = app.groupHelper().getCountGroup();
      GroupData deleteGroup = before.iterator().next();
      System.out.println("delete group: " + deleteGroup);
      //iterator grupuje zbior, next wyciaga pierwszy element.
      app.groupHelper().delete(deleteGroup);
        app.goTo().returnToGroupPage();
        Set<GroupData> after = app.groupHelper().all();

        before.remove(deleteGroup);
        Assert.assertEquals(before,after); //specjalne porównanie zmiennych typu GroupData
    }




}
