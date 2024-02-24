package model;

public class User {
    private String _username;
    private String _password;

    public User(String username, String password) {
        this._username = username;
        this._password = password;
    }

    public String getName() {
        return this._username;
    }

    public String getPassword() {
        return this._password;
    }
}
