package com.createpro.customerapp.service.xlsx

import org.springframework.web.multipart.MultipartFile

interface FileImporterService
{
    fun fetcherXLSX(file : MultipartFile): List<HashMap<String,String>>
}