package com.example.recipe.service;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    private final Map<String, List<Integer>> ratings = new HashMap<>();
    private final Set<String> favorites = new HashSet<>();

    public List<Recipe> findMatchingRecipes(List<String> availableIngredients, String dietary, String difficulty, Integer maxCookingTime) {
        List<Recipe> allRecipes = recipeRepository.getAllRecipes();

        return allRecipes.stream()
            .filter(recipe -> dietary.equalsIgnoreCase("Any") || recipe.getDietary().equalsIgnoreCase(dietary))
            .filter(recipe -> difficulty.equalsIgnoreCase("Any") || recipe.getDifficulty().equalsIgnoreCase(difficulty))
            .filter(recipe -> maxCookingTime == null || recipe.getCookingTime() <= maxCookingTime)
            .filter(recipe -> availableIngredients.isEmpty() || hasMatchingIngredients(recipe, availableIngredients))
            .peek(recipe -> {
                // Inject feedback info
                List<Integer> recipeRatings = ratings.getOrDefault(recipe.getName(), List.of());
                recipe.setAverageRating(recipeRatings.isEmpty() ? 0 : recipeRatings.stream().mapToInt(i -> i).average().orElse(0));
                recipe.setFavorite(favorites.contains(recipe.getName()));
            })
            .collect(Collectors.toList());
    }

    private boolean hasMatchingIngredients(Recipe recipe, List<String> availableIngredients) {
        List<String> recipeIngredients = recipe.getIngredients().stream()
            .map(i -> i.toLowerCase(Locale.ROOT))
            .collect(Collectors.toList());

        return availableIngredients.stream()
            .map(i -> i.toLowerCase(Locale.ROOT))
            .anyMatch(recipeIngredients::contains);
    }

    public void rateRecipe(String recipeName, int rating) {
        ratings.computeIfAbsent(recipeName, k -> new ArrayList<>()).add(rating);
    }

    public void toggleFavorite(String recipeName) {
        if (favorites.contains(recipeName)) {
            favorites.remove(recipeName);
        } else {
            favorites.add(recipeName);
        }
    }
}
