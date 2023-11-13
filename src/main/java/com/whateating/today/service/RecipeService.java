package com.whateating.today.service;

import com.whateating.today.integration.dto.RecipeRequest;
import com.whateating.today.integration.dto.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecipeService {
    ResponseEntity<List<UserResponse>> getAllRecipes();

    ResponseEntity<List<UserResponse>> getAllUserRecipes(Long userId);

    ResponseEntity<String> createUserRecipe(Long userId, RecipeRequest recipe);

    ResponseEntity<UserResponse> findRecipeByUser(Long userId, Long recipeId);

    ResponseEntity<UserResponse> modifyUserRecipe(Long userId, Long recipeId, RecipeRequest recipe);

    ResponseEntity<String> deleteRecipe(Long recipeId);
}
