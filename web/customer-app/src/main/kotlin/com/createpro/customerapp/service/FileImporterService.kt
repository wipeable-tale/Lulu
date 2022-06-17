package com.createpro.customerapp.service

import org.springframework.web.multipart.MultipartFile

interface FileImporterService
{
    fun fetcherXLSX(file : MultipartFile): List<HashMap<String,String>>
}