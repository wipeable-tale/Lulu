package com.createpro.customerapp.repository.sql

import com.createpro.customerapp.domain.BaseconnectCustomer
import com.createpro.customerapp.repository.entity.BaseconnectCustomerEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.DriverManager

@Service
class BaseconnectCustomerRepository {
    @Autowired
    lateinit var dataSource: DataSource


    fun upsert(data: List<BaseconnectCustomer>) {
        val entities = data.map { it.toBaseconnectCustomerEntity() }

        try {
            DriverManager.getConnection(dataSource.url, dataSource.user, dataSource.pass).use { it ->
                for (entity in entities) {
                    it.prepareStatement(BaseconnectCustomerSQL.upsertSQL).let {

                        it.setString(1, entity.id)
                        it.setString(2, entity.companyName)
                        it.setString(3, entity.category)
                        it.setString(4, entity.establish)
                        it.setString(5, entity.foundation)
                        it.setString(6, entity.benefit)
                        it.setInt(7, entity.numberOfEmployee)
                        it.setString(8, entity.newHired)
                        it.setString(9, entity.officesNumber)
                        it.setString(10, entity.site)
                        it.setString(11, entity.address)
                        it.setTimestamp(12, entity.updateDate)

                        it.setString(13, entity.foundation)
                        it.setInt(14, entity.numberOfEmployee)
                        it.setTimestamp(15, entity.updateDate)

                        it.executeUpdate()
                    }
                }
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    private fun BaseconnectCustomer.toBaseconnectCustomerEntity(): BaseconnectCustomerEntity =
        BaseconnectCustomerEntity(
            id = id,
            companyName = companyName,
            category = category,
            establish = establish,
            foundation = foundation,
            benefit = benefit,
            numberOfEmployee = numberOfEmployee,
            newHired = newHired,
            officesNumber = officesNumber,
            site = site,
            address = address,
            updateDate = updateDate
        )
}
