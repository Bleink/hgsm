package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public User getUser(Long userId);

    public List<User> getAllUsers();

    public User updateUser(User user);

    public void deleteUser(Long userId);
}
