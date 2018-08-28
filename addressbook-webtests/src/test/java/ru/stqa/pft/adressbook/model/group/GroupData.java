package ru.stqa.pft.adressbook.model.group;

import java.util.Objects;

public class GroupData {
  private Integer id; //nie ma final, final jest gdy konstruktor jest stały, niezmienny
  private String name;
  private String header;
  private String footer;


  public Integer getId() {
    return id;
  }

  public GroupData setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  //tutaj są setery, konstruktory już nie są potrzebne
  public GroupData withName(String name) {
    //wczesniej bylo void a jest GroupData bo to jest typ obiektu
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;

  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) &&
            Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
