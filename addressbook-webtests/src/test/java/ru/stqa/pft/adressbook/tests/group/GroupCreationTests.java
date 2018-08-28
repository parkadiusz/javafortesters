package ru.stqa.pft.adressbook.tests.group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupData> before = app.groupHelper().all(); //teraz pobierany jest zbior
    GroupData group = new GroupData()
            .withName("nie2")
            .withFooter("test2");
    app.groupHelper().createGroup(group);
    app.goTo().returnToGroupPage();
    Set<GroupData> after = app.groupHelper().all();
    //metoda nr 3 wyszukiwanie elementów w zbiorze
    group.setId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
    //z utworzonego obiektu group wyszukujemy dane po ID.
    //zbior (after) obiektow typu GroupData przeksztalcamy w potok,
    // przy pomocy mapToInt przeksztalcamy w liczby calkowite za pomoca funkcji anonimowej gdzie uzyskujemy ID
    //nastepnie wybieramy maksymalná wartosc ktora jest przeksztalcona w liczbe calkowita
    before.add(group);
    Assert.assertEquals(after,before);
  };

};
