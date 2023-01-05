package dev.dcaraujo.tacocloudspring.repository

import dev.dcaraujo.tacocloudspring.model.TacoOrder
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<TacoOrder, Long> {
    fun findByDeliveryZip(deliveryZip: String): List<TacoOrder>
}
