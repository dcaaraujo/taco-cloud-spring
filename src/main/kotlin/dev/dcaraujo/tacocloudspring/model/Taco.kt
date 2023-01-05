package dev.dcaraujo.tacocloudspring.model

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import java.util.*

@Entity
class Taco(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @field:Size(min = 5, message = "Name must be at least 5 characters")
    var name: String,

    @field:ManyToMany
    @field:Size(min = 1, message = "Choose at least 1 ingredient")
    var ingredients: MutableList<Ingredient> = mutableListOf(),

    val createdAt: Date = Date()
) {
    constructor() : this(0, "")
}
