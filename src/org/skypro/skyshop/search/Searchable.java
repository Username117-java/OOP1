package org.skypro.skyshop.search;

public interface Searchable {


    String searchTerm();

    String getTypeContent();

    String getName();

    default String getStringRepresentation() {
        return "имя " + searchTerm() + "; тип " + getTypeContent();
    }


}
