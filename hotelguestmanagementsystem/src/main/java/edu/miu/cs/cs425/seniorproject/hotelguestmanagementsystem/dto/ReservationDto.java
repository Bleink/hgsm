package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private String roomType;
    private Integer numberOfOccupants;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
    private Integer numberOfNights;
    private Integer numberOfRooms;
    private List<Room> room;

}
