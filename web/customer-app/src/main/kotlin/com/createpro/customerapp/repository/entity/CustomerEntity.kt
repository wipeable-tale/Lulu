package com.createpro.customerapp.repository.entity

import org.jetbrains.exposed.sql.Table

object CustomerEntity : Table() {
    val companyCode: String,
    val kanjiTradeName: String,
    val kanaTradeNameForSearch: String,
    val companyPhoneNumber: String,
    val representativeNameInKanji: String,
    val representativesKanaName: String,
    val tdbIndustryClassificationNameMainBusiness: String,
    val tdbIndustryClassificationNameEmployee: String,
    val postalCodeNumber: String,
    val companyAddressBarcodeNumber: String,
    val imperialAddressCode: String,
    val kanjiAddress: String,
    val capitalThousandYen: String,
    val numberOfEmployees: String,
    val foundingYear: String,
    val foundingMonth: String,
    val yearEstablished: String,
    val monthOfEstablishment: String,
    val fiscalYear: String,
    val closingMonth: String,
    val netSalesMillionsOfYen: String

}



