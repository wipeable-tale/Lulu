package com.createpro.customerapp.controller

import com.createpro.customerapp.usecase.FumaCustomerUsecase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FumaCustomerController {
    @Autowired
    lateinit var usecase: FumaCustomerUsecase

    @GetMapping("/fetch")
    fun fetchCustomers(): String {
        println("------fetcher------")
        usecase.fetchCustomers()
        return "index"
    }
}