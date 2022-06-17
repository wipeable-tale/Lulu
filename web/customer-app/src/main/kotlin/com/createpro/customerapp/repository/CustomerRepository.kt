package com.createpro.customerapp.repository

import com.createpro.customerapp.model.CustomerEntityEnum
import com.createpro.customerapp.repository.entity.CustomerEntity
import com.createpro.customerapp.repository.sql.CustomerSQL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Timestamp

@Service
class CustomerRepository {
    @Autowired
    lateinit var dataSource: DataSource

    fun getCustomers(): List<CustomerEntity> {

        var customerEntities: List<CustomerEntity> = listOf()
        try {
            customerEntities = DriverManager.getConnection(dataSource.url, dataSource.user, dataSource.pass).use { it ->
                it.prepareStatement("select * from customer;")
                    .let { it.executeQuery() }
                    .let {
                        generateSequence {
                            if (!it.next()) null
                            else toCustomerEntity(it)
                        }.toList()
                    }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return customerEntities;
    }


    fun upsert(customerEntity: List<CustomerEntity>) {
        try {
            DriverManager.getConnection(dataSource.url, dataSource.user, dataSource.pass).use { it ->
                for (entity in customerEntity) {
                    it.prepareStatement(CustomerSQL.insertSQL).let {
                        it.setString(CustomerEntityEnum.COMPANY_CODE.index, entity.companyCode)
                        it.setString(CustomerEntityEnum.KANJI_TRADE_NAME.index, entity.kanjiTradeName)
                        it.setString(CustomerEntityEnum.SEARCH_KANA_TRADE_NAME.index, entity.kanaTradeNameForSearch)
                        it.setString(
                            CustomerEntityEnum.KANJI_TRADE_NAMES_FOR_SEARCH.index,
                            entity.kanjiTradeNameForSearch
                        )
                        it.setString(CustomerEntityEnum.COMPANY_PHONE.index, entity.companyPhone)
                        it.setString(CustomerEntityEnum.REPRESENTATIVE_NAME.index, entity.representativeNameInKanji)
                        it.setString(CustomerEntityEnum.REPRESENTATIVE_KANA_NAME.index, entity.representativesKanaName)
                        it.setString(
                            CustomerEntityEnum.TDB_INDUSTORY_CLASSIFICATION_NAME_PRINCIPAL_INDUSTRY.index,
                            entity.tdbIndustryClassificationNameMainBusiness
                        )
                        it.setString(
                            CustomerEntityEnum.TDB_INDUSTRY_CLASSIFICATION_NAME_EMPLOYEE.index,
                            entity.tdbIndustryClassificationNameEmployee
                        )
                        it.setString(CustomerEntityEnum.POSTAL_CODE_NUMBER.index, entity.postalCodeNumber)
                        it.setString(
                            CustomerEntityEnum.COMPANY_LOCATION_BARCODE_NUMBER.index,
                            entity.companyAddressBarcodeNumber
                        )
                        it.setString(CustomerEntityEnum.IMPERIAL_ADDRESS_CODE.index, entity.imperialAddressCode)
                        it.setString(CustomerEntityEnum.KANJI_ADDRESS.index, entity.kanjiAddress)
                        it.setBigDecimal(
                            CustomerEntityEnum.CAPITAL_THOUSAND_YEN.index,
                            BigDecimal(Integer.parseInt(entity.capitalThousandYen))
                        )
                        it.setBigDecimal(
                            CustomerEntityEnum.NUMBER_OF_EMPLOYEES.index,
                            BigDecimal(Integer.parseInt(entity.numberOfEmployees))
                        )
                        it.setString(CustomerEntityEnum.YEAR_OF_FOUNDATION.index, entity.foundingYear)
                        it.setString(CustomerEntityEnum.MONTH_OF_FOUNDATION.index, entity.foundingMonth)
                        it.setString(CustomerEntityEnum.YEAR_ESTABLISHED.index, entity.yearEstablished)
                        it.setString(CustomerEntityEnum.MONTH_OF_ESTABLISHMENT.index, entity.monthOfEstablishment)
                        it.setString(CustomerEntityEnum.FISCAL_YEAR.index, entity.fiscalYear)
                        it.setString(CustomerEntityEnum.FISCAL_MONTH.index, entity.closingMonth)
                        it.setBigDecimal(
                            CustomerEntityEnum.NET_SALES_MILLIONS_OF_YEN.index,
                            BigDecimal(Integer.parseInt(entity.netSalesMillionsOfYen))
                        )
                        it.setTimestamp(CustomerEntityEnum.UPDATE_DATE.index, Timestamp(System.currentTimeMillis()))
                        it.executeUpdate()
                    }
                }

            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }

    private fun toCustomerEntity(rs: ResultSet): CustomerEntity =
        CustomerEntity(
            rs.getString(CustomerEntityEnum.COMPANY_CODE.columName),
            rs.getString(CustomerEntityEnum.KANJI_TRADE_NAME.columName),
            rs.getString(CustomerEntityEnum.SEARCH_KANA_TRADE_NAME.columName),
            rs.getString(CustomerEntityEnum.KANJI_TRADE_NAMES_FOR_SEARCH.columName),
            rs.getString(CustomerEntityEnum.COMPANY_PHONE.columName),
            rs.getString(CustomerEntityEnum.REPRESENTATIVE_NAME.columName),
            rs.getString(CustomerEntityEnum.REPRESENTATIVE_KANA_NAME.columName),
            rs.getString(CustomerEntityEnum.TDB_INDUSTORY_CLASSIFICATION_NAME_PRINCIPAL_INDUSTRY.columName),
            rs.getString(CustomerEntityEnum.TDB_INDUSTRY_CLASSIFICATION_NAME_EMPLOYEE.columName),
            rs.getString(CustomerEntityEnum.POSTAL_CODE_NUMBER.columName),
            rs.getString(CustomerEntityEnum.COMPANY_LOCATION_BARCODE_NUMBER.columName),
            rs.getString(CustomerEntityEnum.IMPERIAL_ADDRESS_CODE.columName),
            rs.getString(CustomerEntityEnum.KANJI_ADDRESS.columName),
            rs.getString(CustomerEntityEnum.CAPITAL_THOUSAND_YEN.columName),
            rs.getString(CustomerEntityEnum.NUMBER_OF_EMPLOYEES.columName),
            rs.getString(CustomerEntityEnum.YEAR_OF_FOUNDATION.columName),
            rs.getString(CustomerEntityEnum.MONTH_OF_FOUNDATION.columName),
            rs.getString(CustomerEntityEnum.YEAR_ESTABLISHED.columName),
            rs.getString(CustomerEntityEnum.MONTH_OF_ESTABLISHMENT.columName),
            rs.getString(CustomerEntityEnum.FISCAL_YEAR.columName),
            rs.getString(CustomerEntityEnum.FISCAL_MONTH.columName),
            rs.getString(CustomerEntityEnum.NET_SALES_MILLIONS_OF_YEN.columName),
            rs.getString(CustomerEntityEnum.UPDATE_DATE.columName),
        )


}