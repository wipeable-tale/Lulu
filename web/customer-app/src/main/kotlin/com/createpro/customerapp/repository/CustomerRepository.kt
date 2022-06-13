package com.createpro.customerapp.repository

import com.createpro.customerapp.repository.entity.CustomerEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.DriverManager

@Service
class CustomerRepository {
    @Autowired
    lateinit var dataSource: DataSource

    fun getCustomers(): List<CustomerEntity> {
        var customerEntities :List<CustomerEntity> = listOf()
        try {
            customerEntities =DriverManager.getConnection(dataSource.url, dataSource.user, dataSource.pass).use { it ->
                it.prepareStatement("select * from customer;")
                    .let { it.executeQuery() }
                    .let { generateSequence {
                        if(!it.next())null
                        else CustomerEntity(it.getString("company_code"))
                    }.toList() }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return  customerEntities;
    }


}