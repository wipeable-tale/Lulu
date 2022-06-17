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

    override fun upsertAll(customers: List<Customer>) {
        customers.map {
            toCustomerEntity(it)
        }.let {
            customerRepository.upsert(it)
        }
    }


    private fun toCustomer(customerEntity: CustomerEntity): Customer =
        Customer(
            customerEntity.companyCode,
            customerEntity.kanjiTradeName,
            customerEntity.kanaTradeNameForSearch,
            customerEntity.kanjiTradeNameForSearch,
            customerEntity.companyPhone,
            customerEntity.representativeNameInKanji,
            customerEntity.representativesKanaName,
            customerEntity.tdbIndustryClassificationNameMainBusiness,
            customerEntity.tdbIndustryClassificationNameEmployee,
            customerEntity.postalCodeNumber,
            customerEntity.companyAddressBarcodeNumber,
            customerEntity.imperialAddressCode,
            customerEntity.kanjiAddress,
            customerEntity.capitalThousandYen,
            customerEntity.numberOfEmployees,
            customerEntity.foundingYear,
            customerEntity.foundingMonth,
            customerEntity.yearEstablished,
            customerEntity.monthOfEstablishment,
            customerEntity.fiscalYear,
            customerEntity.closingMonth,
            customerEntity.netSalesMillionsOfYen,
            customerEntity.updateDate
        )

    fun toCustomerEntity(customer: Customer) =
        CustomerEntity(
            customer.companyCode,
            customer.kanjiTradeName,
            customer.kanaTradeNameForSearch,
            customer.kanjiTradeNamesForSearch,
            customer.companyPhone,
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
            customer.netSalesMillionsOfYen,
            customer.updateDate
        )

}