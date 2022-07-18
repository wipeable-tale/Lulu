package com.createpro.customerapp.service.xlsx

import com.createpro.customerapp.repository.xlsx.FileImporterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class FileImporterServiceImpl : FileImporterService {
    @Autowired
    lateinit var fileImporterRepository: FileImporterRepository


    override fun fetcherXLSX(file: MultipartFile): List<HashMap<String, String>> {
        return fileImporterRepository.fetcherXLSX(file)
    }
}