package ru.stqa.pft.adressbook.tests.contact;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){
  app.getNavigationHelper().gotoHomePage();
  app.getContactHelper().selectContact();
  app.getContactHelper().initContactDeletion();
  app.getNavigationHelper().gotoHomePage();
  }
}
