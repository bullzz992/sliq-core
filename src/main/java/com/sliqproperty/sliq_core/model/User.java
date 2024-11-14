package com.sliqproperty.sliq_core.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUser", nullable = false)
    private long idUser;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "MobileNUmber", nullable = false)
    private String mobileNumber;

    @Column(name = "IDNumber", nullable = true)
    private String idNUmber;

    @Column(name = "Passport", nullable = true)
    private String passport;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHas;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private Status_Enum status;

    // FKs

    @ManyToOne
    @JoinColumn(name = "idUserType", nullable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "idGender", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "idAddress", nullable = true)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "idTitle", nullable = false)
    private Title title;

    public enum Status_Enum {
        Active,
        NotVerified,
        Suspended
    }

}
