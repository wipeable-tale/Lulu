package com.createpro.customerapp.repository.jsoup

import com.createpro.customerapp.model.FUMA
import com.createpro.customerapp.model.FUMA_ITEM_NAME
import com.createpro.customerapp.model.FUMA_ITEM_NAME.*
import com.createpro.customerapp.model.FUMA_TAGS
import com.createpro.customerapp.model.FUMA_TAGS.*
import com.createpro.customerapp.model.FumaSource
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.springframework.stereotype.Service


@Service
class WebScraipingRepository {

    fun fetch(page: String): Pair<Int, List<FumaSource>> {
        val url = "${FUMA.URL.value}${page}"
        val doc = Jsoup.connect(url).get()

        val allCount = Integer.parseInt(doc.getElementById(COUNT.anncestor)?.text().orEmpty())

        val conntents = doc.getElementById(FUMA.CONTENTS.value)
        val compayElementList = conntents?.getElementsByClass(FUMA.COMPPANY_ELEMENTS.value).orEmpty()
        val data = compayElementList.map { it.toFumaSource() }

        return Pair(allCount, data)
    }

    private fun Element.toFumaSource(): FumaSource {

        val companyName = getCompanyNamme()
        val mainIndustry = getIndustry(MAIN_INDUSTRY)
        val subIndustry = getIndustry(SUB_INDUSTRY)
        val address = getAddress()

        val companyInfos = getCompanyInfo()
        val representive = getItem(companyInfos, REPRESENTIVE).replaceValue(REPRESENTIVE)
        val foundation = getItem(companyInfos, FOUNDATION).replaceValue(FOUNDATION)
        val establishDate = getItem(companyInfos, ESTABLISH_DATE).replaceValue(ESTABLISH_DATE)
        val numberOfEmployee = getItem(companyInfos, NUMBER_OF_EMPLOYEE).replaceValue(NUMBER_OF_EMPLOYEE)

//        test(companyName, mainIndustry, subIndustry, address, representive, foundation, establishDate, numberOfEmployee)
        return FumaSource(
            companyName,
            mainIndustry,
            subIndustry,
            address,
            representive,
            foundation,
            establishDate,
            numberOfEmployee
        )
    }

    private fun test(a: String, b: String, c: String, d: String, e: String, f: String, g: String, h: String) {
        println(a)
        println(b)
        println(c)
        println(d)
        println(e)
        println(f)
        println(g)
        println(h)
    }

    private fun Element.getCompanyNamme(): String =
        getElementsByClass(COMPANY.anncestor).first()?.getElementsByTag(COMPANY.parent)?.text().orEmpty()

    private fun Element.getIndustry(target: FUMA_TAGS): String = getElementsByClass(target.anncestor)
        .first()?.getElementsByClass(target.parent)?.get(target.index)
        ?.getElementsByTag(target.child)?.text().orEmpty()

    private fun Element.getAddress(): String = getElementsByClass(ADDRESS.anncestor).text()

    private fun Element.getCompanyInfo(): List<Element> =
        getElementsByClass(COMPANY_INFO.anncestor).first()?.getElementsByTag(COMPANY_INFO.parent)
            .orEmpty()

    private fun getItem(companyInfos: List<Element>, target: FUMA_ITEM_NAME): String {
        for (element in companyInfos) {
            val value = element.text()
            if (value.contains(target.value)) return value else ""
        }
        return ""
    }

    private fun String.replaceValue(itemName: FUMA_ITEM_NAME): String = replace(itemName.value, "")
}
