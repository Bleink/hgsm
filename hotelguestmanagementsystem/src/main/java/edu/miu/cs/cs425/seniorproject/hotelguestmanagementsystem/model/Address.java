package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @NotBlank(message="Street address is required")
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    @NotBlank(message="City  is required")
    private String city;
    @Column(nullable = false)
    @NotBlank(message="State is required")
    private String state;
    @Column(nullable = false)
    @NotBlank(message="zipcode  is required")
    private String zipcode;
}
