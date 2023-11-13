package com.whateating.today.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecipeRequest {

    private String name;
    private List<String> ingredients;
    private String description;
    private String instructions;

}
