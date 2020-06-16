package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashSet;

@Data

@Entity
@Table(name = "guests")
public class Guest extends User {


        public Guest(){
            super(new HashSet<Role>(Arrays.asList(new Role("GUEST"))));
        }

}
