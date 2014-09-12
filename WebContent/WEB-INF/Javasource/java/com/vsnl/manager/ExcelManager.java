package com.vsnl.manager;
import org.apache.log4j.Logger;//version 1.1
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//version 1.1 starts here
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
//version 1.1 ends
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

import com.vsnl.manager.CSVWriter;
import com.vsnl.util.Constants;   // ver 1.6
import com.vsnl.util.FetchResource; 



public class ExcelManager {

	private File file = null;
	private String header = null;
	private String path = null;
	private String style = null;
	private int contentStartIndex = 0;
	private int columnCount = 0;
	private String[] headers = null;
	private String[] cellTypes = null;
	private Logger logger = Logger.getLogger(ExcelManager.class);//version 1.1
		// methods to process an excel file
	
	public List fileToArray(InputStream inputXlsFile)
	{
		
		ArrayList rawBulkUploadList = new ArrayList();
		POIFSFileSystem inputBulkUploadXLS;
		HSSFWorkbook workBook=null;
		HSSFSheet workSheet=null;
		HSSFRow row;
		HSSFCell cell;
		
		try
		{
			inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
			workBook = new HSSFWorkbook(inputBulkUploadXLS);
		}
		catch(Exception e)
		{
			System.out.println("e-->" + e.getMessage());
			return null;
		}
		workSheet = workBook.getSheetAt(0);
		int rowCount = workSheet.getLastRowNum();
		
		//read data from the file
		//start from next line of the header...
		for (int count = contentStartIndex; count <= rowCount; count++) {
			
			boolean isEmptyRow = true;
			//read one row...
			String[] singleRow = new String[columnCount];
			row = workSheet.getRow(count);
			if (row != null) {

				for(int ctr = 0 ; ctr < columnCount; ctr++)
				{
					//read cell value based on type
					//convert and place into string array..
					cell = row.getCell((short) ctr);
					
					if(cell == null)
					{
						singleRow[ctr] = "";
					}
					else
					{
						
						//System.out.println("cellType for column --" + ctr + "=" + cell.getCellType());
						if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
						{
							singleRow[ctr] = cell.getRichStringCellValue().toString().trim();   // ver 1.3 added trim function to remove space character
						}
						
						if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
						{
							//singleRow[ctr] =  new Double(cell.getNumericCellValue()).toString();
//							java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("yy-MMM-dd");
//							Date tmpDate = cell.getDateCellValue();  
//							System.out.println("tmpDate--->" + formatter1.format(tmpDate));
							//System.out.println("::fileToArray:cellValue string-->" + cell.getRichStringCellValue() + "---" + ctr);
							System.out.println("cellValue-->" + cell.getNumericCellValue() + "---" + ctr + "--" + cellTypes[ctr]);
							
							double d = cell.getNumericCellValue();
							if( org.apache.poi.hssf.usermodel.HSSFDateUtil.isValidExcelDate(d) == true && cellTypes[ctr].equalsIgnoreCase("Date"))//date 
							{
//								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-mm-dd");
//								Date date = HSSFDateUtil.getJavaDate(d);
//								System.out.println("date.getTime()--->" + date.getTime());
//								System.out.println("date.getdate...()--->" + date.getDay()+ "--" + date.getMonth() + "--" + date.getYear());

								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MMM-yy");
								//Date date = HSSFDateUtil.getJavaDate(d);
								Date date = cell.getDateCellValue();
								singleRow[ctr] = formatter.format(date);
								System.out.println("singleRow[ctr]-->" + singleRow[ctr]);
							}
							else if(org.apache.poi.hssf.usermodel.HSSFDateUtil.isValidExcelDate(d) == true && cellTypes[ctr].equalsIgnoreCase("Time"))//time
							{
								System.out.println("formatting time...");
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HH:mm");
								Date date = cell.getDateCellValue();
								singleRow[ctr] = formatter.format(date);
								System.out.println("singleRow[ctr]-->" + singleRow[ctr]);
							}
							else//normal numeric...
							{
								// Change ver 1.4 Start if block is change 
								// if(cellTypes[ctr].equalsIgnoreCase("Integer") || cellTypes[ctr].equalsIgnoreCase("String"))
								if(cellTypes[ctr].equalsIgnoreCase("Integer")) {
									singleRow[ctr] =  "" + new Double(cell.getNumericCellValue()).intValue();
								
								} else if(cellTypes[ctr].equalsIgnoreCase("String")) {
									 DecimalFormat dfStr = new DecimalFormat("#");
									 singleRow[ctr] = dfStr.format( cell.getNumericCellValue() );
									 //System.out.println("  singleRow[ctr] :" + singleRow[ctr]+ " Count,rows"+ count+","+ ctr);
									
								} // Change ver 1.4 end								
								else if(cellTypes[ctr].equalsIgnoreCase("Double"))
									//singleRow[ctr] =  new Double(cell.getNumericCellValue()).toString(); commented for version 1.1
								//version 1.1 starts here
								{
									DecimalFormat df = new DecimalFormat("#.##");
									Double dob = new Double(cell.getNumericCellValue());
									System.out.println(dob.doubleValue());
									singleRow[ctr] = df.format(dob.doubleValue()); 
									System.out.println("singleRow[ctr]-->" + singleRow[ctr]);
																						
								}
								//version 1.1 ends here
							}
							
//							System.out.println("numeric-->" + org.apache.poi.hssf.usermodel.HSSFDateUtil.isValidExcelDate(d));
////							cell.get);
//					       java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-mm-dd");
//					       Date date = HSSFDateUtil.getJavaDate(d);
//					       System.out.println("date-->" + date);
//					       System.out.println("formatter.format(date)-->" + formatter.format(date));
////						       System.out.println("Date" + formatter.parseObject(date, 0)   );
						}
						
						
					}
					System.out.println("--" + singleRow[ctr]);
					if(singleRow[ctr] != null)
						if(! singleRow[ctr].equals(""))
						{
							isEmptyRow = false;
						}
						
				}
//				System.out.println("adding to list...");
				//check if row == null...
				if(isEmptyRow == false)
				{
					//add to list
					rawBulkUploadList.add(singleRow);
				}
			}
		}

		return rawBulkUploadList;
	}
	public File arrayToFile(List dataList, File excelFile)throws IOException //
	{
		POIFSFileSystem inputBulkUploadXLS;
		InputStream inputXlsFile = new FileInputStream(excelFile);
		HSSFWorkbook workBook=null;
		HSSFSheet workSheet=null;
		HSSFRow row;
		HSSFCell cell;
		FileOutputStream fosXlsFile = null;
	
		try
		{
			System.out.println("1---");
			inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
			System.out.println("2---");
			workBook = new HSSFWorkbook(inputBulkUploadXLS);
			System.out.println("3---");
//			workSheet = workBook.getSheetAt(0);
//			int rowCount = workSheet.getLastRowNum();
			
			System.out.println("before set excel data...");
			setExcelHeader(workBook);
			setExcelData(dataList, workBook);
			System.out.println("after set excel data...");

			fosXlsFile = new FileOutputStream(excelFile);
			workBook.write(fosXlsFile);

		}
		catch(Exception e)
		{
			System.out.println("e-->" + e.getMessage());
			return null;
		}

		
		return excelFile;
	}
	
	// function used for downloading excel sheet
	
	public File arrayToNewFile(List dataList, File excelFile)throws IOException //
	{
		POIFSFileSystem inputBulkUploadXLS;
		InputStream inputXlsFile = new FileInputStream(excelFile);
		HSSFWorkbook workBook=null;
		HSSFSheet workSheet=null;
		HSSFRow row;
		HSSFCell cell;
		FileOutputStream fosXlsFile = null;
	
		try
		{
			System.out.println("1---");
			//inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
			System.out.println("2---");
			//workBook = new HSSFWorkbook(inputBulkUploadXLS);
			workBook = new HSSFWorkbook();
			System.out.println("3---");
			workSheet = workBook.createSheet();
//			int rowCount = workSheet.getLastRowNum();
			
			System.out.println("before set excel data...");
			setExcelHeader(workBook);
			setExcelData(dataList, workBook);
			System.out.println("after set excel data...");

			fosXlsFile = new FileOutputStream(excelFile);
			workBook.write(fosXlsFile);

		}
		catch(Exception e)
		{
			System.out.println("e-->" + e.getMessage());
			return null;
		}

		
		return excelFile;
	}
	
	
	
	public void setExcelHeader(HSSFWorkbook wb)
	{
		HSSFRow row = null;
		HSSFCell cell = null;
		System.out.println("before getting sheet...");
		HSSFSheet sheet = wb.getSheetAt(0);
		System.out.println("after getting sheet...");
		//create row
		row = sheet.getRow(contentStartIndex-1);
		if(row == null)
			row = sheet.createRow(contentStartIndex-1);

		for(int i = 0 ; i < headers.length; i++)
		{
			cell = row.getCell(i);
			if(cell == null)
				cell	= row.createCell((short)i);
			
			cell.setCellValue( setCellTextValue(headers[i]));
		}
	}
	
	public void setExcelData(List dataList, HSSFWorkbook wb)
	{
			HSSFRow row = null;
			HSSFCell cell = null;
			HSSFSheet sheet = wb.getSheetAt(0);

			int rowCount = contentStartIndex;
			//{
			//iterate the list
			System.out.println("datalist size==> " + dataList.size());
			for(int ctr = 0; ctr < dataList.size(); ctr++)
			{
				//create row
				row = sheet.getRow(rowCount);
				if(row == null)
					row = sheet.createRow(rowCount);
				rowCount++;
				
				try
				{
					String[] strArr = (String[])dataList.get(ctr);
					System.out.println("strArr.length==>" + strArr.length);
					for(int counter = 0; counter < strArr.length; counter++)
					{
						//create cell and insert data depending on type
						cell = row.getCell(counter);
						if(cell == null)
							cell	= row.createCell((short)counter);
						
						if(cellTypes[counter].equalsIgnoreCase("string"))
						{
							System.out.println("in string..." + strArr[counter]);
							cell.setCellValue(setCellTextValue(strArr[counter]));
						}
						else if(cellTypes[counter].equalsIgnoreCase("double"))
						{
							System.out.println("in double...");
							try
							{
							//	cell.setCellValue(Double.parseDouble( strArr[counter] )); commented for version 1.1
							//version 1.1 starts here
								if(strArr[counter]==null || strArr[counter].equals(""))
								{
									cell.setCellValue(setCellTextValue(""));									
								}
								else
								{
									cell.setCellValue(Double.parseDouble( strArr[counter] ));
								}
								//version 1.1 ends here
							}
							catch(NumberFormatException e)
							{
								cell.setCellValue(setCellTextValue( strArr[counter] ));
							}
						}
						else if(cellTypes[counter].equalsIgnoreCase("Integer"))
						{
							try
							{
								cell.setCellValue(Integer.parseInt( strArr[counter] ));
							}
							catch(NumberFormatException e)
							{
								cell.setCellValue(setCellTextValue( strArr[counter] ));
							}
						}
						//version 1.1 starts here
						else if(cellTypes[counter].equalsIgnoreCase("date"))
						{
							try
							{
								if(strArr[counter].equals("") || strArr[counter].equals(null))
								{
									cell.setCellValue(setCellTextValue(""));
								}
								else
								{
									System.out.println("strArr[counter]--->" + strArr[counter]);
									DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
									cell.setCellValue(dateFormat.parse(strArr[counter]));
								}
							}
							catch(NullPointerException npe)
							{
								logger.debug("null pointer exception" + npe.getMessage());
								cell.setCellValue(setCellTextValue(""));
							}
							catch(Exception e)
							{
								logger.debug("date exception" + e.getMessage());
								e.printStackTrace();
								cell.setCellValue(setCellTextValue( strArr[counter] ));
							}
						}
						//version 1.1 ends here
						
					}
				}
				catch(Exception e)
				{
					System.out.println("exception in excel manager" + e.getMessage());
					e.printStackTrace();
				}
			}
		//}
				
	}
	
	public HSSFRichTextString setCellTextValue(String cellElement){
		HSSFRichTextString hs = new HSSFRichTextString(cellElement);
		return hs;
	}

	
	public File getBlankTemplate(String contextPath, String filePath, String fileName, String extn)
	{
		File returnFile = null; 
		try
		{
			contextPath=(contextPath.indexOf(".war")!=-1?contextPath.concat("/"):contextPath);
			System.out.println("contextpath:"+contextPath);
			String exportFilePath = contextPath + filePath;
			returnFile = new File(exportFilePath, fileName + extn);
			System.out.println("export path-->" + exportFilePath);
		}
		catch(Exception e)
		{
			System.out.println("CreditDebitBulkUploadManager.getBlankTemplate" + e);
		}
		return returnFile;
	}
	
	//	ver 1.2 starts here 
	/**
	 * This method is to find the cell count based on the first row 
	 * @param inputXlsFile
	 * @return cellCount  
	 */
	public int columCount(InputStream inputXlsFile){
	
		POIFSFileSystem inputBulkUploadXLS;
		HSSFWorkbook workBook=null;
		HSSFSheet workSheet=null;
		HSSFRow row;
		int count=0;
		HSSFCell cell;
		String cellString;
		int cellCount=0;
		try
		{
			inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
			workBook = new HSSFWorkbook(inputBulkUploadXLS);
			workSheet = workBook.getSheetAt(0);
			row = workSheet.getRow(0);
			if(row!=null)
			{
				count=row.getLastCellNum();
				//This check is to confirm the number of cells
				for(int i=0; i<count; i++)
				{
					cell=row.getCell(i);
					cellString=cell.getRichStringCellValue().toString();
					if( ! "".equals(cellString))
						cellCount++;
				}
				System.out.println("The count is  from exel manager "+cellCount);
			}
			inputXlsFile.close();
		}
		catch(Exception e)
		{
			System.out.println("e-->" + e.getMessage());
			e.printStackTrace();
		}
		return cellCount;
	}
	//ver 1.2 ends here 
	
	
//	----------Getters and Setters-------------
	public String[] getCellTypes() {
		return cellTypes;
	}

	public void setCellTypes(String[] cellTypes) {
		this.cellTypes = cellTypes;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public int getContentStartIndex() {
		return contentStartIndex;
	}

	public void setContentStartIndex(int contentStartIndex) {
		this.contentStartIndex = contentStartIndex;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	// version 1.5 starts here
	public List fileToArrayModified(InputStream inputXlsFile)
	{

		ArrayList rawBulkUploadList = new ArrayList();
		POIFSFileSystem inputBulkUploadXLS;
		HSSFWorkbook workBook=null;
		HSSFSheet workSheet=null;
		HSSFRow row;
		HSSFCell cell;
		int counter=0;
		try
		{
			inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
			workBook = new HSSFWorkbook(inputBulkUploadXLS);
		}
		catch(Exception e)
		{
			System.out.println("e-->" + e.getMessage());
			return null;
		}
		workSheet = workBook.getSheetAt(0);
		int rowCount=0;
		rowCount = workSheet.getLastRowNum();
		System.out.println("row count==========>"+rowCount);
		//read data from the file
		//start from next line of the header...
		for (int count = contentStartIndex; count <= rowCount; count++) {

			boolean isEmptyRow = true;
			//read one row...
			String[] singleRow = new String[columnCount];
			row = workSheet.getRow(count);
			System.out.println("row==========>"+row);
			if (row != null) {
				
				System.out.println("counter value======>"+counter);

				for(int ctr = 0 ; ctr < columnCount; ctr++)
				{
					//read cell value based on type
					//convert and place into string array..
					cell = row.getCell((short) ctr);

					if(cell == null)
					{
						singleRow[ctr] = "";
					}
					else
					{

						//System.out.println("cellType for column --" + ctr + "=" + cell.getCellType());
						if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
						{
							singleRow[ctr] = cell.getRichStringCellValue().toString().trim();   // ver 1.3 added trim function to remove space character
						}

						if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
						{
							//singleRow[ctr] =  new Double(cell.getNumericCellValue()).toString();
//							java.text.SimpleDateFormat formatter1 = new java.text.SimpleDateFormat("yy-MMM-dd");
//							Date tmpDate = cell.getDateCellValue();  
//							System.out.println("tmpDate--->" + formatter1.format(tmpDate));
							//System.out.println("::fileToArray:cellValue string-->" + cell.getRichStringCellValue() + "---" + ctr);
							System.out.println("cellValue-->" + cell.getNumericCellValue() + "---" + ctr + "--" + cellTypes[ctr]);

							double d = cell.getNumericCellValue();
							if( org.apache.poi.hssf.usermodel.HSSFDateUtil.isValidExcelDate(d) == true && cellTypes[ctr].equalsIgnoreCase("Date"))//date 
							{
//								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-mm-dd");
//								Date date = HSSFDateUtil.getJavaDate(d);
//								System.out.println("date.getTime()--->" + date.getTime());
//								System.out.println("date.getdate...()--->" + date.getDay()+ "--" + date.getMonth() + "--" + date.getYear());

								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd-MMM-yy");
								//Date date = HSSFDateUtil.getJavaDate(d);
								Date date = cell.getDateCellValue();
								singleRow[ctr] = formatter.format(date);
								System.out.println("singleRow[ctr]-->" + singleRow[ctr]);
							}
							else if(org.apache.poi.hssf.usermodel.HSSFDateUtil.isValidExcelDate(d) == true && cellTypes[ctr].equalsIgnoreCase("Time"))//time
							{
								System.out.println("formatting time...");
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("HH:mm");
								Date date = cell.getDateCellValue();
								singleRow[ctr] = formatter.format(date);
								System.out.println("singleRow[ctr]-->" + singleRow[ctr]);
							}
							else//normal numeric...
							{
								// Change ver 1.4 Start if block is change 
								// if(cellTypes[ctr].equalsIgnoreCase("Integer") || cellTypes[ctr].equalsIgnoreCase("String"))
								if(cellTypes[ctr].equalsIgnoreCase("Integer")) {
									singleRow[ctr] =  "" + new Double(cell.getNumericCellValue()).intValue();

								} else if(cellTypes[ctr].equalsIgnoreCase("String")) {
									DecimalFormat dfStr = new DecimalFormat("#");
									singleRow[ctr] = dfStr.format( cell.getNumericCellValue() );
									//System.out.println("  singleRow[ctr] :" + singleRow[ctr]+ " Count,rows"+ count+","+ ctr);

								} // Change ver 1.4 end								
								else if(cellTypes[ctr].equalsIgnoreCase("Double"))
								{
									DecimalFormat df = new DecimalFormat("#.##");
									Double dob = new Double(cell.getNumericCellValue());
									System.out.println(dob.doubleValue());
									singleRow[ctr] = df.format(dob.doubleValue()); 
									System.out.println("singleRow[ctr]-->" + singleRow[ctr]);

								}
							}

//							System.out.println("numeric-->" + org.apache.poi.hssf.usermodel.HSSFDateUtil.isValidExcelDate(d));
////							cell.get);
//							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-mm-dd");
//							Date date = HSSFDateUtil.getJavaDate(d);
//							System.out.println("date-->" + date);
//							System.out.println("formatter.format(date)-->" + formatter.format(date));
////							System.out.println("Date" + formatter.parseObject(date, 0)   );
						}


					}
					System.out.println("here-->" + singleRow[ctr]);

					if(singleRow[ctr] != null)
						if(! singleRow[ctr].equals(""))
						{
							System.out.println("column value is==========>"+singleRow[ctr]);
							isEmptyRow = false;
						}

				}
//				System.out.println("adding to list...");
				//check if row == null...
				if(isEmptyRow == false)
				{
					System.out.println("row is not empty inside if");
					//add to list
					rawBulkUploadList.add(singleRow);
					System.out.println("rawBulkUploadList size=============>"+rawBulkUploadList.size());
				}

			}
			else
			{
				System.out.println("rawBulkUploadList size inside else=============>"+rawBulkUploadList.size());
				break;
			}
		}
		//invcForm.setRequestBulkList(rawBulkUploadList);
		return rawBulkUploadList;
	}
	
	// version 1.5 ends here
	
	//ver 1.7 start here
	
	/**@description This function is used to transform the data in proper format to be inserted in CSV and Excel Files
	 * @param dataList
	 * @param excelFile
	 * @param mode
	 * @return
	 * @throws IOException
	 */
	public File arrayToFileForCreditDebitAdjBlkUpload(List dataList, File excelFile, String mode)throws IOException //
	{
		logger.info("Start of arrayToFileForCreditDebitAdjBlkUpload");
		POIFSFileSystem inputBulkUploadXLS;
		InputStream inputXlsFile = new FileInputStream(excelFile);
		HSSFWorkbook workBook=null;
		FileOutputStream fosXlsFile = null;		
		logger.info("dataList size "+dataList.size());
		logger.info("mode "+mode);
		try
		{
			if("downloadExcel".equals(mode)){
				logger.info("Inside condition for mode"+mode);
				String header = FetchResource.fetchMessage("resources.sftpConnection", Constants.adjustmentBlkUpload + "." + Constants.excelHeader);
				String[] headers = header.split(",");
				CSVWriter csvWriter = new CSVWriter(excelFile , null);
				csvWriter.writeHeader(headers);
				for(int j=0; j < dataList.size(); j++){
					String[] accDetails = (String[])dataList.get(j);										
					csvWriter.writeData(accDetails);						
				}
				csvWriter.close();
				logger.info("After setting the csv data for Adjustment Bulk Product Details Upload");
			}else if("referenceExcel".equals(mode)){
				logger.info("Inside condition for mode"+mode);
				inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
				workBook = new HSSFWorkbook(inputBulkUploadXLS);
				setReferenceExcelData(dataList, workBook);				
				logger.info("After setting the csv data for Adjustment Bulk Reference Excel Upload");	
				fosXlsFile = new FileOutputStream(excelFile);
				workBook.write(fosXlsFile);

			}

		}
		catch(Exception e)
		{
			logger.error(e);			
			return null;
		}
		return excelFile;
	}
	
	
	/**@description This function is used to set the data in the Reference Excel
	 * @param dataList
	 * @param wb
	 */
	public void setReferenceExcelData(List dataList, HSSFWorkbook wb)
	{
			HSSFRow row = null;
			HSSFCell cell = null;			
			for(int i=1; i< dataList.size()-2;i++)
			{
				int rowCount = contentStartIndex;
				HSSFSheet sheet = wb.getSheetAt(i-1);
					if(row == null)
						row = sheet.createRow(rowCount);
					try
					{
						List tempList = (List)dataList.get(i);
						logger.info("Reference List size "+tempList.size());
						int counterTemp = 1,counter =0;
						if(i==1){
							counterTemp =2;
						}
						for(int listCount = 0; listCount < tempList.size(); listCount++)
						{
							row = sheet.getRow(rowCount);
							String[] strArr = (String[])tempList.get(listCount);
							logger.info("counter "+counter);
							logger.info("rowCount "+rowCount);
							logger.info("listCount "+listCount);				
								rowCount++;
							for(counter =0; counter < strArr.length ;counter++ )
							{
								logger.info("counter "+counter);
								logger.info("counterTemp "+counterTemp);
								cell = row.getCell(counter);
								if(cell == null)
									cell	= row.createCell((short)counter);
								
								if(cellTypes[counter].equalsIgnoreCase("string"))
								{
									logger.info("The value of the cell is " + strArr[counter]);
									cell.setCellValue(setCellTextValue(strArr[counter]));
								}
							}
						}
					}
					catch(Exception e)
					{
						logger.info("exception in excel manager" + e.getMessage());
						e.printStackTrace();
						logger.error(e);
					}
			}
				
	}
	//ver 1.7 ends here
	
	//ver 1.8 starts here
	/**@description This function is used to transform the data in proper format to be inserted in CSV Files
	 * @param dataList
	 * @param excelFile
	 * @param mode
	 * @return-File
	 * @throws IOException
	 */
	public File arrayToFileForCsv(List dataList, File excelFile,String[] headers)throws Exception
	{
		logger.info("Start of arrayToFileForCsv");		
		CSVWriter csvWriter = new CSVWriter(excelFile , null);
		csvWriter.writeHeaderToCSV(headers);
		int listSize=dataList.size();
		for(int j=0; j <listSize; j++){
			String[] accDetails = (String[])dataList.get(j);										
			csvWriter.writeDataToCSV(accDetails);						
		}
		csvWriter.close();
		logger.info("arrayToFileForCsv::::After setting the csv data for Upload");
		return excelFile;
	}
	//	ver 1.8 ends here
	
	//	ver 1.9 starts here
	/**@description This function is used to transform the data in proper format to be inserted into a carrot seperated file
	 * @param dataList
	 * @param excelFile
	 * @param mode
	 * @return-File
	 * @throws IOException
	 */
	public File arrayToSeperatedFile(List dataList, File excelFile,List headers,String seperator)throws Exception
	{
		logger.info("Excel Manager::Start of arrayToCarrotSeperatedFile");		
		CSVWriter csvWriter = new CSVWriter(excelFile , null);
		
			int headerListSize=headers.size();
			String[] headerDetails=null;
			for(int i=0; i <headerListSize; i++){
				headerDetails = (String[])headers.get(i);
			}		
			csvWriter.writeHeaderIntoSVFile(headerDetails,seperator);
			int listSize=dataList.size();		
			for(int j=0; j <listSize; j++){
				String[] fileDetails = (String[])dataList.get(j);	
				csvWriter.writeDataToSV(fileDetails,seperator);						
			}
		
		csvWriter.close();
		logger.info("arrayToCarrotSeperatedFile::::After setting the csv data for Upload");
		return excelFile;
	}
	
	
	/**
	 * @param inputXlsFile
	 * @return
	 * @throws Exception
	 */
	public List getExcelFileHeader(InputStream inputXlsFile)throws Exception
	{
		
		ArrayList rawBulkUploadList = new ArrayList();
		POIFSFileSystem inputBulkUploadXLS;
		HSSFWorkbook workBook=null;
		HSSFSheet workSheet=null;
		HSSFRow row;
		HSSFCell cell;
		
			inputBulkUploadXLS = new POIFSFileSystem(inputXlsFile);
			workBook = new HSSFWorkbook(inputBulkUploadXLS);
		
		workSheet = workBook.getSheetAt(0);
		//read header from the file		
		for (int count = contentStartIndex; count <= contentStartIndex; count++) {
			
			boolean isEmptyRow = true;
			
			String[] singleRow = new String[columnCount];
			row = workSheet.getRow(count);
			if (row != null) {

				for(int ctr = 0 ; ctr < columnCount; ctr++)
				{
					//read cell value based on type
					//convert and place into string array..
					cell = row.getCell((short) ctr);
					
					if(cell == null)
					{
						singleRow[ctr] = "";
					}
					else
					{			
						if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
						{
							singleRow[ctr] = cell.getRichStringCellValue().toString().trim();   
						}
						
						if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
						{
							
							System.out.println("cellValue-->" + cell.getNumericCellValue() + "---" + ctr + "--" + cellTypes[ctr]);
							
							double d = cell.getNumericCellValue();
															
								 if(cellTypes[ctr].equalsIgnoreCase("String")) {
									 DecimalFormat dfStr = new DecimalFormat("#");
									 singleRow[ctr] = dfStr.format( cell.getNumericCellValue() );
									
								}					
							}
						}			
					
					System.out.println("--" + singleRow[ctr]);
					if(singleRow[ctr] != null)
						if(! singleRow[ctr].equals(""))
						{
							isEmptyRow = false;
						}
						
				}
				if(isEmptyRow == false)
				{
					rawBulkUploadList.add(singleRow);
				}
			}
		}

		return rawBulkUploadList;
	}
	
	//	ver 1.9 ends here
	
	
}

	
	
	
	
	
	
	
	
	
	
	