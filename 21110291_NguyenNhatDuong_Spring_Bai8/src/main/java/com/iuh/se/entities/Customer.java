package com.iuh.se.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 11)
    private int id;
    @Column(name="first_name", length = 45)
    private String firstName;
    @Column(name="last_name", length = 45)
    private String lastName;
    @Column(name="email", length = 45)
    private String email;


}
