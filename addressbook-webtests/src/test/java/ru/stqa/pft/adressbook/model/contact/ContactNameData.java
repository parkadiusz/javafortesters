package ru.stqa.pft.adressbook.model.contact;

import java.util.Objects;

public class ContactNameData {


  private int id;
  private String name;
  private String lastName;
  private String group;
  private Boolean creation;

  public int getId() {
    return id;
  }

  public ContactNameData setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ContactNameData setName(String name) {
    this.name = name;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public ContactNameData setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getGroup() {
    return group;
  }

  public ContactNameData setGroup(String group) {
    this.group = group;
    return this;
  }

  public Boolean getCreation() {
    return creation;
  }

  public ContactNameData setCreation(Boolean creation) {
    this.creation = creation;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactNameData that = (ContactNameData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}
