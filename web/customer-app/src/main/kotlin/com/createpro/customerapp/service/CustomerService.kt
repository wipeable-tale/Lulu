package com.createpro.customerapp.service

import com.createpro.customerapp.domain.Customer

interface CustomerService {

    fun getCustomers(): List<Customer>

    fun upsertAll(customers: List<Customer>)

}