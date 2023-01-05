package dev.dcaraujo.tacocloudspring.util

import dev.dcaraujo.tacocloudspring.model.Ingredient
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class IngredientByIdConverter : Converter<String, Ingredient> {

    private val ingredients: Map<String, Ingredient> = Ingredient.all.associateBy { it.id }

    override fun convert(source: String): Ingredient? = ingredients[source]
}
