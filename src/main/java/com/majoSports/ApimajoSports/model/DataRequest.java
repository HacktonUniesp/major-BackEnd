package com.majoSports.ApimajoSports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class DataRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String dateResponse;

    private LocalDateTime dataReiceved;
}
