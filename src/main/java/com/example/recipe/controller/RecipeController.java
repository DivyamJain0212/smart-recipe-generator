package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public List<Recipe> getRecipes(@RequestBody RecipeRequest request) {
        return recipeService.findMatchingRecipes(
            request.getAvailableIngredients(),
            request.getDietary(),
            request.getDifficulty(),
            request.getMaxCookingTime()
        );
    }

    @PostMapping("/{name}/rate")
    public void rateRecipe(@PathVariable String name, @RequestParam int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        recipeService.rateRecipe(name, rating);
    }

    @PostMapping("/{name}/favorite")
    public void toggleFavorite(@PathVariable String name) {
        recipeService.toggleFavorite(name);
    }

    @PostMapping("/detect")
    public List<String> detectIngredients(@RequestParam("image") String image) {
        // Stub: replace with Google Vision logic if desired
        return List.of("tomato", "onion", "garlic");
    }
}
