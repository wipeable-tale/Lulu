package com.createpro.customerapp.usecase

import com.createpro.customerapp.service.FumaCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FumaCustomerUsecase {
    @Autowired
    lateinit var fumaCustomerService: FumaCustomerService


    fun fetchCustomers() {
        val count = fumaCustomerService.fetchAllCount()
        val pages = toQuery(count)

        for (page in pages) {
            Thread.sleep(3000)
            fumaCustomerService.fetchData(page).let {
                println("**********UPSERT****************")
                fumaCustomerService.upsertAll(it)
            }
        }

//        /* 1件のみテスト */
//        fumaCustomerService.fetchData("").let {
//            println("**********UPSERT****************")
//            fumaCustomerService.upsertAll(it)
//        }
    }

    private fun toQuery(count: Int): List<String> {
        val allPages = if (0 == count % 50) count / 50 else count / 50 + 1

        val queries = arrayListOf<String>()
        (0..allPages).forEach {
            var query = ""
            if (0 == it) else query = "&num=${it * 50}"
            queries.add(query)
        }
        return queries
    }
}