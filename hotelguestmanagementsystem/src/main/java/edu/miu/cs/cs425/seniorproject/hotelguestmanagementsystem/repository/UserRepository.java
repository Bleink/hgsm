package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
