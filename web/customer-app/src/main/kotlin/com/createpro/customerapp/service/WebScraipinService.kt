package com.createpro.customerapp.service

import com.createpro.customerapp.domain.WebSerchCustomer

interface WebScraipinService {

    fun fetcher(): List<WebSerchCustomer>
}