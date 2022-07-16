package com.createpro.customerapp.service.web

import com.createpro.customerapp.repository.jsoup.WebScraipingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WebScripingServiceImpl : WebScraipinService {

    @Autowired
    lateinit var WebScraipingRepository: WebScraipingRepository


    override fun fetcher(): Unit {

        WebScraipingRepository.fetch()

    }
}