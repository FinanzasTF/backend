package com.back.finanzas_back.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "password", length = 300, nullable = false)
    private String password;

    @Size(min = 9, max = 9)
    @NotNull
    @Column(name = "phone_number", length = 9, nullable = false)
    private String phoneNumber;
}