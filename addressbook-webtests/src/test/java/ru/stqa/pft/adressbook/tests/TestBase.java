package ru.stqa.pft.adressbook.tests;

//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.appmanager.ApplicationManager;
//import sun.plugin2.util.BrowserType;

public class TestBase {
  //metoda final oznacza że w to pola może przypisać wartość tylko jeden jedyny raz
  //w obiekcie ApplicationManager jest przekazywana zmienna do konstruktora która uruchamia odpowiedniá przegládarké
  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite
    public void tearDown() {
    app.stop();
  }

}
