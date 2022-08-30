package com.createpro.customerapp.repository.sql

class BaseconnectCustomerSQL {
    companion object {
        const val upsertSQL =
            " insert into baseconnect_customer(id, company_name,category,establish,foundation,benefit,number_of_employees,new_hired,offices_number,site,address,update_date) values(?,?,?,?,?,?,?,?,?,?,?,?) on conflict(company_name) do " +
                    "update set foundation = ?,  number_of_employees = ?, site = ?,update_date =?;"
    }
}