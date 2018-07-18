package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactNameForm(new ContactNameData("Adam", "Rokita"));
    app.getContactHelper().fillContactAddressForm(new ContactAddressData("Aleje Mickiewicza 15\n30-552 Kraków"));
    app.getContactHelper().fillContactTelephoneForm(new ContactTelephoneData("500500100500", "+48600600600", "+48700700700", "800800800"));
    app.getContactHelper().fillContactEmailForm(new ContactEmailData("test123@test.com", "test1@o2.com", "test19@com.pl"));
    app.getContactHelper().submitContactModyfication();
    app.getNavigationHelper().gotoHomePage();
  }
}
