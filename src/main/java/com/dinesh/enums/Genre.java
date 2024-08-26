package com.dinesh.enums;

public enum Genre {
    ACTION ( "Action"),
    THRILLER ( "Thriller"),
    COMEDY ( "Comedy"),
    HORROR ( "Horror"),
    Adventure ( "Adventure");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    public static Genre[] genres() {
        return values();
    }

    @Override
    public String toString() {
        return genre;
    }

    public String getUniqueName() {
        return genre + "Unique Name";
    }
}
