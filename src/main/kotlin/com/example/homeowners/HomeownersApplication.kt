package com.example.homeowners

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeownersApplication

fun main(args: Array<String>) {
    runApplication<HomeownersApplication>(*args)
}
