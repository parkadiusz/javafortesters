package ru.stqa.pft.adressbook.tests.group;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.model.group.Groups;
import ru.stqa.pft.adressbook.tests.TestBase;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {
    app.goTo().groupPage();
    //Set<GroupData> before = app.groupHelper().all(); //teraz pobierany jest zbior
    Groups before = app.groupHelper().all(); //teraz pobierany jest zbior, Groups za pomoca bibliotek hamcrest

    GroupData group = new GroupData()
            .withName("nie2")
            .withFooter("test2");
    app.groupHelper().createGroup(group);
    app.goTo().returnToGroupPage();
    Groups after = app.groupHelper().all();
    //metoda nr 3 wyszukiwanie elementów w zbiorze
    //group.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
    //z utworzonego obiektu group wyszukujemy dane po ID.
    //zbior (after) obiektow typu GroupData przeksztalcamy w potok,
    // przy pomocy mapToInt przeksztalcamy w liczby calkowite za pomoca funkcji anonimowej gdzie uzyskujemy ID
    //nastepnie wybieramy maksymalná wartosc ktora jest przeksztalcona w liczbe calkowita
    //before.add(group);
    assertEquals(after,before);
    //assertThat(after,equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))));
    //assertThat(after,equalTo(before.withAdded(group.withId(after.stream().mapToInt(GroupData -> group.getId()))
    //MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(group.withId(after.stream().mapToInt(g -> g.getId())))));
  }

}
