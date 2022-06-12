package com.createpro.customerapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerAppApplication

fun main(args: Array<String>) {
	runApplication<CustomerAppApplication>(*args)
}
