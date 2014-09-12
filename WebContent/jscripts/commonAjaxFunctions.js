
 /** 
 * File describes common validations 
 * 
 * Name: commonAjaxFunctions..js
 * <p> 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                            		Prior 
 * Date       		By              Version  			Description 
 * ---------- ---------------   ----------------  -------------------------------- 
 
 * ======================================================================================== 
 * </pre> 
 * 
  
 
 **/
 
 
 
 // ver 1.3 starts here
		// function added to get rating tariff is on the basis of custRef, accNum and prodSeq
		function getTariffId(custRef,prodSeq)
		{	
			query  = 'commissionProduct.getTariffId';
			inParams =  custRef + "," + prodSeq;			
			getDetails_ajax(query, inParams, null);			
			var splitAjaxResponse = ajaxResponse.split("~");  
			return splitAjaxResponse;
		}	
		
		// ver 1.3 ends here
		
		// ver 1.3 starts here
		
		// ver 1.1 tariff id 95731,95727 is added for Arrear Price Plan Configuration for La Revised Price Plan for INR ,USD. 
		// var tariffIdArr = new Array("94933","94934","95731","95727");	// commented for ver 1.2
		var tariffIdArr = new Array("94933","94934","16859","95727","95731","94765"); // ver 1.2 // ver 2.4 - added tariff id 94765
		var unfrTariffIdArr = new Array ("94721","94722","94723","94724","94725","4379");	// ver 1.2		
		// ver 1.1 end 		
			
		// ver 1.3 starts here
		
			function getOnNetTariffId(prodCurrCode)
			{
				query  = 'common.getOnNetTariffId';
				inParams =  prodCurrCode;					
				getDetails_ajax(query, inParams, null);
				var splitAjaxResponse = ajaxResponse.split("~!"); 	
				var OnNetTariffIdArr = splitAjaxResponse;
				return OnNetTariffIdArr;
			}
		// ver 1.3 ends here
		
		// ver 1.3 starts here
		
		 function isOnnetTariff(tariffId)
		 {
		 	var flag = false;
		 	for(i = 0 ; i < tariffIdArr.length; i++)
			{	
				if(parseInt(tariffIdArr[i]) == parseInt(tariffId)) 
				{
					flag = true;					
					break;
				}	
			}//end for
			return flag;
		 }
		// ver 1.3 ends here
		
		// ver 1.2 starts here // added to Identify Unfr tariff plan
	    function isUnfrTariff(tariffId)
		 {
		 
		 	var flag = false;
		 	for(i = 0 ; i < unfrTariffIdArr.length; i++)
			{	
				if(parseInt(unfrTariffIdArr[i]) == parseInt(tariffId)) 
				{
					flag = true;					
					break;
				}	
			}
			
			return flag;
		 }
		 
		 // ver 1.2 ends here
	

	// ver 1.4 starts here (Function for country state and city mapping)


	function populate_state_city(obj,targetField,query)
			{
			      var ob=obj.value;
			      if(ob=="")
			      {
			        alert('Please Select From the List');
			        return false;
			       }
			       else
			       {
			    	query  = query;
					
						getDetails_ajax(query,ob,null);
				
						var rowArr =  ajaxResponse.split("!");
						
						var stateString='';			
						for(i=0; i<rowArr.length-1; i++)
						{
							var colArr = rowArr[i].split("~");
							stateString=stateString+colArr[0]+'~'+colArr[1]+'!';			
						}
						removeAllOptions(document.getElementById(targetField),1);
						popDropDown(targetField,stateString);
			   }
			}


			// ver 1.4 ends here 
			// ver 1.5 starts here
			function selectProviderCountry(countryObj,stateFldName,providerCountryId)
			   {
			     if(providerCountryId!=null && providerCountryId!='')
			     {
			        countryObj.value = providerCountryId;      
			        populate_state_city(countryObj,stateFldName,'createAccount.stateList');  
			     }      
			   }
			//ver 1.5 ends here
			// ver 1.6 starts here
			 function populate_ajax_dropdown(obj,targetField,query)
			   {
			        var ob=obj.value;
			    	query  = query;
					
						getDetails_ajax(query,ob,null);
				
						var rowArr =  ajaxResponse.split("!");
						var stateString='';			
						for(i=0; i<rowArr.length-1; i++)
						{
							var colArr = rowArr[i].split("~");
							stateString=stateString+colArr[0]+'~'+colArr[1]+'!';			
						}
						removeAllOptions(document.getElementById(targetField),1);
						popDropDown(targetField,stateString);
			   
			}
			// ver 1.6 ends here
			
		// ver 1.7 starts here
		// function is used to search for country.
		function searchCountry(custCity,custState,custCountry,targetFields,path)
		{			
			var city = trimAll(document.getElementById(custCity).value);
			var state = trimAll(document.getElementById(custState).value);
			var country = trimAll(document.getElementById(custCountry).value);
			//ver 2.0 starts here
			if(restrictDelimeter(custCountry)== false || restrictDelimeter(custState)== false ||restrictDelimeter(custCity) == false)
			   {
			     return false;
			   }
			   
			//ver 2.0 ends here		
			var qid='';		
			var paramsList='';	
			setContextPath(path);
			var postFunc='';
			var rowArr='';
			var colArr='';			
			var flag=true;		
			var delimiter = "~";	
			var qid = "custAddress_Country";	       				
			var paramsList = city + '%25'+ '~'+ state + '%25' + '~'+country +'%25';			
			getDetails_ajax(qid,paramsList,null,delimiter);					
			rowArr =  ajaxResponse.split("!");		
			if(rowArr.length >2)
			{				
				qid = "custAddress_Country"; 														
				postFunc = "focusState";
				focusState();						
			    openPopup(path,qid,paramsList,targetFields,postFunc,delimiter);		    
			}
			else if(rowArr.length==2)
			{
				colArr = rowArr[0].split("~");				
				countryVal = colArr[0];							
				document.getElementById(custCountry).value = countryVal;				
				focusState();	
			}
			else 
			{
				flag = false;
				alert("Invalid city, state or country.Please enter valid details");
				document.getElementById(custCountry).value = "";
				document.getElementById(custCountry).focus();
				return flag;
				
			}	
		}	
		
		// function is used to search for State corresponding to their Country Name.				
		function searchState(custCity,custState,custCountry,targetFields,path)
		{
			var city = trimAll(document.getElementById(custCity).value);
			var state = trimAll(document.getElementById(custState).value);
			var country = trimAll(document.getElementById(custCountry).value);	
			//ver 2.0 starts here
			if(restrictDelimeter(custCountry)== false || restrictDelimeter(custState)== false ||restrictDelimeter(custCity) == false)
			   {
			     return false;
			   }
			   
			//ver 2.0 ends here	
			var qid='';		
			var paramsList='';	
			setContextPath(path);
			var postFunc='';
			var rowArr='';
			var colArr='';		
			var flag=true;	
			var delimiter = "~";			
			var qid = "custAddress_State";	       				
			var paramsList = city + '%25'+ '~'+ state + '%25' + '~'+country + '%25';				
			getDetails_ajax(qid,paramsList,null,delimiter);											
			rowArr =  ajaxResponse.split("!");			
			if(rowArr.length >2)
			{				
				qid = "custAddress_State"; 						
				postFunc = "focusCity";				
				focusCity();	
				
				openPopup(path,qid,paramsList,targetFields,postFunc,delimiter);	
			}
			else if(rowArr.length==2)
			{
				colArr = rowArr[0].split("~");	
				var stateVal   = colArr[0];			
				var countryVal = colArr[1];
				document.getElementById(custCountry).value = countryVal;	
				document.getElementById(custState).value = stateVal;				
				focusCity();
			}
			else 
			{
				flag = false;
				alert("Invalid city, state or country.Please enter valid details");
				document.getElementById(custState).value = "";
				document.getElementById(custState).focus();
				return flag;
			}			
		}
		
			
		// function is used to search for City based on provided inputs and pop will 
		// display their corresponding State and Country
		function searchCity(custCity,custState,custCountry,targetFields,path)
		{			
			var city = trimAll(document.getElementById(custCity).value);
			var state = trimAll(document.getElementById(custState).value);
			var country = trimAll(document.getElementById(custCountry).value);
	        //ver 2.0 starts here
			if(restrictDelimeter(custCountry)== false || restrictDelimeter(custState)== false ||restrictDelimeter(custCity) == false)
			   {
			     return false;
			   }
			   
			//ver 2.0 ends here	
			var qid='';		
			var paramsList='';	
			setContextPath(path);
			var postFunc='';
			var rowArr='';
			var colArr='';			
			var flag=true;			
			var delimiter = "~";
			var qid = "custAddress_City";	       				
			var paramsList = city + '%25'+ '~'+ state + '%25' + '~'+country + '%25';						
			getDetails_ajax(qid,paramsList,null,delimiter);														
			rowArr =  ajaxResponse.split("!");				
			if(rowArr.length >2)
			{
				qid = "custAddress_City"; 								
				postFunc = "focusZipCode";				
				focusZipCode();		
			    openPopup(path,qid,paramsList,targetFields,postFunc,delimiter);		    
			}
			else if(rowArr.length==2)
			{
				colArr = rowArr[0].split("~");	
				var cityVal   = colArr[0];	
				var stateVal   = colArr[1];			
				var countryVal = colArr[2];
				
				document.getElementById(custCity).value = cityVal;
				document.getElementById(custState).value = stateVal;	
				document.getElementById(custCountry).value = countryVal;
				focusZipCode();
			}
			else 
			{
				flag = false;
				alert("Invalid city, state or country.Please enter valid details");
				document.getElementById(custCity).value = "";
				document.getElementById(custCity).focus();
				return flag;
				
			}			
		
		}	
		
		
		// function validateCustomerAddress is used to validate for correct values of city,state and 
		// country on click of submit
		function validateCustomerAddress(custCity,custState,custCountry,path)
		{	
			var city = trimAll(document.getElementById(custCity).value);// ver 1.8 removed escape
			var state = trimAll(document.getElementById(custState).value);// ver 1.8 removed escape
			var country = trimAll(document.getElementById(custCountry).value);// ver 1.8 removed escape		
			//ver 2.0 starts here
			if(restrictDelimeter(custCountry)== false || restrictDelimeter(custState)== false ||restrictDelimeter(custCity) == false)
			   {
			     return false;
			   }
			   
			//ver 2.0 ends here
			var delimiter = "~";//ver 2.0		
			var queryId = "validCustomerAddress";
			inParams = city+ "~"+state+ "~"+ country; //ver 2.0 ',' is replaced by '~'
			setContextPath(path);
			getDetails_ajax(queryId,inParams,null,delimiter);//ver 2.0 delimiter added			
			return ajaxResponse;
		
		}
		//ver 2.0 starts here	
		function restrictDelimeter(address)
		{
		    var str = trimAll(document.getElementById(address).value);
			for(var i=0;i<str.length;i++)
			     { 
			       if(str.charAt(i)== '~')
			        {
			          alert(' ~ is not allowed in address field.');
			          document.getElementById(address).value ='';
			          document.getElementById(address).focus();
				      return false;
			        }
			       
			      } 
		 }
		 //ver 2.0 ends here	
		
		// ver 1.7 ends here
		
		//ver 1.9 starts here
		function validateCustomerNameRef(custName,custRef,path)
		{	
			var customerName = trimAll(document.getElementById(custName).value);
			var customerRef = trimAll(document.getElementById(custRef).value);
			var queryId = "validCustomerNameRef";
			inParams = customerName+ "," + customerRef;
			getDetails_ajax(queryId,inParams,null);
			return ajaxResponse;
		
		}	
		//ver 1.9 ends here
		
	// ver 2.1 starts here
	
	function searchCustomerRefAccCodeName(custmrName,custmrRef,accountingCode,path)
	{		
		var custName= trimAll(document.getElementById(custmrName).value);
		var custRef= trimAll(document.getElementById(custmrRef).value); 
		var accCode= trimAll(document.getElementById(accountingCode).value);	
		
		var query='';
		var inParams='';
		var postFunc = '';
		postFunc="getFocus";
		
		if(custName=="" && custRef=="" && accCode == "")	
		{	
			alert("Please enter Either Customer Name or Customer Reference or Accounting Code.");
			return false;
		}
		if(custRef != '' && custName !='' && accCode !='') 
		{
			 query="gen_customerDetails_name_refNo_accCode";
			 inParams =provider_id+ ','+ custName + '%'+','+custRef + '%'+ ','+ accCode + '%'+','+ 'C'+',' + 'C' ;
		} 
		else if(custRef != '')
		{
			query="gen_customerDetails_refNo_s";
			inParams = provider_id + "," + custRef + '%'+","+"C"+","+"C";
		}
		else if(custName !='')
		{
			query="gen_customerDetails_name_s";
			inParams = provider_id+','+custName + '%'+","+"C"+","+"C";
		}
		else if(accCode !='')
		{
			query="gen_customerDetails_accCode";
			inParams = provider_id + "," + accCode + '%'+","+"C"+","+"C";           	   
		} 
		else if(custRef != '' && custName !='' && accCode =='')
		{
			query="gen_customerDetails_name_ref_s";
			inParams = provider_id+','+custName + '%'+ ','+ custRef + '%'+','+ 'C'+',' + 'C' ;	
		}
		else if(custRef != '' && custName =='' && accCode !='')
		{
			query="gen_customerDetails_refNo_accCode";
			inParams = provider_id+','+custRef + '%'+ ','+ accCode + '%'+','+ 'C'+',' + 'C' ;
		}
		else if(custRef == '' && custName !='' && accCode !='')
		{
			query="gen_customerDetails_name_accCode";
			inParams = provider_id+','+custName + '%'+ ','+ accCode + '%'+','+ 'C'+',' + 'C' ;	
		}  		    
		setContextPath(path);
		getDetails_ajax(query,inParams,null);					
		var rowArr =  ajaxResponse.split("!");
	
		 if(rowArr.length >2)
		 {                       		 
		    targetFields = 'custName,custRef,accountingCode';
			postFunc = "getFocus";
			getFocus();
		    openPopup(path,query,inParams,targetFields,postFunc);
		 }
		 else if(rowArr.length == 2)
		 {
			var colArr = rowArr[0].split("~");
			var name   = colArr[0];	
			var reference  = colArr[1];			
			var accCode = colArr[2];
				
			document.getElementById(custmrName).value = name;
			document.getElementById(custmrRef).value = reference;	
			document.getElementById(accountingCode).value = accCode;
			getFocus();		
		 }
		 else 
		{
			alert("Invalid Customer Name,Customer Ref or Accounting Code.");
			document.getElementById(custmrName).value = "";
			document.getElementById(custmrRef).value = "";	
			document.getElementById(accountingCode).value = "";
			document.getElementById(custmrRef).focus();
			return false;
		}
	}
	
	// ver 2.1 ends here
		// ver 2.2 starts here
		function generic_Check(custRef,providerId)
		{	
			query  = 'generic_check';
			inParams =  providerId+","+custRef;
			getDetails_ajax(query, inParams, null);			
			var cust_check = ajaxResponse.split("~");  
			var flag=cust_check[0].split(",");
           if(flag=='F')
           {
            alert(custRef+"   Doesnt belong to Current Provider");
            return false;
           }
           else
           {
            return true;
           }
		}	
		function flag_Check(custRef,custFlag)
		{	
			query  = 'childParent_Check';
			inParams =  custFlag+","+custRef;
			getDetails_ajax(query, inParams, null);			
			var flag_check = ajaxResponse.split("~");  
			var flag=flag_check[0].split(",");
           if(flag=='F')
           {
            if(custFlag=='P')
            {
              alert(custRef+" is not a Parent Customer");
              return false;
            }
            else if(custFlag=='C')
            {
            
              alert(custRef+" is not a Child Customer");
              return false;
           }
           }
           else
           {
            return true;
           }
		}	
// ver 2.2 ends here
// ver 2.3 starts here
function showCOPFViznet(provider_id,copf,viznet,targetFields,path)
  {
    var copfId=trimVal(copf.value);
    var viznetId=trimVal(viznet.value);
    var qid = "common.copf_viznetCircuitId";
	var rowArr='';
	var colArr='';		   
			  
    if(copfId=='' && viznetId=='')
    {
       alert('Please enter either COPF ID or Viznet Circuit Id');
      return false;
    }
    else 
    {
       var inparams=  provider_id+","+viznetId+'%'+","+copfId+'%';
    }
      setContextPath(path);
      getDetails_ajax(qid,inparams,null);
      rowArr =  ajaxResponse.split("!");
      if(rowArr.length==2)
	   {
			colArr = rowArr[0].split("~");
			var vizId  = colArr[0];
			var cId = colArr[1];
			copf.value=cId;
			viznet.value=vizId;
			return false;
		}
	 else
		{
		    openPopup(path,qid,inparams,targetFields);	
	           return false;
		}
		
  }
  //ver 2.3 ends here


// ver 2.5 starts here
/**
	 This is generic function for customer popup for VSNL 
	input:custmrName=customer name field name for eg 'custName'
	cust=customer refernce field name for eg 'custRef'
	path=context path
	postFunc=function to be executed after pop up
	providerId=Provider Id 
	*/
  function searchCustomerRefName(custmrName,custmrRef,path,postFunc,provider_id)
	{		
		var custName= trimAll(document.getElementById(custmrName).value);
		var custRef= trimAll(document.getElementById(custmrRef).value); 
		var query='';
		var inParams='';
		if(custName=="" && custRef=="" )	
		{	
			alert("Please enter either customer name or customer reference ");
			return false;
		}
		if(custRef != '' && custName !='' ) 
		{
			 query="gen_customerDetails_name_ref";
			 inParams =provider_id+ '~'+ custName + '%'+'~'+custRef + '%'+ '~'+ 'C'+'~' + 'C' ;
		} 
		else if(custRef != '')
		{
			query="gen_customerDetails_refNo";
			inParams = provider_id + '~' + custRef + '%'+'~'+"C"+'~'+"C";
		}
		else if(custName !='')
		{
			query="gen_customerDetails_name";
			inParams = provider_id+'~'+custName + '%'+'~'+"C"+'~'+"C";
		}
		
			    
		setContextPath(path);
		getDetails_ajax(query,inParams,null,'~');					
		var rowArr =  ajaxResponse.split("!");
	    var  targetFields = custmrName+','+custmrRef;
	 	 if(rowArr.length >2)
		 {         
		    openPopup(path,query,inParams,targetFields,postFunc,'~');
			return false;
		 }
		 else if(rowArr.length == 2)
		 {
			var colArr = rowArr[0].split("~");
			var name   = colArr[0];	
			var reference  = colArr[1];			
			document.getElementById(custmrName).value = name;
			document.getElementById(custmrRef).value = reference;	
			eval(postFunc+'();');
			return false;		
		 }
		 else 
		 {
			alert("Invalid Customer Name,Customer Ref ");
			document.getElementById(custmrName).value = "";
			document.getElementById(custmrRef).value = "";	
			document.getElementById(custmrRef).focus();
			return false;
		}
	}
	/**
	 This is generic function for customer popup for VSNL 
	input:custmrName=customer name field name for eg 'custName'
	cust=customer refernce field name for eg 'custRef'
	accountingCode=accountingCode field name for eg 'accountingCode'
	path=context path
	postFunc=function to be executed after pop up
	providerId=Provider Id 
	*/
	
	function genericPoppup_Vsnl(custmrName,custmrRef,accountingCode,path,postFunc,provider_id)
	{		
		var custName= trimAll(document.getElementById(custmrName).value);
		var custRef= trimAll(document.getElementById(custmrRef).value); 
		var accCode= trimAll(document.getElementById(accountingCode).value);	
		
		var query='';
		var inParams='';
		
		
		if(custName=="" && custRef=="" && accCode == "")	
		{	
			alert("Please enter Either Customer Name or Customer Reference or Accounting Code.");
			return false;
		}
		if(custRef != '' && custName !='' && accCode !='') 
		{
			 query="gen_customerDetails_name_refNo_accCode";
			 inParams =provider_id+ '~'+ custName + '%'+'~'+custRef + '%'+ '~'+ accCode + '%'+'~'+ 'C'+'~' + 'C' ;
		} 
		else if(custRef != '')
		{
			query="gen_customerDetails_refNo_s";
			inParams = provider_id + '~' + custRef + '%'+'~'+"C"+'~'+"C";
		}
		else if(custName !='')
		{
			query="gen_customerDetails_name_s";
			inParams = provider_id+'~'+custName + '%'+'~'+"C"+'~'+"C";
		}
		else if(accCode !='')
		{
			query="gen_customerDetails_accCode";
			inParams = provider_id + '~' + accCode + '%'+'~'+"C"+'~'+"C";           	   
		} 
		else if(custRef != '' && custName !='' && accCode =='')
		{
			query="gen_customerDetails_name_ref_s";
			inParams = provider_id+'~'+custName + '%'+ '~'+ custRef + '%'+'~'+ 'C'+'~' + 'C' ;	
		}
		else if(custRef != '' && custName =='' && accCode !='')
		{
			query="gen_customerDetails_refNo_accCode";
			inParams = provider_id+'~'+custRef + '%'+ '~'+ accCode + '%'+'~'+ 'C'+'~' + 'C' ;
		}
		else if(custRef == '' && custName !='' && accCode !='')
		{
			query="gen_customerDetails_name_accCode";
			inParams = provider_id+'~'+custName + '%'+ '~'+ accCode + '%'+'~'+ 'C'+'~' + 'C' ;	
		}  		    
		setContextPath(path);
		getDetails_ajax(query,inParams,null,'~');					
		var rowArr =  ajaxResponse.split("!");
	     var  targetFields = custmrName+','+custmrRef+','+accountingCode;
		 if(rowArr.length >2)
		 {                       		 
		   
			openPopup(path,query,inParams,targetFields,postFunc,'~');
		 }
		 else if(rowArr.length == 2)
		 {
			var colArr = rowArr[0].split("~");
			var name   = colArr[0];	
			var reference  = colArr[1];			
			var accCode = colArr[2];
				
			document.getElementById(custmrName).value = name;
			document.getElementById(custmrRef).value = reference;	
			document.getElementById(accountingCode).value = accCode;
			eval(postFunc+'();');	
		 }
		 else 
		{
			alert("Invalid Customer Name,Customer Ref or Accounting Code.");
			document.getElementById(custmrName).value = "";
			document.getElementById(custmrRef).value = "";	
			document.getElementById(accountingCode).value = "";
			document.getElementById(custmrRef).focus();
			return false;
		}
	}
	
	
	/**
	 This is generic function to obatin account No list 
	input:qid=query key
	cust=customer refernce field name for eg 'custRef'
	accNo=account no field name for eg 'accuntNo'
	*/
	function getAccountNumberList_Generic(cust,accNo,qid)
	{
	    
		var query  =qid;
		
		var	custRef = document.getElementById(cust).value;
		removeAllOptions(document.getElementById(accNo),1);
		getDetails_ajax(query,custRef,null);
		popDropDown(accNo,ajaxResponse);
		document.getElementById(accNo).focus();
	}
	//ver 2.5 ends here