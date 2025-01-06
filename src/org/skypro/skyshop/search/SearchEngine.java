package org.skypro.skyshop.search;

import org.skypro.skyshop.errors.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {


    private Map<String, List<Searchable>> searchableMassive = new TreeMap<>();

    public TreeMap<String, List<Searchable>> search(String searchContent) {
        TreeMap<String, List<Searchable>> searchResult = new TreeMap<>();

        for (Map.Entry<String, List<Searchable>> entry : searchableMassive.entrySet()) {
            for (Searchable s : entry.getValue()) {
                if (s.searchTerm().contains(searchContent)) {
                    searchResult.computeIfAbsent(s.getName(), k -> new LinkedList<>()).add(s);
                }
            }
        }

        if (searchResult.isEmpty()) {
            throw new BestResultNotFound(searchContent);
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        searchableMassive.computeIfAbsent(searchable.getName(), k -> new LinkedList<>()).add(searchable);
    }

}
