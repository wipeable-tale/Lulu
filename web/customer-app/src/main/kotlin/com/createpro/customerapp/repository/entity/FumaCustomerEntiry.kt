package com.createpro.customerapp.repository.entity

import java.math.BigDecimal
import java.sql.Timestamp

data class FumaCustomerEntiry(
    val id: String,
    val companyName: String,
    val mainIndustry: String,
    val subIndustry: String,
    val address: String,
    val representative: String,
    val foundation: BigDecimal,
    val numberOfEmployee: Int,
    val updateDate: Timestamp
) {
}