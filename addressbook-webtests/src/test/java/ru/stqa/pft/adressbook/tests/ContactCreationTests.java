package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactCreation();

        app.fillContactNameForm(new ContactNameData("Jan", "Kowalski"));
        fillContactAddressForm(new ContactAddressData("Aleje Mickiewicza 12\n30-552 Kraków"));
        fillContactTelephoneForm(new ContactTelephoneData("500500500", "600600600", "700700700", "800800800"));
        fillContactEmailForm(new ContactEmailData("test@test.com", "test321@o2.com", "test9@com.pl"));
        submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }











}
