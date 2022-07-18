package com.createpro.customerapp.controller

import com.createpro.customerapp.usecase.CustomerUsecase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes


@Controller
class CustomerController {
    @Autowired
    lateinit var usecase: CustomerUsecase


    @GetMapping("/")
    fun index(model: Model): String {
        model["ResponseCustomersDto"] = usecase.getCustmers()
        return "index"
    }

    @PostMapping("/upload")
    fun uploadFiles(@RequestParam("upload_file") file: MultipartFile, redirectAttributes: RedirectAttributes): String {
        usecase.uploadFiles(file)
        return "index"
    }
}