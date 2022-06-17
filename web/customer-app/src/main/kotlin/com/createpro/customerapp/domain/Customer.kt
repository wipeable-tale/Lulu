package com.createpro.customerapp.domain


data class Customer(
    val companyCode: String,
    val kanjiTradeName: String,
    val kanaTradeNameForSearch: String,
    val kanjiTradeNamesForSearch: String,
    val companyPhone: String,
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
    val netSalesMillionsOfYen: String,
    val updateDate: String
)
