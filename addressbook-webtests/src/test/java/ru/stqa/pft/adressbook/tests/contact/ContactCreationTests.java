package ru.stqa.pft.adressbook.tests.contact;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;
import ru.stqa.pft.adressbook.model.group.GroupData;
import ru.stqa.pft.adressbook.tests.TestBase;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        //int before = app.getContactHelper().getCountContacts();
        List<ContactNameData> before = app.getContactHelper().getContacts();
        app.getNavigationHelper().gotoContactCreation();
        ContactNameData contact = new ContactNameData("Jan", "Kowalski", "zibi", true);
        app.getContactHelper().createContact(
                (contact),
                (new ContactAddressData("Aleje Mickiewicza 12\n30-552 Kraków")),
                (new ContactTelephoneData("500500500", "600600600", "700700700", "800800800")),
                (new ContactEmailData("test@test.com", "test321@o2.com", "test9@com.pl"))
        );
        app.getNavigationHelper().gotoHomePage();
        List<ContactNameData> after = app.getContactHelper().getContacts();
        System.out.println(after.size());
        Assert.assertEquals(after.size(), before.size()+1);
        //int after = app.getContactHelper().getCountContacts();
        //Assert.assertEquals(after, before+1);

        //porownanie list
        int maxId = after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        contact.setId(maxId);
        before.add(contact);
        Comparator<? super ContactNameData>byId =((o1, o2) -> Integer.compare(o1.getId(),o2.getId()));
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(after,before);


    }











}
