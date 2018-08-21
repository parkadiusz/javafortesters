package ru.stqa.pft.adressbook.model.contact;

import java.util.Objects;

public class ContactNameData {
  private int id;
  private final String name;
  private final String lastName;
  private String group;
  private Boolean creation;



  public ContactNameData(int id, String name, String lastName, String group, Boolean creation ) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.group = group;
    this.creation = creation;
  }
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactNameData that = (ContactNameData) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, lastName);
  }
}
