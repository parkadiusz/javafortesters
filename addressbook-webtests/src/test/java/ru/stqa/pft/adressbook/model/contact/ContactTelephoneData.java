package ru.stqa.pft.adressbook.model.contact;

public class ContactTelephoneData {
  private String tel1;
  private String tel2;
  private String tel3;
  private String fax;

  public ContactTelephoneData setTel1(String tel1) {
    this.tel1 = tel1;
    return this;
  }

  public ContactTelephoneData setTel2(String tel2) {
    this.tel2 = tel2;
    return this;
  }


  public ContactTelephoneData setTel3(String tel3) {
    this.tel3 = tel3;
    return this;
  }

  public ContactTelephoneData setFax(String fax) {
    this.fax = fax;
    return this;
  }




  public String getTel1() {
    return tel1;
  }

  public String getTel2() {
    return tel2;
  }

  public String getTel3() {
    return tel3;
  }

  public String getFax() {
    return fax;
  }
}
