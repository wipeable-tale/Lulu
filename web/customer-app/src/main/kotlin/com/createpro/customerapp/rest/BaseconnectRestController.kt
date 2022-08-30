package com.createpro.customerapp.rest

import com.createpro.customerapp.usecase.BaseconnectCustomerUsecase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BaseconnectRestController {
    @Autowired
    lateinit var usecase: BaseconnectCustomerUsecase


    @GetMapping("/baseconnect")
    fun fetch(@RequestParam("page") page: String) {
        usecase.fetcher(page)
    }
}