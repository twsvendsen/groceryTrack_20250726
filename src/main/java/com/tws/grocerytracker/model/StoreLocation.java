package com.tws.grocerytracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "store_location",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"store_name", "address"})
        }
    )
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "address")
    private String address;

    @Column(name = "number_of_visits")
    private Integer numberOfVisits;
}
