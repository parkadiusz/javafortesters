package ru.stqa.pft.adressbook.model.contact;

public class ContactNameData {
  private final String name;
  private final String lastName;
  private String group;

  public ContactNameData(String name, String lastName, String Group ) {
    this.name = name;
    this.lastName = lastName;
    group = Group;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGroup() {
    return group;
  }
}
