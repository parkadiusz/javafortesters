package ru.stqa.pft.adressbook.tests.contact;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.contact.ContactData;
import ru.stqa.pft.adressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhone(){
    app.goTo().homePage();
    ContactData contact = app.contactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contactHelper().infoFromEditForm(contact);
        MatcherAssert.assertThat(contact.getAllPhones(), CoreMatchers.equalTo(mergePhones(contactInfoFromEditForm)));
    }
    private String mergePhones(ContactData contact){
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s)->!s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
