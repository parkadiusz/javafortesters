package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {
  public static void main (String[] args){
    String[] langs = {"java","C#"};
    String[] tab = new String[3];
    tab[0] = "hello";
    tab[1] = "123";

    for (int i = 0; i < langs.length; i++){
      System.out.println(langs[i]);
    }

    for (int i = 0; i<tab.length; i++) {
      System.out.println(tab[i]);
    }

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("javaScript");

    for (String l :languages) {
      System.out.println("Listowanie: " + l);
    }

    List<Integer> number = Arrays.asList(1,12,13,14,15);
            for (int i=0; i<number.size(); i++){ //w tablicach jest lengtch
              System.out.println("liczby: " + number.get(i)); //by odnieść się do odpowiedniego indexu dajemy get()
            }

            List sings = Arrays.asList("@#",2,23,"test"); //gdy nie ma określonej zmiennych w Lisćie to w for dajemy Object

            for(Object s : sings){
              System.out.println("znaki: " + s);
            }

  }
}
