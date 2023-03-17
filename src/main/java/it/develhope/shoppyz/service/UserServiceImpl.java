package it.develhope.shoppyz.service;

import it.develhope.shoppyz.entity.User;
import it.develhope.shoppyz.repository.UserRepository;
import it.develhope.shoppyz.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepositoryImpl service= new UserRepositoryImpl();
    /**
     * @return get the user with the id of:
     */
    public User getUser(int id) {
        User user= service.getUser(id);
        return user;
}
    /**
     * @return delete the user with the id of.
     */
    public void deleteUser(int id) {
        service.deleteUser(id);
    }
    /**
     * @return save the user.
     */
    public void saveUser(User user) {
        service.saveUser(user);
    }
    /**
     * @return update the user with the id of.
     */
    public void updateUser(int id, User user) {
        service.updateUser(id,user);
    }
    /**
     * @return returns the list of users in the db
     */
    public List<User> getUsers() {
        List<User> userList=service.getUsers();
        return userList;
    }

}
