package org.skypro.skyshop.search;

import org.skypro.skyshop.errors.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {

    private Set<Searchable> searchableMassive = new HashSet<>();

    public TreeSet<Searchable> search(String searchContent) {
        TreeSet<Searchable> searchResult = searchableMassive.stream()
                .filter(x -> x.searchTerm().contains(searchContent))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new LengthComparator())));

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
