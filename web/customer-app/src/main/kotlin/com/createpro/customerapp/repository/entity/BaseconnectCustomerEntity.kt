package com.createpro.customerapp.repository.entity

import java.sql.Timestamp

data class BaseconnectCustomerEntity(
    val id: String,
    val companyName: String,
    val category: String,
    val establish: String,
    val foundation: String,
    val benefit: String,
    val numberOfEmployee: Int,
    val newHired: String,
    val officesNumber: String,
    val site: String,
    val address: String,
    val updateDate: Timestamp
)
