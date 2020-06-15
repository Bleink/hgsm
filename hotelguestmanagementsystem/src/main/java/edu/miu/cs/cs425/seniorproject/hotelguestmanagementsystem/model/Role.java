package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Integer roleId;

                @Column(nullable=false)
                @NotBlank
                private String name;



                public Role(String name) {
                        this.name = name;
                }

        }




