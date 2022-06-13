package com.createpro.customerapp.service

import com.createpro.customerapp.domain.Customer
import com.createpro.customerapp.repository.CustomerRepository
import com.createpro.customerapp.repository.entity.CustomerEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomers(): List<Customer> = customerRepository.getCustomers().map {
        toCustomer(it)
    };


    private fun toCustomer(customerEntity: CustomerEntity): Customer =
        Customer(
            customerEntity.companyCode
//            customerEntity.kanjiTradeName,
//            customerEntity.kanaTradeNameForSearch,
//            customerEntity.companyPhoneNumber,
//            customerEntity.representativeNameInKanji,
//            customerEntity.representativesKanaName,
//            customerEntity.tdbIndustryClassificationNameMainBusiness,
//            customerEntity.tdbIndustryClassificationNameEmployee,
//            customerEntity.postalCodeNumber,
//            customerEntity.companyAddressBarcodeNumber,
//            customerEntity.imperialAddressCode,
//            customerEntity.kanjiAddress,
//            customerEntity.capitalThousandYen,
//            customerEntity.numberOfEmployees,
//            customerEntity.foundingYear,
//            customerEntity.foundingMonth,
//            customerEntity.yearEstablished,
//            customerEntity.monthOfEstablishment,
//            customerEntity.fiscalYear,
//            customerEntity.closingMonth,
//            customerEntity.netSalesMillionsOfYen
        )

}