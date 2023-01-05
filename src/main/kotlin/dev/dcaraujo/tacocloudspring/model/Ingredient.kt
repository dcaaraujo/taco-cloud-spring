package dev.dcaraujo.tacocloudspring.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Ingredient(
    @field:Id
    val id: String,
    val name: String,
    val type: Type
) {
    enum class Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
