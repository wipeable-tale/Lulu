package com.createpro.customerapp.domain

import java.sql.Timestamp
import java.util.regex.Pattern

data class BaseconnectCustomer(
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


fun convertNumberOfEmployee(value: String): Int {
    val reglex = Pattern.compile("[0-9０-９]+")
    val matcher = reglex.matcher(value)

    var result = "0"
    var index = 0;
    while (matcher.find()) {
        if (0 == index) result = matcher.group()
    }

    return Integer.parseInt(result)
}
