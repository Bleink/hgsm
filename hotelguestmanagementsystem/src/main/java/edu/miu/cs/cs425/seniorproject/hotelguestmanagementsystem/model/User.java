package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    @NotBlank(message = "First Name is required")
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @Column(name = "username",unique= true ,nullable = false )
    @NotBlank(message="user name is required")
    private String userName;
    @Column(name="password" ,nullable=false)
    @Size(min = 8)
    @NotBlank(message="password is required")
    private String userPassword;
    @Enumerated
    private Role roles;
   // @NotBlank(message="cell phone number is required")
    @Column(nullable = true )
    private  String cellPhoneNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_Id")
    private Address address;


}



