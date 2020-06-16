package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;
    @NotBlank(message="Bill number is required")
    @Column(nullable= false , unique=true)
    private Integer billNumber;
    @NotBlank(message="checkout date is required")
    private LocalDate checkoutDate;
    private  Double finalRate;
    @ManyToOne( optional = false)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    public void calculateBill(LocalDate checkinDate, Double rate){
        Period intervalPeriod = Period.between(checkinDate, checkoutDate);
        int numberOfDays = intervalPeriod.getDays();
        finalRate = rate * numberOfDays;
    }
}
