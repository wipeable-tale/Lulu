package com.createpro.customerapp.service

import com.createpro.customerapp.domain.WebSerchCustomer
import com.createpro.customerapp.repository.WebScraipingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WebScripingServiceImpl : WebScraipinService{

    @Autowired
    lateinit var WebScraipingRepository : WebScraipingRepository


    override fun fetcher(): List<WebSerchCustomer> {

        WebScraipingRepository.fetch()
        TODO()

    }
}