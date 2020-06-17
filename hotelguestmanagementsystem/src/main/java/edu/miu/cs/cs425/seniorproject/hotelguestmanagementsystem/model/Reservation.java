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
    private LocalDate checkinDate;
    @NotBlank(message = "Reservation date is required ")
    @DateTimeFormat(pattern = "mm-dd-yyyy")
    private LocalDate checkoutDate;
    @Column(nullable=false)
    private Long numberOfNights;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
//    @OneToMany(mappedBy = "reservation")
//    private List<Room> roomList;

}
