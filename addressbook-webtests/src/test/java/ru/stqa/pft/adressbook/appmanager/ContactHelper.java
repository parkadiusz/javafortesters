package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.model.contact.ContactAddressData;
import ru.stqa.pft.adressbook.model.contact.ContactEmailData;
import ru.stqa.pft.adressbook.model.contact.ContactNameData;
import ru.stqa.pft.adressbook.model.contact.ContactTelephoneData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd); //zwrócenie do konstruktora w HeleprBase
  }

  public void fillContactNameForm(ContactNameData contactNameData) {
    type(By.name("firstname"),contactNameData.getName());
    type(By.name("lastname"), contactNameData.getLastName());
  }
  public void fillContactAddressForm(ContactAddressData contactAddressData) {
    type(By.name("address"), contactAddressData.getAddress());
  }

  public void fillContactTelephoneForm(ContactTelephoneData contactTelephoneData) {
    type(By.name("home"), contactTelephoneData.getTel1());
    type(By.name("mobile"), contactTelephoneData.getTel2());
    type(By.name("work"),contactTelephoneData.getTel3());
    type(By.name("fax"), contactTelephoneData.getFax());
  }

  public void fillContactEmailForm(ContactEmailData contactEmailData) {
    type(By.name("email"), contactEmailData.getEmail1());
    type(By.name("email2"), contactEmailData.getEmail2());
    type(By.name("email3"), contactEmailData.getEmail3());
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }


}
