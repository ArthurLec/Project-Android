package com.vogella.projectandroid.model;

import java.util.List;

public class RestGhibliResponse {
    private int count;
    private String next;
    private List<Ghibli> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Ghibli> getResults() {
        return results;
    }
}
