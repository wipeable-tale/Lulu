package com.createpro.customerapp.repository

import com.createpro.customerapp.model.CustomerSourceEnum
import com.createpro.customerapp.model.TYPE
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.NumberToTextConverter
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FileImporterRepository {
    companion object {
        const val BLANK: String = ""
    }


    fun fetcherXLSX(multipartFile: MultipartFile): ArrayList<HashMap<String, String>> {

        val wb: Workbook = XSSFWorkbook(multipartFile.inputStream)
        val sheet: Sheet = wb.getSheet("COSMS001")

        val featchResult: ArrayList<HashMap<String, String>> = ArrayList()
        for (i in 0..sheet.lastRowNum) {
            if (0 == i) continue
            featchResult.add(getCellValue(sheet.getRow(i)))
        }
        return featchResult
    }

    private fun getCellValue(row: Row): HashMap<String, String> {
        val hm: HashMap<String, String> = hashMapOf()
        for (index in 0..21) {
            val source: CustomerSourceEnum = CustomerSourceEnum.values().first { index == it.pos }
            val cellValue = when (source.type) {
                TYPE.DOUBLE -> NumberToTextConverter.toText(row.getCell(source.pos).numericCellValue)
                TYPE.STRING ->
                    try {
                        val rawValue = row?.getCell(source.pos)
                        if (rawValue == null) BLANK
                        else rawValue.stringCellValue
                    } catch (ie: java.lang.IllegalStateException) {
                        /* 一部例外屋号 */
                        println("---------- エラーが出た企業 ${hm[CustomerSourceEnum.KANJI_TRADE_NAME.toString()]}-------------")
                        println("---------- エラーが出たカラム ${source}-------------")
                        println(ie.printStackTrace())
                        NumberToTextConverter.toText(row.getCell(source.pos).numericCellValue)
                    }
            }
            hm[source.toString()] = cellValue
        }
        return hm
    }
}