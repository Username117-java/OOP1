package org.skypro.skyshop.product.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String nameArticle;
    private String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    // Исправить
    @Override
    public String toString() {
        return nameArticle + " " + textArticle;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return nameArticle;
    }

}
