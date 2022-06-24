package com.createpro.customerapp.usecase

import com.createpro.customerapp.domain.Customer
import com.createpro.customerapp.model.CustomerDto
import com.createpro.customerapp.model.ResponseCustomersDto
import com.createpro.customerapp.model.CustomerSourceEnum
import com.createpro.customerapp.model.getSource
import com.createpro.customerapp.service.CustomerService
import com.createpro.customerapp.service.FileImporterService
import com.createpro.customerapp.service.WebScraipinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class CustomerUsecase {
    @Autowired
    lateinit var customerService: CustomerService

    @Autowired
    lateinit var fileImporterService: FileImporterService

    @Autowired
    lateinit var webScripingService: WebScraipinService


    fun getCustmers(): ResponseCustomersDto = ResponseCustomersDto(customerService.getCustomers().map {
        toCostomerDto(it)
    });

    fun uploadFiles(multipartFile: MultipartFile) {
        fileImporterService.fetcherXLSX(multipartFile).map {
            toCustomer(it)
        }.toList().let {
            customerService.upsertAll(it)
        }
    }

    fun fetchCustomers() {
        val webSearchCustomers = webScripingService.fetcher()
    }


    private fun toCostomerDto(customer: Customer): CustomerDto =
        CustomerDto(
            customer.companyCode,
            customer.kanjiTradeName,
            customer.kanaTradeNameForSearch,
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
            customer.netSalesMillionsOfYen
        )

    private fun toCustomer(customer: HashMap<String, String>): Customer {
        return Customer(
            customer[getSource(CustomerSourceEnum.COMPANY_CODE.pos)]!!,
            customer[getSource(CustomerSourceEnum.KANJI_TRADE_NAME.pos)]!!,
            customer[getSource(CustomerSourceEnum.SEARCH_KANA_TRADE_NAME.pos)]!!,
            customer[getSource(CustomerSourceEnum.KANJI_TRADE_NAMES_FOR_SEARCH.pos)]!!,
            customer[getSource(CustomerSourceEnum.COMPANY_PHONE.pos)]!!,
            customer[getSource(CustomerSourceEnum.REPRESENTATIVE_NAME.pos)]!!,
            customer[getSource(CustomerSourceEnum.REPRESENTATIVE_KANA_NAME.pos)]!!,
            customer[getSource(CustomerSourceEnum.TDB_INDUSTORY_CLASSIFICATION_NAME_PRINCIPAL_INDUSTRY.pos)]!!,
            customer[getSource(CustomerSourceEnum.TDB_INDUSTRY_CLASSIFICATION_NAME_EMPLOYEE.pos)]!!,
            customer[getSource(CustomerSourceEnum.POSTAL_CODE_NUMBER.pos)]!!,
            customer[getSource(CustomerSourceEnum.COMPANY_LOCATION_BARCODE_NUMBER.pos)]!!,
            customer[getSource(CustomerSourceEnum.IMPERIAL_ADDRESS_CODE.pos)]!!,
            customer[getSource(CustomerSourceEnum.KANJI_ADDRESS.pos)]!!,
            customer[getSource(CustomerSourceEnum.CAPITAL_THOUSAND_YEN.pos)]!!,
            customer[getSource(CustomerSourceEnum.NUMBER_OF_EMPLOYEES.pos)]!!,
            customer[getSource(CustomerSourceEnum.YEAR_OF_FOUNDATION.pos)]!!,
            customer[getSource(CustomerSourceEnum.MONTH_OF_FOUNDATION.pos)]!!,
            customer[getSource(CustomerSourceEnum.YEAR_ESTABLISHED.pos)]!!,
            customer[getSource(CustomerSourceEnum.MONTH_OF_ESTABLISHMENT.pos)]!!,
            customer[getSource(CustomerSourceEnum.FISCAL_YEAR.pos)]!!,
            customer[getSource(CustomerSourceEnum.FISCAL_MONTH.pos)]!!,
            customer[getSource(CustomerSourceEnum.NET_SALES_MILLIONS_OF_YEN.pos)]!!,
            /* 暫定でデータを取得（システム日付を設定する） */
            System.currentTimeMillis().toString()
        )
    }

}