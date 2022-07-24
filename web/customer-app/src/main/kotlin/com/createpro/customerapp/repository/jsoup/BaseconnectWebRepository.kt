package com.createpro.customerapp.repository.jsoup

import com.createpro.customerapp.model.BASECONNECT
import com.createpro.customerapp.model.BaseconnectSource
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.stereotype.Service


@Service
class BaseconnectWebRepository {


    fun fetchCount(): Int {
        val doc = Jsoup.connect(BASECONNECT.URL.value).get()
        val countInfo = doc.getElementsByClass(BASECONNECT.COUNTS.value)?.text()
        val count = countInfo.replace()

        return Integer.parseInt(count)
    }

    fun fetchCompanyDetail(page: String): List<BaseconnectSource> {
        val doc = Jsoup.connect("${BASECONNECT.URL.value}${page}").get()
        println("***********${BASECONNECT.URL.value}${page}*******************")
        val companyElements = doc.getElementsByClass("searches__result__list")

        var sources = arrayListOf<BaseconnectSource>()
        for (element in companyElements) {
            val category =
                element.getElementsByClass("searches__tag searches__tag--listed")!!.first()!!.getElementsByTag("a")
                    .text()
            val detailUri =
                element.getElementsByClass("searches__result__list__header__title").first()?.getElementsByTag("a")
                    ?.first()?.attr("href").orEmpty()
            val detailDoc = Jsoup.connect("${BASECONNECT.DETAIL_URL.value}${detailUri}").get()

            val companyName = detailDoc.getElementsByClass("node__header__text__title").text()
            val companyBaseInfo =
                detailDoc.getElementsByClass("nodeTable--simple nodeTable--simple__twoColumn nodeTable--simple__twoColumn_side")
                    .first()!!
                    .getElementsByTag("dl")
            val establish = fetchItem(companyBaseInfo, "設立年月")
            val foundation = fetchItem(companyBaseInfo, "資本金")
            val benefit = fetchItem(companyBaseInfo, "売上高")
            val numberOfEmployee = fetchItem(companyBaseInfo, "従業員数")
            val newHired = fetchItem(companyBaseInfo, "新卒採用人数")
            val officesNumber = fetchItem(companyBaseInfo, "事業所数")

            val site = detailDoc.getElementsByClass("node__box node__contact")!!.first()
                ?.getElementsByClass("node__box__heading__link node__box__heading__link-othersite")?.first()
                ?.getElementsByTag("a")?.first()?.attr("href").orEmpty()


            val contactInfo =
                detailDoc.getElementsByClass("nodeTable--simple nodeTable--simple__oneColumn cf")!!.first()!!
                    .getElementsByTag("dl")
            val address = fetchItem(contactInfo, "住所")

            val source = BaseconnectSource(
                companyName = companyName,
                category = category,
                establish = establish,
                foundation = foundation,
                benefit = benefit,
                numberOfEmployee = numberOfEmployee,
                newHired = newHired,
                officesNumber = officesNumber,
                site = site,
                address = address
            )
            sources.add(source)
        }
        return sources
    }

    private fun String.replace(): String {
        val targets = split("　")

        var value = "0"
        for (target in targets) {
            if (target.contains("検索結果")) value = target.replace("検索結果 ", "").replace("件中", "")
        }

        return value
    }

    private fun fetchItem(baseInfos: Elements, target: String): String {
        var value = ""
        for (base in baseInfos) {
            val key = base.getElementsByTag("dt").text()
            if (key.contains(target))
                when (key) {
                    "設立年月" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                    "資本金" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                    "売上高" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                    "従業員数" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                    "新卒採用人数" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                    "事業所数" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                    "住所" -> {
                        value = base.getElementsByTag("dd").text()
                    }
                }
        }
        return value
    }

}