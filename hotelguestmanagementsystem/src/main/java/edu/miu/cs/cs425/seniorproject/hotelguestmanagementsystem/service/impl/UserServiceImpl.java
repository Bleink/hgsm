package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto.UserRegistrationDto;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Role;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.GuestRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.RolesRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.UserRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final GuestRepository guestRepository;
    private final UserRepository userRepository;
    private final RolesRepository roleRepository;
    @Autowired
    private  BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(GuestRepository guestRepository,UserRepository userRepository, RolesRepository roleRepository){
        this.roleRepository=roleRepository;
        this.userRepository=userRepository;
        this.guestRepository=guestRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User findByEmail(String email){

        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Email"+ email + "not found"));
    }
    @Override
    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User oldUser = getUser(user.getUserId());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setCellPhoneNumber(user.getCellPhoneNumber());
        oldUser.setUserName(user.getUserName());
        oldUser.setPassword(user.getPassword());
        oldUser.setRoles(user.getRoles());
        oldUser.setAddress(user.getAddress());
        return userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User save(UserRegistrationDto registration) {
        Guest user = new Guest();
       Role role= roleRepository.findByName("GUEST");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setUserName(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));

        Guest user1= guestRepository.save(user);
        System.out.println(user1);
        return user1;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Email"+ email + "not found"));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),getAuthorities(user));

    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles=user.getRoles().stream().map(Role::getName).toArray((String[]::new));

        return AuthorityUtils.createAuthorityList(userRoles);
    }
}
