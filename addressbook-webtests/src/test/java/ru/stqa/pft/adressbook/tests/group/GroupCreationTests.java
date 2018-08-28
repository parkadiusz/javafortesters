package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.groupHelper().list(); //pobierana jest Lista z grupami dlatego w asercji jest size()
    //int before = app.groupHelper().getCountGroup(); //tutaj zliczana jest ilość grup, before i after to są tylko zmienne
    GroupData group = new GroupData()
            .withName("nie2")
            .withFooter("test2");
    app.groupHelper().createGroup(group);
    app.goTo().returnToGroupPage();
    List<GroupData> after = app.groupHelper().list();
    //int after = app.groupHelper().getCountGroup();
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
