package com.createpro.customerapp.model


enum class FUMA(val value: String) {
    URL("https://fumadata.com/search?fromtop=1&area_id[]=37&titledata=%E6%84%9B%E5%AA%9B%E7%9C%8C%E5%86%85"),
    CONTENTS("contents_main_box2"),
    COMPPANY_ELEMENTS("s_box")
}

enum class FUMA_TAGS(val anncestor: String, val parent: String, val child: String, val index: Int = 99) {
    COMPANY("s_res s_coprate", "", ""),
    MAIN_INDUSTRY("s_title s_bottom clearfix", "s_res s_listed_03", "a", 0),
    SUB_INDUSTRY("s_title s_bottom clearfix", "s_res s_listed_03", "a", 1),
    ADDRESS("s_res s_bottom", "", ""),
    COMPANY_INFO("fl_box clearfix", "li", "")
}

enum class FUMA_ITEM_NAME(val value: String) {
    REPRESENTIVE("代表："),
    FOUNDATION("資本金："),
    ESTABLISH_DATE("設立："),
    NUMBER_OF_EMPLOYEE("従業員数："),

}

