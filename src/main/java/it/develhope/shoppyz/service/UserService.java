package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.User;

import java.util.List;

public interface UserService {
    public User getUser(int id);
    public void deleteUser(int id);
    public void saveUser(User user);
    public void updateUser(int id, User user);
    public List<User> getUsers();
}
