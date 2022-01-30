package com.techtogether.deedcovenants.models;

public class Search {

    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Search(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Search() {}
}
