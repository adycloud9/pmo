
 /** 
 * File describes common validations 
 * 
 * Name: common.js
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            		Prior 
 * Date       		By              Version  			Description 
 * ---------- ---------------   ----------------  -------------------------------- 
 
 ======================================================================================== 
 * </pre> 
 * 
  
 **/

// version 2.21 starts here
function checkHotupgradeRequestCount(qid,customerId,productSeq,accountNumber,path) 
{  
	inParams = customerId+ ","+accountNumber+ ","+ productSeq;
	setContextPath(path);
	getDetails_ajax(qid,inParams,null);
	var rowArr =  ajaxResponse.split("!");
	var colArr = rowArr[0].split("~");
	var count = colArr[0].split(",");
	return count;
}
// version 2.21 ends here



 //version 2.0 starts here
function validateDecimalPlaces(obj,evt,len) 
    {
    	//var pid= document.getElementById('productId').value; version 2.8
    	//if(isProductId(pid)== true)version 2.8
    	//{version 2.8
	    	if (!(evt.keyCode == 46 || (evt.keyCode >= 48 && evt.keyCode <= 57))) 
			{
				alert("Enter only numeric values");
				return false;
			}
			var parts = evt.srcElement.value.split('.');
			if (parts.length > 2) 
			{
				return false;
			}
			if (evt.keyCode == 46) 
				return (parts.length == 1);
						
			if (parts.length == 2 && parts[1].length >= len)		
				return false;
			return true;
		//}version 2.8
    }



function integer(obj,evt)
{
    var decimal=obj.value;
     if (!(evt.keyCode >= 48 && evt.keyCode <= 57)) 
			{
				alert("Enter only integer values");
				return false;
			}
      else
           return true;	

}


//version 2.0 ends here

//version 2.2 starts here
function checkNumber(obj)
{  
 	var decimal=obj.value;
 	
	if(isNaN(decimal)) 
	{
		alert("Enter only numeric value");
		obj.value="";
		obj.focus();
		return false;
	}
	 else
           return true;	
	
}

//version 2.2 ends here

function amtCheck(amountField)

{

	var amt = amountField.value;

	var iChars = "0123456789.";

	var count=0; //ver 2.18

		for (var i = 0; i < amt.length; i++)

		{

	  		if (iChars.indexOf(amt.charAt(i)) == -1)

	  		{

  			alert ("Please Enter Valid Amount");

  			amountField.value="";

  			amountField.focus();

  			return false;

  			}
  			else //ver 2.18 starts here
			{
				if(amt.charAt(i)==".")
				{
          			count++;
          		}
			}
			if(count>=2)
			{
				alert("Please Enter decimal point only once");
				amountField.value="";
				amountField.focus();
				return false;
			} //ver 2.18 ends here

  		}
	}
	function getSelectedObject(buttonGroup) //ver 1.7	 starts
			{		
				if(buttonGroup != null)	
				{
					   if (buttonGroup[0])
					   { 
						  for (var i=0; i<buttonGroup.length; i++) 
						  {
							 if (buttonGroup[i].checked)
							 {					 	
								return buttonGroup[i];
							 }
						  }
					   }
					   else
					   {			   
						  if (buttonGroup.checked) 
						  {
							return buttonGroup; 
						  } 
					   }
				}
			   return null;
			} // Ends the "getSelectedRadio" function
		
		
		function getSelectedRadio(buttonGroup) 
			{
			
			   if (buttonGroup[0])
			   { 
				  for (var i=0; i<buttonGroup.length; i++) 
				  {
					 if (buttonGroup[i].checked)
					 {
						return i;
					 }
				  }
			   }
			   else
			   {
				  if (buttonGroup.checked) { return 0; } 
			   }

			   return -1;
			} // Ends the "getSelectedRadio" function

			function getSelectedRadioValue(buttonGroup) 
			{
			
			   var i = getSelectedRadio(buttonGroup);
			   if (i == -1) 
			   {
				  return "";
			   }
			   else
			   {
				  if (buttonGroup[i])
				  { 
					 return buttonGroup[i].value;
				  } 
				  else 
				  { 
					 return buttonGroup.value;
				  }
			   }
			} // Ends the "getSelectedRadioValue" function ver end 1.7	
		
	
function amtCheckAll(amountField)

{

	var amt = amountField.value;

	var iChars = "-0123456789.";

	

		for (var i = 0; i < amt.length; i++)

		{

	  		if (iChars.indexOf(amt.charAt(i)) == -1)

	  		{

  			alert ("Please Enter Valid Amount");

  			amountField.value="";

  			amountField.focus();

  			return false;

  			}

  		}

}


function checkNumeric(numberFeild)

{
	var amt = numberFeild.value;
	var iChars = "0123456789";
		for (var i = 0; i < amt.length; i++)
		{
	  		if (iChars.indexOf(amt.charAt(i)) == -1)
	  		{
  			alert ("Please enter a valid number.");
  			numberFeild.value="";
  			numberFeild.focus();
  			return false;
  			}
  			else
  			return true;
  		}
}
//version 2.4 starts here
function checkNumericValues(numberFeild)

{
	var amt = numberFeild.value;
	var iChars = "0123456789.";
		for (var i = 0; i < amt.length; i++)
		{
	  		if (iChars.indexOf(amt.charAt(i)) == -1)
	  		{
  			alert ("Please enter a valid number.");
  			numberFeild.value="";
  			numberFeild.focus();
  			return false;
  			}
  		}
	return true;
}
//version 2.4 ends here
 	

 	

 	

 	







function openNewWindow(linkurl,windowname,left,top,width,height,scroll,resize){

windowname = window.open(linkurl,windowname,"toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars="+scroll+",resizable="+resize+",left="+left+",top="+top+",width="+width+",height="+height);

}





function changeVsnlFields(fieldArr) {

    

    if (fieldArr == null) 

	return;



    for (i = 0; i < fieldArr.length; i++) {	

		

		fldObj = fieldArr[i]

		

    	if (fldObj == null) {

			continue			

		}			

		fldObj.value = "";	

		fldObj.disabled = true;	

		alert(fldObj.disabled);			

	}

	return

}



function getFldobj(fldName,index) {	

	if (index == null) index = 0;

	return document.all(fldName,index);

}



function openCalendar(aPath,aDateObj,aleft,atop)

{	

	dateObj = aDateObj;

	window.showModalDialog(aPath,window,'status:no;scroll:no;resizable:no;help:no;dialogHeight:225px;dialogWidth:240px;dialogLeft=' + aleft + ';dialogTop=' + atop);

}

function fillDate(str)

{
	dateObj.value = str;
	//validateDate(dateObj);

}



/*function getHTML1(strname,blnEmpty){



	strHTML = "<select name='"+strname+"' >";

	

	if (blnEmpty)

		strHTML = strHTML + "<option value=''>--select--</option>";

	return strHTML;

}*/





/*

Use this method, if the "div" blocks need to be shown/hidden/blurred

This method takes an array of div ids that need to be shown or hidden

1 - show the block

0 - hide the block

Usage:

if "div1" is to be shown

divArr = [[div1,1]];



if "div1" is to be shown and "div5" is to be hidden

divArr = [[div1,1], [div5,0]];



call the function using showhideBlock(divArr)

*/



function showhideBlock(divArr,disableFlag){

	if (divArr == null) 

	{

	return;	

	}	

	for (var i=0;i<divArr.length;i++){

		

		divObj = divArr[i][0];

		changeType = divArr[i][1];

		if (changeType == 1){		

			divObj.style.display = "block";

		}

		else {

			divObj.style.display = "none";			

		}

		if (disableFlag != null && disableFlag == 1)

			disableCtrls(divObj,changeType);	

	}		

}



function disableCtrls(parentNode,enableflag) 

{		

	for (var i=0;i<parentNode.childNodes.length;i++) 

	{

		var oNode  = parentNode.childNodes[i];

		

		if (oNode.tagName == 'A') {

			oNode.outerHTML = oNode.innerText; 			

		}

		else if (oNode.childNodes.length > 0 && oNode.tagName != 'SELECT' && oNode.tagName != 'TEXTAREA') 

		{

			disableCtrls(oNode,enableflag);

		}

		else 

		{		

			if ((oNode.tagName == 'INPUT' || oNode.tagName == 'SELECT' || oNode.tagName == 'TEXTAREA') && oNode.type != 'button' && oNode.type != 'hidden') 

			{				

				if (enableflag == 1) 

				{					

					oNode.disabled = false;

					if (oNode.tagName == 'SELECT') {					

						if (oNode.options.length!=0 && oNode.value=='')

							oNode.options[0].selected = true;

					}

				}

				else if(enableflag == -1)

				{					

					oNode.disabled = true;

				}

				else 

				{

					oNode.value = '';

					oNode.disabled = true;

				}								

			}

		}		

	}

}



//to convert from yyyy-mm-dd to dd-mm-yyyy

    function formatDate(inputDate) {

    

    inputDate = inputDate.replace( /\./g, "-" )

    inputDate = inputDate.replace( /\//g, "-" )

    

    var strDateArray;

    if (inputDate.indexOf("-") != -1) {

		strDateArray = inputDate.split("-");

			if (strDateArray.length != 3) {

	    		return false;

			} else {

		    	var year = strDateArray[0];

		    	var month = strDateArray[1];

		    	var day = strDateArray[2];

			}

    }

    

	return validityDate = day +"-"+ month+"-"+year ;

}



/// Function to validate month year.

function validateMonthYear(oDate) {

	var date = oDate.value;



	if(date!= "undefined" && date!=""){		

		if(validateDate(date)){				

			oDate.value = formatMonthYear(oDate);							

			return;

		}

		else { 

			oDate.value="";

			oDate.focus();	

		}

	}else if(date == "undefined"){

		oDate.value = "";

	}	

	return;		

}





function validateDate(input) {

	var msgs = new Array();

	msgs["date"]= "Please enter the month year in MM-YYYY Format";	

	var chequeDate = input;	

	if (chequeDate!=""){

		vsnldate = new VsnlDate(chequeDate);

		if (!vsnldate.monthyearValidation(1)) {				

			 alert(msgs["date"]);				 

			 return false;

		}else return true;

	}

	else return true;

}



function formatMonthYear(oDate){			

		var date = oDate.value;	

		

		if (date!=""){

			date = date.replace( /\./g, "-" )

			date = date.replace( /\//g, "-" )

			var strDateArray;

	    	if (date.indexOf("-") != -1) {

		    	strDateArray = date.split("-");			

		    	month = strDateArray[0];

		    	year = strDateArray[1];

		    }

	    	else {

	    		if (date.length == 6) {

					year = date.substr(0,2);

					month = date.substr(4);	

				}

	    	}

	    	

	    	var intMonth = parseInt(month, 10);

	    	

	    	if( intMonth < 10 )

				month = "0" + intMonth;

			date =  month  + "-" + year ;

			return date;			

		}

		else return ;		

	}
	
// ver 1.1 starts here
	
	function validateThreeDecimalPlaces(obj, evt) 
    {
		if (!(evt.keyCode == 46 || (evt.keyCode >= 48 && evt.keyCode <= 57))) 
		{
			alert("Enter only numeric values");
			return false;
		}
		var parts = evt.srcElement.value.split('.');
		if (parts.length > 2) 
			return false;
		if (evt.keyCode == 46) 
			return (parts.length == 1);
			
		if (parts[0].length >= 13) 
			return false;	
		
		if (parts.length == 2 && parts[1].length >= 3)		
			return false;
		

		return true;
    }

// ver 1.1 ends here
	
// ver 1.2 added by Rashmi Batra for Admin Module CR-121108-F1
 
	function chkSpecialChar(obj)
	{
		var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
			for (var i = 0; i < obj.value.length; i++)
			{
		  		if (iChars.indexOf(obj.value.charAt(i)) != -1)
		  		{
		  			alert ("Specials Characters are not allowed.");
					obj.focus();					
		  			return false;
	  			}
	  			
	  		}
	  	return true;	
	}
	
//	ver 1.2 ends here

// ver 1.2 added by Rashmi Batra for Admin Module CR-121108-F1 

	function chkZipLength(zipcode, country)
	{
		if(zipcode.value.length>20)
		{
			alert("Zip Code/Postal code length cannot be greater than 20 charcters");
			zipcode.focus();
			return false;
		}
		if(country.value == "South Africa")
		{
			if(zipcode.value.length > 4 || zipcode.value.length < 4)
			{
				alert("Zip code/Postal code must be 4 digits");
				zipcode.value = ""
				zipcode.focus();
				return false;
			}
		}
		for(var i=0;i<zipcode.length;i++)
		{
			var testChar = zipcode.value.charAt(i);
			if(testChar<"0" || testChar>"9")
			{
				alert("Please enter digits only");
				zipcode.value = "";
				zipcode.focus();
				return false;
			}
		
		}	
	}
//	ver 1.2 ends here


// ver 1.3 starts here (functions added by Rashmi Batra for LA OffNet OnNet CR)

// function is used to compare two dates
		var monthArr = new Array("JAN", "FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");
		function getMonthNumber(monthNameParam)
		{
			var monthName = monthNameParam.toUpperCase();								
			var monthNumber;			
			for(i = 0 ; i < monthArr.length; i++)
			{
			
				if(monthArr[i] == monthName)
				{  
					monthNumber = i+1;
					break;
				}
			}	
			return monthNumber;
		}
		
	// ver 1.3 ends here
	
	// ver 1.3 starts here

	function validateDate(commissionDate, comparisonDate)
	{	
		var commissionDateArr = new Array();
		commissionDateArr = commissionDate.split("-");		
		var comparisonDateArr = new Array();
		comparisonDateArr = comparisonDate.split("-");	
		var commissionDate, commissionMonth, commissionYear;
		var comparisonDate, comparisonMonth, comparisonYear;
		
		commissionDate = commissionDateArr[0];			
		commissionMonth = getMonthNumber(commissionDateArr[1]);	
		commissionYear = commissionDateArr[2];

		comparisonDate = comparisonDateArr[0];
		comparisonMonth = getMonthNumber(comparisonDateArr[1]);
		comparisonYear = comparisonDateArr[2];
		
		if(parseInt(commissionYear) > parseInt(comparisonYear))
		{			
			flag =  false;
		}
		else
		{
			
			if(parseInt(commissionYear) == parseInt(comparisonYear))
			{
				if(parseInt(commissionMonth) > parseInt(comparisonMonth))
				{								
					flag =  false;
				}
				else
				{
					if(parseInt(commissionMonth) == parseInt(comparisonMonth))
					{						
						if(parseInt(commissionDate) > parseInt(comparisonDate))
						{		
							
							flag = false;
						}
						else
						{														
							flag = true;
						}
					}
					else
					{						
						flag =  true;
					}
				}
			}
			else
			{	
				flag =  true;
			}
		}
		return flag;		
	}
	
	// ver 1.3 ends here
	
	
	// ver 1.4 starts here
	
	// This function is used to trim all white spaces from left as well as right to the entered values. 
	function trimAll(sString) 
	{
		while (sString.substring(0,1) == ' ')
		{
		sString = sString.substring(1, sString.length);
		}
		while (sString.substring(sString.length-1, sString.length) == ' ')
		{
		sString = sString.substring(0,sString.length-1);
		}
		return sString;
	}
	// ver 1.4 ends here
	
	//Version 	1.5 starts {
	function removeAllOptions(listObj,setIndex)
	{			
		if(listObj.options.length >setIndex)
		{
			for(var i=listObj.options.length-1;i>=setIndex;i--)
				listObj.remove(i);	
		}
	 }
	//Version 1.5 ends }
	
		
	// ver 1.6 starts here
	//  This function is used to validate a numeric value and limit to enter the number of only 8 digits. 
	
	function isNumberKey(obj, evt)
	{
		var charCode = (evt.which) ? evt.which : event.keyCode
		var value = obj.value;
		
		if (charCode > 31 && (charCode < 48 || charCode > 57))
		{
			alert("Enter only numeric values");
			return false;
		}
		if(value.length > 7 )
		{
			return false;
		}
			return true;
	}
	
	// ver 1.6 ends here
	
	//ver 1.7 starts
	function trimAll(sString) 
	{
		while (sString.substring(0,1) == ' ')
		{
		sString = sString.substring(1, sString.length);
		}
		while (sString.substring(sString.length-1, sString.length) == ' ')
		{
		sString = sString.substring(0,sString.length-1);
		}
		return sString;
	}
	//ver 1.7 end
	function validateAlphaNumeric(obj, evt) 
    {
		if ((evt.keyCode == 46 || (evt.keyCode >= 48 && evt.keyCode <= 57) || evt.keyCode == 45)) 
		{
			alert("Enter Alphanumeric values");
			return false;
		}
		var parts = evt.srcElement.value.split('.');
		if (parts.length > 2) 
			return false;
		if (evt.keyCode == 46) 
			return (parts.length == 1);
			
		if (parts[0].length >= 13) 
			return false;	
		
		if (parts.length == 2 && parts[1].length >= 3)		
			return false;
		

		return true;
    }
	
	//ver 1.8 starts
	//ver 2.43 starts here	
	/* This function is used to check COPF ID, whether there are existing records of the inserted COPFID,
	* if there are then display a new pop up will all the account and products having duplicate records 
	* and force the user to enter a valid reason for continuing with the duplicate value	
	*/	
	function validateCOPF(valueObj,path,page,providerId)
	{	
		var strURL = path+"/pages/popups/checkDuplicateCOPFID.jsp";	
		 if(page == 'showProdAttr'){
		 	var copf_id = document.getElementById('COPF_ID').value;
		 }else if(page == 'product1'){
		 	var copf_id = document.createproduct.P_CUSTOMER_ORDER_NO.value;
		 }else if(page == 'parallelUpgradeRequest'){
		 	var copf_id = document.parallelupgraderequest.P_CUSTOMER_ORDER_NO.value;
		 }else if(page == 'updateProductDetails'){
		 	var copf_id = document.getElementById('copfId').value;
		 }else if(page == 'addmulticircuit'){
		 	var copf_id = document.getElementById('copfId').value;
		 }
		 var alphanum=/^[0-9a-zA-Z]+$/;		  	
		 if(alphanum.test(copf_id))
		 {		 
			if(providerId==1)
			{
		  		var prodName = new Array();
		  		var accNum = new Array();
		  		var reqstat = new Array();
		  		inParams = providerId+','+copf_id;
		  		var queryId  = 'accountAttr.getAccountNum';
		  		setContextPath(path);
		  		getDetails_ajax(queryId,inParams, null);
				var splitAjaxResponse = ajaxResponse.split("~"); 
		  		var ParmA = "";	
		  		var rowArr =  ajaxResponse.split("!");
		  		if(ajaxResponse !=null && ajaxResponse!="")
				{		
					for(var i=0; i < (rowArr.length)-1 ; i++)
					{	
						var colArr = rowArr[i].split("~");
						prodName[i] = colArr[0];
						accNum[i] = colArr[1];
						reqstat[i] = colArr[2];
					}
					var MyArgs = new Array(ParmA, copf_id, accNum, prodName,reqstat);					
					var MyArgs = window.showModalDialog(strURL,MyArgs,'center:yes;resizable:no;dialogWidth:650px;dialogHeight:300px;scrollbars:yes,statusbar:true');			
					if(MyArgs[0].toString()=='Close'){
						if(page == 'showProdAttr'){
							document.getElementById('COPF_ID').value="";
						}else if(page == 'product1'){
							document.createproduct.P_CUSTOMER_ORDER_NO.value="";
						}else if (page == 'parallelUpgradeRequest'){
							document.parallelupgraderequest.P_CUSTOMER_ORDER_NO.value="";
						}else if (page == 'updateProductDetails'){
							document.getElementById('copfId').value="";
						}else if (page == 'addmulticircuit'){
							document.getElementById('copfId').value="";
						}
					}else{
						if(page == 'showProdAttr'){
					 		document.showProdAttr.reasonCopf.value=MyArgs[0].toString();
					 	}else if(page == 'product1'){
					 		document.createproduct.reasonCopf.value=MyArgs[0].toString();
					 	}else if(page == 'parallelUpgradeRequest'){
					 		document.parallelupgraderequest.reasonCopf.value=MyArgs[0].toString();		 		
					 	}else if(page == 'updateProductDetails'){
					 		document.updateProdForm.reasonCopf.value=MyArgs[0].toString();
					 	}else if(page == 'addmulticircuit'){
					 		document.addMultiCircuitForm.reasonCopf.value=MyArgs[0].toString();
					 	}
					 }				
				}else{
					if(page == 'showProdAttr'){
				 		document.showProdAttr.reasonCopf.value="";
				 	}else if(page == 'product1'){
				 		document.createproduct.reasonCopf.value="";
				 	}else if(page == 'parallelUpgradeRequest'){
				 		document.parallelupgraderequest.reasonCopf.value="";		 		
				 	}else if(page == 'updateProductDetails'){
				 		document.updateProdForm.reasonCopf.value="";
				 	}else if(page == 'addmulticircuit'){
				 		document.addMultiCircuitForm.reasonCopf.value="";
				 	}
				}
			}					 
			//valueObj.value="";   // ver 2.6
			valueObj.focus();
			return false; 
		}else{
			 alert('COPF ID should only contain characters from [0-9] and [A-Z]');
			 valueObj.value="";    // ver 2.6
			 valueObj.focus();
			 return false;
		}
	}
	/* This function is used to check Viznet Circuit ID, whether there are existing records of the inserted Viznet Circuit ID,
	* if there are then display a new pop up will all the account and products having duplicate records 
	* and force the user to enter a valid reason for continuing with the duplicate value	
	*/	
	function validateViznetCircuit(valueObj,path,page,providerId)
	{	
		var strURL = path+"/pages/popups/checkDuplicateViznetID.jsp";	
		 if(page == 'showProdAttr'){
		 	var viznet_id = document.getElementById('VIZNET_ID').value;
		 }else if(page == 'addmulticircuit'){
		 	var viznet_id = document.getElementById('viznetcircuitId').value;
		 }
		 var alphanum=/^[0-9a-zA-Z]+$/;		  	
		 if(alphanum.test(viznet_id))
		 {		 
			if(providerId==1)
			{
		  		var prodName = new Array();
		  		var accNum = new Array();
		  		var reqstat = new Array();
		  		var queryId  = 'accountAttr.getAccountNumforViznet';
		  		inParams = providerId+','+viznet_id;
		  		setContextPath(path);
		  		getDetails_ajax(queryId,inParams, null);
				var splitAjaxResponse = ajaxResponse.split("~"); 
		  		var ParmA = "";	
		  		var rowArr =  ajaxResponse.split("!");
		  		if(ajaxResponse !=null && ajaxResponse!="")
				{			
					for(var i=0; i < (rowArr.length)-1 ; i++)
					{	
						var colArr = rowArr[i].split("~");
						prodName[i] = colArr[0];
						accNum[i] = colArr[1];	
						reqstat[i] = colArr[2];	
					}
					var MyArgs = new Array(ParmA, viznet_id, accNum, prodName,reqstat);					
					var MyArgs = window.showModalDialog(strURL,MyArgs,'center:yes;resizable:no;dialogWidth:650px;dialogHeight:300px;scrollbars:yes,statusbar:true');			
					if(MyArgs[0].toString()=='Close'){
						if(page == 'showProdAttr'){
							document.getElementById('VIZNET_ID').value="";
						}else if(page == 'addmulticircuit'){
							document.getElementById('viznetcircuitId').value="";
						}
					}else{					
						if(page == 'showProdAttr'){
					 		document.showProductAttr.reasonViznetCircuit.value=MyArgs[0].toString();
					 	}else if(page == 'addmulticircuit'){
					 		document.addMultiCircuitForm.reasonViznetCircuit.value=MyArgs[0].toString();		 		
					 	}
					}				
				}else{
					if(page == 'showProdAttr'){
				 		document.showProductAttr.reasonViznetCircuit.value="";
				 	}else if(page == 'addmulticircuit'){
				 		document.addMultiCircuitForm.reasonViznetCircuit.value="";		 		
				 	}
				}
				if(document.getElementById('billingTypeLabel').value=="PH")
				{
					document.getElementById('PHASE_ID').value=viznet_id;
				}
				if(document.getElementById('billingTypeLabel').value=="PJ")
				{
					document.getElementById('PROJECT_ID').value=viznet_id;
				}				
			}					 
			//valueObj.value="";   // ver 2.6
			valueObj.focus();
			return false;  
		}else{
			 alert('Viznet Circuit ID should contain characters from [0-9] and [A-Z]');
			 valueObj.value="";    // ver 2.6
			 valueObj.focus();
			 return false;
		}
	}	

	function validateCopfId(valueObj)
	{	
		 if(isAlphaNumeric(valueObj.value))
		 {	
			 //if(!isNumeric(valueObj) || !isAlphabetic(valueObj)){
			   alert('COPF ID should contains atleast a digit as well as a character');
			   //valueObj.value="";   // ver 2.6
    		   
    		   //---  
    		   document.getElementById('reasonCopf').disabled = false;
    		   document.getElementById('reasonCopf').value = "XYZ";
    		   //for single product
    		   document.newprodforILL.P_REASONCOPF.disabled = false;
    		   document.newprodforILL.P_REASONCOPF.value = "XYZ";
    		   //--
    		   document.parallelupgraderequest.P_REASONCOPF.disabled = false;
    		   document.parallelupgraderequest.P_REASONCOPF.value = "XYZ";
    		   // --
    		   document.createproduct.P_REASONCOPF.disabled = false;
    		   document.createproduct.P_REASONCOPF.value = "XYZ";
    		   // --
    		   document.upgraderequest.P_REASONCOPF.disabled = false;
    		   document.upgraderequest.P_REASONCOPF.value = "XYZ";
    		   
    		   	inParams = valueObj.value;
				//setContextPath(path);
				getDetails_ajax('productAttrCOPF.getAccountDetails',inParams,null);
				alert('Account Nos'+ajaxResponse);
      			valueObj.focus();
			   //return false; 
			   //}
		} 
		else{
			 alert('COPF ID should be alphanumeric with values from [0-9] and [A-Z]');
			 // valueObj.value="";    // ver 2.6
			 valueObj.focus();
			 //return false;
		
		 }
	}

	function validateCircuitId(valueObj)
	{	
		 if(isAlphaNumeric(valueObj.value))
		 {
			 if(!isNumeric(valueObj) || !isAlphabetic(valueObj)){
			   alert('Circuit ID should contains atleast a digit as well as a character');
			   //valueObj.value="";   // ver 2.6
    		  
    		   document.getElementById('reasonCircuit').disabled = false;
    		   document.getElementById('reasonCircuit').value = "ABC";
			    valueObj.focus();
			   //return false; 
			 } 
		}
		 else{
			 alert('Circuit ID should be alphanumeric with values from [0-9] and [A-Z]');
			 // valueObj.value="";    // ver 2.6
			 valueObj.focus();
			 //return false;
		
		 }
	}

   function validateCircuitReason(valueObj)
   {
	   	if(getFldobj('reasonCircuit'+getobjectName(valueObj)).value=="")
		{
			alert("Please enter the Reason for Duplicate Circuit ID");
			getFldobj('reasonCircuit'+getobjectName(valueObj)).focus();
			return false;
		} 
   }
   function validateCOPFReason(valueObj)
   {
	   	if(getFldobj('reasonCopf'+getobjectName(valueObj)).value=="")
		{
			alert("Please enter the Reason for Duplicate COPF ID");
			getFldobj('reasonCopf'+getobjectName(valueObj)).focus();
			return false;
		} 
   }
// ver 2.43 ends here
	

function isNumeric(valueObj){
	var val = trimVal(valueObj.value);
	valueObj.value = val;
	var format = /^[0-9]+$/;
	
	if(val.length==0)
	{
	  return false;
	} 
	
	if(!format.test(val))
	 {
	   alert('Please enter a valid integer');
	   valueObj.value='';
	   valueObj.focus();
	   return false;
	 }
	 
	 return true;
}

 function isAlphabetic(valueObj)
 {
	var alph_valid="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var sizechar=valueObj.value.length;
	var count=0;	
    for (var i=0; i<sizechar; i++) {
        if (alph_valid.indexOf(valueObj.value.charAt(i)) < 0) {
           count++;
        }        	
    }
    if(count==sizechar)
    	return false;
    else
    	return true; 
}

function isAlphaNumeric(val)
{
  var values = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for (var i=0; i < val.length; i++) 
    if (values.indexOf(val.charAt(i)) < 0) 
        return false;
  return true;
}	

// ver1.8 end
//ver 1.9 starts
function alpha(obj,evt) 
	{
		var k = (evt.which) ? evt.which : event.keyCode
		if(k != 32 && k!= 45)
		{
			if((k<65 || k>122) || k == 32)
			{
				alert("Please Enter Only Characters");
				return false; 
			}
		}
		return true;
		//return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k==46);
	}

	
	function isValueAlphaNumeric(obj, evt) 
    {
    //46 . , 39 '
		if (evt.keyCode == 46 || (evt.keyCode >= 48 && evt.keyCode <= 57) || evt.keyCode == 45 || evt.keyCode == 32 || evt.keyCode == 39 ||
			(evt.keyCode > 64 && evt.keyCode < 91) || (evt.keyCode > 96 && evt.keyCode < 123) || evt.keyCode == 8
		) 
			return true;
		else
		{
			alert("Enter Alphanumeric values");
			return false;
		}
    }
    //ver 1.9 end
    function isNumberKeyNew(obj, evt,len)
	{
		var charCode = (evt.which) ? evt.which : event.keyCode;
		var value = obj.value;
		if (charCode > 31 && (charCode < 48 || charCode > 57))
		{
			alert("Enter only numeric values");
			return false;
		}
		if(value.length + 1 > parseInt(len) )			// ver 2.10 "+1" added
		{
			return false;
		}
			return true;
	}
	
	
	// ver 2.1 starts here
	// function allows to enter only alphanumeric values  
    function chkAlphaNumericValues(obj, evt)
    {
    	if ((evt.keyCode >= 48 && evt.keyCode <= 57) || (evt.keyCode >= 65 && evt.keyCode <= 90)  || (evt.keyCode >= 97 && evt.keyCode <= 122)) 
		{
			return true;
		}
		else
		{
			alert("Only Alpha Numeric values are allowed");
			return false;
		}
    }
	// ver 2.1 ends here
	//ver 2.3 starts
	function isDateLessThanEqualTo(startDate, endDate)			// version 2.5 Changed the name of function from compareDate to isDateLessThanEqualTo version 	
	{
		if(startDate == '' || endDate== '')
			return false;
			
				var reqDateArr = new Array();		
				startDateArr = startDate.split("-");		
				var lastDateArr  = endDate.split("-");
				var startDate, startMonth, startYear;
				var endDate, endMonth, endYear;
				startDate = startDateArr[0];	
				startMonth = getMonthNumber(startDateArr[1]);
				startYear = startDateArr[2];
				endDate = lastDateArr[0];
				endMonth = getMonthNumber(lastDateArr[1]);
				endYear = lastDateArr[2];
				if(parseInt(endYear) < parseInt(startYear))
				{
					return false;
				}
				else
				{
					if(parseInt(startYear) == parseInt(endYear))
					{
						if(parseInt(endMonth)<parseInt(startMonth) )
						{
							return false;
						}
						else
						{
							if(parseInt(startMonth) == parseInt(endMonth))
							{						
							if(parseInt(endDate)<=parseInt(startDate) ) // added = version 2.5
							{							
								return false;
							}
							else
							{							
								return true;
							}
						}
						else
						{
							return true;
						}
					}
				}
				else
				{
					return true;
				}
			}
		}
		
		//ver 2.3 ends
		
		//version 2.7 starts here (Following Functions are used to validate date period of two months)

var dateArray =new Array("28","29","30","31");	
function isDateIn(date)
 {		
	var flag = false;
	for(i = 0 ; i < dateArray.length; i++)
	{	
		if(parseInt(dateArray[i]) == parseInt(date)) 
		{
			flag = true;					
			break;
		}
	}	
	return flag;
 }
function dateCheck(date1,date2)
	{
	     
		  	var fromDate= date1;	
		  	var toDate	= date2;	
		  	var FDt		= fromDate.split("-");	
		  	var TDt		= toDate.split("-");
		  	date1 = fromDate.toUpperCase();		
		  	date1 = date1.split("-");	
		  	monthArray =new Array("TST","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");
		   	dayFromDate  = date1[0];	
		   	monFromDate  = date1[1];		
		  	yearFromDate = date1[2];		
		  	date2 = toDate.toUpperCase();		
		  	date2 = date2.split("-");	
		  	dayToDate  = date2[0];	
		  	monToDate  = date2[1];		
		  	yearToDate = date2[2];		
		   	var a, b;		
		  	for(i=1;i<13;i++)
		  	{
		  	  if (monFromDate == monthArray[i])
		  	    {			
		  	      a = i;
		  	       break;
		  		  }	
		 	} 
		  for(i=0;i<13;i++)
		  {		
		  	if (monToDate == monthArray[i])			
		  		{	
		  		   b = i;
		  		   break;
				}		
		  }  
		 
		  //calculated number of days between 
		  var d1		= new Date(FDt[2],a,FDt[0]);	
		  var d2		= new Date(TDt[2],b,TDt[0]);
		  var day		= 1000*60*60*24;
		  var diff	= Math.ceil((d2.getTime()-d1.getTime())/(day));
          if(diff<0)
          {
          	alert("Invalid dates are selected.");
		    return false;
          }		
		  else if(diff >62)
		  {
		  	alert("From date and to date difference should not be greater than 2 months");// Ver 2.37
		    return false;
		  }
		  else if(diff>=59 && diff <=62)
		  {
		  
			   var datToDate =(parseInt(dayToDate)+1)- parseInt(dayFromDate);
			   if(dayFromDate ==1 && isDateIn(dayToDate) == true)
			   {
			   	 return true;
			   }
			   else if(datToDate !=0)
			   {
			      alert("From date and to date difference should not be greater than 2 months");// Ver 2.37
			      return false;
			   }
			   else
			   {
			   	  return true;
			   }
		  }
		  return true;
	}
//version 2.7 ends here

	//version 2.11 starts here
	 function isDateLessThan(startDate, endDate)			
	{
	   
		if(startDate == '' || endDate== '')
			return false;
			
				var reqDateArr = new Array();		
				startDateArr = startDate.split("-");		
				var lastDateArr  = endDate.split("-");
				var startDate, startMonth, startYear;
				var endDate, endMonth, endYear;
				startDate = startDateArr[0];	
				startMonth = getMonthNumber(startDateArr[1]);
				startYear = startDateArr[2];
				endDate = lastDateArr[0];
				endMonth = getMonthNumber(lastDateArr[1]);
				endYear = lastDateArr[2];
				if(parseInt(endYear) < parseInt(startYear))
				{
					return false;
				}
				else
				{
					if(parseInt(startYear) == parseInt(endYear))
					{
						if(parseInt(endMonth)<parseInt(startMonth) )
						{
							return false;
						}
						else
						{
							if(parseInt(startMonth) == parseInt(endMonth))
							{						
							if(parseInt(endDate)<parseInt(startDate) ) 
							{							
								return false;
							}
							else
							{							
								return true;
							}
						}
						else
						{
							return true;
						}
					}
				}
				else
				{
					return true;
				}
			}
		}
	//version 2.11 ends here
// ver 2.12 starts here
function checkNumericDecimalValue(numberField,len)// function to allow only Numeric Values and restrict "." alone to Enter
	{
		var amt = numberField.value;
		var iChars = " 0123456789.";
		var flag = flagValue(iChars,amt);
		if (flag==false)
			{
				alert ("Please enter a valid number.");
				numberField.value="";
				numberField.focus();
				return false; // ver 2.23
			}
		else
			{
			  for (var i = 0; i < amt.length; i++)
				{
		  	      var parts= amt.split('.');
			   	  if (parts.length > 2) 
			  		{
						alert ("Please enter a valid number.");
						numberField.value="";
		  				numberField.focus();
		  				
						return false;
			  		}
				  if (iChars.indexOf(amt.charAt(i)) == -1)
	  		  		{
				  		alert ("Please enter a valid number.");
			  			numberField.value="";
			  			numberField.focus();
			  			
			  			return false;
  			  		}
  		   		  if (iChars.indexOf(amt.charAt(i)) == 11)
  		     		{
  		   	   			if (iChars.indexOf(amt.charAt(i+1))=="") 
  		         			{
				  		      alert("Please enter a valid number.");
				  		      numberField.value="";
				  			  numberField.focus();
				  			  
				  		      return false;
  		         			}
  		     		} 
  		  		  if (parts.length == 2 && parts[1].length >len)
  		    		{
  		      			alert("Enter only " +len+ " value after decimal");		
			  			numberField.value="";
			  			numberField.focus();
			  			
					  	return false;	
  					}		
  		  		}
  			}
  			return true; // ver 2.23
	 }

function isNumber(numberField)		// function to restrict 0 as Unique Id and and allows only numeric values
	 {
		var amt = numberField.value;
		if (amt==0) 
		{
		 if (amt!="")
		 {
			alert("Unique Id should not be 0");
			numberField.value="";
  			numberField.focus();
			return false;
		 }
		}
		var iChars = "0123456789";
		for (var i = 0; i < amt.length; i++)
		 {	
		 	
	  		if ((iChars.indexOf(amt.charAt(i)) == -1))
	  		{
  			alert ("Please enter a valid number.");
  			numberField.value="";
  			numberField.focus();
  			return false;
  			}
  		 }
	 }
	
function flagValue(iChars,amt)// function to return flag when entered value is not numeric
	{
		for (var i = 0; i < amt.length; i++)
		{
			if (iChars.indexOf(amt.charAt(i)) == -1)
	  		  	{
			  		return false;
  			  	}
		}
	}
// ver 2.12 ends here

// ver 2.22 starts here

function getDateAndTimeDifference(qid,startDateTime,stopDateTime,path) 
{  
   try
   {
   	inParams = startDateTime+ ","+ stopDateTime;
    setContextPath(path);
	getDetails_ajax(qid,inParams,null);
	var rowArr =  ajaxResponse.split("!");
	var colArr = rowArr[0].split("~");
	var serviceDuration = colArr[0];
	return serviceDuration;
   }
   catch(err)
   {
   alert("err----"+err);
   }
}
// ver 2.22 ends here
// ver 2.14 starts here
	
		// function used to calculate key code of numerics
		function CalcKeyCode(cCode)
		{			
			//if (cCode < 48 || cCode > 57 ) 
			var iChars = "0123456789";
			if(iChars.indexOf(cCode) != -1 )
			{
				return true;
			}
			else
				return false;
		}
// ver 2.14 ends here

// ver 2.15 starts here

	// function is used to check alpha numeric values
	function isAlphaNumericValue(alphanumericChar)
	{
		if((alphanumericChar).length == 0 || alphanumericChar.search(/[^a-zA-Z0-9 ]/g) != -1 )
		{
			return false;
		}
		else
			return true;
	}	
		
	
	// function is used to check numeric value and validate on length
		
	function numericLengthChk(obj, evt,len)
	{
		var charCode = (evt.which) ? evt.which : event.keyCode;
		var value = obj.value;
		if (charCode > 31 && (charCode < 48 || charCode > 57))
		{
			alert("Enter only numeric values");
			return false;
		}
		if(value.length > parseInt(len) )			// ver 2.10 "+1" added
		{
			return false;
		}
			return true;
	}
	// ver 2.15 ends here
	
	// ver 2.16 starts - Function validates number of characters entered in the textbox
	function checkLength(obj, charLength)
	{
		if(obj.value.length > charLength-1) 
		{
			alert('Only ' + charLength + ' characters allowed');
			obj.focus();
			return false;
		}
		else
			return true;
	}
	
// ver 2.16 ends here

// ver 2.44 starts - Function validates number of characters entered in the textbox
	function checkFieldLength(obj, charLength)
	{
		if(obj.value.length > charLength)
		{
			alert('Only ' + charLength + ' characters allowed');
			obj.value ="";   // ver 2.46 (for Geneva AR CR)
			obj.focus();
			return false;
		}
		else
			return true;
	}
	
// ver 2.44 ends here

//ver 2.18 starts here 
	 function validateDateForOnNet(commissionDate, comparisonDate)
	{	
		var commissionDateArr = new Array();
		commissionDateArr = commissionDate.split("-");		
		var comparisonDateArr = new Array();
		comparisonDateArr = comparisonDate.split("-");	
		var commissionDate, commissionMonth, commissionYear;
		var comparisonDate, comparisonMonth, comparisonYear;
		
		commissionDate = commissionDateArr[0];			
		commissionMonth = getMonthNumber(commissionDateArr[1]);	
		commissionYear = commissionDateArr[2];

		comparisonDate = comparisonDateArr[0];
		comparisonMonth = getMonthNumber(comparisonDateArr[1]);
		comparisonYear = comparisonDateArr[2];
		
		if(parseInt(commissionYear) > parseInt(comparisonYear))
		{			
			flag =  false;
		}
		else
		{
			
			if(parseInt(commissionYear) == parseInt(comparisonYear))
			{
				if(parseInt(commissionMonth) > parseInt(comparisonMonth))
				{								
					flag =  false;
				}
				else
				{
					if(parseInt(commissionMonth) == parseInt(comparisonMonth))
					{						
						if(parseInt(commissionDate) > parseInt(comparisonDate))
						{		
							
							flag = false;
						}
						else
						{														
							flag = true;
						}
					}
					else
					{						
						flag =  true;
					}
				}
			}
			else
			{	
				flag =  true;
			}
		}
		return flag;		
	}
function expandAll()
{
	var total=document.getElementById("totalRecords").value;
	for(val=0; val<total; val++)
	{
		document.getElementById("tbody"+val).style.display='';
		document.getElementById("collapse"+val).style.display='';
		document.getElementById("expand"+val).style.display='none';
	}
	return false;
}
function collapseAll()
{
	var totalVal=document.getElementById("totalRecords").value;
	for(val=0; val<totalVal; val++)
	{
		document.getElementById("tbody"+val).style.display='none';
		document.getElementById("collapse"+val).style.display='none';
		document.getElementById("expand"+val).style.display='';
	}
	return false;
}
//ver 2.18 ends here
// ver 2.17 starts here
function checkDateWithinOneYear(startDateArr,lastDateArr) 		// this function check whether the date falls within one year of existing date
{
    var startDate, startMonth, startYear;
	var endDate, endMonth, endYear;
	startDate = startDateArr[0];	
	startMonth = getMonthNumber(startDateArr[1]);
	startYear = startDateArr[2];
	endDate = lastDateArr[0];
	endMonth = getMonthNumber(lastDateArr[1]);
	endYear = lastDateArr[2];
	 if(((parseInt(startYear)-parseInt(endYear))>=2) || ((parseInt(endYear)-parseInt(startYear))>=2))
     	{
     		return false;
     	} 
     else 
      	{
          if (parseInt(startYear)-parseInt(endYear) == 1 )
            	{
            		if (parseInt(startMonth)>parseInt(endMonth))
         				{ 
         		   			return false;
           				}	
           			if (parseInt(startMonth) < parseInt(endMonth))
           				{
           					return true;
           				} 
                    if (parseInt(startMonth)==parseInt(endMonth))
           		     	{	 
           		     		if ( parseInt(startDate) > parseInt(endDate) )
           	       				{	
             						return false;
       							}
      							          				 		 
           			 		else
      				     		{
      				  				return true;
                  	      		}
                      	}
                			
           		}
           	else 
           		  {
           			  if (parseInt(startYear)==parseInt(endYear))
           			   		{
 								if (parseInt(startMonth)>parseInt(endMonth))
           			   		 		{
           			    				return true;
           			    	 		}
           			     		if (parseInt(startMonth)==parseInt(endMonth))
           			     			{
                			       		if (parseInt(startDate) >= parseInt(endDate))
           			       					{
           			       						return true;
           			       					}
           			       				else 
           			       					{
           	        			       			return false;
           			       					}
           			     			}
           			     		else 
           			     			{
           								return false;
           							}   
              				}
              		}
   		
   		} 
}

// this function returns Commissioning date,Price Revision Date and PO End date
function getDates(qid,customerId,productSeq,flag,path) 
{  
	inParams = customerId+ ","+ productSeq+ ","+flag;
   	setContextPath(path);
	getDetails_ajax(qid,inParams,null);
	var rowArr =  ajaxResponse.split("!");
	var colArr = rowArr[0].split("~");
	var priceRevisionDate = colArr[0];
	return priceRevisionDate;
}

// ver 2.17 ends here 

// ver 2.19 starts here
function getDateFlag(startDateArr,lastDateArr) 		
{
    var startDate, startMonth, startYear;
	var endDate, endMonth, endYear;
	startDate = startDateArr[0];	
	startMonth = getMonthNumber(startDateArr[1]);
	startYear = startDateArr[2];
	endDate = lastDateArr[0];
	endMonth = getMonthNumber(lastDateArr[1]);
	endYear = lastDateArr[2];
	 if(((parseInt(startYear)-parseInt(endYear))>=2) || ((parseInt(endYear)-parseInt(startYear))>=2))
     	{
     		return false;
     	} 
     else 
      	{
          if (parseInt(startYear)-parseInt(endYear) == 1 )
            	{
       	      		if (parseInt(startMonth)>parseInt(endMonth))
         				{
         		   			return false;
           				}	
           			if (parseInt(startMonth) < parseInt(endMonth))
           				{
           					return true;
           				} 
                    if (parseInt(startMonth)==parseInt(endMonth))
           		     	{		
           	       			if (parseInt(startDate) > parseInt(endDate))
             					{				 		
       								return false;
       							}
      							          				 		 
           			 		else
      				     		 {
        				     		return true;
                  	      		 }
                      	}
                			
           		}
           	else 
           		  {
           			  if (parseInt(startYear)==parseInt(endYear))
           			   		{
 								if (parseInt(startMonth)>parseInt(endMonth))
           			   		 		{
           			    				return true;
           			    	 		}
           			     		if (parseInt(startMonth)==parseInt(endMonth))
           			     			{
                			       		if (parseInt(startDate) >= parseInt(endDate))
           			       					{
           			       						return true;
           			       					}
           			       				else 
           			       					{
           	        			       			return false;
           			       					}
           			     			}
           			     		else 
           			     			{
           								return false;
           							}   
              				}
              		}
   		
   		} 
}

function getPODateFlag(startDateArr,poEndDateArr)
	{
	var startDate, startMonth, startYear;
	var endDate, endMonth, endYear;
	var poEndDate,poEndMonth,poEndYear;
	startDate = startDateArr[0];	
	startMonth = getMonthNumber(startDateArr[1]);
	startYear = startDateArr[2];
	poEndDate = poEndDateArr[0];
	poEndMonth = getMonthNumber(poEndDateArr[1]);
	poEndYear = poEndDateArr[2];
	
	if(parseInt(startYear) < parseInt(poEndYear))
		{
		  return true;
		}
	else
		{
			if(parseInt(startYear) == parseInt(poEndYear))
				{
				   if(parseInt(startMonth) < parseInt(poEndMonth))
					  {	
					    return true;
					  }
					else
					  {
						if(parseInt(startMonth) == parseInt(poEndMonth))
						    {						
							  if(parseInt(startDate) < parseInt(poEndDate))
							      {							
									return true;
							      }
							  else
							      {							
								    return false;
							      }
						    }
						else
							{
								return false;
							}
					  }
				}
			else
				{
				   return false;
				}
		}
		
	}		

// ver 2.19 ends here

// ver 2.23 starts here
// function to allow only Numeric Values ,restrict "." alone to Enter and Only 40 Characters can be entered
function checkNumericDecimalValueLength(numberField,len)
{
	var flag = checkNumericDecimalValue(numberField,len);
	var value=numberField.value;
	if(flag== false)
	{
		return false;
	}
	else
	{
	     if (value.length>40)
	     {
			alert("Only 40 characters are allowed");
			numberField.value="";
			numberField.focus();
			return false;
		 }
	}
}
// ver 2.23 ends here	 
// ver 2.24 starts here
   function validate(formname,fieldList)
     {  
        for(var i=0;i<fieldList.length	;i++)
        { 
          var obj = eval('document.'+formname+'.elements[\''+fieldList[i]+'\']'); 
          if(obj.type=='text' || obj.type=='password')//ver 2.27 added //added by Soumya for password fields
	         obj.value=trimVal(obj.value);//ver 2.27 added            
	          if(trimVal(obj.value)=='')
	          {  
	             var type='';
	             if(obj.type=='text'||obj.type=='textarea' ||obj.type=='password') //ver 2.51 added obj.type=='textarea'
	                type='enter';
	             else if(obj.type=='select-one'||obj.type=='select-multiple')
	                type='select';
                 else if(obj.type=='file') 
           			type='upload';  
	             var title = obj.title;
	             alert('Please '+type+' '+title);
	             obj.focus();
	             return false;
	          }
        }
        return true;       
     }

          
     function isValidEmail(emailObj) 
         {
		    
			if(emailObj.value!='')
			  {
					//var myRegExp = /^([\w]+)(\.[\w]+)*@([\w\-]+)(\.[\w]{2,7})(\.[a-z]{2})?$/i;//ver 2.28 commented
					var myRegExp = /^([a-zA-Z0-9]+)([\.|_]?[a-zA-Z0-9]*)@([a-zA-Z0-9\-]+)(\.[a-zA-Z0-9]{2,7})(\.[a-z]{2})?$/i;// ver 2.28 added
					if((trimVal(emailObj.value)!='')&&(myRegExp.test(emailObj.value)))
					   {
					       // ver 2.28 starts here
					       var val =  emailObj.value;
						   if(val.search(/([@]{1}[-]{1})|([-]{1}[.]{1})|([-]{2})/)!=-1)
						     {
						       alert('Please enter proper Email Address');
							   emailObj.value='';
							   emailObj.focus();
							   return false;
						     }
						    // ver 2.28 ends here 
						   return true;
					   }
					   else
					   {
						   alert('Please enter proper Email Address');
						   emailObj.value='';
						   emailObj.focus();
						   return false;
						   
					   }	
				}
				else
				{
					return true;
				}
		
		}
	// this function can be used for validating telephone,mobile,extension and fax number
	//input parameters are object which is to be validated and type whether it is mobile,fax,ext or tel  
	// ver 2.27 starts here---completely replaced by new code
     function validateTelNo(telObject,type)
		{
			var myRegxp =''; 			
			var text = trimVal(telObject.value);
			telObject.value = text;// added to resolve bug (bugzilla defect id 4712)
			var strAppend = '';
			if(type=='mobile')
			  {
			     
			     myRegxp = /^([0-9\+]+)$/; 
			     strAppend+='Only numbers and (+) are allowed.';
			  }
			else if(type=='extension')
			  {  
			     myRegxp = /^[0-9\/]+$/; 
			     strAppend+='Only numbers and (/) are allowed.';
			  }	
			else if(type=='fax')
			  {
			     myRegxp = /^([0-9\-\+]+)$/;
			     strAppend+='Only numbers,(+) and (-) are allowed.';			      
			  }  
			else 
			  { 
			     myRegxp = /^([0-9\-\+]+)$/;
			     strAppend+='Only numbers,(+) and (-) are allowed.';			      
			  }   	
			 if(text!='')
			  {
					if(trimVal(text)!='')
					{
							if(myRegxp.test(text)==false) 
							{  
								alert('Please enter proper '+ telObject.title +' number.\n'+strAppend);
								telObject.value='';
								telObject.focus();
								return false;
							}
							else
						   {
						      if(type=='extension')
							       {
							          var format1 = /^[/]+|[/]+$/;
							          var format2 = /[/]{2}/;
							            if(format2.test(text)==true)
							              {
							                 alert('Please enter in proper format.\nForward slash (/) cannot be continuously repeated.');// ver 2.28 edited the alert message
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              }
							              if(format1.test(text)==true)
							              {
							                 alert('Forward slash (/) is not allowed in first and last position.');
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              } 
							       }
						       else if(type=='telephone'|type=='fax')
							       {
							          var format3 = /[-]{2}/;
							          var format4 = /^([+]?[0-9\-]+)$/;
							          var format5 = /^[-]+|[-]+$/;
							          var format7 = /^[+]+[-]+[0-9]*$/;
							            if(format3.test(text)==true)
							              {
							                 alert('Please enter in proper format.\nHyphen (-) cannot be continuously repeated.');// ver 2.28 edited the alert message
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              } 
							             if(format4.test(text)==false)
							              {
							                 alert('Please enter in proper format.\nPlus (+) is allowed only once at the First positon with numbers.');
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              } 
							              if(format5.test(text)==true)
							              {
							                 alert('Hyphen (-) is not allowed in first and last position.');
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              }	
							              if(format7.test(text)==true)
							              {
							                 alert('Hyphen (-) is not allowed in this position.');
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              }
							              
							       }
						       else if(type='mobile')
							       {
							          var format6 = /^([+]?[0-9]+)$/;
							             if(format6.test(text)==false)
							              {
							                 alert('Please enter in proper format.\nPlus (+) is allowed only once at the First position with numbers.');
							                 telObject.value='';
											 telObject.focus();
											 return false;
							              } 
							        
							       } 					
							return true;
						   }
					 }
					 else
					 {				    
						telObject.value='';
						telObject.focus();
						return false;
					 }
              }
			  else
			  {
				 return true;
			  }

		}
		// ver 2.27 ends here
	 	
// ver 2.24 ends here

// 2.25 starts here
// function to allow only Numeric Values ,restrict "." alone to Enter and to restrict amount to 'length' and upto 'decimalLen' decimal places
function amountCheckLength(amountField,length,decimalLen)
 {
   	var amountFieldFlag = checkNumericDecimalValue(amountField,decimalLen);
	var amountValue = amountField.value;
	var totalLength=length+decimalLen+1;
	if (amountFieldFlag==false)
		{
			return false;
		}
	else
		{
		  if (amountValue.length > totalLength)
			  {
			   alert("Only " +totalLength+ " characters are allowed");
			   amountField.value="";
			   amountField.focus();
			   return false;
			  } 
		}
		return true;
 }
// 2.25 ends here
//version 2.26 starts here
		 
//This function gets tariffId based on the Tariff Name and Account Number
function getTariffIdFromTariffName(tariff,accountNum,path)
{
		
		var queryId  = 'parallelUpgrade.getTariffId';
		var inParameter = tariff+","+accountNum;
		var tariffId="";
		setContextPath(path);
		getDetails_ajax(queryId,inParameter, null);
						
		if(ajaxResponse !=null && ajaxResponse!="")
		{
			var temp = ajaxResponse.split('!');
			var rowValue = temp[0].split('~');
			tariffId = rowValue[0];
		}
		
		
		return tariffId;		
}
//version 2.26 ends here
// ver 2.27 starts here
 function validateNameField(obj)
	{
	   str=trimVal(obj.value);
	   var format = /^([\w\'\s\.{1}\-]*)$/;
	   var format0 = /^[-]+|[-]+$/
	   var format1 = /^[']+|[']+$/;
	   // commented for ver 2.27var format2 = /[']{2}|([']+[\s|\.]+[']+)|[.]{2}|([.]+[\s|\']+[.]+)|([']+[\.]+)|([.]+[\']+)/;
	   // ver 2.27 starts here
	   // removed var format3,format4 & format5 for resolving bug (bugzilla defect id 4712 & 4713)	   
	   var format6 = /^[.]+|[.]+$/;//added for resolving bug (bugzilla defect id 4712 & 4713)
	   // ver 2.27 ends here
	   str = str.replace(/[\s]{2,}/g,' ');
	   if(str!='')
	   {
		   if(format.test(str))
		    {	      
		        for(var i=0;i<str.length;i++)
			     { 
			       if(str.charAt(i)=='_')
			        {
			          alert('No other characters except alphanumerics,(.),(-) and (\') are allowed.');
				      obj.value='';
				      obj.focus();
				      return false;
			        }
			      }  
		       
		       if(format1.test(str))
		        {
		          alert('Symbol (\') is not allowed in first and last position');
		          obj.value='';
	     	      obj.focus();
	     	      return false;
		        }
		        if(format0.test(str))
		        {
		          alert('Hyphen (-) is not allowed in first and last position');
		          obj.value='';
	     	      obj.focus();
	     	      return false;
		        }
		        //block starts---- added for resolving bug (bugzilla defect id=4712,4713) 
		        // removed the above 3 if conditions used for bugzilla defect code 4501     
                if(format6.test(str))
		        {
		          alert('Symbol (.) is not allowed in first and last position');
		          obj.value='';
	     	      obj.focus();
	     	      return false;
		        }
		        if(str.search(/([-.']+[\s]?[-.']+)/)!=-1)
		        {
		          alert('Symbols (.),(\') and (-) should not occur adjacently or repeat continuously');
		          obj.value='';
	     	      obj.focus();
	     	      return false;
		        }
		        // block ends for resolving bug (bugzilla defect id=4712,4713)	        	        
		    }
		   else
		    {
		      alert('No other characters except alphanumerics,(.),(-) and (\') are allowed.');
		      obj.value='';
		      obj.focus();
		      return false;
		    }
		     
		   obj.value = changeInitCap(str);  // ver 2.33 added function  changeInitCap()
		}  
		else
		{
		  obj.value='';
	      return false;
		}  
	}
 
// ver 2.27 ends here
// ver 2.29 starts here
// this function validates the price entered
function isValidPrice(objectField)
 {
    var format = /^[0-9 \.]+$/
    var format1 = /^[0-9]+(\.[0-9]{1,2})?$/
    var format2 = /^[\.]+|[\.]+$/
    var objValue = trimVal(objectField.value);
    objValue = objValue.replace(/[\s]+/g,'');
    objValue = objValue.replace(/^[0]+/g,'0');
    objectField.value = objValue;
    objectField.value = objValue;
    if(objValue=='')
      return true;
     if(format.test(objValue)==false)
      {
         alert('Please enter only numbers');
         objectField.value='';
         objectField.focus();
         return false;
      }
      if(format2.test(objValue)==true)
      {
         alert('Special Character (.) is not allowed in First and Last Position');
         objectField.value='';
         objectField.focus();
         return false;
      }
     if(format1.test(objValue)==false)
      {
         alert('Numbers with decimals more than 2 digits\nAnd Numbers with more than 1 decimal points are not allowed.');
         objectField.value='';
         objectField.focus();
         return false;
      }
      return true;
 } 
// ver 2.29 ends here
//ver 2.30 starts here
 function validateCustomerName(obj,event,mode)
  { 
     var strValue = trimVal(obj.value);
     var format0 = /^[a-zA-Z]{3}/;
     var format = /^[\w\s]$/;
     var format1 = /^[a-zA-Z]$/;
     var format2 = /^[%+]/;
     obj.value = strValue;
     var strOut = '';
     if(strValue=='')
      return false;
      if (format0.test(strValue)==false && event=='submit' && mode=='parent')
      {
         alert('First three characters of '+obj.title+' should be alphabets');
         obj.value='';
	     obj.focus();
	     return false;
      } 
      
      if (format2.test(strValue))
      {
         alert('Symbol (%) and (+) are not allowed in first position');
         obj.value='';
	     obj.focus();
	     return false;
      } 
      
     if(strValue.search(/[~]+|[,]|["]+/g)>-1)  
      {
        alert('Special Characters (~),(") and (,) are not allowed');      
        obj.value='';
        obj.focus();
        return false;
      } 
      if(event=='onblur' && mode=='child' && strValue.search(/[a-zA-Z]/g)==-1)
       {
         alert('There should be atleast one alphabet');
         obj.value='';
	     obj.focus();
	     return false;
       }
       
       return true; 
  }
 //ver 2.30 ends here
 
 // ver 2.31 starts here
 function  selectAll(field, checkedType)
	{
	
		  	if(field[0] == null)
			field.checked = checkedType;
			else
			{
				for (i = 0; i < field.length; i++)
					field[i].checked = checkedType ;
			}
	}
 // ver 2.31 ends here
 
// ver 2.32 starts here
  function trimVal(strValue)
     {
		var trimmed = strValue.replace(/^\s+|\s+$/g, '') ;
	 	return trimmed;
     }
  
 function validateZipCode(zipObject)
		{
			var myRegxp = /^([\w\-\s]*)$/;
			var regExp1 = /^[-]+|[-]+$/; 
			var regExp2 =/[-]+[\s]?[-]+/;
			var text = zipObject.value;	
			
			text = trimVal(text);
			text = text.replace(/[\s]{2,}/g,' ');
			zipObject.value = text;		
			
			 if(text!='')
			 {
				if(text.length<=16 & trimVal(text)!='')
				{
						if(myRegxp.test(text)==false) 
						{  							
							alert('Please enter proper '+ zipObject.title +' number.\nNo special characters allowed except hyphen(-).');
							zipObject.value='';
							zipObject.focus();
							return false;
							
						}
						else
					   {
					     for(var i=0;i<text.length;i++)
					     { 
					       if(text.charAt(i)=='_')
					        {
					            alert('Please enter proper '+ zipObject.title +' number.\nNo special characters allowed except hyphen(-).');
								zipObject.value='';
								zipObject.focus();
								return false;
					        }
					     }
					    
					     if(regExp1.test(text)==true) 
						  {  							
							alert('Please enter proper '+ zipObject.title +' number.\nHyphen (-) is not allowed in first and last position.');
							zipObject.value='';
							zipObject.focus();
							return false;							
						  }
						  if(text.search(regExp2)!=-1) 
						  {  							
							alert('Please enter proper '+ zipObject.title +' number.\nHyphen (-) cannot be continuously repeated.');
							zipObject.value='';
							zipObject.focus();
							return false;							
						  }
						
					     				
						return true;
					   }
				 }
				 else
				 {
					if(text.length>16)
					  alert('Please enter proper '+ zipObject.title +' number.\nZipCode should not exceed 16 digits.'); 
					  else
					  alert('Please enter proper '+ zipObject.title +' number'); 
					zipObject.value='';
					zipObject.focus();
					return false;
				 }
              }
			  else
			  {
				 return true;
			  }

		}	
 //ver 2.32 ends here
    // ver 2.33 starts here	
 function changeInitCap(customerName){
       	var temp=customerName.split(" ");
		count=temp.length;
		for(i=0;i<temp.length;i++)
		{
			temp[i]=temp[i].charAt(0).toUpperCase()+ temp[i].substring(1).toLowerCase();
		}
		customerName=temp[0];
		for(i=1;i<temp.length;i++)
		{
			customerName=customerName+" ";
			customerName=customerName+temp[i];
		} 
		
       return customerName;

 }
 // ver 2.33 ends here
 
 // ver 2.34 starts here
 function validateContractDuration(numberFeild)
{
	var amt = numberFeild.value;
	var iChars = "0123456789";
		for (var i = 0; i < amt.length; i++)
		{
	  		if (iChars.indexOf(amt.charAt(i)) == -1)
	  		{
  			alert ("Please enter only numeric values for Contract Duration.");
  			numberFeild.value="";
  			numberFeild.focus();
  			return false;
  			}
  		}
}
 // ver 2.34 ends here
 // ver 2.35 starts here
 function trimDoubleQuotes(fieldObject)
  {
    var objectValue = fieldObject.value;
    objectValue = trimVal(objectValue);
    objectValue = objectValue.replace(/^[\\\\"\s]+|[\\\\"\s]+$/g,'');
    fieldObject.value=objectValue;    
  }
 // ver 2.35 ends here
 // ver 2.36 changes starts here
 var custNameObj,custRefObj,custAccCodeObj;
 
 function getCustNameRefAccCodePopup(type, source) {
	
	 var searchType = "";
	 var qid = "";
	 var searchStr = "";
	 
	 var cName = "";
	 var cRef = "";
	 var cAccCode = "";
	 
	 var genPopup = false;
	 
	 if (source == "createCustomer") {
		 cName = trimVal(document.getElementById('custName').value);
		 cAccCode = trimVal(document.getElementById('accountingCode').value);
	 } else if (source == "cancelOrder" || source == "changeProductPrice" || source == "terminateProduct") {
		
		 cName = trimVal(document.getElementById('P_CUSTOMER_NAME').value);
		 cRef = trimVal(document.getElementById('P_CUSTOMER_REF').value);
		 cAccCode = trimVal(document.getElementById('accountingCode').value);
	 } else if (source == "createProduct" || source == "changeBillingAddress" || source == "prodcutCommissioning"
		 || source == "collections" || source == "paymentAllocation" || source == "reverseAllocation") {
		 cName = trimVal(document.getElementById('custName').value);
		 cRef = trimVal(document.getElementById('custRef').value);
		 cAccCode = trimVal(document.getElementById('accountingCode').value);
	 } else if (source == "rateOverride" || source == "updateProductDetails") {
		 cName = trimVal(document.getElementById('customerName').value);
		 cRef = trimVal(document.getElementById('customerRefNo').value);
		 cAccCode = trimVal(document.getElementById('accountingCode').value);
	 } else {
		 if (source == "updateCustDetails") {
			 cName = trimVal(document.getElementById('custName').value);
			 cRef = trimVal(document.getElementById('customerRefNo').value);
		 } else if (source == "demandNoteRequest") {
			
			 cName = trimVal(document.getElementById('P_CUSTOMER_NAME').value);
			 cRef = trimVal(document.getElementById('P_CUSTOMER_REF').value);
		 }else if (source == "tdsEntry") {
			
			 cName = trimVal(document.getElementById('CUSTOMER_NAME').value);
			 cRef = trimVal(document.getElementById('CUSTOMER_REF').value);
		 }
		 else {
			
			 cName = trimVal(document.getElementById('customerName').value);
			 cRef = trimVal(document.getElementById('customerRef').value);
		 }
		 cAccCode = trimVal(document.getElementById('accountingCode').value);
	 }
	// alert(cName.length+ " = "+cRef.length+" : "+cAccCode.length+" l:"+cAccCode.length);
	// alert(type + " : "+cRef + " : "+custRefObj);

	 // ver 2.41 changes starts here
	 /*if (type == "name" && cName == "") {
		 alert("Please Enter Customer Name");
	 } else if (type == "refNo" && cRef == "") {
		 alert("Please Enter Customer Ref");
	 } else if (type == "accCode" && cAccCode == "") {
		 alert("Please Enter Accounting Code");
	 } else if (type == "name" && cName == "" &&  custNameObj != null) {
		 alert("Please Enter Customer Name");
	 } else if (type == "refNo" && cRef == "" && custRefObj != null) {
		 alert("Please Enter Customer Ref");
	 } else if (type == "accCode" && cAccCode == "" && custAccCodeObj != null) {
		 alert("Please Enter Accounting Code");
	 } else {*/
	 
	 // ver 2.41 changes ends
		 if (cName == "" && cRef == "" && cAccCode == "" && source != "createCustomer") {
			alert("Please Provide Customer Name or Customer Ref or Accounting Code");
			//document.getElementById('customerName').focus();
			genPopup = false;
		
		} else if(cName == "" && cAccCode == "" && source == "createCustomer"){
			alert("Please Enter Accoutning Code");
			//document.getElementById('custName').focus();
			genPopup = false;
		
		} else if (cName != "" && cRef == "" && cAccCode == "" ) {
			// searchType = custNameObj.value;
			 qid = "customerSearchPopup_name";
			 searchStr = cName;
			 genPopup = true;
		
		} else if (cRef != "" && cName == "" && cAccCode == "" ) {
			 //searchType = custRefObj.value;
			 qid = "customerSearchPopup_refNo";
			 searchStr = cRef;
			 genPopup = true;
		
		} else if (cAccCode != "" && cName == "" && cRef == "" ) {
			 //searchType = custAccCodeObj.value;
			 qid = "customerSearchPopup_accCode";
			 searchStr = cAccCode;
			 genPopup = true;
			
		} else if (cName != "" && cRef != "" && cAccCode == "" ) {
			 //searchType = custNameObj.value;
			 qid = "customerSearchPopup_name_refNo";
			 searchStr = cName+","+cRef+"";
			 genPopup = true;
			
		} else if (cName != "" && cAccCode != "" && cRef == "" && source != "createCustomer") {
			 //searchType = custRefObj.value;
			 qid = "customerSearchPopup_name_accCode";
			 searchStr = cName+","+cAccCode;
			 genPopup = true;
			
		} else if (cName != "" && cAccCode != ""  && source == "createCustomer" ) {
			 //searchType = custRefObj.value;
			 qid = "customerSearchPopup_name_refNo";
			 searchStr = cName+","+cAccCode;
			 genPopup = true;
			
		} else if (cRef != "" && cAccCode != "" && cName == "") {
			 //searchType = custAccCodeObj.value;
			 qid = "customerSearchPopup_refNo_accCode";
			 searchStr = cRef+","+cAccCode;
			 genPopup = true;
			
		} else if (cName != "" && cRef != "" && cAccCode !="") {
			 //searchType = custAccCodeObj.value;
			 qid = "customerSearchPopup_name_refNo_accCode";
			 searchStr = cName+","+cRef+","+cAccCode;
			 genPopup = true;
			
		} 
	 

	// alert(qid+" : "+searchStr);
		 if (genPopup) {
			 //var strURL = "pages/popups/vsnlPopup.jsp?source="+source+"&qid="+qid+"&searchString="+searchStr+"&searchType="+searchType;
			 var strURL = "pages/popups/vsnlPopup.jsp?source="+source+"&qid="+qid+"&searchString="+searchStr;
			 if (source == "cancelOrder" || source == "changeProductPrice" || source == "terminateProduct") {
				 strURL = "../popups/vsnlPopup.jsp?source="+source+"&qid="+qid+"&searchString="+searchStr;
			 
			 }
			 else if(source=="demandNoteRequest"||source=="tdsEntry")
			 {
			   strURL = "../pages/popups/vsnlPopup.jsp?source="+source+"&qid="+qid+"&searchString="+searchStr;
			 }
			 
			 var myWindow= window.open(strURL,"mywin","left=20,top=20,width=550, height=500, toolbar=0 ,statusbar=true, resizable=1,scrollbars=1");
			 myWindow.focus();
		 }
	// 	} end of else  // commented by ver 2.41
 }

function setObject(obj, sname) {
	if(sname == "name") {
			custNameObj = obj;
	} else if (sname == "refNo") {
		custRefObj = obj;
	} else if (sname == "accCode") {
		custAccCodeObj = obj;
	}
}

// ver 2.36 changes ends
// ver 2.38 starts here
// this function is used to validate in a customized way
// in params : dataField,no. of digits before decimal,no. of digits after decimal
function isValidNumber(objectField,beforeDecLength,decimalLength,msg)  // ver 2.46 one param added
 {
 // ver 2.46 starts here 
 	if(msg == undefined)
 	{
 		msg = "";
 	}
 	// ver 2.46 ends here
    var format = /^[0-9 \.]+$/
    var format1 = eval('/^[0-9]+(\.[0-9]{0,'+decimalLength+'})?$/');// ver 2.47 changed decimal minimum length to 0 from 1
    var format2 = /^[\.]+|[\.]+$/
    var objValue = trimVal(objectField.value);
    objValue = objValue.replace(/[\s]+/g,'');
    objValue = objValue.replace(/^[0]+/g,'0');
    objectField.value = objValue;    
    if(objValue=='')
      return true;
     if(format.test(objValue)==false)
      {
         alert('Please enter only numbers');
         objectField.value='0';  // ver 2.46 '0' added
         objectField.focus();
         return false;
      }
      if(format2.test(objValue)==true)
      {
         alert('Special Character (.) is not allowed in First and Last Position');
         objectField.value='0'; // ver 2.46 '0' added
         objectField.focus();
         return false;
      }
     if(format1.test(objValue)==false)
      {
      //	alert('Numbers with decimals more than 2 digits\nAnd Numbers with more than 1 decimal points are not allowed.');commented for ver 2.46
      	// ver 2.46 starts here(if -else condition added)
      	if(msg == "")
      	{
      		alert('Numbers with decimals more than '+decimalLength+' digits\nAnd invalid numbers with more than 1 decimal point are not allowed.');// ver 2.47 added decimallength to make the message generic     		
      	}
      	else
      	{
      		alert(msg);
      	}
        // ver 2.46 ends here
         objectField.value='0'; // ver 2.46 '0' added
         objectField.focus();
         return false;
      }
      var beforeDecimal = objValue;
      var msgPrefix = 'Number';      
      if(objValue.search(/\./g)!=-1)
       {
	       beforeDecimal = objValue.substring(0,objValue.indexOf('.'));
	       msgPrefix = 'Number before decimal';
       }
      if(beforeDecimal.length>beforeDecLength)
      {
         alert(msgPrefix+' should not exceed '+beforeDecLength+' digits.');
         objectField.value='0'; // ver 2.46 '0' added
         objectField.focus();
         return false;
      }
      return true;
 }
 // ver 2.38 ends here
 
 
 
 // ver 2.39 starts here
 
 // The function checks wether the field is numeric integer or not
 function checkForNumericValues(field)
 {
 		var flag= true;
 		var iChars = "0123456789";
		for (var i = 0; i < field.length; i++)
		{
	  		if (iChars.indexOf(field.charAt(i)) == -1)
	  		{
  			  flag=false;
  			}
  			
  		}
  		
  		return flag;
 }
 
 // This function removes zeros on the left side of a number.
 function validateLeftZeroValues(fieldValue)
 {
 	 while (fieldValue.substr(0,1) == '0' && fieldValue.length>1)
 	  { 
 	  	fieldValue = fieldValue.substr(1,9999);
 	  }
 	  
 	  return fieldValue;
 }
 
 
 // ver 2.39 ends here
 //ver 2.40 starts here
 function isAlphaNumericSpecial(val)
{
  var name = trimVal(val.value);
  val.value=name;
   		
   var format = /^[A-Za-z0-9\s.\'-]+$/;
   if(name!='' && !format.test(name))
     {
        alert('Only alphanumeric values and special characters hyphen, dot, apostrophes and space  are allowed');
        val.value='';
    	val.focus();
        return false;
     }	
   else
     {
        return true;
     }  	
}
 //ver 2.40 ends here
 
 // ver 2.42 starts here
 // This function is used to validate the product id exist into the array list or not
	function isProductIdPresent(pid,productIdList)
	{		 	
		var flag = false;
		for(i = 0 ; i < productIdList.length; i++)
		{	
			if(parseInt(productIdList[i]) == parseInt(pid)) 
			{
				flag = true;					
				break;
			}	
		}
		return flag;
	}
// ver 2.42 ends here


// ver 2.45 starts here
// This function is used to validate the extension of uploaded file
	function validateUploadedFile(lowercaseType,upperCaseType,filePath)
	{
		if(filePath!="")
		{
		  var fileExt=filePath.split(".");
		  var fileExtension=fileExt[fileExt.length-1];
		  if(fileExtension==lowercaseType || fileExtension==upperCaseType)
			{	
				return true;
			}
			else
			{
		    	
				alert("."+fileExtension+ ' extension file is not allowed. Upload a '+lowercaseType+' file');
				return false;				
			}
		}
	   	else
	   	 {
			alert("Please select a file to upload");
			return false;
		  }
	} 
	// ver 2.45 ends here
	// ver 2.47 starts here
	function validateMultipleDiv(formname,fieldList,divName,index)
     {  
        for(var i=0;i<fieldList.length	;i++)
        { 
         
          var obj = eval('document.'+formname+'.elements[\''+fieldList[i]+'\']');  
          if(obj.type=='text')
	         obj.value=trimVal(obj.value);
	          if(trimVal(obj.value)=='')
	          {  
	             var type='';
	             if(obj.type=='text'||obj.type=='hidden') 
	                type='enter';
	             else if(obj.type=='select-one'||obj.type=='select-multiple')
	                type='select';

	             var title = obj.title;
	             showPage(divName,index);
	             alert('Please '+type+' '+title);	             
	             if(obj.type!='hidden')
	             obj.focus();
	             return false;
	          }
        }
        return true;       
     }
     function resetForm(fieldList,formname)
     {
	      for(var i=0;i<fieldList.length;i++)
	        {          
	          var obj = eval('document.'+formname+'.elements[\''+fieldList[i]+'\']');  
	          obj.value='';
	        }
     }
   // ver 2.47 ends here
   
   // ver 2.48 starts here 
    function checkAlphaNumeric(obj)
	 {
       obj.value=obj.value.replace(/[\s]+/g,'');
       if(obj.value=='')
        return false;
       if(!isAlphaNumericValue(obj.value))
        {
	          alert('Please enter Alphanumeric value');
	          obj.value=''
	          obj.focus();
	          return false;
        }
        return true;
	}
   // ver 2.48 ends here
   
   // ver 2.49 starts here
   
	function isAlphaNumericWithUnderScore(alphanumericChar)
	{
	    if(alphanumericChar.search(/[^a-zA-Z0-9_]/g) != -1)
		{			
			return false;
		}
		else
			return true;
	}
   
   // ver 2.49 ends here
   // ver 2.50 starts here
   function getCurrentDate()
   {
      var currentDate = new Date();
	  var curr_date = currentDate.getDate();
	  var m_names = new Array("Jan", "Feb", "Mar","Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec");
	  var curr_month = currentDate.getMonth();
	  var curr_year = currentDate.getFullYear();
	  var currDate = curr_date + "-" + m_names[curr_month]+ "-" + curr_year;
	  return currDate;
   }
   // ver 2.50 ends here
//ver 2.51 starts here   
  /**
	 This is generic function for disable form fields  
	input:list=List of  form fieds which needs to be disabled
	formName=Form Name
	
	*/
   function disableForm(formname,fieldList)
     {  
        for(var i=0;i<fieldList.length;i++)
        { 
          var obj = eval('document.'+formname+'.elements[\''+fieldList[i]+'\']'); 
         if(obj.type=='text'||obj.type=='textarea') 
	       {
	        obj.readOnly=true;
	        obj.className='disabledformtext'
	       }
	       else if(obj.type=='select-one'||obj.type=='select-multiple')
	       { 
	        obj.disabled=true;
	        obj.className='disabledformtext'
	       }
        }
     }
      /**
	 This is generic function for enable form fields  
	input:list=List of  form fieds which needs to be enabled
	formName=Form Name
	
	*/
     function enableForm(formname,fieldList)
     {  
     
       for(var i=0;i<fieldList.length;i++)
       { 
       
        var obj = eval('document.'+formname+'.elements[\''+fieldList[i]+'\']'); 
       
        if(obj.type=='text'||obj.type=='textarea') 
	     {
	      obj.readOnly=false;
	      obj.className='formtext'
	     }
	     else if(obj.type=='select-one'||obj.type=='select-multiple')
	     { 
	       obj.disabled=false;
	      obj.className='formtext'
	     }
       }
    }
    /**
	 This is generic function for reseting dropDown to select
	input:list=List of dropdown form fieds which needs to be reset down
	formName=Form Name
	
	*/
    function resetDropdown(list,formName)
	{
	  for(var i=0;i<list.length;i++)
	   {
	   	  removeAllOptions(document.getElementById(list[i]),1);
	   }
	}
    
   
    //ver 2.51 ends here
    
    //ver 2.52 starts here
    
    // The function will check whether the field is alphanumeric or not.
	function checkAlphanumeric(obj,val)
	{				 
		var fieldValue=trimAll(obj.value);
		if(fieldValue!='')
		{
			var fieldName=val;		
			if(fieldValue!=null||fieldValue!='')
			{
				if(!isAlphaNumericValue(obj.value))
		 		{
					alert("Please enter Alphamuneric values only.");
		 			document.getElementById(fieldName).value='';
		 			document.getElementById(fieldName).focus();
		 			return false;
		 		}
		 	}
		 }
	}
	// The function will check alphanumeric values for records in bulk	
	
	function checkAlphanumeric(obj,val,count)
	{				 
		var fieldValue=trimAll(obj.value);
		var fieldName=val;		
		if(fieldValue!=null||fieldValue!='')
		{
			if(!isAlphaNumericValue(obj.value))
	 		{
				alert("Please enter Alphamuneric values only.");
	 			document.getElementById(fieldName+count).value='';
	 			document.getElementById(fieldName+count).focus();
	 			return false;
	 		}
	 	}
	}
    
    
    // Function to perform validations on from date and to date
    function fromToDateValidation(field)
    {
      var fromDate =document.getElementById('fromDate').value;
      var toDate=document.getElementById('toDate').value;
       
       if(fromDate!='' && toDate!='' && !validateDate(fromDate,toDate)) 
        {
        	alert('From Date should be less than  or equal to To Date ');
        	document.getElementById(field).value='';
        	document.getElementById(field).focus();        	
            return false;
        }         
        return true;     
    } 
    // Function to disable right click
    function disableRightClick()
		{			
			if (event.button==2)
			{
				alert("Function is disabled.");
				return false;
			}
		}
    
   