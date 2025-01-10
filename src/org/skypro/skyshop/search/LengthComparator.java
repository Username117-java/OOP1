package org.skypro.skyshop.search;

import java.util.Comparator;

public class LengthComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        if (s1.getName().length() != s2.getName().length()) {
            return Integer.compare(s2.getName().length(), s1.getName().length());
        }
        return s1.getName().compareTo(s2.getName());

    }

}
