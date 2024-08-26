package com.dinesh.io;

import java.io.*;

public class Movie implements Externalizable {
//    @Serial
    private static final long serialVersionUID = -2856907389312536747L;
    private String title;
    private String description;
    private String genre;
    private int ageRestriction;

    public Movie(String title, String description, String genre, int ageRestriction) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.ageRestriction = ageRestriction;
    }

    public Movie() { // No args constructor required
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(description);
        out.writeInt(ageRestriction);
        System.out.println("Writing work is going on ...");
        System.out.println("out object= " + out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Reading work is going on ...");
        System.out.println("ObjectInput = " + in);
        title = (String) in.readObject(); // writeExternal Order must be followed
        description = (String) in.readObject();
        ageRestriction = (int) in.readInt();

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", ageRestriction=" + ageRestriction +
                '}';
    }
}
