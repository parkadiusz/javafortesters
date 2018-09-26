package ru.stqa.pft.adressbook.model.group;

import java.util.Objects;
import java.util.stream.IntStream;

public class GroupData {


  private int id = Integer.MAX_VALUE; //nie ma final, final jest gdy konstruktor jest stały, niezmienny
  private String name;
  private String header;
  private String footer;

  public int getId() {
    return id;
  }


  public GroupData withId(int id) {
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

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
