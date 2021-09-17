package model;

class User {
    private static int _id = 0;
    private int id;
    private String key;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.id = ++_id;
        this.key = "user:" + this.id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}