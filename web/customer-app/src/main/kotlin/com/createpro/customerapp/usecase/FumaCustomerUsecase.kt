package com.createpro.customerapp.usecase

import com.createpro.customerapp.service.FumaCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FumaCustomerUsecase {
    companion object {
        const val SLEEP_TIME: Long = 10000
        const val PAGE_COUNT = 50
    }

    @Autowired
    lateinit var service: FumaCustomerService


    fun fetcher() {
        val count = service.fetchAllCount()
        val pages = toQuery(count)

        for (page in pages) {
            println("**********fetcher(URL:${page})****************")
            Thread.sleep(SLEEP_TIME)
            service.fetchData(page).let {
                println("**********UPSERT****************")
                service.upsertAll(it)
            }
        }
    }

    private fun toQuery(count: Int): List<String> {
        val allPages = if (0 == count % PAGE_COUNT) count / PAGE_COUNT else count / PAGE_COUNT + 1

        val queries = arrayListOf<String>()
        (0..allPages).forEach {
            var query = ""
            /* for reccovery */
            if (121 <= it) query = "&num=${it * PAGE_COUNT}"
            /* original */
//            if (1 < it) query = "&num=${it * PAGE_COUNT}"

            if (!query.isEmpty()) queries.add(query)

        }
        return queries
    }
}