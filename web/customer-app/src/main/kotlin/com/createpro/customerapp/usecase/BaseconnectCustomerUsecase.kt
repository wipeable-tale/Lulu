package com.createpro.customerapp.usecase

import com.createpro.customerapp.service.BaseconnectCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BaseconnectCustomerUsecase {
    companion object {
        const val MAX_PAGE_COUNT = 200
        const val PAGE_COUNT = 50
        const val SLEEP_TIME: Long = 20000
    }

    @Autowired
    lateinit var service: BaseconnectCustomerService

    fun fetcher() {
        val count = service.fetchCount()

        val pages = toUri(count)

        for (page in pages) {
            println("*******${page}の処理***********")
            Thread.sleep(SLEEP_TIME)
            val data = service.fetchDetail(page)
            service.upsert(data)

        }
    }

    fun fetcher(query: String) {
        val queryInt = Integer.parseInt(query).toPage()

        val data = service.fetchDetail(queryInt)
        service.upsert(data)
    }

    private fun toUri(count: Int): List<String> {
        var allpage = if (0 == count % PAGE_COUNT) count / PAGE_COUNT else (count / PAGE_COUNT) + 1

        var result = arrayListOf<String>()
        (0..allpage).forEach {
            var query = ""
            if (0 < it) query = "?page=${it}"

            if (it in 50..MAX_PAGE_COUNT) result.add(query)
        }
        return result
    }

    private fun Int.toPage() = "?page=${this}"
}