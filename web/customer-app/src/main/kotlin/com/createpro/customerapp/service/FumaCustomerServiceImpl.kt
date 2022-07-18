package com.createpro.customerapp.service

import com.createpro.customerapp.domain.FumaCustomer
import com.createpro.customerapp.domain.toDecimal
import com.createpro.customerapp.domain.toNumber
import com.createpro.customerapp.model.FumaSource
import com.createpro.customerapp.repository.jsoup.FumaWebRepository
import com.createpro.customerapp.repository.sql.FumaCustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FumaCustomerServiceImpl : FumaCustomerService {

    @Autowired
    lateinit var fumaWebRepository: FumaWebRepository

    @Autowired
    lateinit var fumaCustomerRepository: FumaCustomerRepository

    override fun fetchAllCount(): Int = fumaWebRepository.fetchAllCount()

    override fun fetchData(page: String): List<FumaCustomer> {
        val data = fumaWebRepository.fetch(page)

        return data.map { it.toFumaCustomer() }
    }

    override fun upsertAll(fumaCustomers: List<FumaCustomer>) =
        fumaCustomerRepository.upsertAll(fumaCustomers)

    private fun FumaSource.toFumaCustomer(): FumaCustomer = FumaCustomer(
        id = UUID.randomUUID().toString(),
        companyName = companyName,
        mainIndustry = mainIndustry,
        subIndustry = subIndustry,
        address = address,
        representative = representative,
        foudation = foundation.toDecimal(),
        numberOfEmployee = numberOfEmployee.toNumber()
    )
}