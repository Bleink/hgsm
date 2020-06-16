package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


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
    private String password;
    @NotBlank(message="cell phone number is required")
    @Column(nullable = true)
    private  String cellPhoneNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_Id")
    private Address address;
    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Email is required")
    @Email(message="{errors.invalid_email}")
    private String email;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")}
    )
    private Set<Role> roles;
    private boolean enabled;

    public User(HashSet<Role> roles) {
        this.roles=roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cellPhoneNumber='" + cellPhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }


}



