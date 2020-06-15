package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User createUser(User user);
    User findByEmail(String email);
    public User getUser(Long userId);

    public List<User> getAllUsers();

    public User updateUser(User user);

    public void deleteUser(Long userId);
    User save(UserRegistrationDto registration);
}
