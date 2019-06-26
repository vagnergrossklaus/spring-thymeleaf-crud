package dev.vagnergrossklaus.springthymeleafcrud.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;

    @Column
    private String dsVehicle;

}
