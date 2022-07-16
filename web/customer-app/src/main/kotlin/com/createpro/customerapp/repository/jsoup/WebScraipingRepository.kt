package com.createpro.customerapp.repository.jsoup

import com.createpro.customerapp.model.FumaSource
import com.createpro.customerapp.model.WebSource
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class WebScraipingRepository {

    fun fetch(): List<FumaSource> {

        val doc = Jsoup.connect(WebSource.FUMA.url).get()
        val div = doc.getElementById("contents_main_box2")
        val compayList = div?.getElementsByClass("s_box")

        return compayList?.let { setFumaSource(it) }.orEmpty()

    }

    private fun setFumaSource(companyList: Elements): List<FumaSource> {
        val dataList = arrayListOf<FumaSource>()

        for (company in companyList) {
            val companyName =
                company.getElementsByClass("s_res s_coprate").first()?.getElementsByTag("a")?.text()
            val industry =
                company.getElementsByClass("s_title s_bottom clearfix")
                    .first()?.getElementsByClass("s_res s_listed_03")?.first()?.getElementsByTag("a")?.text()


            dataList.add(FumaSource(companyName, industry))

        }
        return dataList
    }


    private fun getCompanyNamme(): String {
        return ""
    }

    private fun getIndustry(): String {
        return ""
    }

}