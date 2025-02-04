package com.jpa.sprinjparelation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Club {

    @Id // aca le estoy asignando esta variable como pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La hago auto incremental
    private Long id;
    private String name;

    // aca estoy establenciendo las relaciones entre las entidades segun el modelo
    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST) // relacion uno a uno donde coah es fk
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club") // carga la lista cuando se pide
    private List<Player> players;

    @ManyToOne(targetEntity = FootballAssociation.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "club_competition", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition"))
    private List<FootballCompetition> footballCompetitions;

}
