package com.jpa.sprinjparelation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false, unique = true)
    private String name;

    @Column(name = "last_name", columnDefinition = "VARCHAR(100)")
    private String lastName;

    private String nationality;
    private Integer age;
    private String position;

    @ManyToOne(targetEntity = Club.class)
    @JoinColumn(name = "id_club", nullable = false)
    private Club club;

}
