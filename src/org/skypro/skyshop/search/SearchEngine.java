package org.skypro.skyshop.search;

import org.skypro.skyshop.errors.BestResultNotFound;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchableMassive = new LinkedList<>();


    public List<Searchable> search(String searchContent) {
        List<Searchable> searchResult = new LinkedList<>();
        Iterator<Searchable> iterator = searchableMassive.iterator();
        while (iterator.hasNext()) {
            Searchable s = iterator.next();
            if (s.searchTerm().contains(searchContent)) {
                searchResult.add(s);
            }
        }
        if (searchResult.isEmpty()) {
            throw new BestResultNotFound(searchContent);
        }
        return searchResult;
    }

    public Searchable searchBestResult(String searchContent) {
        Searchable searchResult = null;
        int maxCount = 0;
        for (Searchable s : searchableMassive) {
            int index = 0;
            int count = 0;
            int subIndex = s.searchTerm().indexOf(searchContent, index);
            while (subIndex != -1) {
                count++;
                index += searchContent.length();
                subIndex = s.searchTerm().indexOf(searchContent, index);
            }
            if (count > maxCount) {
                searchResult = s;
            }
        }
        if (searchResult == null) {
            throw new BestResultNotFound(searchContent);
        }
        return searchResult;
    }



    public void add(Searchable searchable) {
        searchableMassive.add(searchable);
    }

}
