package com.tws.grocerytracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "commodity",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"itemName", "brand"})
        })
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemCategory")
    private ItemCategory itemCategory;

    @Column(name = "brand")
    private String brand;

    @Column(name = "timesPurchased")
    private Integer timesPurchased;

    @Column(name = "timeOfLatestPurchase")
    private OffsetDateTime timeOfLatestPurchase;
}
