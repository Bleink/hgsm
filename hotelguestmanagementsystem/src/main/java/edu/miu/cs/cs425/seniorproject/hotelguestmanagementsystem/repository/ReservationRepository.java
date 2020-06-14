package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
