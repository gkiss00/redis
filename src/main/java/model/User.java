package model;

public class User {
    private static int _id = 0;
    private int id;
    public String key;
    public String firstName;
    public String lastName;

    public User(String firstName) {
        this.id = ++_id;
        this.key = "user:" + this.id;
        this.firstName = firstName;
        this.lastName = "";
    }

    public User(String firstName, String lastName) {
        this.id = ++_id;
        this.key = "user:" + this.id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}