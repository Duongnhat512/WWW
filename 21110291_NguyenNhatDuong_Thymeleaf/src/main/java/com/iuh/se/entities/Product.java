package com.iuh.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Pattern(regexp = "Pro[0-9]{3}-(0[1-9]|1[0-2])]", message = "Product code must be in format ProXXX-YY")
    private String code;
    @Column(columnDefinition = "nvarchar(255)")
    @Size(max = 20, message = "Product name must be less than 20 characters")
    @Pattern(regexp = "[A-Za-z ]+", message = "Product name must contain only letters and spaces")
    private String name;
    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "Product description must not be empty")
    private String description;
    @Column(name = "register_date")
    @Past(message = "Register date must be in the past")
    private LocalDate registerDate;
    @Min(value = 1, message = "Price must be greater than or equal to 1")
    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Category cart;
}
