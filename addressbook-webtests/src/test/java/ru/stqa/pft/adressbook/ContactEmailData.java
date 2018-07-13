package ru.stqa.pft.adressbook;

public class ContactEmailData {
  private final String email1;
  private final String email2;
  private final String email3;

  public ContactEmailData(String email1, String email2, String email3) {
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }
}
