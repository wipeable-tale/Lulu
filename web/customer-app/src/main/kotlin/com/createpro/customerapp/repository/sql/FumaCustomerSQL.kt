package com.createpro.customerapp.repository.sql

class FumaCustomerSQL {
    companion object {
        const val upsertSQL =
            " insert into fuma_customer(id, company_name,main_industry,sub_industry,address,representative,foundation,number_of_employees,update_date) values(?,?,?,?,?,?,?,?,?) on conflict(company_name) do " +
                    "update set foundation = ?,  number_of_employees = ?,update_date =?;"
    }
}