package com.createpro.customerapp.usecase

import com.createpro.customerapp.domain.Customer
import com.createpro.customerapp.model.CustomerDto
import com.createpro.customerapp.model.ResponseCustomersDto
import com.createpro.customerapp.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerUsecase {
    @Autowired
    lateinit var customerService: CustomerService


    fun getCustmers(): ResponseCustomersDto = ResponseCustomersDto(customerService.getCustomers().map {
        toCostomerDto(it)
    });


    private fun toCostomerDto(customer: Customer) : CustomerDto =
        CustomerDto(
            customer.companyCode,
            customer.kanjiTradeName,
            customer.kanaTradeNameForSearch,
            customer.companyPhoneNumber,
            customer.representativeNameInKanji,
            customer.representativesKanaName,
            customer.tdbIndustryClassificationNameMainBusiness,
            customer.tdbIndustryClassificationNameEmployee,
            customer.postalCodeNumber,
            customer.companyAddressBarcodeNumber,
            customer.imperialAddressCode,
            customer.kanjiAddress,
            customer.capitalThousandYen,
            customer.numberOfEmployees,
            customer.foundingYear,
            customer.foundingMonth,
            customer.yearEstablished,
            customer.monthOfEstablishment,
            customer.fiscalYear,
            customer.closingMonth,
            customer.netSalesMillionsOfYen
        )

}