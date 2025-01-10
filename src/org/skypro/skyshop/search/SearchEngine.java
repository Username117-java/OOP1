package org.skypro.skyshop.search;

import org.skypro.skyshop.errors.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchableMassive = new HashSet<>();

    public TreeSet<Searchable> search(String searchContent) {
        TreeSet<Searchable> searchResult = new TreeSet<>(new LengthComparator());

        for (Searchable s : searchableMassive) {
            if (s.searchTerm().contains(searchContent)) {
                searchResult.add(s);
            }
        }


        if (searchResult.isEmpty()) {
            throw new BestResultNotFound(searchContent);
        }
        return searchResult;
    }

    // А оно вообще нужно?
    public void add(Searchable searchable) {
        searchableMassive.add(searchable);
    }

}
