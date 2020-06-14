package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkIn_id")
    private Long checkInId;
    @NotBlank(message = "CheckIn date is required ")
    @DateTimeFormat(pattern = "mm-dd-yyyy")
    private LocalDate checkInDate;
    private Integer roomNumber;
}
