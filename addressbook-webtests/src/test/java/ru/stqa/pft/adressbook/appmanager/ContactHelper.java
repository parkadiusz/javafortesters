package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.contact.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd); //zwrócenie do konstruktora w HeleprBase
  }

  //true jeżeli ma być dropdown
  public void fillContactNameForm(ContactNameData contactNameData) {
    type(By.name("firstname"), contactNameData.getName());
    type(By.name("lastname"), contactNameData.getLastName());

    if (contactNameData.getCreation()) { //creation true or false
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactNameData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));//sprawdza czy dropdown jest widoczny jeżeli nie jest to ma być nie widoczny
    }
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


  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModyfication() {
    click(By.name("update"));
  }

  public void selectContact(int index){
    wd.findElements(By.name("selected[]")).get(index).click(); //get bo to jest List
  }

  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactNameData name, ContactAddressData address, ContactTelephoneData telephone, ContactEmailData email) {
    fillContactNameForm(name);
    fillContactAddressForm(address);
    fillContactTelephoneForm(telephone);
    fillContactEmailForm(email);
    submitContactCreation();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getCountContacts() {
    return wd.findElements(By.name("selected[]")).size();
  }

//  public List<ContactNameData> all() {
//    List<ContactNameData> contacts = new ArrayList<>();
//    List<WebElement> elements = wd.findElements(By.name("entry"));
//    for (WebElement element : elements){
//      String name = element.findElement(By.xpath("td[3]")).getText();
//      //System.out.println(name);
//      String lastName = element.findElement(By.xpath("td[2]")).getText();
//      //System.out.println(lastName);
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
//      ContactNameData contact = new ContactNameData().setId(id).setName(name).setLastName(lastName);
//      contacts.add(contact);
//    }
//    return contacts;
//  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows){
      List <WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withFirstname(firstName).withLastname(lastName).withAllPhones(allPhones));
      //System.out.println(name);

      //System.out.println(lastName);
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstName).withLastname(lastName).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

  };

  public void initContactModificationById(int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}
