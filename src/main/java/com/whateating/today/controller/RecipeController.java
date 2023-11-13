package com.whateating.today.controller;

import com.whateating.today.integration.dto.RecipeRequest;
import com.whateating.today.integration.dto.UserResponse;
import com.whateating.today.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeController {

    private static final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value= "/getAll", produces = "application/json")
    private ResponseEntity<List<UserResponse>> getAllRecipes() {
        LOG.info("Getting all recipes from database.");
        return recipeService.getAllRecipes();
    }

    @GetMapping(value= "/getAllUserRecipes/{userId}", produces = "application/json")
    private ResponseEntity<List<UserResponse>> getAlUserlRecipes(@PathVariable("userId") Long userId) {
        LOG.info("Getting all recipes from database.");
        return recipeService.getAllUserRecipes(userId);
    }

    @PostMapping(value= "/create/{userId}", consumes = "application/json", produces = "application/json")
    private ResponseEntity<String> createUserRecipes(
            @PathVariable("userId") Long userId,
            @RequestBody RecipeRequest recipe
    ) {
        LOG.info("Attempting to save user in database.");
        return recipeService.createUserRecipe(userId, recipe);
    }

    @GetMapping(value= "/findRecipe", produces = "application/json")
    private ResponseEntity<UserResponse> findRecipeByUser(
            @RequestParam("userId") Long userId,
            @RequestParam("recipeId") Long recipeId
    ) {
        return recipeService.findRecipeByUser(userId, recipeId);
    }

    @PutMapping(value= "/modifyRecipeUser", consumes = "application/json", produces = "application/json")
    private ResponseEntity<UserResponse> modifyUser(
            @RequestParam("userId") Long userId,
            @RequestParam("recipeId") Long recipeId,
            @RequestBody RecipeRequest recipe
    ) {
        return recipeService.modifyUserRecipe(userId, recipeId, recipe);
    }

    @DeleteMapping(value = "/deleteRecipe/{recipeId}", produces = "application/json")
    private ResponseEntity<String> deleteRecipe(@PathVariable("recipeId") Long recipeId){
        return recipeService.deleteRecipe(recipeId);
    }
}
