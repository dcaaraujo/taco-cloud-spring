package dev.dcaraujo.tacocloudspring.controller

import dev.dcaraujo.tacocloudspring.model.TacoOrder
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.SessionStatus

@Controller
@RequestMapping("/order")
@SessionAttributes("tacoOrder")
class OrderController {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(OrderController::class.java)
    }

    @GetMapping
    fun index(): String {
        return "order"
    }

    @PostMapping
    fun process(@Valid order: TacoOrder, errors: Errors, session: SessionStatus): String {
        if (errors.hasErrors()) {
            return "order"
        }
        logger.info("Processing order {}", order)
        session.setComplete()
        return "redirect:/"
    }
}
