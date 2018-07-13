package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.adressbook.appmanager.ApplicationManager;

public class TestBase {
  //metoda final oznacza że w to pola może przypisać wartość tylko jeden jedyny raz
  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod
    public void tearDown() {
    app.stop();
  }

}
