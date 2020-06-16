package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType , Long> {
    RoomType findByType(String type);
}
