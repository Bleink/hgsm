package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private String roomType;
    private Integer numberOfOccupants;
    private LocalDate reservationDate;
    private Integer numberOfNights;
    private Integer numberOfRooms;

}
