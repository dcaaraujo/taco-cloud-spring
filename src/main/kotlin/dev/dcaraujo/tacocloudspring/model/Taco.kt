package dev.dcaraujo.tacocloudspring.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class Taco(
    @field:NotNull
    @field:Size(min = 5, message = "Name must be at least 5 characters")
    var name: String?,

    @field:NotNull
    @field:Size(min = 1, message = "Choose at least 1 ingredient")
    var ingredients: MutableList<Ingredient>
)
