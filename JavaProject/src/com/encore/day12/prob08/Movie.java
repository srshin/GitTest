package com.encore.day12.prob08;

public class Movie {
    
    private String title;       // 제목
    private int year;           // 개봉연도
    private String director;    // 감독

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", year=" + year + ", director=" + director + "]";
    }
}