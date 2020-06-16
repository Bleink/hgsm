package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;

import java.util.List;

public interface GuestService {

    public Guest createUser(User user);
    Guest findByEmail(String email);
    public Guest getUser(Long userId);

    public List<Guest> getAllUsers();

    public Guest updateUser(User user);

    public void deleteUser(Long userId);
    Guest save(UserRegistrationDto registration);

}
