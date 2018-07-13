package ru.stqa.pft.adressbook.model.contact;

public class ContactTelephoneData {
  private final String tel1;
  private final String tel2;
  private final String tele3;
  private final String fax;

  public ContactTelephoneData(String tele1, String tele2, String tele3, String fax) {
    this.tel1 = tele1;
    this.tel2 = tele2;
    this.tele3 = tele3;
    this.fax = fax;
  }

  public String getTel1() {
    return tel1;
  }

  public String getTel2() {
    return tel2;
  }

  public String getTele3() {
    return tele3;
  }

  public String getFax() {
    return fax;
  }
}
