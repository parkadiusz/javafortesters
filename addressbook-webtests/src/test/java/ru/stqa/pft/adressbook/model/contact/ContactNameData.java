package ru.stqa.pft.adressbook.model.contact;

public class ContactNameData {
  private final String name;
  private final String lastName;
  private String group;
  private Boolean creation;

  public ContactNameData(String name, String lastName, String group, Boolean creation ) {
    this.name = name;
    this.lastName = lastName;
    this.group = group;
    this.creation = creation;
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

  public Boolean getCreation(){return creation;}
}
