package dev.dcaraujo.tacocloudspring.controller

import dev.dcaraujo.tacocloudspring.model.Ingredient
import dev.dcaraujo.tacocloudspring.model.Taco
import dev.dcaraujo.tacocloudspring.model.TacoOrder
import dev.dcaraujo.tacocloudspring.repository.IngredientRepository
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
class DesignController(private val ingredientRepository: IngredientRepository) {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(DesignController::class.java)
    }

    @GetMapping
    fun index() = "design"

    @PostMapping
    fun addTacoToOrder(@Valid taco: Taco, errors: Errors, @ModelAttribute order: TacoOrder): String {
        if (errors.hasErrors()) {
            return "design"
        }
        order.tacos.add(taco)
        logger.info("Processing taco: {}", taco)
        return "redirect:/order"
    }

    @ModelAttribute(name = "taco")
    private fun addNewTacoToModel() = Taco()

    @ModelAttribute(name = "tacoOrder")
    private fun addNewOrderToModel() = TacoOrder()

    @ModelAttribute
    private fun addIngredientsToModel(model: Model) {
        val ingredients = ingredientRepository.findAll()
        Ingredient.Type.values().forEach { type ->
            val name = type.name.lowercase()
            val ingredient = ingredients.filter { it.type == type }
            model.addAttribute(name, ingredient)
        }
    }
}
