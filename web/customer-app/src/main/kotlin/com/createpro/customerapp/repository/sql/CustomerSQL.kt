package com.createpro.customerapp.repository.sql

class CustomerSQL {
    companion object {
        const val insertSQL =
            "insert into customer(\n" +
                    "    company_code,\n" +
                    "    kanji_tradeName,\n" +
                    "    kana_trade_name_for_search,\n" +
                    "    kanji_trade_name_for_search,\n" +
                    "    company_phone,\n" +
                    "    representative_name_in_kanji,\n" +
                    "    representatives_kana_name,\n" +
                    "    tdbIndustry_classification_name_main_business,\n" +
                    "    ttdb_industry_classification_name_employee,\n" +
                    "    postal_code_number,\n" +
                    "    company_address_barcode_number,\n" +
                    "    imperial_address_code,\n" +
                    "    kanji_address,\n" +
                    "    capitalthousand_yen,\n" +
                    "    number_of_employees,\n" +
                    "    founding_year,\n" +
                    "    founding_month,\n" +
                    "    year_established,\n" +
                    "    month_of_establishment,\n" +
                    "    fiscal_year,\n" +
                    "    closing_month,\n" +
                    "    net_sales_millions_of_yen,\n" +
                    "    update_date)\n" +
                    "    values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                    "    on conflict (kanji_tradeName)" +
                    "    do nothing; "
    }

}