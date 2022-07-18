package com.createpro.customerapp.repository.sql

import com.createpro.customerapp.domain.FumaCustomer
import com.createpro.customerapp.repository.entity.FumaCustomerEntiry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.DriverManager
import java.sql.Timestamp

@Service
class FumaCustomerRepository {
    @Autowired
    lateinit var dataSource: DataSource

    fun upsertAll(customers: List<FumaCustomer>) {
        val entities = customers.map { it.toFumaCustomerEntity() }

        try {
            DriverManager.getConnection(dataSource.url, dataSource.user, dataSource.pass).use { it ->
                for (entity in entities) {
                    it.prepareStatement(FumaCustomerSQL.upsertSQL).let {
                        it.setString(1, entity.id)
                        it.setString(2, entity.companyName)
                        it.setString(3, entity.mainIndustry)
                        it.setString(4, entity.subIndustry)
                        it.setString(5, entity.address)
                        it.setString(6, entity.representative)
                        it.setBigDecimal(7, entity.foundation)
                        it.setInt(8, entity.numberOfEmployee)
                        it.setTimestamp(9, entity.updateDate)

                        it.setBigDecimal(10, entity.foundation)
                        it.setInt(11, entity.numberOfEmployee)
                        it.setTimestamp(12, entity.updateDate)

                        it.executeUpdate()
                    }
                }
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }


    private fun FumaCustomer.toFumaCustomerEntity(): FumaCustomerEntiry =
        FumaCustomerEntiry(
            id = id,
            companyName = companyName,
            mainIndustry = mainIndustry,
            subIndustry = subIndustry,
            address = address,
            representative = representative,
            foundation = foudation,
            numberOfEmployee = numberOfEmployee,
            updateDate = Timestamp(System.currentTimeMillis())
        )
}