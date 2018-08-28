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

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.goTo().homePage();
    List<ContactNameData> before = app.contactHelper().getContacts();
    // int before = app.contactHelper().getCountContacts();
    if(!app.contactHelper().isThereAContact()){
      app.goTo().contactCreation();
      app.contactHelper().createContact(
              (new ContactNameData("Jan", "Kowalski", "zibi", true)),
              (new ContactAddressData("Aleje Mickiewicza 12\n30-552 Kraków")),
              (new ContactTelephoneData("500500500", "600600600", "700700700", "800800800")),
              (new ContactEmailData("test@test.com", "test321@o2.com", "test9@com.pl"))
      );
      app.goTo().homePage();
    }
    app.contactHelper().initContactModification();
    ContactNameData contact = new ContactNameData(before.get(0).getId(),"Adam", "Rokita", null,false);
    app.contactHelper().fillContactNameForm(contact);
    app.contactHelper().fillContactAddressForm(new ContactAddressData("Aleje Mickiewicza 15\n30-552 Kraków"));
    app.contactHelper().fillContactTelephoneForm(new ContactTelephoneData("500500100500", "+48600600600", "+48700700700", "800800800"));
    app.contactHelper().fillContactEmailForm(new ContactEmailData("test123@test.com", "test1@o2.com", "test19@com.pl"));
    app.contactHelper().submitContactModyfication();
    app.goTo().homePage();
    //int after = app.contactHelper().getCountContacts();
    List<ContactNameData> after = app.contactHelper().getContacts();
    before.remove(0);
    before.add(contact);
    Comparator<?super ContactNameData>byId= (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after,before);
  }
}
