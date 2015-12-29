package com.rui.algorithm.mappercolor;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * 
 * Excel Info Reader
 *
 */
public class FileResolver {
	
	private Workbook workbook;
	
	public FileResolver(String fileName) throws BiffException, IOException {
		this.workbook  = Workbook.getWorkbook(new File(fileName));
	}
	
	public FileResolver(File file) throws BiffException, IOException {
		this.workbook  = Workbook.getWorkbook(file);
	}

	/**
	 * 
	 * Read matrix from Excel
	 * 
	 * @return
	 */
	public int[][] readExcel() {
         Sheet sheet = workbook.getSheet(0);
         int[][] data = null;
         for(int i = 0; i < sheet.getRows(); i++){
             Cell[] cells = sheet.getRow(i);
             if(i == 0) {
            	 data = new int[sheet.getRows()-1][cells.length-1];
            	 continue;
             } else {
            	 for(int j = 0; j < cells.length; j++){
            		 if( j > 0) {
            			Cell cell = cells[j];
            			data[i-1][j-1] = Integer.parseInt(cell.getContents());
            		 }
            	 }
             }
         }
		return data;
	}
	
	/**
	 * 
	 * Reads the region information from the excel header
	 * 
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public String[] readHeader() throws BiffException, IOException {
		Sheet sheet = workbook.getSheet(0);
		Cell[] cells = sheet.getRow(0);
		String[] headers = new String[sheet.getRows()-1];
		for(int i = 0; i < cells.length; i++) {
			if(i > 0) {
				Cell cell = cells[i];
				headers[i-1] = cell.getContents();
			}
		}
		return headers;
	}

}
