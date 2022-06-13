package com.createpro.customerapp.repository

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.ResourceBundle

@Service
class DataSource {

    lateinit var url: String
    lateinit var user: String
    lateinit var pass: String

    init {
        exectionHooks()
        println(url)
        println(user)
        println(pass)
    }

    fun exectionHooks() =
        ResourceBundle.getBundle("application").let {
            this.url = it.getString("url")
            this.user = it.getString("user")
            this.pass = it.getString("pass")
        }

}