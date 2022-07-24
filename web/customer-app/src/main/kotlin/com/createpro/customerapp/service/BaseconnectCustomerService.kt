package com.createpro.customerapp.service

import com.createpro.customerapp.domain.BaseconnectCustomer

interface BaseconnectCustomerService {
    fun fetchCount(): Int

    fun fetchDetail(page: String): List<BaseconnectCustomer>

    fun upsert(data: List<BaseconnectCustomer>)
}