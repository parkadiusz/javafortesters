package ru.stqa.pft.adressbook.model.contact;

public class ContactEmailData {

  private String email1;
  private String email2;
  private String email3;


  public ContactEmailData setEmail1(String email1) {
    this.email1 = email1;
    return this;
  };

  public ContactEmailData setEmail2(String email2) {
    this.email2 = email2;
    return this;
  };


  public ContactEmailData setEmail3(String email3) {
    this.email3 = email3;
    return this;
  };



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
