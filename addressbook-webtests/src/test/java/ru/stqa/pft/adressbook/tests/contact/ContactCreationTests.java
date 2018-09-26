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

public class ContactCreationTests extends TestBase {

    @Test(groups = "Contact")
    public void testContactCreation() {

        //int before = app.contactHelper().getCountContacts();
        List<ContactNameData> before = app.contactHelper().getContacts();
        app.goTo().contactCreation();
        ContactNameData contact = new ContactNameData().setName("Jan").setLastName("Kowalski").setGroup("zibi").setCreation(true);
        app.contactHelper().createContact(
                (contact),
                (new ContactAddressData().setAddress("Aleje Mickiewicza 12\n30-552 Kraków")),
                (new ContactTelephoneData().setTel1("500500500").setTel2("600600600").setTel3("700700700").setFax("800800800")),
                (new ContactEmailData().setEmail1("test@test.com").setEmail2("test321@o2.com").setEmail3("test9@com.pl"))
        );
        app.goTo().homePage();
        List<ContactNameData> after = app.contactHelper().getContacts();
        System.out.println(after.size());
        Assert.assertEquals(after.size(), before.size()+1);
        //int after = app.contactHelper().getCountContacts();
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
