package org.skypro.skyshop.errors;

public class BestResultNotFound extends RuntimeException {
    private String search;


    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Для поискового запроса '" + search + "' не найдено подходящих результатов";
    }

}
