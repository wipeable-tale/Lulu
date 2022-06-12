package com.createpro.customerapp.controller

import com.createpro.customerapp.usecase.CustomerUsecase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping


@Controller
class CustomerController {
    @Autowired
    lateinit var usecase: CustomerUsecase


    @GetMapping("/")
    fun index(model : Model) : String {
        model["ResponseCustomersDto"] = usecase.getCustmers()
        return "index"
    }
}