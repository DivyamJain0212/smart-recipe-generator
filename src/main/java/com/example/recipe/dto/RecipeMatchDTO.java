package com.example.recipe.model;

public class RecipeMatchDTO {
    private Recipe recipe;
    private double score;

    public RecipeMatchDTO(Recipe recipe, double score) {
        this.recipe = recipe;
        this.score = score;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
