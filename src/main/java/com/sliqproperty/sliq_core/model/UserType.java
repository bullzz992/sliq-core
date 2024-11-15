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
@Table(name = "\"UserType\"")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IdUserType\"", nullable = false)
    private long idUserType;

    @Column(name = "\"Name\"", nullable = false)
    private String name;

    @Column(name = "\"Description\"", nullable = false)
    private String Description;

}
