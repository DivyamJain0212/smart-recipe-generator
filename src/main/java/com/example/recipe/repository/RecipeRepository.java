package com.example.recipe.repository;

import com.example.recipe.model.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Component
public class RecipeRepository {

    private List<Recipe> recipes;

    @PostConstruct
    public void init() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Recipe>> typeRef = new TypeReference<>() {};
            InputStream inputStream = getClass().getResourceAsStream("/recipes.json");
            if (inputStream == null) {
                throw new RuntimeException("recipes.json file not found in resources!");
            }
            this.recipes = mapper.readValue(inputStream, typeRef);
            System.out.println("✅ Loaded " + recipes.size() + " recipes into memory.");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load recipes.json", e);
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }
}
