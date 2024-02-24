package model;

public class User {
    private String _username;
    private String _password;

    public User(String username, String password) {
        this._username = username;
        this._password = password;
    }

    public boolean checkUser(String username, String password) {
        if (_username.equals(username) && password.equals(password)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this._username;
    }
}
