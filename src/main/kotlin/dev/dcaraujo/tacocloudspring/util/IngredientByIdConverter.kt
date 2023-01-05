package dev.dcaraujo.tacocloudspring.util

import dev.dcaraujo.tacocloudspring.model.Ingredient
import dev.dcaraujo.tacocloudspring.repository.IngredientRepository
import org.springframework.core.convert.converter.Converter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class IngredientByIdConverter(private val repo: IngredientRepository) : Converter<String, Ingredient> {

    override fun convert(source: String): Ingredient? = repo.findByIdOrNull(source)
}
