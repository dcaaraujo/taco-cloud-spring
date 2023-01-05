package dev.dcaraujo.tacocloudspring.model

data class Ingredient(
    val id: String,
    val name: String,
    val type: Type
) {
    enum class Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    companion object {
        val all = listOf(
            Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            Ingredient("CARN", "Carnitas", Type.PROTEIN),
            Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            Ingredient("LETC", "Lettuce", Type.VEGGIES),
            Ingredient("CHED", "Cheddar", Type.CHEESE),
            Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
            Ingredient("SLSA", "Salsa", Type.SAUCE),
            Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        )
    }
}
