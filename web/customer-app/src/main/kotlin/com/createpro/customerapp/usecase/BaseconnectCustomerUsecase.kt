package com.createpro.customerapp.usecase

import com.createpro.customerapp.service.BaseconnectCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BaseconnectCustomerUsecase {
    companion object {
        const val MAX_PAGE_COUNT = 200
        const val PAGE_COUNT = 50
    }

    @Autowired
    lateinit var service: BaseconnectCustomerService

    fun fetcher() {
        val count = service.fetchCount()

        val pages = toUri(count)

        for (page in pages) {
            println("*******${page}の処理***********")
            val data = service.fetchDetail(page)
            println("*******upsert***********")
            service.upsert(data)

        }

    }

    private fun toUri(count: Int): List<String> {
        var allpage = if (0 == count % PAGE_COUNT) count / PAGE_COUNT else (count / PAGE_COUNT) + 1

        var result = arrayListOf<String>()
        (0..allpage).forEach {
            var query = ""
            if (0 < it) query = "?page=${it}"

            if (it in 0..MAX_PAGE_COUNT) result.add(query)
        }
        return result
    }

}