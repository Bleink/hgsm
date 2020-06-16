package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.GuestRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestRepository guestRepository;


    @Override
    public Guest createUser(User user) {
        return null;
    }

    @Override
    public Guest findByEmail(String email) {
      return guestRepository.findByEmail(email);


    }

    @Override
    public Guest getUser(Long userId) {
        return null;
    }

    @Override
    public List<Guest> getAllUsers() {
        return null;
    }

    @Override
    public Guest updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public Guest save(UserRegistrationDto registration) {
        return null;
    }
}
