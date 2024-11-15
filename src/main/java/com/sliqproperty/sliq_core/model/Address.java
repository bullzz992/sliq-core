package com.sliqproperty.sliq_core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Address\"")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdAddress\"", nullable = false)
    private long idAddress;

    @Column(name = "\"Line1\"", nullable = false)
    private String line1;

    @Column(name = "\"Line2\"", nullable = true)
    private String line2;

    @Column(name = "\"Suburb\"", nullable = false)
    private String suburb;

    @Column(name = "\"City\"", nullable = false)
    private String city;

    @Column(name = "\"Province\"", nullable = false)
    private String province;

    @Column(name = "\"Code\"", nullable = false)
    private String code;
}
