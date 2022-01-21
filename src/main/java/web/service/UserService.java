package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> allUsers();

    public void add(User user);

    public void delete(User user);

    public void edit(User user);

    public User getById(int id);
}
