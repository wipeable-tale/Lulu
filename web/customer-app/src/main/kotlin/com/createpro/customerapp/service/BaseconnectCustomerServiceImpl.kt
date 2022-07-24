package com.createpro.customerapp.service

import com.createpro.customerapp.domain.BaseconnectCustomer
import com.createpro.customerapp.domain.convertNumberOfEmployee
import com.createpro.customerapp.model.BaseconnectSource
import com.createpro.customerapp.repository.jsoup.BaseconnectWebRepository
import com.createpro.customerapp.repository.sql.BaseconnectCustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class BaseconnectCustomerServiceImpl : BaseconnectCustomerService {
    @Autowired
    lateinit var webRepository: BaseconnectWebRepository

    @Autowired
    lateinit var baseconnectRepository: BaseconnectCustomerRepository

    override fun fetchCount(): Int = webRepository.fetchCount()

    override fun fetchDetail(page: String): List<BaseconnectCustomer> {
        val data = webRepository.fetchCompanyDetail(page)

        return data.map { it.toBaseconnectCustomer() }
    }

    override fun upsert(data: List<BaseconnectCustomer>) = baseconnectRepository.upsert(data)

    private fun BaseconnectSource.toBaseconnectCustomer(): BaseconnectCustomer =
        BaseconnectCustomer(
            id = UUID.randomUUID().toString(),
            companyName = companyName,
            category = category,
            establish = establish,
            foundation = foundation,
            benefit = benefit,
            numberOfEmployee = convertNumberOfEmployee(numberOfEmployee),
            newHired = newHired,
            officesNumber = officesNumber,
            site = site,
            address = address,
            updateDate = Timestamp(System.currentTimeMillis())
        )

}