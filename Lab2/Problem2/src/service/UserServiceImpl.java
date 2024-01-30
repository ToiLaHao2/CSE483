package service;

import entity.User;

public class UserServiceImpl implements UserService {
    private User user;

    public UserServiceImpl(User user) {
        this.user = user;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        if (this.user.getUsername().equals(username) && this.user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
