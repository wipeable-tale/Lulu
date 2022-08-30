package com.createpro.customerapp.model

enum class BASECONNECT(val value: String) {
    //    愛媛
    //    URL("https://baseconnect.in/companies/listing_market/%E6%9C%AA%E4%B8%8A%E5%A0%B4/prefecture/18e4d2f6-9b16-4488-931c-17ced3101b74"),
//    栃木
    URL("https://baseconnect.in/companies/prefecture/5d54c878-c20d-4f57-bb73-e021f2210d6c"),
    DETAIL_URL("https://baseconnect.in"),
    COUNTS("searches__result__number")
}

enum class BASECONNECT_TAG(ancestor: String, parent: String, child: String) {

}
