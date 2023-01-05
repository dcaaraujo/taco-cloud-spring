package dev.dcaraujo.tacocloudspring.model

import jakarta.persistence.*
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.CreditCardNumber
import java.util.*

@Entity
class TacoOrder(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @field:NotBlank(message = "Delivery name is required")
    var deliveryName: String,

    @field:NotBlank(message = "Street is required")
    var deliveryStreet: String,

    @field:NotBlank(message = "City is required")
    var deliveryCity: String,

    @field:NotBlank(message = "State is required")
    var deliveryState: String,

    @field:NotBlank(message = "Zip code is required")
    var deliveryZip: String,

    @field:CreditCardNumber(message = "Not a valid credit card number")
    var ccNumber: String,

    @field:Pattern(regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Must be formatted MM/YY")
    var ccExpiration: String,

    @field:Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    var ccCvv: String,

    @field:OneToMany(cascade = [CascadeType.ALL])
    val tacos: MutableList<Taco> = mutableListOf(),

    val placedAt: Date = Date()
) {
    constructor() : this(0, "", "", "", "", "", "", "", "")
}
