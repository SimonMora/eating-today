package com.whateating.today.service.impl;

import com.whateating.today.integration.dto.RecipeRequest;
import com.whateating.today.integration.dto.UserResponse;
import com.whateating.today.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Override
    public ResponseEntity<List<UserResponse>> getAllRecipes() {
        return null;
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAllUserRecipes(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<String> createUserRecipe(Long userId, RecipeRequest recipe) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> findRecipeByUser(Long userId, Long recipeId) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> modifyUserRecipe(Long userId, Long recipeId, RecipeRequest recipe) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteRecipe(Long recipeId) {
        return null;
    }
}
