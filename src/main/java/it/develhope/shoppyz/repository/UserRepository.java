package it.develhope.shoppyz.repository;

import it.develhope.shoppyz.entity.Account;
import it.develhope.shoppyz.entity.User;

import java.util.List;

public interface UserRepository {
    public User getUser(int id);

    public void deleteUser(int id);

    public void saveUser(User user);

    public void updateUser(int id);

    public List<User> getUsers(List<User> account);
}
