package ru.stqa.pft.adressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test(groups = "Contact")
  public void testContactDeletion(){

  app.goTo().homePage();
  //int before = app.contactHelper().getCountContacts();
    List<ContactNameData> before = app.contactHelper().getContacts();
  if(! app.contactHelper().isThereAContact()){
    app.goTo().contactCreation();
    app.contactHelper().createContact(
            (new ContactNameData("Jan", "Kowalski", "zibi", true)),
            (new ContactAddressData("Aleje Mickiewicza 12\n30-552 Kraków")),
            (new ContactTelephoneData("500500500", "600600600", "700700700", "800800800")),
            (new ContactEmailData("test@test.com", "test321@o2.com", "test9@com.pl"))
    );
    app.goTo().homePage();
  }

  app.contactHelper().selectContact(0);
  app.contactHelper().initContactDeletion();
  app.goTo().homePage();
  List<ContactNameData> after = app.contactHelper().getContacts();
  before.remove(0);
    Comparator<?super ContactNameData> byId= (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);

  //int after = app.contactHelper().getCountContacts();
    Assert.assertEquals(after, before);


  }
}
