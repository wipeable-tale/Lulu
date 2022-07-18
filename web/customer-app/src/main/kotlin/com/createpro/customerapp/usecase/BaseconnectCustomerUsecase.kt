package com.createpro.customerapp.usecase

import com.createpro.customerapp.service.BaseconnectCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BaseconnectCustomerUsecase {
    @Autowired
    lateinit var service: BaseconnectCustomerService

    fun fetcher() {
        val count = service.fetchCount()

        service.fetchDetail()
    }

}