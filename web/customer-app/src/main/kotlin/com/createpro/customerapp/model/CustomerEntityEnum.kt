package com.createpro.customerapp.model

enum class CustomerEntityEnum(val index: Int, val columName: String) {
    COMPANY_CODE(1, "company_code"),
    KANJI_TRADE_NAME(2, "kanji_tradeName"),
    SEARCH_KANA_TRADE_NAME(3, "kana_trade_name_for_search"),
    KANJI_TRADE_NAMES_FOR_SEARCH(4, "kanji_trade_name_for_search"),
    COMPANY_PHONE(5, "company_phone"),
    REPRESENTATIVE_NAME(6, "representative_name_in_kanji"),
    REPRESENTATIVE_KANA_NAME(7, "representatives_kana_name"),
    TDB_INDUSTORY_CLASSIFICATION_NAME_PRINCIPAL_INDUSTRY(8, "tdbIndustry_classification_name_main_business"),
    TDB_INDUSTRY_CLASSIFICATION_NAME_EMPLOYEE(9, "ttdb_industry_classification_name_employee"),
    POSTAL_CODE_NUMBER(10, "postal_code_number"),
    COMPANY_LOCATION_BARCODE_NUMBER(11, "company_address_barcode_number"),
    IMPERIAL_ADDRESS_CODE(12, "imperial_address_code"),
    KANJI_ADDRESS(13, "kanji_address"),
    CAPITAL_THOUSAND_YEN(14, "capitalthousand_yen"),
    NUMBER_OF_EMPLOYEES(15, "number_of_employees"),
    YEAR_OF_FOUNDATION(16, "founding_year"),
    MONTH_OF_FOUNDATION(17, "founding_month"),
    YEAR_ESTABLISHED(18, "year_established"),
    MONTH_OF_ESTABLISHMENT(19, "month_of_establishment"),
    FISCAL_YEAR(20, "fiscal_year"),
    FISCAL_MONTH(21, "closing_month"),
    NET_SALES_MILLIONS_OF_YEN(22, "net_sales_millions_of_yen"),
    UPDATE_DATE(23, "update_date")
}