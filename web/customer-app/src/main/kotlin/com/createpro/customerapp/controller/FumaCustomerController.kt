package com.createpro.customerapp.controller

import com.createpro.customerapp.usecase.FumaCustomerUsecase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FumaCustomerController {
    @Autowired
    lateinit var usecase: FumaCustomerUsecase

    @GetMapping("/fuma/fetch")
    fun fetch(): String {
        println("------fuma fetcher------")
        usecase.fetcher()
        return "index"
    }
}