package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
public void ensurePrecondition(){
    app.getNavigationHelper().gotoGroupPage();
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test", null, "test2"));
    }

  }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //int before = app.getGroupHelper().getCountGroup();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1);
        //int after = app.getGroupHelper().getCountGroup();
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
