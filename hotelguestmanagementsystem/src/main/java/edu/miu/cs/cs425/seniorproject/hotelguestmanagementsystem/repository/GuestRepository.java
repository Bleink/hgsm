package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
