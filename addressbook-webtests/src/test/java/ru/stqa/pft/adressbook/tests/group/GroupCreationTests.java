package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); //pobierana jest Lista z grupami dlatego w asercji jest size()
    //int before = app.getGroupHelper().getCountGroup(); //tutaj zliczana jest ilość grup, before i after to są tylko zmienne
    GroupData group = new GroupData("nie2", null, "test2");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getCountGroup();
    //Assert.assertEquals(after, before+1);
    Assert.assertEquals(after.size(), before.size()+1);
//dodaje elementy alfabetycznie, dlatego trzeba znaleźć największe ID = metoda nr 1
    int max = 0;
    for(GroupData g:after){ //pobiera ID elementu i przypisuje do zmiennej max
      if(g.getId()>max){
        max=g.getId();
      }
    }

    //lambda, strumienie, potok, funkcja max porównuje elementy z listy = metoda nr 2
    int max1 = after.stream().max(((o1, o2) -> Integer.compare(o1.getId(),o2.getId())) ).get().getId();
    group.setId(max1);
    before.add(group);
    Comparator<? super GroupData> byId = ((o1, o2) -> Integer.compare(o1.getId(),o2.getId()));
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);
    //Assert.assertEquals( new HashSet<Object>(after),new HashSet<Object>(before));
    // HashSet juz nie jest potrzebny, teraz porównujemmy posortowame listy a nie zbiory
  }

}
