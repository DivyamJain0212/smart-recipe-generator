package com.example.recipe.controller;

import lombok.Data;
import java.util.List;

@Data
public class RecipeRequest {
    private List<String> availableIngredients;
    private String dietary;
    private String difficulty;
    private Integer maxCookingTime;
}
