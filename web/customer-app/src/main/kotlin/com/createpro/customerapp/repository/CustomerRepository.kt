package com.createpro.customerapp.repository

import com.createpro.customerapp.repository.entity.CustomerEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerRepository {
    @Autowired
    lateinit var dataSource: DataSource

    init {
        Database.connect(dataSource.url,dataSource.driver,dataSource.user,dataSource.pass)
    }
    fun getCustomers() : List<CustomerEntity> {
        transaction {

        }
    }


}