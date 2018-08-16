package ru.stqa.pft.adressbook.model.group;

import java.util.Objects;

public class GroupData {
  private Integer id; //nie ma final, final jest gdy konstruktor jest stały, niezmienny
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String name, String header, String footer) { //sztucznie utworzona grupa z nieznany identyfikatorem
    // (IDE rozpoznaje jako dwie różne grupy GroupData
    this.id = 0;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }



  public GroupData(Integer id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
