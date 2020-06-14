package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    @NotBlank(message = "Reservation date is required ")
    @DateTimeFormat(pattern = "mm-dd-yyyy")
    private LocalDate reservationDate;
    @Column(nullable=false)
    private Integer numberOfNights;
    private Integer roomNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomtype_id")
    private List<RoomType> roomTypeList;


}
