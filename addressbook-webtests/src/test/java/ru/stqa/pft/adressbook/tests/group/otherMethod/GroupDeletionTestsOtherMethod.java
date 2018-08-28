package ru.stqa.pft.adressbook.tests.group.otherMethod;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTestsOtherMethod extends TestBase {

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
        List<GroupData> before = app.groupHelper().list();
        //int before = app.groupHelper().getCountGroup();
        app.groupHelper().selectGroup(0);
        app.groupHelper().deleteSelectGroups();
        app.goTo().returnToGroupPage();
        List<GroupData> after = app.groupHelper().list();
        Assert.assertEquals(after.size(),before.size()-1);
        //int after = app.groupHelper().getCountGroup();
        //Assert.assertEquals(after, before-1);
        before.remove(0);
//        for(int i=0; i<before.size();i++){ //porównuje każdy element z listy
//            Assert.assertEquals(before.get(i), after.get(i));
//        }
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after); //specjalne porównanie zmiennych typu GroupData
    }




}
