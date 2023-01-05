package dev.dcaraujo.tacocloudspring.util

import dev.dcaraujo.tacocloudspring.model.Ingredient
import dev.dcaraujo.tacocloudspring.repository.IngredientRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DatabaseSeedRunner(private val ingredientRepository: IngredientRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val ingredients = listOf(
            Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
            Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
            Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
            Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
            Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
            Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
            Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
            Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
            Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
            Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        )
        ingredients.forEach { ingredientRepository.save(it) }
    }
}