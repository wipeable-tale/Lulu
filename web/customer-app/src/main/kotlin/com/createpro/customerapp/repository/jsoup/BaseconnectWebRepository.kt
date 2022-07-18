package com.createpro.customerapp.repository.jsoup

import com.createpro.customerapp.model.BASECONNECT
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

@Service
class BaseconnectWebRepository {


    fun fetchCount(): Int {
        val doc = Jsoup.connect(BASECONNECT.URL.value).get()
        val countInfo = doc.getElementsByClass(BASECONNECT.COUNTS.value)?.text()
        val count = countInfo.replace()

        val details = doc.getDetails()
        return Integer.parseInt(count)
    }

    fun fetchCompanyDetail(): Unit {
        val doc = Jsoup.connect(BASECONNECT.URL.value).get()
        val companyElements = doc.getElementsByClass("searches__result__list")
        for (element in companyElements) {
            println("---------")
            val detailUri =
                element.getElementsByClass("searches__result__list__header__title").first()?.getElementsByTag("a")
                    ?.first()?.attr("href").orEmpty()
            val companyName =
                element.getElementsByClass("searches__result__list__header__title").first()?.getElementsByTag("a")
                    ?.first()?.text()
            val category =
                element.getElementsByClass("searches__tag searches__tag--listed")?.first()?.getElementsByTag("a")
                    ?.text()

            println(companyName)
            println(detailUri)
            println(category)
        }


    }

    private fun String.replace(): String {
        val targets = split("　")

        var value = "0"
        for (target in targets) {
            if (target.contains("検索結果")) value = target.replace("検索結果 ", "").replace("件中", "")
        }

        return value
    }

    private fun Document.getDetails(): List<String> {
        val elements = getElementsByClass("searches__result__list__header__title")

        var data = arrayListOf<String>()
        for (element in elements) {
            val url = element.getElementsByTag("a").first()?.attr("href").orEmpty()
            data.add(url)
        }
        return data
    }

}