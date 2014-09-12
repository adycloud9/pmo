package com.vsnl.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import java.io.FileOutputStream;
import com.vsnl.dao.CommonDao;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;
import com.vsnl.util.Constants;

public class CommonManager{
	
	Logger logger = Logger.getLogger(CommonManager.class);
	public static String replaceWithNull(String input)
	{
		input = input.equals("")?null:input;
		return input;
	}
	
	public static String replaceNull(String input)
	{
		input = input==null?"":input;
		return input;
	}
	
	public static String replace(String input,String tobeReplaced,String replaceWith)
	{
		input=replaceNull(input);
		input = input.equalsIgnoreCase(tobeReplaced)?replaceWith:input;
		return input;
	}
	public List getDropdownValuesByQuery(String key, String[] inParams)throws AppException 
	{
        String[] inputParams= {};
        if(inParams != null)
        {
        	inputParams = inParams;
        }

        List returnList = new ArrayList();
        String[] outValues;
        List list = null;
		LabelValueBean lvb = null;
		CommonDao commonDao=new CommonDao();
        try {
        	
        	list =(ArrayList)commonDao.getDatafromDbByQuery(key,inputParams);
        }
            catch(Exception e){
        	System.out.println("Exception==>" + e.getMessage());
        	ExceptionHandler.handleException(this.getClass().getName(), "getDropdownValuesByQuery", key + "," + inParams.toString(), "", e);
            e.printStackTrace();
        }
        if(list!=null && list.size()>0)    
	        {
		        for(int ctr = 0; ctr < list.size(); ctr++)
				{
					if(list.get(ctr)!=null)
					{
			        	outValues = (String[])list.get(ctr);
						lvb = new LabelValueBean();
						lvb.setValue(outValues[0]);
						lvb.setLabel( outValues[0]);
						returnList.add(lvb);
					}
				}
	        }
		return returnList;
	}
	
	public static java.sql.Date getSQLFormatDate(String str, String format)
	{
		System.out.println("str===>" + str);
		String strDate = null;
		java.sql.Date sDate = null;
		
		if(str == null)
			return null;
		else
		{
			try
			{
				 DateFormat df = new SimpleDateFormat(format);
				 java.util.Date jDate     = df.parse(str);
				 System.out.println("jDate===>" + jDate);

				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 strDate = formatter.format(jDate);
				 System.out.println("strDate===>" + strDate);
				 try
				 {
					 sDate = java.sql.Date.valueOf(strDate);
				 }
				 catch(IllegalArgumentException e)
				 {
					 sDate= null;
				 }
			}
			catch(Exception e)
			{
				sDate = null;
			}
		}
		System.out.println("sDate====>" + sDate);
	 return sDate;
	}
	public void copyFile(File source, File target) throws IOException {
		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(target);

		// Copy the bits from instream to outstream
		byte[] buf = new byte[1024];
		int len;

		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		in.close();
		out.close();
	}
	
	public String getdate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
	    String formatDate = formatter.format(date);
	    return formatDate;
	}
	
	
	public List uploadFileinServer(FormFile file,String folderName,String prefix) {
		String uploadResult="false";
		String fileName="";
		List returnList= new ArrayList();
		//String filePath=System.getProperty("user.home");
		String filePath="";
		filePath += Constants.filePath+"\\"+folderName;
		try {
			if(!new File(filePath).exists())
			{
				 new File(filePath).mkdir();
				 
			}
			String fleNameDtls[]=file.getFileName().split("\\.");
			fileName=prefix+"_"+fleNameDtls[0]+"_"+getdate()+"."+fleNameDtls[1];
			logger.debug(fileName);
			File fileToCreate=new File(filePath,fileName);
			if (!fileToCreate.exists()) {
				FileOutputStream fileOutputStream= new FileOutputStream(fileToCreate);
				fileOutputStream.write(file.getFileData());
				fileOutputStream.flush();
				fileOutputStream.close();
				uploadResult="true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnList.add(uploadResult);
		returnList.add(filePath+"\\"+fileName);
		return returnList;
	}
	public void removeFileFromServer(String filepath)
	{
		File deleteFile=new File(filepath);
		if(deleteFile.exists())
		{
			deleteFile.delete();
		}
	}
	
	public File getFile(String filePath) throws Exception
	{
		File returnFile=null;
		returnFile=new File(filePath);
		return returnFile;
		
	}
	
	/*
	 * 
	 * 
	 */
	public String amtWithComma(String amount)
	{
		String temp="";
		if (!amount.equalsIgnoreCase("")) {
			
			String compareAmount="";
			String amountTotal[]=null;
			if (amount.charAt(amount.length()-3)=='.') {
				amountTotal=amount.split("\\.");
				compareAmount=amountTotal[0];
			}
			else
			{
				compareAmount=amount;
			}
			int digitCount=0;
			int k=3;
			for(int i=(compareAmount.length()-1);i>=0;i--)
			{
				if(digitCount==k)
				{
				temp=','+temp;
				k=digitCount+2;
				}
				temp=compareAmount.charAt(i)+temp;
				digitCount=digitCount+1;
			}
			if(amountTotal!=null)
			{
				temp=temp+"."+amountTotal[1];
			}
			else
			{
				temp=temp+".00";
			}
		}
		return temp;
	}
}
