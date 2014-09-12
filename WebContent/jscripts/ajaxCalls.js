/*
 * Created on Dec 15, 2008
 ** Name: ajaxCalls.js
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                          	       Prior 
 * Date       		   By          	  Version  				Description
 * [dd/mm/yyyy] 
 * ------------  -------------------- -------  ---------------------------------------------------- 
 
 * ======================================================================================== 
 * </pre> 
 * 
  

 **/


//functions for AJAX call

	var targetObj;
	var ajaxResponse;
	function handleStateChange()
	{ 
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200)
			{
				  var message = xmlHttp.responseText; 					  
				  if(targetObj != null)
					  targetObj.value = message;
				  ajaxResponse = message;
					 xmlHttp = null;//1.1 ssn
			}
			else
			{
			   alert("Error loading page"+ xmlHttp.status +":"+xmlHttp.statusText);
			}
		}
	}

	
	var xmlHttp;// global instance of XMLHttpRequest

	function createXmlHttpRequest()
	{
			 xmlHttp = null;  // ver 1.1
	       if(window.ActiveXObject)
	       {
			  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");	
	       }
	       else if(window.XMLHttpRequest)
	       {
	          xmlHttp=new XMLHttpRequest();
   	       }
	}

// Version 1.1 starts {
	var contextRoot  = "";
	function setContextPath(path)
	{
		contextRoot = path;
	}
// Version 1.1 ends   }	


	function startRequest(url){
		createXmlHttpRequest();
//Commented for Verison 1.1  		xmlHttp.open("GET","callAjax.do?" + url ,false)
		// Version 1.1 starts {
		
		// ver 1.3 starts
		if( contextRoot.charAt(contextRoot.length-1) == '/')
		{
			//alert('/ present');						
			contextRoot = contextRoot.substring(0,contextRoot.length-1);
		}
		// ver 1.3 ends
		if(contextRoot != "")
		{
			contextRoot += "/";
		}
  		xmlHttp.open("GET",contextRoot+"callAjax.do?" + url ,false)
		// Version 1.1 ends   }	
  		xmlHttp.onreadystatechange=handleStateChange;
  		xmlHttp.send(null);
	}
   function callAjax(url, targetField)
	{
		//ver 1.5 starts here
		if(targetField == undefined || targetField == null)
		    targetObj = "";	
		else
		//ver 1.5 ends here
     	targetObj = targetField;
		startRequest(url);
	}
	
/* commented for ver 1.5 starts here
	function callAjax(url)//
	{
		startRequest(url);
	}
   ver 1.5 ends here */
   
	function getAccountNumbers(custRef, targetFld)
	{
		return getAccount_AJAX(custRef, targetFld);
	}
		
	function getAccount_AJAX(custRef, targetFld)//try to use DB Framework and arrays to call dynamically....
	{
		//form URL
	    var url  = "method=getDetails&query=GET_ACCOUNT_LIST&custRef=" + custRef;
		callAjax(url, targetFld);
	}
	
	function getAccountNumbers(query, inParams, targetFld)
	{
 	    var url  = "method=getDetails&query=" +  query + "&inParams=" + inParams;
		callAjax(url, targetFld);
	}
	
	function getDetails_ajax(query, inParams, targetFld,ajaxDelimiter)// ver 1.5 added ajaxDelimiter param
	{
		inParams = inParams.replace(/%25/g,'%');  // ver 1.4
		inParams = escape(inParams);  // ver 1.4		
 	    var url  = "method=getDetails&query=" +  query + "&inParams=" + inParams;
 	    // ver 1.5 starts here
		if(ajaxDelimiter == undefined)
			ajaxDelimiter = "";
		url += "&ajaxDelimiter=" + ajaxDelimiter;  	
 	    // ver 1.5 ends here
		callAjax(url, targetFld);
	}

/* commented for ver 1.5 starts here 
	function getDetails_ajax(query, inParams)
	{
 	    var url  = "method=getDetails&query=" +  query + "&inParams=" + inParams;
		callAjax(url);
	}
ver 1.5 ends here */
	
	//temp... move it to diff file later...
	function openPopup(contextPath,qid,paramsList,targetFields, postSelFunction,delimiterVal,tableFlag,tableValue,rowValue,cellValue)  // ver 1.5 (delimiterVal param added)//VERSION 1.7 added ,tableFlag,tableValue,rowValue,cellValue
	{
		var strURL = contextPath+"/getPopup.do?method=getDetails";	

		//qid, paramList, targetFields
		var qid = qid;
		paramsList = paramsList.replace(/%25/g,'%');// ver 1.4 added 	
		var paramList = escape(paramsList);// ver 1.4 added escape;
		
		var trgtFields = targetFields;
		var addURL = "&qid="+qid+"&paramList="+paramList+"&targetFields=" + trgtFields;
		
		if(postSelFunction != null)
			addURL += "&postSelFunction=" + postSelFunction;			
		// ver 1.5 starte here
		if(delimiterVal == undefined)
			delimiterVal = "";
		addURL += "&delimiterVal=" + delimiterVal;			
		// ver 1.5 ends here
		
		//ver 1.7 starte here
		if(tableValue == undefined)
			tableValue = "";
		addURL += "&tableValue=" + tableValue;
		if(tableFlag == undefined)
			tableFlag = "";
		addURL += "&tableFlag=" + tableFlag;
		if(rowValue == undefined)
			rowValue = "";
		addURL += "&rowValue=" + rowValue;
		if(cellValue == undefined)
			cellValue = "";
		addURL += "&cellValue=" + cellValue;	
		
		// ver 1.7 ends here
		
		
		
		strURL += addURL;		
		var myWindow= window.open(strURL,"mywin","left=20,top=20,width=500, height=500, toolbar=0 ,statusbar=true, resizable=1,scrollbars=1");
		myWindow.focus();
		return myWindow;
			
	}
	
	
		function popDropDown(targetFld, value, noDefFlag)  // ver 1.2
		{
			  temp = value.split('!');// output has to be ! and ~ delimited
			  //temp has one row...split on ~ to get value and display
			  obj = document.getElementById(targetFld);
			  if( noDefFlag == null )                            // ver 1.2
			  {													// ver 1.2
			    obj.options[0] = new Option("----Select----",""); 					  
			  }													// ver 1.2
			  for(i = 0 ; i < temp.length ; i++)					  
			  {
				  if(temp[i] != "")
				  {
					  rowValue = temp[i].split('~');
					  for(j = 0 ; j < rowValue.length ; j++)
					  {
					  	  if( noDefFlag == null )        //ver 1.1
					  	  {								// ver 1.1
					  	  
							obj.options[i+1] = new Option(rowValue[1],rowValue[0]); 
						 }			// ver 1.1
						 else        // ver 1.2
						 {			// ver 1.2
						 	obj.options[i] = new Option(rowValue[1],rowValue[0]); // ver 1.2
						 }			// ver 1.2
					  }
				  }
			  }				  
		}
		
		
		function popTextBox(targetFld, value)
		{
    		  obj = document.getElementById(targetFld);
   		      temp = value.split('!');
			  rowValue = temp[0].split('~');
		  	  obj.value =  rowValue[0]	;
		}
	//end temp...
	
	
	// ver 1.6 starts here
	function getBillingAddr_ajax(query, inParams, targetFld,ajaxDelimiter)
	{
 	    var url  = "method=getBillingAddr&query=" +  query + "&inParams=" + inParams;
 	    // ver 1.5 starts here
		if(ajaxDelimiter == undefined)
			ajaxDelimiter = "";
		url += "&ajaxDelimiter=" + ajaxDelimiter;  	
 	    // ver 1.5 ends here
		callAjax(url, targetFld);
	}
	
	function validateInmarProducts_ajax(familyIds, productIds, currency, billingType, targetFld, attributes)
	{
		var url  = "method=validateInmarProducts&familyIds=" +  familyIds + "&productIds=" + productIds + "&currency=" + currency + "&billingType=" + billingType + "&attributes=" + attributes;
		callAjax(url, targetFld);
	}
	// ver 1.6 ends here
	
	
	
