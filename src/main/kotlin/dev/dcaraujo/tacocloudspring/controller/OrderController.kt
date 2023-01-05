package dev.dcaraujo.tacocloudspring.controller

import dev.dcaraujo.tacocloudspring.model.TacoOrder
import dev.dcaraujo.tacocloudspring.repository.OrderRepository
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.SessionStatus

@Controller
@RequestMapping("/order")
@SessionAttributes("tacoOrder")
class OrderController(private val orderRepository: OrderRepository) {

    @GetMapping
    fun index(): String {
        return "order"
    }

    @PostMapping
    fun process(@Valid order: TacoOrder, errors: Errors, session: SessionStatus): String {
        if (errors.hasErrors()) {
            return "order"
        }
        orderRepository.save(order)
        session.setComplete()
        return "redirect:/"
    }
}
