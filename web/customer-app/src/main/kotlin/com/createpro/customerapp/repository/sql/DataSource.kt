package com.createpro.customerapp.repository.sql

import org.springframework.stereotype.Service
import java.util.ResourceBundle

@Service
class DataSource {

    lateinit var url: String
    lateinit var user: String
    lateinit var pass: String

    init {
        exectionHooks()
    }

    fun exectionHooks() =
        ResourceBundle.getBundle("application").let {
            this.url = it.getString("url")
            this.user = it.getString("user")
            this.pass = it.getString("pass")
        }

}