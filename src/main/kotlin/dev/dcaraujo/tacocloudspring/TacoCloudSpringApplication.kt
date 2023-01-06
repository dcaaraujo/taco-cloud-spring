package dev.dcaraujo.tacocloudspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TacoCloudSpringApplication

fun main(args: Array<String>) {
    runApplication<TacoCloudSpringApplication>(*args)
}
