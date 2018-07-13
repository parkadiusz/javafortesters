package ru.stqa.pft.adressbook.model.contact;

public class ContactNameData {
  private final String name;
  private final String lastName;

  public ContactNameData(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }
}
