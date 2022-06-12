package com.createpro.customerapp.repository


class DataSource {
    lateinit var url: String
    lateinit var driver: String
    lateinit var user: String
    lateinit var pass: String

    init {
        executionhooks()
    }

    fun executionhooks(): Unit {
        this.url=""
        this.driver=""
        this.user=""
        this.pass=""
    }

}