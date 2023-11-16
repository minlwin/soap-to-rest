package com.jdc.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class ExcelUploadApi {
	
	@Autowired
	private ExcelUploadService service;

	@PostMapping
	public List<AccountDto> upload(@RequestParam Optional<MultipartFile> file) {
		return service.read(file);
	}
}
