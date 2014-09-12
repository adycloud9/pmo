/** 
 * Description of the Class here. 
 * 
 * Name: CheckString
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            Prior 
 * Date       By              Version  Description 
 * ---------- --------------- -------  ---------------------------------------------------- 
  
 * ======================================================================================== 
 * </pre> 
 * 
  
 
 **/

package com.vsnl.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Krunal
 * @version 1.0
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public  class  CheckString {
	
		/**
		 * Method CheckNotNull
		 * if the input string is null, return false
		 * @param strString
		 * @return boolean
		 */
  		public static boolean CheckNotNull(String strString)
  		{

  			try
  			{
 				 if(strString!=null) {
 				 	strString = strString.trim();
 					 if( !(strString.equalsIgnoreCase(""))){
 				 		return true;
 				 	}
 				 }
  			}

  			catch(Exception e) {
  				
				e.printStackTrace();
  			}

  			return false;

  		}
  		
  		
  		//returns true if string is null or empty
  		public static boolean CheckNull(String strString)
  		{

  			try
  			{
 				 if(strString==null) {
 				 		return true;
 				 }else if(strString!=null) {
  				 	strString = strString.trim();
					 if( (strString.equalsIgnoreCase(""))){
				 		return true;
				 	}
 				 }
  			

 				 }catch(Exception e) {
  				
				e.printStackTrace();
  			}

  			return false;

  		}

  		public static boolean CheckNotNull(Double strString) {

		try {
			if (strString != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

  		public static boolean CheckNotZero(String strString)
  		{

  			try
  			{
 				double value = 0;
 				// if input is null, return false
 				if (CheckNotNull(strString) == true) {
 					value = Double.parseDouble(strString);
 					// if input is 0, return false
 					if (value == 0) {
 	 					return false;
 	 				}else return true;
 				} else 
 					return false;
  			}

  			catch(Exception e) {
  				
				e.printStackTrace();
  			}

  			return false;

  		}
  		
  		
  		/**
		 * Method compareString
		 * @param String paid
		 * @param String payable
		 * @return boolean
		 */
  		public static boolean compareString(String paid,String payable)
  		{
  		    double totalPaid = 0;
  		    double totalPayable = 0;
  		    
  			try
  			{
 				if(CheckString.CheckNotNull(paid)) {
 				   totalPaid = Double.parseDouble(paid); 				    
 				}
 				if(CheckString.CheckNotNull(payable)) {
 				   totalPayable = Double.parseDouble(payable); 				    
 				}
 				
  			}

  			catch(Exception e) {
  				
				e.printStackTrace();
  			}
  			if(totalPaid >= totalPayable){
				    return true;
			}
  			else return false;

  		}

  		/**
  		 * Method tuncateString.
  		 *  this function retuens the string in the rounded format.
  		 * @param input is input String 
  		 * @param Number is the int number for rounding.
  		 * @return String
  		 */
  		public static String truncateString (String input , int number)  {
  			try
  			{
  				NumberFormat formatter = new DecimalFormat("#.00");
  				formatter.setMaximumFractionDigits(number);		 		
  				if (input==null || input == ""){
  				    input = "0";    
  				}
  				if (CheckString.CheckNotNull(input)) {
  				    input = formatter.format(Double.parseDouble(input));
  				}
  			} catch (Exception e)
  			{
  			  e.printStackTrace();
  			}
  			return input;
  		}
  		
  		public static List partString (String input ) {
  		    List name = new ArrayList();
  		    String firstName = null;
  		    String middleName = null;
  		    
  		    int flag =0;
  		    
  		    try
  			{
  		        for (int i = 0; i < input.length(); i++) {
  		            if (input.length()!=0){
	  		            if (flag==0){
	  		                if (input.charAt(i) == ' ') {
	  		                    firstName = input.substring(0,i);
	  		                    System.out.println("firstname: "+firstName);
	  		                    input = input.substring(i+1,input.length()).trim();
	  		                    System.out.println("input after firstname: "+input);
	  		                    name.add(0,firstName);
	  		                    flag++;
	  		                }
	  		            }else if (flag==1){
	  		                if (input.charAt(i) == ' ') {
			                    middleName = input.substring(0,i).trim();
			                    System.out.println("middleName: "+middleName);
			                    name.add(1,middleName);
			                    input = input.substring(i+1,input.length()).trim();
			                    name.add(2,input);
			                    System.out.println("lastName: "+input);
			                }
	  		            }
  		            }
  		        }
  				
  			} catch (Exception e)
  			{
  			  e.printStackTrace();
  			}
  			return name;
  		}
  		
  		public static String dateToString(java.util.Date inputdate) {
  	        String outputDate = null;

  	        try {
  	            //DateFormat dateFormat = DateFormat.getDateInstance();
  	            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
  	            outputDate = dateFormat.format(inputdate);

  	        } catch (Exception e) {

  	            e.printStackTrace();
  	        }

  	        return outputDate;

  	    }
  		
  		public static String ConvertDate(String inputDate) {

	        String outputDate = inputDate;
	        String date = null;
	        String year = null;
	        String month = null;
	        String day = null;
	        try {
	        	if (CheckNotNull(inputDate)) {
		        	date = inputDate.substring(0,10);
		            year = date.substring(0,4);
		            month = date.substring(5,7);
		            day = date.substring(8,10);
		            outputDate = day+"-"+month+"-"+year;  
	        	}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return outputDate;
	    }
  		
  		public static String toDateOnly(String inputDate) {
  	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
  	        String strDate = null;
  	        try {
  	            strDate = sdf.format(inputDate);
  	        } catch (Exception e) {
  	           
  	            e.printStackTrace();
  	        }

  	        return strDate;
  	    }
  		
  		public static String getLable(String value) {
  	        
  			String lable = null;
  			try {
	  			if ("C".equalsIgnoreCase(value)) {
	  				lable = Constants.CHEQUE;
	  			}
	  			if ("D".equalsIgnoreCase(value)) {
	  				lable = Constants.DEMAND_DRAFT;
	  			}
  			}
  	        catch (Exception e) {
  	            e.printStackTrace();
  	        }
  	        return lable;
  	    }

  		public static String[] parseAddress(String address){
  			
  			String addresses[] = new String[2];
  			if(CheckNotNull(address)){
  			StringTokenizer stk = new StringTokenizer(address,"^");
  			int i=0;
  			while(stk.hasMoreTokens() && i<2){
  				addresses[i] = new String();
  				addresses[i] = stk.nextToken();
  				i++;
  			}
  			}
  			return addresses;
  		} 		
  		
  		public static String appendAddress(String add1,String add2) {
  			String address = null;
  			if (CheckNotNull(add1)){
  				address = add1;
  			}
  			
  			if (CheckNotNull(address)){
  				if (CheckNotNull(add2)){
  					address += "^"; 
  					address += add2;
  				}
  			}else if (CheckNotNull(add2)){
  				address = add2;
  			}
  			return address;
  		}
  		
  		/**
  		 * Oct 26, 2005 
  		 * 142729
  		 * @param firstString
  		 * @param secondString
  		 * @param separator
  		 * @return String
  		 */
  		public static String appendString(String firstString,String secondString,String separator) {
  			String concatenatedString = null;
  			if (CheckNotNull(firstString)){
  				concatenatedString = firstString;
  			}
  			
  			if (CheckNotNull(concatenatedString)){
  				if (CheckNotNull(secondString)){
  					concatenatedString += separator; 
  					concatenatedString += secondString;
  				}
  			}else if (CheckNotNull(secondString)){
  				concatenatedString = secondString;
  			}
  			return concatenatedString;
  		}

  		/**
  		 * @description This functions takes a complete String and a Separator as input and
  		 * 		breaks up that string into array of two Strings separated by the passed separator
  		 * 
  		 * Oct 26, 2005 
  		 * 142729
  		 * @param string
  		 * @param separator
  		 * @return String Array
  		 */
  		public static String[] tokenizeString(String string, String separator){
  			String strArray[] = new String[2];
  			if(CheckNotNull(string)){
  				StringTokenizer stk = new StringTokenizer(string, separator);
	  			int i=0;
	  			while(stk.hasMoreTokens() && i<2){
	  				strArray[i] = new String();
	  				strArray[i] = stk.nextToken();
	  				i++;
	  			}
  			}
  			return strArray;
  		}
  		
  		/**
  		 * @description This functions takes a complete String and a Separator as input and
  		 * 		breaks up that string into array of two Strings separated by the passed separator
  		 * 
  		 * Oct 26, 2005 
  		 * 142729 
  		 * @param String string
  		 * @return String value
  		 */
  		public static String isPercentage(String string){
			String value = null;
			try {
				if (string!=null) {
					char[] chArray = string.toCharArray();
					int length = string.length();
					if (chArray[length-1] == '%') {
						value = string.substring(0,length-1);
					}else value = string;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return value;  			
		}
  		
  		/**
  		 * @description This functions takes a complete String as the input and replace charecter ' by ''
  		 * 
  		 * Oct 26, 2005 
  		 * 142729 
  		 * @param String string
  		 * @return String value
  		 */
  		public static String getModifiedString(String strCustName) {
  			StringBuffer strBuf = new StringBuffer(strCustName);
  			int index = strBuf.indexOf("'");
  			if(index != -1) {
  				for(int i=index; (index != -1) && (i<strBuf.length());) {
  					strBuf.insert(index , "'");
  					index = strBuf.indexOf("'",index+2);
  				}
  			}
  			return strBuf.toString();
  		}

  		/**
  		 * @description This functions takes a complete String as well as escape charecter as the inputs and puts 
  		 * backslash '\'. 
  		 * 
  		 * Oct 26, 2005 
  		 * 142729 
  		 * @param String string
  		 * @return String value
  		 */
  		public static String getModifiedString(String strCustName, String escapeChar) {
  			StringBuffer strBuf = new StringBuffer(strCustName);
  			int index = strBuf.indexOf(escapeChar);
  			if(index != -1) {
  				for(int i=index; (index != -1) && (i<strBuf.length());) {
  					strBuf.insert(index, "\\");
  					index = strBuf.indexOf(escapeChar,index+2);
  				}
  			}
  			return strBuf.toString();
  		}
  		
//Version 1.1 by Madhumita M started
  		
  		/** This method checks whether input the value is String or not
  		 * If the input value is String it returns true otherwise it returns false.
  		 * @param inputString
  		 * @return boolean
  		 * @author 202513 --Madhumita M added on 07/09/2007
  		 */
  		public static boolean checkStringValue(String inputString) {

		try {
			if (inputString != null) {
				Double.parseDouble(inputString);
				return false;
			}
			else {
			return false;
			}
		} catch (NumberFormatException e) {
			return true;
		}

	} 	
  		
  		/**
		 * This method checks whether the input value is number or not. If the
		 * input value is number it returns true otherwise it returns false.
		 * 
		 * @param inputNum
		 * @return boolean
		 * @author 202513--Madhumita M added on 07/09/07
		 */
  		public static boolean checkNumber(String inputNum){
  			
  			try{
  				if (inputNum != null){
  					Double.parseDouble(inputNum);
  	  				return true;
  				}
  				else {
  					return true;
  				}
  			}
  			catch (NumberFormatException e){			
  				return false;
  			}
  			
  		} 
  		
  		public static boolean checkValidDate(String inputDate) {
  			
  			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
  			
  			if(inputDate.indexOf("/")!=-1) {
  				inputDate=inputDate.replace('/','-');
  			}
  			
  			try {
  				sdf.parse(inputDate);
  				return true;
  			} catch(Exception e) {
  				return false;
  			}
  			
  		}
  		
  		//Version 1.1 End
  		
  		 public static String replace(String source, String pattern, String replace)
   	    {
   	        if (source!=null)
   	        {	
   	        final int len = pattern.length();
   	        StringBuffer sb = new StringBuffer();
   	        int found = -1;
   	        int start = 0;

   	        while( (found = source.indexOf(pattern, start) ) != -1) {
   	            sb.append(source.substring(start, found));
   	            sb.append(replace);
   	            start = found + len;
   	        }

   	        sb.append(source.substring(start));

   	        return sb.toString();
   	        }
   	        else return "";
   	    }
  		
}
