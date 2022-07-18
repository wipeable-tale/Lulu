package com.createpro.customerapp.domain

import java.math.BigDecimal

data class FumaCustomer(
    val id: String,
    val companyName: String = "",
    val mainIndustry: String = "",
    val subIndustry: String = "",
    val address: String = "",
    val representative: String = "",
    val foudation: BigDecimal = BigDecimal(0),
    val numberOfEmployee: Int = 0
)


fun String.toDecimal(): BigDecimal {
    val toNumber = replace("百万円", "0000000")
    val tweak = toNumber.replace(",", "")

    if (tweak.isBlank()) return BigDecimal(0)
    return BigDecimal(tweak)
}

fun String.toNumber(): Int {
    val replaced = replace("人", "")
    val tweak = replaced.replace(",", "")

    if (tweak.isBlank()) return 0
    return Integer.parseInt(tweak)
}

