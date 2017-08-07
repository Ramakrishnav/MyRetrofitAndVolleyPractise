package com.happyadda.myretrofitandvolleypractise.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dumadu on 31/07/17.
 */

public class MovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<Movie> results;

    private int getPage() {
        return page;
    }
    private void setPage(int page) {
        this.page = page;
    }
    private int getTotalResults() {
        return totalResults;
    }
    private void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
    public List<Movie> getResults() {
        return results;
    }
    private void setResults(List<Movie> results) {
        this.results = results;
    }
    private int getTotalPages() {
        return totalPages;
    }
    private void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
