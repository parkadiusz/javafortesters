package ru.stqa.pft.adressbook.tests.contact;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;
import ru.stqa.pft.adressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
  app.getNavigationHelper().gotoHomePage();
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
  app.getContactHelper().selectContact();
  app.getContactHelper().initContactDeletion();
  app.getNavigationHelper().gotoHomePage();
  }
}
