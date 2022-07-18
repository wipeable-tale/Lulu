package com.createpro.customerapp.service

import com.createpro.customerapp.domain.FumaCustomer

interface FumaCustomerService {
    
    fun fetchAllCount(): Int

    fun fetchData(page: String = ""): List<FumaCustomer>

    fun upsertAll(fumaCustomers: List<FumaCustomer>)
}