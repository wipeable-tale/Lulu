package com.createpro.customerapp.controller

import com.createpro.customerapp.usecase.BaseconnectCustomerUsecase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BaseconnectCustomerController {
    @Autowired
    lateinit var usecase: BaseconnectCustomerUsecase

    @GetMapping("/baseconnect/fetch")
    fun fetch(): String {
        println("------baseconnect fetcher------")
        usecase.fetcher()

        return "index"

    }
}