package dev.dcaraujo.tacocloudspring.repository

import dev.dcaraujo.tacocloudspring.model.Ingredient
import org.springframework.data.repository.CrudRepository

interface IngredientRepository : CrudRepository<Ingredient, String>
