package com.jdc.demo.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExcelUploadService {
	
	private Logger logger = LoggerFactory.getLogger(ExcelUploadService.class);

	public List<AccountDto> read(Optional<MultipartFile> file) {
		
		var list = new ArrayList<AccountDto>();
		
		if(file.isPresent()) {
			try {
				var workbook = new XSSFWorkbook(file.get().getInputStream());
				
				logger.info("SHEET SIZE {}", workbook.getNumberOfSheets());
				
				var sheet = workbook.getSheetAt(0);
				logger.info("ROW SIZE {}", sheet.getLastRowNum());
				
				for(var i = 1; i <= sheet.getLastRowNum(); i ++) {
					
					var row = sheet.getRow(i);
					logger.info("COL SIZE of SHEET {} {}", i, row.getLastCellNum());

					var values = new String[row.getLastCellNum()];
					
					for(var j = 0; j < row.getLastCellNum(); j ++) {
						values[j] = row.getCell(j).getStringCellValue();
					}
					
					list.add(AccountDto.from(values));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
