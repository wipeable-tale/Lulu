package com.createpro.customerapp.service

import com.createpro.customerapp.repository.jsoup.BaseconnectWebRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BaseconnectCustomerServiceImpl : BaseconnectCustomerService {
    @Autowired
    lateinit var webRepository: BaseconnectWebRepository

    override fun fetchCount(): Int = webRepository.fetchCount()

    override fun fetchDetail() = webRepository.fetchCompanyDetail()

}