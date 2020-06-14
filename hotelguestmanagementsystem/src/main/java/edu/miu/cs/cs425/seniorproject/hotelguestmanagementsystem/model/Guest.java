package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guests")
public class Guest extends User{

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "reservation_id")
    private List<Reservation> reservationList;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private List<Bill> bill;

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }
}
