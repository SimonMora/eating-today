package com.whateating.today.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "instructions")
    private String instructions;

    @ManyToOne(
            targetEntity = User.class,
            fetch = FetchType.LAZY,
            optional = false,
            cascade = CascadeType.REMOVE
    )
    @JsonIgnore
    private User user;

    @OneToMany(
            targetEntity = Ingredient.class,
            mappedBy = "recipe",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Ingredient> ingredients;


}
