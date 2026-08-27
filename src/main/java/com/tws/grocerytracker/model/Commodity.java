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
                @UniqueConstraint(columnNames = {"name", "brand"})
        })
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private ItemCategory category;

    @Column(name = "brand")
    private String brand;

    @Column(name = "times_purchased")
    private Integer timesPurchased;

    @Column(name = "latest_purchase_datetime")
    private OffsetDateTime latestPurchaseDateTime;
}
