package ru.stqa.pft.adressbook.tests;

//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.adressbook.appmanager.ApplicationManager;
//import sun.plugin2.util.BrowserType;

public class TestBase {
  //metoda final oznacza że w to pola może przypisać wartość tylko jeden jedyny raz
  //w obiekcie ApplicationManager jest przekazywana zmienna do konstruktora która uruchamia odpowiedniá przegládarké
  protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();

  }

  @AfterMethod
    public void tearDown() {
    app.stop();
  }

}
