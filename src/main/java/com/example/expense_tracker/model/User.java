package com.example.expense_tracker.model;

import com.example.expense_tracker.model.enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Username;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Phone;

    @Column(nullable = false)
    private String Address;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime CreatedDate;

}
