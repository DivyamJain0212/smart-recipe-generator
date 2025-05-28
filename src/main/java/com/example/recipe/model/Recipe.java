package com.example.recipe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Recipe {
    private String name;
    private List<String> ingredients;
    private List<String> steps;
    private int calories;
    private int protein;
    private String difficulty;
    private int cookingTime;
    private String dietary;

    // NEW: user feedback fields
    private double averageRating;
    private boolean favorite;
}
