package ru.stqa.pft.adressbook.tests.contact;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;
import ru.stqa.pft.adressbook.tests.TestBase;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getCountContacts();
    if(! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoContactCreation();
      app.getContactHelper().createContact(
              (new ContactNameData("Jan", "Kowalski", "zibi", true)),
              (new ContactAddressData("Aleje Mickiewicza 12\n30-552 Kraków")),
              (new ContactTelephoneData("500500500", "600600600", "700700700", "800800800")),
              (new ContactEmailData("test@test.com", "test321@o2.com", "test9@com.pl"))
      );
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactNameForm(new ContactNameData("Adam", "Rokita", null,false));
    app.getContactHelper().fillContactAddressForm(new ContactAddressData("Aleje Mickiewicza 15\n30-552 Kraków"));
    app.getContactHelper().fillContactTelephoneForm(new ContactTelephoneData("500500100500", "+48600600600", "+48700700700", "800800800"));
    app.getContactHelper().fillContactEmailForm(new ContactEmailData("test123@test.com", "test1@o2.com", "test19@com.pl"));
    app.getContactHelper().submitContactModyfication();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getCountContacts();
    Assert.assertEquals(after,before);
  }
}
