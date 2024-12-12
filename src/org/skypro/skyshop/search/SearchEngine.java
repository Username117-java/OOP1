package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchableMassive;

    public SearchEngine (int massiveSize) {
        searchableMassive = new Searchable[massiveSize];
    }

    public Searchable[] search(String searchContent) {
        Searchable[] searchResult = new Searchable[5];
        int i = 0;
        for (Searchable s : searchableMassive) {
            if (s.searchTerm().contains(searchContent)) {
                searchResult[i] = s;
                i++;
                if (i == 5) {
                    return searchResult;
                }
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        if (searchableMassive[searchableMassive.length - 1] != null) {
            System.out.println("Массив поиска заполнен");
            return;
        }
        for (int i = 0; i < searchableMassive.length; i++) {
            if (searchableMassive[i] == null) {
                searchableMassive[i] = searchable;
                break;
            }
        }
    }

}
